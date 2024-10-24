package org.database.services;

import org.database.User;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

public class UserService extends DataBase {

    public User getUser(String username) {
        User user_in_db = em.find(User.class, username);
        if (user_in_db != null) {
            return user_in_db;
        }

        throw new EntityNotFoundException("User " + username + " not found");
    }

    public void addUser(String userName, String name, String surname, Integer age) {
        User user_in_db = em.find(User.class, userName);

        if (user_in_db != null) {
            throw new EntityExistsException("User " + userName + " already exists");
        }

        User userToAdd = new User(userName, name, surname, age);

        em.getTransaction().begin();
        em.persist(userToAdd);
        em.getTransaction().commit();
        System.out.println("Added " + userToAdd.getUserName());
    }

    public void updateAge(User user, int age) {
        User userInDB = em.find(User.class, user.getUserName());
        if (userInDB == null) {
            throw new EntityNotFoundException("User " + user.getUserName() + " not found");
        }

        em.getTransaction().begin();
        user.setAge(age);
        em.getTransaction().commit();
    }

    public void updateName(User user, String name) {
        User userInDB = em.find(User.class, user.getUserName());
        if (userInDB == null) {
            throw new EntityNotFoundException("User " + user.getUserName() + " not found");
        }

        em.getTransaction().begin();
        user.setName(name);
        this.em.getTransaction().commit();
    }

    public void updateSurname(User user, String surname) {
        User userInDB = em.find(User.class, user.getUserName());
        if (userInDB == null) {
            throw new EntityNotFoundException("User " + user.getUserName() + " not found");
        }

        this.em.getTransaction().begin();
        user.setSurname(surname);
        this.em.getTransaction().commit();
    }

}
