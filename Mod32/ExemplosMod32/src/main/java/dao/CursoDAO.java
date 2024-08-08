package main.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.domain.Curso;

public class CursoDAO implements ICursoDAO {

  @Override
  public Curso cadastrar(Curso curso) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    entityManager.persist(curso);
    entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();

    return curso;

  }

  @Override
  public Curso buscarPorID(Long id) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    Curso curso = entityManager.find(Curso.class, id);
    entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();

    return curso;
  }

  @Override
  public void excluir(Curso curso) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    curso = entityManager.merge(curso);
    entityManager.remove(curso);
    entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();
  }

  @Override
  public Curso alterar(Curso curso) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    curso = entityManager.merge(curso);
    entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();
    return curso;
  }

  @Override
  public List<Curso> buscarTodos() {
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
      EntityManager entityManager = entityManagerFactory.createEntityManager();

     entityManager.getTransaction().begin();
     List<Curso> lista = entityManager.createQuery("Select c From Curso c", Curso.class).getResultList();
     entityManager.getTransaction().commit();

      entityManager.close();
      entityManagerFactory.close();
      return lista;
  }

}
