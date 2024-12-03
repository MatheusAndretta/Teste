package br.com.ebac.padrao_estrangulamento.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ebac.padrao_estrangulamento.entidades.Jogo;
import br.com.ebac.padrao_estrangulamento.servico.ServicoJogo;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "/jogos")
public class ControllerJogo {

    private final ServicoJogo servicoJogo;

    public ControllerJogo(ServicoJogo servicoJogo) {
        this.servicoJogo = servicoJogo;
    }

    

    @GetMapping
    public Iterable<Jogo> encontraTodos() {
        return servicoJogo.encontrarTodos();
    }
    

}
