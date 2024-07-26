package Mod30.src.java.main.dao.services;

import Mod30.src.java.main.dao.domain.Cliente;
import Mod30.src.java.main.dao.exceptions.DAOException;
import Mod30.src.java.main.dao.services.generico.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    //	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
    //
        Cliente buscarPorCPF(Long cpf) throws DAOException;
    //
    //	void excluir(Long cpf);
    //
    //	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
    
    }
