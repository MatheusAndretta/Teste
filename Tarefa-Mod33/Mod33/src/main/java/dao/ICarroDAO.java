package main.java.dao;

import main.java.domain.Carro;

public interface ICarroDAO {

    public Carro cadastrar(Carro carro);

    public Carro buscarPorID(Long id);

    public void excluir(Carro carro);

}
