package main.java.dao;

import java.util.List;

import main.java.domain.Produto;

public interface IProdutoDAO {

    public Produto cadastrar(Produto prod);

    public Produto buscarPorID(Long id);

    public void excluir(Produto prod);

    public Produto alterar(Produto produtoDB);

    public List<Produto> buscarTodos();

}
