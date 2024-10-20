package org.example.database;

import javax.persistence.*;



public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default"); // lub "default", jeśli zmieniłeś nazwę
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            User u = new User();
            u.setId(111321114);
            u.setUsername("new user");
            u.setPassword("sdd");
            u.setEmail("a@sddsdsaag.com");
            em.persist(u);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
            emf.close();
        }


    }
}