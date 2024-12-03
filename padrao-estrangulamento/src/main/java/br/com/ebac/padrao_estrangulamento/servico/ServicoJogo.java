package br.com.ebac.padrao_estrangulamento.servico;

import org.springframework.stereotype.Component;

import br.com.ebac.padrao_estrangulamento.entidades.Jogo;
import br.com.ebac.padrao_estrangulamento.repositorios.RepositorioJogo;

@Component
public class ServicoJogo {

    private final RepositorioJogo repositorioJogo;

    public ServicoJogo(RepositorioJogo repositorioJogo) {
        this.repositorioJogo = repositorioJogo;
    }

    public Iterable<Jogo> encontrarTodos(){
        return repositorioJogo.findAll();
    }

}
