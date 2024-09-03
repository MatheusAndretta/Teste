package service;

import java.util.List;

import domain.Produto;
import services.generic.IGenericService;


public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
