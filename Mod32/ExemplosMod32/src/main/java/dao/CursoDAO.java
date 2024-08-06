package main.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.domain.Curso;

public class CursoDAO implements ICursoDAO {

    @Override
    public Curso cadastrar(Curso curso) {
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
      EntityManager entityManager = entityManagerFactory.createEntityManager();

      entityManager.getTransaction().begin();
      entityManager.persist(curso);
      entityManager.getTransaction().commit();

      entityManager.close();
      entityManagerFactory.close();

      return curso;
    
    }

}
