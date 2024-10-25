package org.database.services;

import org.database.Goal;
import org.database.User;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

public class UserService extends DataBase {

    public User getUser(String username) {
        User user_in_db = em.find(User.class, username);
        if (user_in_db != null) {
            return user_in_db;
        }
        throw new EntityNotFoundException("User " + username + " not found");
    }

    public User addUser(String userName, String name, String surname, Integer age, String email, String password) {
        User userToAdd = new User(userName, name, surname, age, email, password);

        List<User> users = this.getAllUsers();
        for (User user : users) {
            if(Objects.equals(user, userToAdd)) {
                throw new EntityExistsException("User " + userName + " " + email + " already exists");
            }
        }

        em.getTransaction().begin();
        em.persist(userToAdd);
        em.getTransaction().commit();
        System.out.println("Added " + userToAdd.getUserName());
        return userToAdd;
    }

    public void updateAge(User user, int newAge) {
        User userInDB = em.find(User.class, user.getUserName());
        if (userInDB == null) {
            throw new EntityNotFoundException("User " + user.getUserName() + " not found");
        }

        em.getTransaction().begin();
        user.setAge(newAge);
        em.getTransaction().commit();
    }

    public void updateName(User user, String newName) {
        User userInDB = em.find(User.class, user.getUserName());
        if (userInDB == null) {
            throw new EntityNotFoundException("User " + user.getUserName() + " not found");
        }

        em.getTransaction().begin();
        user.setName(newName);
        this.em.getTransaction().commit();
    }

    public void updateSurname(User user, String newSurname) {
        User userInDB = em.find(User.class, user.getUserName());
        if (userInDB == null) {
            throw new EntityNotFoundException("User " + user.getUserName() + " not found");
        }

        this.em.getTransaction().begin();
        user.setSurname(newSurname);
        this.em.getTransaction().commit();
    }

    public void updateEmail(User user, String newEmail) {
        User userInDB = em.find(User.class, user.getUserName());
        if (userInDB == null) {
            throw new EntityNotFoundException("User " + user.getUserName() + " not found");
        }
        this.em.getTransaction().begin();
        user.setEmail(newEmail);
        this.em.getTransaction().commit();
    }

    public void updatePassword(User user, String newPassword) {
        User userInDB = em.find(User.class, user.getUserName());
        if (userInDB == null) {
            throw new EntityNotFoundException("User " + user.getUserName() + " not found");
        }
        this.em.getTransaction().begin();
        user.setPassword(newPassword);
        this.em.getTransaction().commit();
    }


    public List<User> getAllUsers() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.select(root);

        return em.createQuery(criteriaQuery).getResultList();
    }

    @Transactional
    public void deleteUser(User userToDelete) {
        User userInDB = em.find(User.class, userToDelete.getUserName());
        if (userInDB == null) {
            throw new EntityNotFoundException("HabitCategory " + userToDelete.getUserName() + " not found");
        }
        em.getTransaction().begin();
        em.remove(userInDB);
        em.getTransaction().commit();
        System.out.println("Deleted " + userToDelete.getUserName());
    }


}
