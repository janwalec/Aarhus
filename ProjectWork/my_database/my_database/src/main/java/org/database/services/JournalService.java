package org.database.services;

import org.database.*;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JournalService extends DataBase {


    public List<Journal> getUserJournals(User user) {
        List<Journal> journals = new ArrayList<>();
        int i = 0;
        String userName = user.getUserName();

        while (true) {
            Journal j = em.find(Journal.class, i++);
            if (j != null)
                if (j.getUser().getUserName().equals(userName))
                    journals.add(j);
                else break;
        }
        if (journals.isEmpty())
            throw new EntityNotFoundException("Journal for " + userName + " not found");

        return journals;
    }


    public Journal addJournal(Habit habit, Goal goal, User user, String activityType) {
        Journal to_add = new Journal(habit, goal, user, activityType);
        em.getTransaction().begin();
        em.persist(to_add);

        em.getTransaction().commit();
        System.out.println("Added " + to_add.getId());

        return to_add;
    }

    public void incrementCurrentStreak(Journal j) {
        em.getTransaction().begin();
        Journal journalInDb = em.find(Journal.class, j.getId());
        if (journalInDb == null) {
            throw new EntityNotFoundException("Journal" + j.getId() + " not found");
        }

        j.setCurrentStreak(j.getCurrentStreak() + 1);
        em.getTransaction().commit();
    }

    public void setEndDate(Journal j, LocalDate newEndDate) {
        em.getTransaction().begin();

        Journal journalInDb = em.find(Journal.class, j.getId());
        if (journalInDb == null) {
            throw new EntityNotFoundException("Journal" + j.getId() + " not found");
        }

        j.setEndDate(newEndDate);
        em.getTransaction().commit();
    }

    public void setStartDate(Journal j, LocalDate newStartDate) {
        em.getTransaction().begin();
        Journal journalInDb = em.find(Journal.class, j.getId());
        if (journalInDb == null) {
            throw new EntityNotFoundException("Journal" + j.getId() + " not found");
        }
        j.setStartDate(newStartDate);
        em.getTransaction().commit();
    }

    public void setActivityType(Journal j, String activityType) {
        em.getTransaction().begin();
        Journal journalInDb = em.find(Journal.class, j.getId());
        if (journalInDb == null) {
            throw new EntityNotFoundException("Journal" + j.getId() + " not found");
        }
        j.setActivityType(activityType);
        em.getTransaction().commit();
    }


    public List<Entry> getAllEntriesByJournal(Journal journal) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Entry> criteriaQuery = criteriaBuilder.createQuery(Entry.class);
        Root<Entry> root = criteriaQuery.from(Entry.class);

        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("journal"), journal));

        return em.createQuery(criteriaQuery).getResultList();
    }
}