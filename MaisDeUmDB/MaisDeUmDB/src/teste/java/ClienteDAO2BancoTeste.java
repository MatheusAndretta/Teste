package teste.java;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Test;

import main.java.dao.ClienteDAO;
import main.java.dao.ClienteDAO2;
import main.java.dao.IClienteDAO;
import main.java.domain.Cliente;
import main.java.exceptions.DAOException;
import main.java.exceptions.MaisDeUmRegistroException;
import main.java.exceptions.TableException;
import main.java.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAO2BancoTeste {

    private IClienteDAO<Cliente> clienteDAO;

    private IClienteDAO<Cliente> clienteDAO2;

    private Random rd;

    public ClienteDAO2BancoTeste() {
        clienteDAO = new ClienteDAO();
        clienteDAO2 = new ClienteDAO2();
        rd = new Random();
    }

    @Test
    public void pesquisarClienteEm2DB() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException{
        Cliente cliente = criarCliente();
        clienteDAO.cadastrar(cliente);

        Cliente clienteDB = clienteDAO.consultar(cliente.getId());
        assertNotNull(clienteDB);

        Cliente cliente2 = criarCliente("Matheus Andretta");
        clienteDAO2.cadastrar(cliente2);

        Cliente clienteDB2 = clienteDAO2.consultar(cliente2.getId());
        assertNotNull(clienteDB2);

    }


    @After
    public void end() throws DAOException{
        Collection<Cliente> lista1 = clienteDAO.buscarTodos();
        excluirDB1(lista1);

        Collection<Cliente> lista2 = clienteDAO2.buscarTodos();
        excluirDB2(lista2);
    }

    private void excluirDB2(Collection<Cliente> lista) {
        lista.forEach(cli -> {
            try {
                clienteDAO2.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        } );
    }

    private void excluirDB1(Collection<Cliente> lista) {
        lista.forEach(cli -> {
            try {
                clienteDAO.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        } );
    }

    
    private Cliente criarCliente(){
        Cliente cliente = new Cliente();
        cliente.setCpf(rd.nextLong());
		cliente.setNome("Matheus");
		cliente.setCidade("Santa Catarina");
		cliente.setEnd("End");
		cliente.setEstado("SC");
		cliente.setNumero(10);
		cliente.setTelefone(1199999999L);
		return cliente;
    }

    private Cliente criarCliente(String nome){
        Cliente cliente = new Cliente();
        cliente.setCpf(rd.nextLong());
		cliente.setNome(nome);
		cliente.setCidade("Santa Catarina");
		cliente.setEnd("End");
		cliente.setEstado("SC");
		cliente.setNumero(10);
		cliente.setTelefone(1199999999L);
		return cliente;
    }

}
