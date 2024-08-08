package teste.java.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.Instant;
import java.util.List;

import org.junit.Test;

import main.java.dao.IMatriculaDAO;
import main.java.dao.MatriculaDAO;
import main.java.domain.Matricula;

public class MatriculaTeste {
    private IMatriculaDAO matriculadao;

    public MatriculaTeste() {
        matriculadao = new MatriculaDAO();
    }

    @Test
    public void cadastrarMatricula(){
        Matricula matricula = criarMatricula("A1");
        assertNotNull(matricula);

        Matricula matriculaDB = matriculadao.buscarPorID(matricula.getId());
        assertNotNull(matriculaDB);
        assertEquals(matricula.getId(), matriculaDB.getId());
        assertEquals(matricula.getCodigo(), matriculaDB.getCodigo());

        matriculadao.excluir(matricula);
        Matricula matriculaEX = matriculadao.buscarPorID(matricula.getId());
        assertNull(matriculaEX);
    }

      @Test
    public void alterarMatricula(){
        Matricula mat = criarMatricula("A2");
        assertNotNull(mat);

        Matricula matriculaDB = matriculadao.buscarPorID(mat.getId());
        assertEquals(mat.getId(), matriculaDB.getId());
        assertEquals(mat.getCodigo(), matriculaDB.getCodigo());

        matriculaDB.setStatus("DESATIVADO");
        Matricula matriculaUp = matriculadao.alterar(matriculaDB);
        assertEquals("DESATIVADO", matriculaUp.getStatus());

        matriculadao.excluir(mat);
        Matricula matriculaEX = matriculadao.buscarPorID(mat.getId());
        assertNull(matriculaEX);
    }

    @Test
    public void buscarTodosMatricula(){
        Matricula mat = criarMatricula("A3");
        assertNotNull(mat);

        Matricula mat1 = criarMatricula("A4");
        assertNotNull(mat1);

        List<Matricula> lista = matriculadao.buscarTodos();
        lista.forEach(matex -> matriculadao.excluir(matex));
    }



    private Matricula criarMatricula(String codigo) {
        Matricula mat = new Matricula();
        mat.setCodigo(codigo);
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat = matriculadao.cadastrar(mat);
        return mat;
    }
}