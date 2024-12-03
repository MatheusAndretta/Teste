package br.com.ebac.padrao_estrangulamento.servico;

import org.springframework.stereotype.Component;

import br.com.ebac.padrao_estrangulamento.entidades.Usuario;
import br.com.ebac.padrao_estrangulamento.repositorios.RepositorioUsuario;
import br.com.ebac.padrao_estrangulamento.utils.UsuarioUtils;
import br.com.ebac.padrao_estrangulamento.vo.UsuarioVO;

@Component
public class ServicoUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicoUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Iterable<UsuarioVO> encontraTodos() {
       final Iterable<Usuario> usuarioIterable = repositorioUsuario.findAll();

       return UsuarioUtils.toUsuarioVO(usuarioIterable);
    }

    public UsuarioVO criaUsuario (UsuarioVO usuarioVO){
        
        Usuario novoUsuario =  UsuarioUtils.fromUsuarioVO(usuarioVO);
        novoUsuario = repositorioUsuario.save(novoUsuario);
        
        return UsuarioUtils.toUsuarioVO(novoUsuario);
    }
}
