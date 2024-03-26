import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import DAO.IClienteDAO;
import domain.Cliente;
import execptions.TipoChaveNaoEncontradaException;
import service.ClienteService;
import service.IClienteService;

public class ClienteServiceTeste {


    private IClienteService clienteService;
    private Cliente cliente;              
    
    public ClienteServiceTeste(){
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }
    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Matheus");
        cliente.setCidade("Santa Catarina"); 
        cliente.setEnd("End");
        cliente.setCidade("SC");
        cliente.setNumero(10);
        cliente.setTel(479999999999L);
        
    }

    @Test
    public void pesquisaCliente(){
       Cliente clienteConsultado = clienteService.buscaPorCPF(cliente.getCpf());
       Assert.assertNotNull(clienteConsultado);
    }
    
    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException{
       Boolean retorno = clienteService.salvar(cliente);
       Assert.assertTrue(retorno);
    }
    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alteraCliente() throws TipoChaveNaoEncontradaException{
        cliente.setNome("Matheus Andretta");
        clienteService.altera(cliente);
        
        Assert.assertEquals("Matheus Andretta", cliente.getNome());
    }
}
