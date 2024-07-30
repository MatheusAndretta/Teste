package Mod30.src.java.main.dao.services;

import Mod30.src.java.main.dao.IProdutoDAO;
import Mod30.src.java.main.dao.domain.Produto;
import Mod30.src.java.main.dao.services.generico.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
