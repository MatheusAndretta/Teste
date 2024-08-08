package main.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.domain.Produto;

public class ProdutoDAO implements IProdutoDAO{

    @Override
    public Produto cadastrar(Produto prod) {
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
      EntityManager entityManager = entityManagerFactory.createEntityManager();

      entityManager.getTransaction().begin();
      entityManager.persist(prod);
      entityManager.getTransaction().commit();

      entityManager.close();
      entityManagerFactory.close();

      return prod;
    }

    @Override
    public Produto buscarPorID(Long id) {
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
      EntityManager entityManager = entityManagerFactory.createEntityManager();

      entityManager.getTransaction().begin();
      Produto produto = entityManager.find(Produto.class, id);
      entityManager.getTransaction().commit();

      entityManager.close();
      entityManagerFactory.close();

      return produto;
    }

    @Override
    public void excluir(Produto produto) {
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
      EntityManager entityManager = entityManagerFactory.createEntityManager();

      entityManager.getTransaction().begin();
      produto = entityManager.merge(produto);
      entityManager.remove(produto);
      entityManager.getTransaction().commit();

      entityManager.close();
      entityManagerFactory.close();

    }

    @Override
    public Produto alterar(Produto produto) {
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
      EntityManager entityManager = entityManagerFactory.createEntityManager();

      entityManager.getTransaction().begin();
      produto = entityManager.merge(produto);
      entityManager.getTransaction().commit();

      entityManager.close();
      entityManagerFactory.close();
      return produto;
      
    }

    @Override
    public List<Produto> buscarTodos() {
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
      EntityManager entityManager = entityManagerFactory.createEntityManager();

     entityManager.getTransaction().begin();
     List<Produto> lista = entityManager.createQuery("Select c From Produto c", Produto.class).getResultList();
     entityManager.getTransaction().commit();

      entityManager.close();
      entityManagerFactory.close();
      return lista;
      
    }

}
