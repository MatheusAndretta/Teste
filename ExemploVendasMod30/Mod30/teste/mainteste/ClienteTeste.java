package Mod30.teste.mainteste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import java.util.Collection;

import Mod30.src.java.main.dao.ClienteDAO;
import Mod30.src.java.main.dao.IClienteDAO;
import Mod30.src.java.main.dao.domain.Cliente;
import Mod30.src.java.main.dao.exceptions.DAOException;
import Mod30.src.java.main.dao.exceptions.MaisDeUmRegistroException;
import Mod30.src.java.main.dao.exceptions.TableException;
import Mod30.src.java.main.dao.exceptions.TipoChaveNaoEncontradaException;


public class ClienteTeste {

    private IClienteDAO clienteDAO;

    public ClienteTeste(){
        clienteDAO = new ClienteDAO();

    }
   

    @Test
    public void pesquisaClienteTeste() throws DAOException, MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException{
        Cliente cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Matheus");
        cliente.setIdade(24);
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

}
