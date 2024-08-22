package main.java.dao;

import main.java.dao.generic.GenericDAO3;
import main.java.domain.Cliente;

public class ClienteDAO3 extends GenericDAO3<Cliente,Long>implements IClienteDAO<Cliente>{

    public ClienteDAO3() {
        super(Cliente.class);
    }

}
