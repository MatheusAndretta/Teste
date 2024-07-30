package Mod30.src.java.main.dao.services;

import Mod30.src.java.main.dao.IClienteDAO;
import Mod30.src.java.main.dao.domain.Cliente;
import Mod30.src.java.main.dao.exceptions.DAOException;
import Mod30.src.java.main.dao.exceptions.MaisDeUmRegistroException;
import Mod30.src.java.main.dao.exceptions.TableException;
import Mod30.src.java.main.dao.services.generico.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	//private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		//this.clienteDAO = clienteDAO;
	}

//	@Override
//	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//
//	@Override
//	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}

}
