package br.com.ebac.padrao_estrangulamento.vo;

import java.io.Serializable;

public class UsuarioVO implements Serializable{

    private final Long id;

    private final String nome;

    private final String login;

    private final Integer idade;

    private String idNovoUsuario;


    public UsuarioVO(Long id, String nome, String login, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.idade = idade;
    }

    public Long getId() {
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

    public String getIdNovoUsuario() {
        return idNovoUsuario;
    }

    public void setIdNovoUsuario(String idNovoUsuario) {
        this.idNovoUsuario = idNovoUsuario;
    }

    
    

}
