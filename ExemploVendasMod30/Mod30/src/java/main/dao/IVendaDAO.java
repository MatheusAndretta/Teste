package Mod30.src.java.main.dao;

import Mod30.src.java.main.dao.domain.Venda;
import Mod30.src.java.main.dao.exceptions.DAOException;
import Mod30.src.java.main.dao.exceptions.TipoChaveNaoEncontradaException;
import Mod30.src.java.main.dao.generico.IGenericDAO;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
