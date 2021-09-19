package no.hvl.dat250.jpa.basicexample;

import no.hvl.dat250.jpa.basicexample.part2.*;
import no.hvl.dat250.jpa.basicexample.part2.Person;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select t from Todo t");
        List<Todo> todoList = q.getResultList();
        for (Todo todo : todoList) {
            System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());

        // create new todo
        em.getTransaction().begin();
        Todo todo = new Todo();
        todo.setSummary("This is a test");
        todo.setDescription("This is a test");
        em.persist(todo);
        em.getTransaction().commit();
        em.close();

        part2();

    }

    private static void part2() {
        final String PERSISTENCE_UNIT_PART_2_NAME = "creditCards";
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_PART_2_NAME);

        // create entity manager
        EntityManager em = factory.createEntityManager();

        // start a transaction
        em.getTransaction().begin();

        // create a new address
        Address inndalsveien = new Address();
        inndalsveien.setStreet("Inndalsveien");
        inndalsveien.setNumber(28);

        // create a new person
        Person maxMustermann = new Person();
        maxMustermann.setName("Max Mustermann");
        ArrayList<Address> maxsAddresses = new ArrayList<>();
        maxsAddresses.add(inndalsveien);
        maxMustermann.setAddresses(maxsAddresses);
        ArrayList<Person> residents = new ArrayList<>();
        residents.add(maxMustermann);
        inndalsveien.setResidents(residents);

        // create credit cards
        CreditCard card1 = new CreditCard();
        card1.setNumber(12345);
        card1.setBalance(-5000);
        card1.setLimit(-10000);
        CreditCard card2 = new CreditCard();
        card2.setNumber(123);
        card2.setBalance(1);
        card2.setLimit(2000);

        // create pin
        Pincode pin = new Pincode();
        pin.setPincode("123");
        pin.setCount(1);
        card1.setPin(pin);
        card2.setPin(pin);

        // create bank
        Bank pengebank = new Bank();
        pengebank.setName("Pengebank");
        ArrayList<CreditCard> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        pengebank.setCreditCards(cards);


        card1.setBank(pengebank);
        card2.setBank(pengebank);

        em.persist(maxMustermann);
        em.persist(inndalsveien);
        em.persist(card1);
        em.persist(card2);
        em.persist(pin);
        em.persist(pengebank);

        em.getTransaction().commit();

        em.close();

    }
}
