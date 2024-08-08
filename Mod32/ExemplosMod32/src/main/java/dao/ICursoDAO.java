package main.java.dao;

import java.util.List;

import main.java.domain.Curso;

public interface ICursoDAO {
    
    public Curso cadastrar(Curso curso);

    public Curso buscarPorID(Long id);

    public void excluir(Curso curso);

    public Curso alterar(Curso cursoDB);

    public List<Curso> buscarTodos();

}
