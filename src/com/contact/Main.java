package com.contact;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Management management = new Management();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by id");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Contact ct = new Contact();
                    ct.inputData();
                    management.addnewContact(ct);
                    break;

                case 2:
                    System.out.println(" Enter id");
                    int id=scanner.nextInt();

                    Contact ps=management.getContactById(id);
                    if (ps!=null){
                        System.out.println(ps.toString());
                    }else{
                        System.out.println("Not found");
                    }
                    break;

                case 3:
                    management.getAllContact();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (choice != 4);
    }
}
