package main.java.dao;

import java.util.List;

import main.java.domain.Matricula;

public interface IMatriculaDAO {

    public Matricula cadastrar(Matricula mat);

    public Matricula buscarPorID(Long id);

    public void excluir(Matricula matricula);

    public Matricula alterar(Matricula matriculaDB);

    public List<Matricula> buscarTodos();

}
