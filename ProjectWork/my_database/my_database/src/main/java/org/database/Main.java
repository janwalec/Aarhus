package org.database;

import org.database.services.*;


public class Main {
    public static void main(String[] args) {

        /* TODO
            deleter
            set values for each service
            check string output
        */

        /*
            HabitCategory - name + description
                PK - name

            Habit - name + description + HabitCategory
                PK - auto-Increment

            Goal - value + description
                PK - auto-Increment

            Journal - (String) ActivityType, Habit, User, Goal
                PK - auto-Increment

            Entry - Value, Journal
                PK - auto-Increment
         */

        //Examples examples = new Examples();
        //examples.ex();
        DataBase dataBase = new DataBase();
        dataBase.testConnection();
        UserService userService = new UserService();
        //    public User(String userName, String name, String surname, Integer age, String email, String password) {
        userService.addUser("testUser", "test", "user", 12, "email@email.com", "adss");


    }
}