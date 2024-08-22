package main.java.dao;

import main.java.dao.generic.GenericDAO2;
import main.java.domain.Cliente;

public class ClienteDAO2 extends GenericDAO2<Cliente,Long> implements IClienteDAO<Cliente> {

    public ClienteDAO2() {
        super(Cliente.class);
        
    }

}
