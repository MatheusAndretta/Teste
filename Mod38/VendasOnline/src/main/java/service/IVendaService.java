package service;

import dao.generic.IGenericDAO;
import domain.Venda;
import exceptions.DAOException;
import exceptions.TipoChaveNaoEncontradaException;


public interface IVendaService extends IGenericDAO<Venda, Long>{

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	
	public Venda consultarComCollection(Long id);

}
