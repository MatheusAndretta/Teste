package main.java.dao;

import main.java.domain.Marca;

public interface IMarcaDAO {

    public Marca cadastrar(Marca marca);

    public Marca buscarPorID(Long id);

    public void excluir(Marca marca);

    public Marca buscarPorCodigoAcessorio(String codigo);


    

    
} 
