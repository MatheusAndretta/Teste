package br.com.ebac.padrao_estrangulamento.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ebac.padrao_estrangulamento.vo.NovoUsuarioVO;

@FeignClient(value = "cliente-novo-usuario", url = "http://localhost:8081")
public interface ClienteFeingNovoUsuario {

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    NovoUsuarioVO criaNovoUsuarioVO(@RequestBody NovoUsuarioVO novoUsuarioVO);
}
