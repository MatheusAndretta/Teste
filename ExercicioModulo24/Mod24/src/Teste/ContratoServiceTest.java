package Teste;

import org.junit.Assert;
import org.junit.Test;

import BR.DAO.ContratoDao;
import BR.DAO.IContratoDao;
import BR.Mocks.ContratoDaoMock;
import BR.Service.ContratoService;
import BR.Service.IContratoService;


public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }
    @Test
    public void testeExcluir(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Excluido", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroExcluirNoBancoDeDados(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Excluido", retorno);
    }
    @Test
    public void busca(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.busca();
        Assert.assertEquals("Buscando", retorno);   
    }
    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroBuscaNoBancoDeDados(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.busca();
        Assert.assertEquals("Buscando", retorno); 
    }
    @Test
    public void atualizar(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Atualizado", retorno);

    }
    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroAtualizarBancoDeDados(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Atualizado", retorno);

    }
    @Test
    public void retorna(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.retornar("Analizando");
        Assert.assertEquals("Analizando", retorno);
    }
    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroRetornaBancoDeDados(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.retornar("Analizando");
        Assert.assertEquals("Analizando", retorno);
     }
    }



