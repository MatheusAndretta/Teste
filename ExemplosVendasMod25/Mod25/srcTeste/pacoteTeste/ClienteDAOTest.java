import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import DAO.IClienteDAO;
import domain.Cliente;
import execptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;

    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDAO = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Matheus");
        cliente.setCidade("Santa Catarina");
        cliente.setEnd("End");
        cliente.setCidade("SC");
        cliente.setNumero(10);
        cliente.setTel(479999999999L);
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisaCliente(){
       Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
       Assert.assertNotNull(clienteConsultado);
    }
    
    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException{
       Boolean retorno = clienteDAO.cadastrar(cliente);
       Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteDAO.excluir(cliente.getCpf());
    }
    @Test
    public void alteraCliente() throws TipoChaveNaoEncontradaException{
        cliente.setNome("Matheus Andretta");
        clienteDAO.alterar(cliente);

        Assert.assertEquals("Matheus Andretta", cliente.getNome());
    }
}
