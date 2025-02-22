package br.com.ebac.padrao_estrangulamento.vo;

import java.io.Serializable;

public class NovoUsuarioVO implements Serializable {

    private final String id;

    private final String nome;

    private final String login;

    private final Integer idade;


    public NovoUsuarioVO (String id, String nome, String login, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.idade = idade;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public Integer getIdade() {
        return idade;
    }


}
