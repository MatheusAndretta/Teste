package main.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.domain.Carro;

public class CarroDAO implements ICarroDAO{

    @Override
    public Carro cadastrar(Carro carro) {
               EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
      EntityManager entityManager = entityManagerFactory.createEntityManager();

      entityManager.getTransaction().begin();
      entityManager.persist(carro);
      entityManager.getTransaction().commit();

      entityManager.close();
      entityManagerFactory.close();

      return carro;
    }

    @Override
    public Carro buscarPorID(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
  
        entityManager.getTransaction().begin();
        Carro carro = entityManager.find(Carro.class, id);
        entityManager.getTransaction().commit();
  
        entityManager.close();
        entityManagerFactory.close();
  
        return carro;
    }

    @Override
    public void excluir(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
  
        entityManager.getTransaction().begin();
        carro = entityManager.merge(carro);
        entityManager.remove(carro);
        entityManager.getTransaction().commit();
  
        entityManager.close();
        entityManagerFactory.close();
    }

}
