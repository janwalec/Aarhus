package org.example;
import org.database.services.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        DataBase db = new DataBase();
        db.testConnection();
        Examples examples = new Examples();
        examples.ex();

    }
}