package org.database.services;

import org.database.HabitCategory;

import javax.persistence.EntityNotFoundException;

public class HabitCategoryService extends DataBase {

    public HabitCategory getHabitCategory(int habit_cat_id) {
        HabitCategory habit_cat_in_db = em.find(HabitCategory.class, habit_cat_id);
        if (habit_cat_in_db == null) {
            throw new EntityNotFoundException("Habit " + habit_cat_id + " not found");
        }
        return habit_cat_in_db;
    }

    public HabitCategory addHabitCategory(String name, String description) {
        HabitCategory to_add = new HabitCategory(name, description);

        em.getTransaction().begin();
        em.persist(to_add);

        em.getTransaction().commit();
        System.out.println("Added " + to_add.getId());

        return to_add; //with id given by auto-increment
    }

    public void deleteHabitCategory(HabitCategory habit_cat) {
        int id = habit_cat.getId();
        HabitCategory habit_cat_in_db = em.find(HabitCategory.class, habit_cat.getId());
        if (habit_cat_in_db == null) {
            throw new EntityNotFoundException("HabitCategory " + habit_cat.getId() + " not found");
        }

        em.getTransaction().begin();
        em.remove(habit_cat_in_db);
        em.getTransaction().commit();
        System.out.println("Deleted " + habit_cat);
    }

    public void changeName(HabitCategory hc, String newName) {
        HabitCategory hcInDB = em.find(HabitCategory.class, hc.getId());
        if (hcInDB == null) {
            throw new EntityNotFoundException("HabitCategory " + hc.getId() + " not found");
        }

        em.getTransaction().begin();
        hc.setName(newName);
        em.getTransaction().commit();
    }

    public void changeDescription(HabitCategory hc, String newDescription) {
        HabitCategory hcInDB = em.find(HabitCategory.class, hc.getId());
        if (hcInDB == null) {
            throw new EntityNotFoundException("HabitCategory " + hc.getId() + " not found");
        }

        em.getTransaction().begin();
        hc.setDescription(newDescription);
        em.getTransaction().commit();
    }


}
