package services;

import entities.Dog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public class DogService {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Dog_Toy");
    private static EntityManager entityManager = factory.createEntityManager();

    public void create(Dog dog) {
        entityManager.getTransaction().begin();
        entityManager.persist(dog);
        entityManager.getTransaction().commit();
    }

    public Dog findById(int dogId) {
        Dog dog = entityManager.find(Dog.class, dogId);
        entityManager.detach(dog);
        return dog;
    }

    public List<Dog> findAll() {
        List dogs = entityManager.createQuery("select e from Dog e").getResultList();
        return dogs;
    }

    public void delete(Dog dog) {
        entityManager.getTransaction().begin();
        entityManager.remove(dog);
        entityManager.getTransaction().commit();
    }

    public void update(Dog dog) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Dog.class, dog.getId()));
        entityManager.persist(dog);
        entityManager.getTransaction().commit();
    }

    public void clear() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Dog ").executeUpdate();
        entityManager.getTransaction().commit();
    }
}
