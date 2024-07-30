package Mod30.teste.mainteste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;

import Mod30.src.java.main.dao.IProdutoDAO;
import Mod30.src.java.main.dao.ProdutoDAO;
import Mod30.src.java.main.dao.domain.Produto;
import Mod30.src.java.main.dao.exceptions.DAOException;
import Mod30.src.java.main.dao.exceptions.MaisDeUmRegistroException;
import Mod30.src.java.main.dao.exceptions.TableException;
import Mod30.src.java.main.dao.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDAOTeste {
    private IProdutoDAO produtoDAO;

    public ProdutoDAOTeste() {
        produtoDAO = new ProdutoDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Produto> list = produtoDAO.buscarTodos();
        list.forEach(prod -> {
            try {
                produtoDAO.excluir(prod.getCodigo());
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }
    
    private Produto criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException{
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("128gb");
        produto.setNome("Sony Z4");
        produto.setValor(BigDecimal.TEN);
        produto.setCor("Black");
        produtoDAO.cadastrar(produto);
        return produto;
    }

    private void excluir(String valor) throws DAOException{
       this.produtoDAO.excluir(valor);
    }

    @Test
    public void pesquisa() throws DAOException, MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException{
        Produto produto = criarProduto("A1");
        assertNotNull(produto);
        Produto produtoDB = this.produtoDAO.consultar(produto.getCodigo());
        assertNotNull(produtoDB);
        excluir(produtoDB.getCodigo());
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException{
        Produto produto = criarProduto("A2");
        assertNotNull(produto);
        excluir(produto.getCodigo());
    }

    @Test
    public void excluirTeste() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException{
        Produto produto = criarProduto("A3");
        assertNotNull(produto);
        excluir(produto.getCodigo());
        Produto produtoDB = this.produtoDAO.consultar(produto.getCodigo());
        assertNull(produtoDB);
    }

    @Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A4");
		produto.setNome("Rodrigo Pires");
		produtoDAO.alterar(produto);
		Produto produtoBD = this.produtoDAO.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
	    assertEquals("Rodrigo Pires", produtoBD.getNome());
		
		excluir(produto.getCodigo());
		Produto produtoBD1 = this.produtoDAO.consultar(produto.getCodigo());
		assertNull(produtoBD1);
	}

    @Test
	public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
		criarProduto("A5");
		criarProduto("A6");
		Collection<Produto> list = produtoDAO.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		for (Produto prod : list) {
			excluir(prod.getCodigo());
		}
		
		list = produtoDAO.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 0);
		
	}


    @Test
    public void alterCor() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException{
    Produto produto = criarProduto("A7");
    produto.setCor("Verde");
    produtoDAO.alterar(produto);
    Produto produtoDB = this.produtoDAO.consultar(produto.getCodigo());
    assertNotNull(produtoDB);
    assertEquals("Verde", produtoDB.getCor());

    excluir(produto.getCodigo());
		Produto produtoBD1 = this.produtoDAO.consultar(produto.getCodigo());
		assertNull(produtoBD1);

        
    }
}
