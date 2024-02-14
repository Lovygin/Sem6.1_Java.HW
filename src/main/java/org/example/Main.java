package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddContact addContact = new AddContact();
        AllContacts allContacts = new AllContacts();
        boolean exit = false;
        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();
        phoneBook.put("Emergency", new HashSet<>(Arrays.asList("911")));
        phoneBook.put("Bank", new HashSet<>(Arrays.asList("900")));

        while (!exit) {
            System.out.print("Do you want to add a new contact to phone book? Enter \"yes\" or \"no\" --> ");
            String select = sc.nextLine().toLowerCase(Locale.ROOT);

            if (select.equals("yes")) {
                System.out.print("Enter the name of the new contact: ");
                String name = sc.nextLine();
                System.out.print("Enter without \"+\" and another text symbols (only digits) + " +
                        "the phone number of the new contact: ");
                String num = null;
                while (num == null) {
                    String inputNum = sc.nextLine();
                    if (areAllNumbers(inputNum)) {
                        num = inputNum;

                    } else {
                        System.out.print("Enter without \"+\" and another text symbols (only digits) + " +
                                "the phone number of the new contact: ");
                    }
                }
                phoneBook = addContact.addContact(phoneBook, name, num);
                allContacts.addToGeneralPhoneBook(phoneBook);
                System.out.println("allContacts.getAllContacts() = " + allContacts.getAllContacts());


            } else if (select.equals("no")) {
                System.out.println("Do you want to view all contacts from phone book?");
                System.out.print("Enter \"yes\" for that or \"no\", if you want to exit --> ");
                select = sc.nextLine().toLowerCase(Locale.ROOT);
                if (select.equals("yes")) {
                    allContacts.sortedByValueLength(phoneBook);
                } else if (select.equals("no")) {
                    System.out.println("Thank you for your time! Goodbye!");
                    exit = true;
                } else {
                    System.out.println("Wrong entering. Try again, please.");
                }

            } else {
                System.out.println("Wrong entering. Try again, please.");
            }
        }


    }

    private static boolean areAllNumbers(String input) {
        String[] numbers = input.split("\\s+");
        for (String number : numbers) {
            if (!isNumber(number)) {
                return false;
            }

        }
        return true;
    }

    private static boolean isNumber(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}