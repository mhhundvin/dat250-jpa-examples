package no.hvl.dat250.jpa.basicexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "people";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select t from Person t");
        List<Person> personList = q.getResultList();
        for (Person person : personList) {
            System.out.println(person);
        }
        System.out.println("Size: " + personList.size());

        // create new person
        em.getTransaction().begin();
        Person person = new Person();
        person.setLastName("Nordmann");
        person.setFirstName("Ola");
        em.persist(person);
        em.getTransaction().commit();

        em.close();
    }
}
