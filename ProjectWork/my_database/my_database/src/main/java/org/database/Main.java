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

        //User new_user = new User("test_user", "hello", "there", 10);
        //db.addUser(new_user);

        DBUserService userService = new DBUserService();
        User get_user = userService.getUser("john_doe");
        System.out.println(get_user);
        userService.updateAge(get_user, 999);
        userService.updateName(get_user, "John");
        System.out.println(get_user);




        /*
        DBJournalService journalService = new DBJournalService();

        List<Journal> journals = journalService.getUserJournal(get_user);
        for (Journal j : journals) {
            System.out.println(j);
        }*/




    }
}