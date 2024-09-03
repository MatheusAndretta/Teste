package service;

import java.util.List;

import domain.Cliente;
import exceptions.DAOException;
import services.generic.IGenericService;


public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
