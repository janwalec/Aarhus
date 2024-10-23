package org.database;

import javax.persistence.EntityNotFoundException;

public class DBGoalService extends DataBase{

    public Goal getGoal(int goal_id) {
        Goal goal_in_db = em.find(Goal.class, goal_id);
        if (goal_in_db != null) {
            return goal_in_db;
        }
        throw new EntityNotFoundException("Goal " + goal_id + " not found");
    }

    public Goal addGoal(String value, String description) {
        Goal to_add = new Goal(value, description);

        em.getTransaction().begin();
        em.persist(to_add);

        em.getTransaction().commit();
        System.out.println("Added " + to_add);

        return to_add;
    }
}
