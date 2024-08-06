package teste.main;

import static org.junit.Assert.assertNotNull;

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
 public void cadastrar(){
    Curso curso = new Curso();
    curso.setCodigo("A1");
    curso.setDescricao("Curso Teste");
    curso.setNome("Curso de Java Backend");
    curso = cursoDAO.cadastrar(curso);

    assertNotNull(curso);
    assertNotNull(curso.getId());
    
 }


}
