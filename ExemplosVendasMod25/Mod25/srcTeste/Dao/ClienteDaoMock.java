import java.util.Collection;

import DAO.IClienteDAO;
import domain.Cliente;
import execptions.TipoChaveNaoEncontradaException;

public class ClienteDaoMock implements IClienteDAO  {

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {
     
    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
        
    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

   
    
}
        

