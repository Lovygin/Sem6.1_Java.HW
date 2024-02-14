package org.example; // не реализованная идея

import java.util.HashMap;
import java.util.HashSet;

public class CreatePhoneBook {
    public HashMap<String, HashSet<String>> newPhoneBook(String title) {

        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();
        System.out.println("The phone book called " + title + " has been created.");
        return phoneBook;
    }
}
