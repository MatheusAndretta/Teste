package teste.java.main;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import main.java.dao.IProdutoDAO;
import main.java.dao.ProdutoDAO;
import main.java.domain.Produto;

public class ProdutoTeste {

    private IProdutoDAO produtoDAO;

    public ProdutoTeste(){
        produtoDAO = new ProdutoDAO();
    }
    
    @Test
    public void cadastraProduto(){
        Produto prod = criarProduto("A1");
        assertNotNull(prod);

        Produto produtoDB = produtoDAO.buscarPorID(prod.getId());
        assertNotNull(produtoDB);
        assertEquals(prod.getId(), produtoDB.getId());
        assertEquals(prod.getNome(), produtoDB.getNome());

        produtoDAO.excluir(prod);
        Produto produtoEx = produtoDAO.buscarPorID(prod.getId());
        assertNull(produtoEx);
    }

    @Test
    public void alterarProduto(){
        Produto prod = criarProduto("A2");
        assertNotNull(prod);

        Produto produtoDB = produtoDAO.buscarPorID(prod.getId());
        assertEquals(prod.getId(), produtoDB.getId());
        assertEquals(prod.getNome(), produtoDB.getNome());

        produtoDB.setNome("Z1");
        Produto produtoUp = produtoDAO.alterar(produtoDB);
        assertEquals("Z1", produtoUp.getNome());

         produtoDAO.excluir(prod);
         Produto produtoEx = produtoDAO.buscarPorID(prod.getId());
         assertNull(produtoEx);
    }

    @Test
    public void buscaTodosProdutos(){
        Produto prod1 = criarParaTesteTodos("Z1", "Cel", 1234.56D);
        assertNotNull(prod1);

        Produto prod2 = criarParaTesteTodos("Z2", "TV", 4321.56D);
        assertNotNull(prod2);

        List<Produto> lista = produtoDAO.buscarTodos();
        lista.forEach(prod-> produtoDAO.excluir(prod));
        

    }
    private Produto criarParaTesteTodos(String codigo,String nome,Double valor) {
        Produto prod = new Produto();
        prod.setCodigo(codigo);
        prod.setNome(nome);
        prod.setValor(valor);
        prod = produtoDAO.cadastrar(prod);
        return prod;
     }

    private Produto criarProduto(String codigo) {
       Produto prod = new Produto();
       prod.setCodigo(codigo);
       prod.setNome("TV");
       prod.setValor(2999.99D);
       prod = produtoDAO.cadastrar(prod);
       return prod;
    }

}
