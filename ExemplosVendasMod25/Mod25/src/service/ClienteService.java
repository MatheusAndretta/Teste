package service;
import DAO.IClienteDAO;
import domain.Cliente;
import execptions.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO){
       this.clienteDAO = clienteDAO;
    }

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
       return clienteDAO.cadastrar(cliente);
    }

    @Override
    public Cliente buscaPorCPF(Long cpf) {
        return clienteDAO.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
       clienteDAO.excluir(cpf);
    }

    @Override
    public void altera(Cliente cliente) throws TipoChaveNaoEncontradaException{
        clienteDAO.alterar(cliente);
    }

}
