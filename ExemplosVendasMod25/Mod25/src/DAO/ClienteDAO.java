package DAO;

import DAO.Generic.GenericDAO;
import domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO{

    public ClienteDAO(){
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
       
    }

    
}
