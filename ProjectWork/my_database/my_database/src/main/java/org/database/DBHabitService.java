package org.database;

import javax.persistence.EntityNotFoundException;

public class DBHabitService extends DataBase {
    public Habit addHabit(String name, String description, HabitCategory habit_cat) {
        Habit to_add = new Habit(name, description, habit_cat);

        em.getTransaction().begin();
        em.persist(to_add);

        em.getTransaction().commit();
        System.out.println("Added " + to_add);

        return to_add;
    }

    public void deleteHabit(Habit habit) {
        em.getTransaction().begin();

        HabitCategory habit_in_db = em.find(HabitCategory.class, habit.getId());
        if (habit_in_db == null) {
            throw new EntityNotFoundException("Habit " + habit.getId() + " not found");
        }

        em.remove(habit_in_db);
        em.getTransaction().commit();
        System.out.println("Deleted " + habit);
    }
}
