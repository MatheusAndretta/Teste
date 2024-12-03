package br.com.ebac.padrao_estrangulamento.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.ebac.padrao_estrangulamento.entidades.Usuario;
import br.com.ebac.padrao_estrangulamento.vo.NovoUsuarioVO;
import br.com.ebac.padrao_estrangulamento.vo.UsuarioVO;

public final class UsuarioUtils {

    private UsuarioUtils() {
    }

    public static Usuario fromUsuarioVO(UsuarioVO usuarioVO) {
        return new Usuario(usuarioVO.getId(), usuarioVO.getNome(), usuarioVO.getLogin(), usuarioVO.getIdade());

    }

    public static UsuarioVO toUsuarioVO(Usuario usuario) {
        return new UsuarioVO(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getIdade());

    }

    public static Iterable<UsuarioVO> toUsuarioVO(Iterable<Usuario> usuarios) {
        List<UsuarioVO> usuariosVOList = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuariosVOList.add(new UsuarioVO(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getIdade()));
        }

        return usuariosVOList;

    }

    public static UsuarioVO fromNovUsuarioVO (NovoUsuarioVO novoUsuarioVO){
        UsuarioVO usuarioVO = new UsuarioVO(null, novoUsuarioVO.getNome(), novoUsuarioVO.getLogin(), novoUsuarioVO.getIdade());
        usuarioVO.setIdNovoUsuario(novoUsuarioVO.getId());
        return usuarioVO;
    }

    public static NovoUsuarioVO toNovoUsuarioVO(UsuarioVO usuarioVO){
        return new NovoUsuarioVO(null, usuarioVO.getNome(), usuarioVO.getLogin(), usuarioVO.getIdade());
    }

}
