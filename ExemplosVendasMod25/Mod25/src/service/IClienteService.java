package service;

import domain.Cliente;
import execptions.TipoChaveNaoEncontradaException;

public interface IClienteService {

   Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscaPorCPF(Long cpf);

    void excluir(Long cpf);

    void altera (Cliente cliente) throws TipoChaveNaoEncontradaException;

}
