package main.java.dao;

import main.java.dao.generic.GenericDAO1;
import main.java.domain.Cliente;

public class ClienteDAO extends GenericDAO1<Cliente, Long> implements IClienteDAO<Cliente>{

    public ClienteDAO(){
        super(Cliente.class);
    }

}
