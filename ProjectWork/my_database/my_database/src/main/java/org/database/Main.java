package org.database;

import org.database.services.*;

import java.io.Console;
import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DataBase db = new DataBase();


        try {
            db.testConnection();
        } catch (Exception e){
            System.out.println("some exception");
        }

        /* TODO
            add email
            deleter
            set values for each service
            check string output
        */

        /*
            HabitCategory - name + description
                PK - auto-Increment

            Habit - name + description + HabitCategory
                PK - auto-Increment

            Goal - value + description
                PK - auto-Increment

            Journal - (String) ActivityType, Habit, User, Goal
                PK - auto-Increment

            Entry - Value, Journal
                PK - auto-Increment
         */


        // create a new user
        UserService userService = new UserService();
        try {
            // set all parameters
            userService.addUser("walec", "Jan", "W", 21);
        } catch (Exception e) {
            System.out.println("---User exists---");
        }

        User user = userService.getUser("walec"); // get the user instance
        userService.updateAge(user, 24); // update age if you want
        userService.updateSurname(user, "Kowalski"); // update surname if you want
        userService.updateName(user, "Jakub"); // update name if you want
        System.out.println(user);
        userService.stopConnection(); // stop the service


        // start a service
        HabitCategoryService habitCategoryService = new HabitCategoryService();
        // add a habit category (returns HabitCategory)
        HabitCategory habitCategoryAdded = habitCategoryService.addHabitCategory("healthy", "I want to be very very healthy");
        System.out.println(habitCategoryAdded);

        
        // start a habit service
        HabitService habitService = new HabitService();
        // add a habit (pass a HabitCategory instance)
        Habit habitAdded = habitService.addHabit("Horse riding", "I like horses", habitCategoryAdded);
        System.out.println(habitAdded);




        habitService.deleteHabit(habitAdded);
        habitService.stopConnection();
        habitCategoryService.deleteHabitCategory(habitCategoryAdded);
        habitCategoryService.stopConnection();
        /*
        TODO
        change habitCategory through journal
        change habit through journal
         */

    }
}