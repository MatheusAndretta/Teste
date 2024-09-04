package br.com.matheus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.matheus.domain.Produto;

@Repository
public interface IProdutoRepository extends CrudRepository<Produto,Long>{

}
