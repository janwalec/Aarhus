package org.database.services;

import org.database.Entry;
import org.database.Journal;

import javax.persistence.EntityNotFoundException;

public class EntryService extends DataBase {
    public Entry addEntry(String value, Journal journal) {
        Entry to_add = new Entry(value, journal);

        em.getTransaction().begin();
        em.persist(to_add);

        em.getTransaction().commit();
        System.out.println("Added " + to_add.getId());

        return to_add;

    }

    public void changeValue(Entry e, String newValue) {
        em.getTransaction().begin();
        Entry entryInDB = em.find(Entry.class, e.getId());
        if (entryInDB == null) {
            throw new EntityNotFoundException("Entry" + e.getId() + " not found");
        }

        e.setValue(newValue);
        em.getTransaction().commit();
    }
}