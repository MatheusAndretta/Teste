package main.java.dao;

import main.java.dao.generic.IGenericDAO;

public interface IClienteDAO <T extends Persistente> extends IGenericDAO<T,Long>{

    

}
