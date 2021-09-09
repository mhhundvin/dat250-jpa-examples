package main.java;

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
        /*Query q = em.createQuery("select t from Person t");
        List<Person> personList = q.getResultList();
        for (Person person : personList) {
            System.out.println(person);
        }
        System.out.println("Size: " + personList.size());*/

        // create new person
        em.getTransaction().begin();

        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        em.persist(address);

        Bank bank = new Bank();
        bank.setName("Pengebank");
        em.persist(bank);

        Person person = new Person();
        person.setLastName("Mustermann");
        person.setFirstName("Max");
        person.setAddress(address);
        em.persist(person);

        CreditCard card = new CreditCard();
        card.setNumber(123);
        card.setBalance(1);
        card.setLimit(2000);
        card.setPerson(person);
        card.setBank(bank);
        em.persist(card);


        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);
        pincode.setCard(card);
        em.persist(pincode);

        card.setPincode(pincode);
        em.persist(card);

        em.getTransaction().commit();

        em.close();
    }
}

