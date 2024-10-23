package org.database;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DataBase db = new DataBase();


        try{
            db.testConnection();
        } catch (Exception e){
            System.out.println("some exception");
        }

        /*
        HabitCategory habitCategory = new HabitCategory("name", "description");
        DBHabitCategoryService dbHabitCategoryService = new DBHabitCategoryService();
        dbHabitCategoryService.addHabitCategory(habitCategory);

        HabitCategory to_delete = dbHabitCategoryService.getHabitCategory(5);
        dbHabitCategoryService.deleteHabitCategory(to_delete);

        DBHabitCategoryService dbHabitCategoryService = new DBHabitCategoryService();
        HabitCategory hc = dbHabitCategoryService.getHabitCategory(2);

        Habit h = new Habit("habit name", "habit description", hc);
        System.out.println(h);
        */

        /*
            HabitCategory - name + description
                PK - auto-Increment

            Habit - name + description + HabitCategory
                PK - auto-Increment

            Goal - value + description
                PK - auto-Increment

         */



        DBHabitCategoryService dbhabitCategoryService = new DBHabitCategoryService();
        HabitCategory hc = dbhabitCategoryService.addHabitCategory("test name", "test_description");
        System.out.println(hc);

        DBHabitService dbhabitService = new DBHabitService();
        Habit h = dbhabitService.addHabit("test habit", "test habit description", hc);
        System.out.println(h);

        DBGoalService dbgoalService = new DBGoalService();
        Goal g = dbgoalService.addGoal("test goal", "test_description");
        System.out.println(g);

    }
}