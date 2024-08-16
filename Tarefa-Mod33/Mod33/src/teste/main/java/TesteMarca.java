package teste.main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.nio.channels.AcceptPendingException;

import org.junit.Test;

import main.java.dao.AcessorioDAO;
import main.java.dao.CarroDAO;
import main.java.dao.IAcessorioDAO;
import main.java.dao.ICarroDAO;
import main.java.dao.IMarcaDAO;
import main.java.dao.MarcaDAO;
import main.java.domain.Acessorio;
import main.java.domain.Carro;
import main.java.domain.Marca;

public class TesteMarca {

    private IMarcaDAO marcaDAO;
    private ICarroDAO carroDAO;
    private IAcessorioDAO acessorioDAO;

    public TesteMarca() {
        marcaDAO = new MarcaDAO();
        carroDAO = new CarroDAO();
        acessorioDAO = new AcessorioDAO();
    }

    @Test
    public void criarMarcaTeste() {
        Acessorio acessorio = criarAcessorio("A1");
        assertNotNull(acessorio);

        Carro carro = criarCarro("A1",acessorio);
        assertNotNull(carro);

        Marca marca = criarMarca("A1",carro,acessorio);
        assertNotNull(marca);

        Marca marcaDB = marcaDAO.buscarPorCodigoAcessorio(marca.getCodigo());
        assertNotNull(marcaDB);
        assertEquals(marca.getId(), marcaDB.getId());


        marcaDAO.excluir(marca);
        Marca marcaEX = marcaDAO.buscarPorID(marca.getId());
        assertNull(marcaEX);

        carroDAO.excluir(carro);
        Carro carroEX = carroDAO.buscarPorID(carro.getId());
        assertNull(carroEX);

        acessorioDAO.excluir(acessorio);
        Acessorio acessorioEX = acessorioDAO.buscarPorID(acessorio.getId());
        assertNull(acessorioEX);

    }

    private Marca criarMarca(String codigo,Carro carro,Acessorio acessorio) {
        Marca marca = new Marca();
        marca.setCodigo(codigo);
        marca.setNome("AUDI");
        marca.setCarro(carro);
        marca.setAcessorio(acessorio);
        marca = marcaDAO.cadastrar(marca);
        return marca;
    }
     private Carro criarCarro(String codigo,Acessorio acessorio){
        Carro carro = new Carro();
        carro.setCodigo(codigo);
        carro.setNome("Audi A4");
        carro.setCor("Azul");
        carro.setDescricao("16v 2.0 130cv");
        carro.setAcessorio(acessorio);
        carro = carroDAO.cadastrar(carro);
        return carro;
     }
    
     private Acessorio criarAcessorio(String codigo){
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo(codigo);
        acessorio.setTipoAcessorio("Luxo");
        acessorio.setDescricao("Banco de luxo creme");
        acessorio = acessorioDAO.cadastrar(acessorio);
        return acessorio;
     }
}
