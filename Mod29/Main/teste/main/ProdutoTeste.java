import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import main.dao.IProdutoDAO;
import main.dao.Produto;
import main.dao.ProdutoDAO;

public class ProdutoTeste {
IProdutoDAO dao = new ProdutoDAO();

   @Test
   public void cadastrarTeste() throws Exception {
      Produto pord = new Produto();
      pord.setNome("Telefone");
      pord.setCodigo("92");
      pord.setValor(2999.99d);

      Integer qtd = dao.cadastrar(pord);
      assertTrue(qtd == 1);

      Produto prodDB = dao.consultar(pord.getCodigo());
      assertNotNull(prodDB);
      assertNotNull(prodDB.getId());
      assertEquals(pord.getCodigo(), prodDB.getCodigo());
      assertEquals(pord.getNome(), prodDB.getNome());
      assertEquals(pord.getValor(), prodDB.getValor());

      Integer qtdDel = dao.excluir(prodDB);
      assertNotNull(qtdDel);
   }

   @Test
   public void atualizar() throws Exception {
      Produto produto = new Produto();
      produto.setCodigo("193");
      produto.setNome("Sony Z");
      produto.setValor(2400.00d);
      Integer qtd = dao.cadastrar(produto);
      assertTrue(qtd == 1);

      Produto produtoDB = dao.consultar("193");
      assertNotNull(produtoDB);
      assertEquals(produto.getNome(), produtoDB.getNome());
      assertEquals(produto.getCodigo(), produtoDB.getCodigo());
      assertEquals(produto.getValor(), produtoDB.getValor());

      produtoDB.setCodigo("200");
      produtoDB.setNome("esgotado");
      produtoDB.setValor(0.00);
      Integer qtdUpdate = dao.atualizar(produtoDB);
      assertTrue(qtdUpdate == 1);

      Produto produtoDB1 = dao.consultar("193");
      assertNull(produtoDB1);

      Produto produtoDB2 = dao.consultar("200");
      assertNotNull(produtoDB2);
      assertEquals(produtoDB.getNome(), produtoDB2.getNome());
      assertEquals(produtoDB.getCodigo(), produtoDB2.getCodigo());
      assertEquals(produtoDB.getValor(), produtoDB2.getValor());

      Integer qtdDel = dao.excluir(produtoDB2);
      assertNotNull(qtdDel);
      
   }

   @Test
   public void buscaTodosDB() throws Exception{
      Produto produto = new Produto();
      produto.setCodigo("193");
      produto.setNome("Sony Z");
      produto.setValor(2400.00d);

      List<Produto> list = dao.buscartodos();
      for (Produto produto2 : list) {
         dao.excluir(produto2);
      }
      Produto prodDB = dao.consultar(produto.getCodigo());
      assertNull(prodDB);
   }
}
