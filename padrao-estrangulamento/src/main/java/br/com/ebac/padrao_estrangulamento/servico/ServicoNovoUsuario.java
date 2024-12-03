package br.com.ebac.padrao_estrangulamento.servico;

import org.springframework.stereotype.Component;

import br.com.ebac.padrao_estrangulamento.feign.ClienteFeingNovoUsuario;
import br.com.ebac.padrao_estrangulamento.utils.UsuarioUtils;
import br.com.ebac.padrao_estrangulamento.vo.NovoUsuarioVO;
import br.com.ebac.padrao_estrangulamento.vo.UsuarioVO;

@Component
public class ServicoNovoUsuario {

    private final ClienteFeingNovoUsuario clienteFeingNovoUsuario;

    public ServicoNovoUsuario(ClienteFeingNovoUsuario clienteFeingNovoUsuario) {
        this.clienteFeingNovoUsuario = clienteFeingNovoUsuario;
    }

    public UsuarioVO criaNovoUsuarioVO(UsuarioVO usuarioVO){
        NovoUsuarioVO novoUsuarioVO = UsuarioUtils.toNovoUsuarioVO(usuarioVO);
        novoUsuarioVO = clienteFeingNovoUsuario.criaNovoUsuarioVO(novoUsuarioVO);

        return UsuarioUtils.fromNovUsuarioVO(novoUsuarioVO);
    }
}
