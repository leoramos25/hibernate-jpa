package br.com.leonardords;

import br.com.leonardords.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Person leonardo = em.find(Person.class, 1L);
        em.remove(leonardo);
        em.getTransaction().commit();

        System.out.println("Done");
        em.close();
        emf.close();
    }
}
