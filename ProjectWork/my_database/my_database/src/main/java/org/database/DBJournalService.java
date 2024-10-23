package org.database;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DBJournalService extends DataBase {


    public List<Journal> getUserJournal(User user) {
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


    public void addJournal(Journal journal) {
        Journal journal_in_db = em.find(Journal.class, journal.getId());
        if (journal_in_db == null) {
            throw new EntityExistsException("Journal " + journal.getId() + " already exists");
        }
        //TODO check if goal field is filled
        em.getTransaction().begin();
        em.persist(journal);

        em.getTransaction().commit();
        System.out.println("Added " + journal);

    }



}
