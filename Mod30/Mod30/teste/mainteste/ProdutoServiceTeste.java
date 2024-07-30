package Mod30.teste.mainteste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

import Mod30.src.java.main.dao.IProdutoDAO;
import Mod30.src.java.main.dao.domain.Produto;
import Mod30.src.java.main.dao.exceptions.DAOException;
import Mod30.src.java.main.dao.exceptions.TipoChaveNaoEncontradaException;
import Mod30.src.java.main.dao.services.IProdutoService;
import Mod30.src.java.main.dao.services.ProdutoService;
import Mod30.teste.mainteste.dao.ProdutoDaoMock;

public class ProdutoServiceTeste {
private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTeste() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
	}
	
	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Rodrigo Pires");
		produtoService.alterar(produto);
		
		assertEquals("Rodrigo Pires", produto.getNome());
	}
}
