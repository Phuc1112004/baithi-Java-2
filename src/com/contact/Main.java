package com.contact;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Management management = new Management();
        Scanner scanner = new Scanner(System.in);
        int choice;
        try {
            do {
                System.out.println("1. Add new contact");
                System.out.println("2. Find a contact by id");
                System.out.println("3. Display contacts");
                System.out.println("4. Exit");
                System.out.print("Enter your choice:");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1: {
                        Contact ct = new Contact();
                        ct.inputData();
                        management.addnewContact(ct);
                    }
                    break;

                    case 2: {
                        System.out.println(" Enter Name:");
                        scanner.nextLine();
                        String name = scanner.nextLine();

                       Contact ct = management.getContactByName(name);
                        if (ct != null) {
                            System.out.println(ct.toString());
                        } else {
                            System.out.println("Not found");
                        }
                    }
                    break;

                    case 3:{
                        management.getAllContact();
                    }
                    break;

                    case 4: {
                        System.out.println("Exiting program...");
                    }
                    return;
                }

            } while (true);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
