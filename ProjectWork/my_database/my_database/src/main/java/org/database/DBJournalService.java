package org.database;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DBJournalService extends DataBase{


    public List<Journal> getUserJournal(User user) {
        List<Journal> journals = new ArrayList<>();
        int i = 0;
        String userName = user.getUserName();

        while (true) {
            Journal j = em.find(Journal.class, i++);
            if (j != null)
                if (j.getUserName().getUserName().equals(userName))
                    journals.add(j);
                else break;
        }
        if (journals.isEmpty())
            throw new EntityNotFoundException("Journal for " + userName + " not found");

        return journals;
    }



}
