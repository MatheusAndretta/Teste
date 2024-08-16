package main.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import main.java.domain.Marca;

public class MarcaDAO implements IMarcaDAO {

    @Override
    public Marca cadastrar(Marca marca) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return marca;
    }

    @Override
    public Marca buscarPorID(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Marca marca = entityManager.find(Marca.class, id);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return marca;
    }

    @Override
    public void excluir(Marca marca) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        marca = entityManager.merge(marca);
        entityManager.remove(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public Marca buscarPorCodigoAcessorio(String codigoCarro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT m From Marca m ");
        builder.append("INNER JOIN Carro c on c = m.carro ");
        builder.append("Where c.codigo = :codigocarro");

        entityManager.getTransaction().begin();
        TypedQuery<Marca> query = entityManager.createQuery(builder.toString(), Marca.class);
        query.setParameter("codigocarro", codigoCarro);
        Marca marca = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();
        return marca;
    }


}
