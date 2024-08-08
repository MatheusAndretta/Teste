package teste.java.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import main.java.dao.CursoDAO;
import main.java.dao.ICursoDAO;
import main.java.domain.Curso;

public class CursoTeste {

    private ICursoDAO cursoDAO;

    public CursoTeste(){
        cursoDAO = new CursoDAO();
    }

        @Test
    public void cadastrarCurso(){
        Curso curso = criarCurso("A1");
        assertNotNull(curso);

        Curso cursoDB = cursoDAO.buscarPorID(curso.getId());
        assertNotNull(cursoDB);
        assertEquals(curso.getId(), cursoDB.getId());
        assertEquals(curso.getCodigo(), cursoDB.getCodigo());

        cursoDAO.excluir(curso);
        Curso cursoEX = cursoDAO.buscarPorID(curso.getId());
        assertNull(cursoEX);
    }

      @Test
    public void alterarMatricula(){
        Curso curso = criarCurso("A2");
        assertNotNull(curso);

        Curso cursoDB = cursoDAO.buscarPorID(curso.getId());
        assertEquals(curso.getId(), cursoDB.getId());
        assertEquals(curso.getCodigo(), cursoDB.getCodigo());

        cursoDB.setNome("Curso B");
        Curso cursoUp = cursoDAO.alterar(cursoDB);
        assertEquals("Curso B", cursoUp.getNome());

        cursoDAO.excluir(curso);
        Curso cursoEX = cursoDAO.buscarPorID(curso.getId());
        assertNull(cursoEX);
    }

    @Test
    public void buscarTodosMatricula(){
        Curso curso = criarCurso("A3");
        assertNotNull(curso);

        Curso curso1 = criarCurso("A4");
        assertNotNull(curso1);

        List<Curso> lista = cursoDAO.buscarTodos();
        lista.forEach(cursoEX -> cursoDAO.excluir(cursoEX));
    }

    private Curso criarCurso(String codigo){
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setDescricao("Curso Teste");
        curso.setNome("Curso JAVA");
        curso = cursoDAO.cadastrar(curso);
        return curso;
    }
}
