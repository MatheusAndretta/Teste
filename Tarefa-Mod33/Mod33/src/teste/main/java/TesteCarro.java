package teste.main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import main.java.dao.CarroDAO;
import main.java.dao.ICarroDAO;
import main.java.domain.Carro;

public class TesteCarro {

    private ICarroDAO  carroDAO;

    public TesteCarro() {
        carroDAO = new CarroDAO();
    }

    @Test
    public void cadastrarCarro(){

        Carro carro = criarCarro("A1");
        assertNotNull(carro);

        Carro carroDB = carroDAO.buscarPorID(carro.getId());
        assertNotNull(carroDB);
        assertEquals(carro.getId(), carroDB.getId());
        assertEquals(carro.getNome(), carroDB.getNome());

         carroDAO.excluir(carro);
         Carro carroEX = carroDAO.buscarPorID(carro.getId());
         assertNull(carroEX);
    }


    
    private Carro criarCarro(String codigo){
        Carro carro = new Carro();
        carro.setCodigo(codigo);
        carro.setNome("RS8");
        carro.setCor("Preto");
        carro.setDescricao("Moto V8 500cv");
        carro = carroDAO.cadastrar(carro);
        return carro;
    }
}
