package org.database;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

public class DBUserService extends DataBase {

    public User getUser(String username) {
        User user = em.find(User.class, username);
        if (user != null) {
            return user;
        } else {
            throw new EntityNotFoundException("User " + username + " not found");
        }
    }

    public void addUser(User user) {
        User in_db = em.find(User.class, user.getUserName());

        if (in_db != null) {
            throw new EntityExistsException("User " + user + " already exists");
        }

        em.getTransaction().begin();
        em.persist(user);

        em.getTransaction().commit();
        System.out.println("Added " + user);
    }

    public void updateAge(User user, int age) {
        this.em.getTransaction().begin();
        user.setAge(age);
        this.em.getTransaction().commit();
    }

    public void updateName(User user, String name) {
        this.em.getTransaction().begin();
        user.setName(name);
        this.em.getTransaction().commit();
    }

    public void updateSurname(User user, String surname) {
        this.em.getTransaction().begin();
        user.setSurname(surname);
        this.em.getTransaction().commit();
    }

    public void deleteUser(User user) {
        // TODO
    }
}
