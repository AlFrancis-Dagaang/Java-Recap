package com.ExceptionLambdaStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Roles>role = ConfiguringRoles.configurationRoles();
        List<TxtFiles> txt = new ArrayList<>();

        Roles chosenRole = new Roles();

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            int choice;

            System.out.println("1. admin");
            System.out.println("2. user");
            System.out.println("3. guest");
            System.out.println();
            System.out.println("0. exit");
            System.out.println();
            System.out.print(">> ");

            try{
                choice = Integer.parseInt(scanner.next());
            }catch(NumberFormatException e){
                System.out.println("characters or strings are not valid!");
                System.out.println();
                continue;
            }

            switch (choice) {
                case 1:
                    chosenRole = returnRoles (role, "admin");
                    break;
                case 2:
                    chosenRole = returnRoles (role, "user");
                    break;
                case 3:
                    chosenRole = returnRoles (role, "guest");
                    break;
                case 0:
                    exit = true;
                    break;
                    default:
                        System.out.println("Invalid choice");
                        break;
            }

            runProgram(scanner, txt, chosenRole);
        }

        System.out.println("version 1.0");

    }
    public static Roles returnRoles(List<Roles>roles, String role){
        Roles checkRole = roles.stream()
                .filter(n -> n.getRole().equals(role))
                .findFirst()
                .orElse(null);

        return checkRole;

    }
    public static void runProgram(Scanner scanner, List<TxtFiles> txt, Roles role) {

        System.out.println("------------- Text Directory ------------- ");
        System.out.println();

        boolean goBack = false;

        while (!goBack){

            int choice;

            System.out.println("1. list text file");
            System.out.println("2. read text file ");
            System.out.println("3. write text file ");
            System.out.println("4. delete text file");
            System.out.println();
            System.out.println("0. return");
            System.out.println();
            System.out.print(">> ");

            try {
                choice = Integer.parseInt(scanner.next());
            }catch (NumberFormatException e){
                System.out.println("characters or strings are not valid!");
                continue;
            }

            switch (choice) {
                case 1:
                    if (txt.isEmpty()) {
                        System.out.println("No text files found");
                    }else{
                        txt.stream().forEach(file -> {
                            System.out.println(file.getName());
                        });
                    }
                    break;
                case 2:




            }



        }

        txt.stream()
                .forEach(n -> System.out.print("1. "+n.getName()));





    }
}
