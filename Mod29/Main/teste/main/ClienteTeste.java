import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import main.dao.Cliente;
import main.dao.ClienteDAO;
import main.dao.IClienteDAO;

public class ClienteTeste {
    IClienteDAO dao = new ClienteDAO();    

    @Test
    public void cadastrarTeste() throws Exception{

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Matheus Araujo");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteDB = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteDB);
        assertNotNull(clienteDB.getId());
        assertEquals(cliente.getCodigo(),clienteDB.getCodigo());
        assertEquals(cliente.getNome(),clienteDB.getNome());

        Integer qtdDel = dao.excluir(clienteDB);
        assertNotNull(qtdDel);
    }

    @Test
    public void atualizar() throws Exception{
        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Matheus Araujo");
        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteDB = dao.consultar("10");
        assertNotNull(clienteDB);
        assertEquals(cliente.getCodigo(),clienteDB.getCodigo());
        assertEquals(cliente.getNome(),clienteDB.getNome());
        
        clienteDB.setCodigo("25");
        clienteDB.setNome("Teste atualizar");
        Integer qtdUpdate = dao.atualizar(clienteDB);
        assertTrue(qtdUpdate==1);

        Cliente clienteDB1 = dao.consultar("10");
        assertNull(clienteDB1);

        Cliente clienteDB2 = dao.consultar("25");
        assertNotNull(clienteDB2);
        assertEquals(clienteDB.getId(), clienteDB2.getId());
        assertEquals(clienteDB.getCodigo(), clienteDB2.getCodigo());
        assertEquals(clienteDB.getNome(), clienteDB2.getNome());

        List<Cliente> list = dao.buscartodos();
        for (Cliente cliente2 : list) {
            dao.excluir(cliente2);
        }
        Cliente clienteDB3 = dao.consultar("25");
        assertNull(clienteDB3);

    }

}
