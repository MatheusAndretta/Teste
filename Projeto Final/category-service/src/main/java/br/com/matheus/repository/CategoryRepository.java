package br.com.matheus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.matheus.entities.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String>{

}
