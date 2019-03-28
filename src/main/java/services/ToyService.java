package services;

import entities.Toy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ToyService {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Dog_Toy");
    private static EntityManager entityManager = factory.createEntityManager();

    public void create(Toy toy) {
        entityManager.getTransaction().begin();
        entityManager.persist(toy);
        entityManager.getTransaction().commit();
    }

    public Toy findById(int toyId) {
        Toy toy = entityManager.find(Toy.class, toyId);
        entityManager.detach(toy);
        return toy;
    }

    public List<Toy> findAll() {
        List toys = entityManager.createQuery("select e from Toy e").getResultList();
        return toys;
    }

    public void delete(int toyId) {
        entityManager.getTransaction().begin();
        Toy toy = entityManager.find(Toy.class, toyId);
        entityManager.remove(toy);
        entityManager.getTransaction().commit();
    }

    public void update(Toy toy) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Toy.class, toy.getId()));
        entityManager.persist(toy);
        entityManager.getTransaction().commit();
    }
    public void clear() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Toy").executeUpdate();
        entityManager.getTransaction().commit();
    }
}
