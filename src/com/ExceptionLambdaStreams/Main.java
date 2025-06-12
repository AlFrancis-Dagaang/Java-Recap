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

            if(choice!=0){
                runProgram(scanner, txt, chosenRole);
            }

        }

        System.out.println("version 1.0");

    }
    public static Roles returnRoles(List<Roles>roles, String role){
       return roles.stream()
                .filter(n -> n.getRole().equals(role))
                .findFirst()
                .orElse(null);


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
                        txt.forEach(file -> {
                            System.out.println(file.getName());
                        });
                    }
                    break;
                case 2:

                    boolean hasAccessRead = role.getAction().isRead();

                    if(!hasAccessRead) {
                        System.out.println("You do not have permission to read text files");
                        continue;
                    }

                    if (txt.isEmpty()) {
                        System.out.println("No text files found");
                        continue;
                    }

                    txt.forEach(file -> System.out.println(file.getName()));


                    System.out.print("Enter the name file to read:");
                    String filename = scanner.next();
                    scanner.nextLine();

                    TxtFiles toBeRead = txt.stream()
                            .filter(file -> file.getName().equals(filename))
                            .findFirst()
                            .orElse(null);

                    if(toBeRead == null) {
                        System.out.println("File not found");
                        continue;
                    }else{
                        System.out.println(toBeRead.getName());
                        System.out.println(toBeRead.getBody());
                    }

                    break;

                case 3:

                    boolean hasAccessWrite = role.getAction().isWrite();

                    if(!hasAccessWrite) {
                        System.out.println("You do not have permission to write text files");
                        continue;
                    }

                    System.out.print("File name:");
                    String fileName = scanner.next();
                    scanner.nextLine();
                    System.out.println("File content:");
                    String body = scanner.nextLine();

                    txt.add(new TxtFiles(fileName, body));
                    System.out.println();
                    System.out.println("You have been successfully added to the text file:");

                    break;


                case 4:
                    boolean hasAccessDelete = role.getAction().isDelete();

                    if(!hasAccessDelete) {
                        System.out.println("You do not have permission to delete text files");
                        continue;
                    }

                    System.out.print("File name to delete:");
                    String fileNameToDelete = scanner.next();

                    TxtFiles toBeDeleted = txt.stream().filter(file -> file.getName().equals(fileNameToDelete)).findFirst()
                            .orElse(null);

                    if(toBeDeleted == null) {
                        System.out.println("File not found");
                        continue;
                    }
                        txt.stream().filter(file -> file.getName().equals(fileNameToDelete)).findFirst()
                                .ifPresent(txt::remove);
                    System.out.println();
                    System.out.println("You have been successfully deleted text file:");

                    break;

                case 0:
                    goBack = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }



        }







    }
}
