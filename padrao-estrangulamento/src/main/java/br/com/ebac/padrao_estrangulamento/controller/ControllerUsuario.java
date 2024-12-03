package br.com.ebac.padrao_estrangulamento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ebac.padrao_estrangulamento.servico.ServicoNovoUsuario;
import br.com.ebac.padrao_estrangulamento.servico.ServicoUsuario;
import br.com.ebac.padrao_estrangulamento.vo.UsuarioVO;

@RestController
@RequestMapping(path = "/user")
public class ControllerUsuario {

    private final ServicoUsuario servicoUser;
    private final ServicoNovoUsuario servicoNovoUsuario;

    public ControllerUsuario(ServicoUsuario servicoUser, ServicoNovoUsuario servicoNovoUsuario) {
        this.servicoNovoUsuario = servicoNovoUsuario;
        this.servicoUser = servicoUser;
    }

    @PostMapping
    public UsuarioVO criarUsuario(@RequestBody UsuarioVO usuario) {
        UsuarioVO usuarioVOCriado = servicoUser.criaUsuario(usuario);
        UsuarioVO novoUsuarioVOCriado = servicoNovoUsuario.criaNovoUsuarioVO(usuario);

        return usuarioVOCriado;
    }

    @GetMapping
    public Iterable<UsuarioVO> encontraTodos() {
        return servicoUser.encontraTodos();
    }

}
