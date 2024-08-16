package main.java.dao;

import java.util.List;

import main.java.domain.Acessorio;

public interface IAcessorioDAO {

    public Acessorio cadastrar(Acessorio acs);

    public Acessorio buscarPorID(Long id);

    public void excluir(Acessorio acessorio);

    public Acessorio alterar(Acessorio acessorioDB);

    public List<Acessorio> buscarTodos();

}
