package main.dao;

import java.util.List;

public interface IClienteDAO {
public Integer cadastrar(Cliente cliente) throws Exception;

    public Cliente consultar(String codigo) throws Exception;

    public Integer excluir(Cliente clienteDB)throws Exception;

    public Integer atualizar(Cliente clienteDB)throws Exception;

    public List<Cliente> buscartodos() throws Exception;

}
