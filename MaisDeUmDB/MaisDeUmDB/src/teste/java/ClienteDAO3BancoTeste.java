package teste.java;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Test;

import main.java.dao.ClienteDAO;
import main.java.dao.ClienteDAO2;
import main.java.dao.ClienteDAO3;
import main.java.dao.IClienteDAO;
import main.java.domain.Cliente;
import main.java.exceptions.DAOException;
import main.java.exceptions.MaisDeUmRegistroException;
import main.java.exceptions.TableException;
import main.java.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAO3BancoTeste {

    private IClienteDAO<Cliente> clienteDAO;

    private IClienteDAO<Cliente> clienteDAO2;

    private IClienteDAO<Cliente> clienteDAO3;

    private Random rd;

    public ClienteDAO3BancoTeste() {
        clienteDAO = new ClienteDAO();
        clienteDAO2 = new ClienteDAO2();
        clienteDAO3 = new ClienteDAO3();
        rd = new Random();
    }

    @Test
    public void pesquisarClienteEm2DB() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException{
        
        //Postgres banco de dados 1 vendas_online
        Cliente cliente = criarCliente();
        clienteDAO.cadastrar(cliente);

        Cliente clienteDB = clienteDAO.consultar(cliente.getId());
        assertNotNull(clienteDB);

        //Postgres banco de dados 2 vendas_online2
        Cliente cliente2 = criarCliente("Matheus Andretta");
        clienteDAO2.cadastrar(cliente2);

        Cliente clienteDB2 = clienteDAO2.consultar(cliente2.getId());
        assertNotNull(clienteDB2);

        //Mysql banco de dados venda_online
        Cliente cliente3 = criarCliente("Wallace Andretta");
        clienteDAO3.cadastrar(cliente3);

        Cliente clienteDB3 = clienteDAO3.consultar(cliente3.getId());
        assertNotNull(clienteDB3);

    }


    @After
    public void end() throws DAOException{
        Collection<Cliente> lista1 = clienteDAO.buscarTodos();
        excluirDB1(lista1);

        Collection<Cliente> lista2 = clienteDAO2.buscarTodos();
        excluirDB2(lista2);

        Collection<Cliente> lista3 = clienteDAO3.buscarTodos();
        excluirDB3(lista3);
    }

    private void excluirDB3(Collection<Cliente> lista) {
        lista.forEach(cli -> {
            try {
                clienteDAO3.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        } );
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
