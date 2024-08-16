package teste.main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import main.java.dao.AcessorioDAO;
import main.java.dao.IAcessorioDAO;
import main.java.domain.Acessorio;

public class TesteAcessorio {

    private IAcessorioDAO acessorioDAO;

    

    public TesteAcessorio() {
        acessorioDAO = new AcessorioDAO();
    }

    @Test
    public void cadastrarAcessorio(){
        Acessorio acessorio = criaAcessorio("A1");
        assertNotNull(acessorio);

        Acessorio acessorioDB = acessorioDAO.buscarPorID(acessorio.getId());
        assertNotNull(acessorioDB);
        assertEquals(acessorio.getId(), acessorioDB.getId());
        assertEquals(acessorio.getCodigo(), acessorioDB.getCodigo());

        acessorioDAO.excluir(acessorio);
        Acessorio acessorioEX = acessorioDAO.buscarPorID(acessorio.getId());
        assertNull(acessorioEX);
    }

    @Test
    public void alteraAcessorio(){
        Acessorio acessorio = criaAcessorio("A2");
        assertNotNull(acessorio);

        Acessorio acessorioDB = acessorioDAO.buscarPorID(acessorio.getId());
        assertNotNull(acessorioDB);
        assertEquals(acessorio.getId(), acessorioDB.getId());
        assertEquals(acessorio.getCodigo(), acessorioDB.getCodigo());

        acessorioDB.setDescricao("bancos de estofado creme");  
        Acessorio acessorioUp = acessorioDAO.alterar(acessorioDB);
        assertEquals("bancos de estofado creme", acessorioUp.getDescricao());      

        acessorioDAO.excluir(acessorio);
        Acessorio acessorioEX = acessorioDAO.buscarPorID(acessorio.getId());
        assertNull(acessorioEX);

    }

    @Test
    public void buscarTodosAcessorio(){
        Acessorio acessorioRd = criaAcessorio("A3", "Rodas");
        assertNotNull(acessorioRd);

        Acessorio acessorioCp = criaAcessorio("A4", "Capo");
        assertNotNull(acessorioCp);

        List<Acessorio> lista = acessorioDAO.buscarTodos();
        lista.forEach(acs -> acessorioDAO.excluir(acs));
    }


    @SuppressWarnings("unused")
    private Acessorio criaAcessorio(String codigo,String tipoAcs){
        Acessorio acs = new Acessorio();
        acs.setCodigo(codigo);
        acs.setTipoAcessorio(tipoAcs);
        acs.setDescricao("Teste Desc");
        acs = acessorioDAO.cadastrar(acs);
        return acs;
    }

    private Acessorio criaAcessorio(String codigo){
        Acessorio acs = new Acessorio();
        acs.setCodigo(codigo);
        acs.setTipoAcessorio("Interno");
        acs.setDescricao("Adicionado Kit luxo Acs");
        acs = acessorioDAO.cadastrar(acs);
        return acs;
    }

}
