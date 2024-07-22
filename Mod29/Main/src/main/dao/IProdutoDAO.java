package main.dao;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDAO {
public Integer cadastrar(Produto prod) throws SQLException;

    public Produto consultar(String codigo) throws SQLException;

    public Integer excluir(Produto prodDB) throws Exception;

    public Integer atualizar(Produto produtoDB) throws Exception;

    public List<Produto> buscartodos() throws Exception;

}
