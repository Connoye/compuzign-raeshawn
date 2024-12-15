package org.example;

import org.example.commands.MenuOptionCommand;

import java.util.Scanner;

public class MainCli {

    private static final String USERNAME = "jfrog_user";
    private static final String PASSWORD = "P@ssw0rd12345";

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu(){
        System.out.println("Maven CLI Tool. Please to use help for available commands.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you wish to log into the Maven CLI? Y or N: ");
        String option = scanner.nextLine();
        switch(option){
            case "Y","y":
                System.out.println("Please enter your login credentials");
                System.out.print("Username: ");
                String user = scanner.nextLine();
                System.out.print("Password: ");
                String pswd = scanner.nextLine();
                while(option.equalsIgnoreCase("y")){
                    if(user.equalsIgnoreCase(USERNAME) && pswd.equals(PASSWORD)){
                        try {
                            MenuOptionCommand.displayMethodNames();
                        } catch (StackOverflowError e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        System.out.println("User/Password entered is incorrect. Do you wish to try again? Y or N");
                        option = scanner.nextLine();
                        if(option.equalsIgnoreCase("N"))
                            break;

                        System.out.println("Please enter your login credentials");
                        System.out.print("Username: ");
                        user = scanner.nextLine();
                        System.out.print("Password: ");
                        pswd = scanner.nextLine();
                    }
                }
                break;
            case "N","n":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("You have entered an invalid response. Goodbye!");
        }
    }
}