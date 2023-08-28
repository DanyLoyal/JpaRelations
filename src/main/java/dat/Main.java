package dat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        /*EntityManager em = emf.createEntityManager();*/

        Person steve = new Person("steve");

        Person john = new Person("john");

        Phone p1 = new Phone("apple");
        Phone p2 = new Phone("samsung");

        steve.setPhone(p1);
        john.setPhone(p2);

        try(EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();
            em.persist(steve);
            em.persist(john);
            em.persist(p1);
            em.persist(p2);

            em.getTransaction().commit();

        }

        try (var em = emf.createEntityManager()){

            Person person = em.find(Person.class, 2);

            System.out.println("phome " + person.getPhone().getMake());

        }

    }
}