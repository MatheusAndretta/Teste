package br.com.ebac.padrao_estrangulamento.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class JogoUser {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Usuario user;

    @OneToOne
    private Jogo jogo;

    public JogoUser() {}

    public JogoUser(Usuario user, Jogo jogo) {
        this.user = user;
        this.jogo = jogo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

}
