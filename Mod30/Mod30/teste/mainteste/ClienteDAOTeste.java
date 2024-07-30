package Mod30.teste.mainteste;



import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import Mod30.src.java.main.dao.ClienteDAO;
import Mod30.src.java.main.dao.IClienteDAO;
import Mod30.src.java.main.dao.domain.Cliente;
import Mod30.src.java.main.dao.exceptions.DAOException;
import Mod30.src.java.main.dao.exceptions.MaisDeUmRegistroException;
import Mod30.src.java.main.dao.exceptions.TableException;
import Mod30.src.java.main.dao.exceptions.TipoChaveNaoEncontradaException;


public class ClienteDAOTeste {

    private IClienteDAO clienteDAO;

    public ClienteDAOTeste(){
        clienteDAO = new ClienteDAO();

    }

    @Test
    public void alteraIdade() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException{
        Cliente cliente = new Cliente();
        cliente.setCpf(12312312388L);
        cliente.setNome("Matheus AA");
        cliente.setIdade(24L);
        cliente.setCidade("Santa Catarina");
        cliente.setEnd("End");
        cliente.setEstado("SC");
        cliente.setNumero(10);
        cliente.setTel(11339999999L);
        Boolean retorno = clienteDAO.cadastrar(cliente);
        assertTrue(retorno);
        
        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        assertNotNull(clienteConsultado);

        clienteConsultado.setIdade(29L);
		clienteDAO.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDAO.consultar(clienteConsultado.getCpf());
        assertNotNull(clienteAlterado);
        assertEquals(clienteConsultado.getIdade(),clienteAlterado.getIdade());

        clienteDAO.excluir(cliente.getCpf());
        clienteConsultado = clienteDAO.consultar(cliente.getCpf());
		assertNull(clienteConsultado);
    }


    @Test
    public void pesquisaClienteTeste() throws Exception{
        Cliente cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Matheus");
        cliente.setIdade(24L);
        cliente.setCidade("Santa Catarina");
        cliente.setEnd("End");
        cliente.setEstado("SC");
        cliente.setNumero(10);
        cliente.setTel(11999999999L);
        clienteDAO.cadastrar(cliente);

        Cliente clienteConsulta = clienteDAO.consultar(cliente.getCpf());
        assertNotNull(clienteConsulta);

        clienteDAO.excluir(cliente.getCpf());
        
    }

    @Test
    public void salvarClienteTeste() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException{
        Cliente cliente = new Cliente();
        cliente.setCpf(12312772312L);
        cliente.setNome("Matheus");
        cliente.setIdade(24L);
        cliente.setCidade("Santa Catarina");
        cliente.setEnd("End");
        cliente.setEstado("SC");
        cliente.setNumero(10);
        cliente.setTel(11999999999L);
        Boolean retorno = clienteDAO.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        assertNotNull(clienteConsultado);

        clienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void excluirClienteTeste() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException{
        Cliente cliente = new Cliente();
        cliente.setCpf(99912312312L);
        cliente.setNome("Matheus");
        cliente.setIdade(33L);
        cliente.setCidade("Santa Catarina");
        cliente.setEnd("End");
        cliente.setEstado("SC");
        cliente.setNumero(10);
        cliente.setTel(11999999999L);
        Boolean retorno = clienteDAO.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        assertNotNull(clienteConsultado);

        clienteDAO.excluir(cliente.getCpf());
        clienteConsultado = clienteDAO.consultar(cliente.getCpf());

        assertNull(clienteConsultado);
    }

    @Test
    public void alteraCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException{
        Cliente cliente = new Cliente();
        cliente.setCpf(19992312312L);
        cliente.setNome("Matheus");
        cliente.setIdade(54L);
        cliente.setCidade("Santa Catarina");
        cliente.setEnd("End");
        cliente.setEstado("SC");
        cliente.setNumero(10);
        cliente.setTel(11999999999L);
        Boolean retorno = clienteDAO.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Rodrigo Pires");
		clienteDAO.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDAO.consultar(clienteConsultado.getCpf());
        assertNotNull(clienteAlterado);
        assertEquals("Rodrigo Pires", clienteAlterado.getNome());

        clienteDAO.excluir(cliente.getCpf());
        clienteConsultado = clienteDAO.consultar(cliente.getCpf());
		assertNull(clienteConsultado);
    }
    
    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException{
        Cliente cliente = new Cliente();
        cliente.setCpf(12312312388L);
        cliente.setNome("Matheus AA");
        cliente.setIdade(24L);
        cliente.setCidade("Santa Catarina");
        cliente.setEnd("End");
        cliente.setEstado("SC");
        cliente.setNumero(10);
        cliente.setTel(11339999999L);
        Boolean retorno = clienteDAO.cadastrar(cliente);
        assertTrue(retorno);

        Cliente cliente1 = new Cliente();
        cliente1.setCpf(33312312388L);
        cliente1.setNome("Matheus AC");
        cliente1.setIdade(34L);
        cliente1.setCidade("Santa Catarina");
        cliente1.setEnd("End");
        cliente1.setEstado("SC");
        cliente1.setNumero(10);
        cliente1.setTel(22339999999L);
        Boolean retorno1 = clienteDAO.cadastrar(cliente1);
        assertTrue(retorno1);

        Collection<Cliente> list = clienteDAO.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDAO.excluir(cli.getCpf());
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection<Cliente> lista1 = clienteDAO.buscarTodos();
        assertTrue(lista1 != null);
        assertTrue(lista1.size() == 0);
    }
}
