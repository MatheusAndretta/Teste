package main.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.domain.Matricula;

public class MatriculaDAO implements IMatriculaDAO {

  @Override
  public Matricula cadastrar(Matricula mat) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    entityManager.persist(mat);
    entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();

    return mat;
  }

  @Override
  public Matricula buscarPorID(Long id) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    Matricula mat = entityManager.find(Matricula.class, id);
    entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();

    return mat;
  }

  @Override
  public void excluir(Matricula matricula) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
      EntityManager entityManager = entityManagerFactory.createEntityManager();

      entityManager.getTransaction().begin();
      matricula = entityManager.merge(matricula);
      entityManager.remove(matricula);
      entityManager.getTransaction().commit();

      entityManager.close();
      entityManagerFactory.close();
  }

  @Override
  public Matricula alterar(Matricula matricula) { EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
  EntityManager entityManager = entityManagerFactory.createEntityManager();

  entityManager.getTransaction().begin();
  matricula = entityManager.merge(matricula);
  entityManager.getTransaction().commit();

  entityManager.close();
  entityManagerFactory.close();
  return matricula;
  }

  @Override
  public List<Matricula> buscarTodos() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
      EntityManager entityManager = entityManagerFactory.createEntityManager();

     entityManager.getTransaction().begin();
     List<Matricula> lista = entityManager.createQuery("Select c From Matricula c", Matricula.class).getResultList();
     entityManager.getTransaction().commit();

      entityManager.close();
      entityManagerFactory.close();
      return lista;
  }

}
