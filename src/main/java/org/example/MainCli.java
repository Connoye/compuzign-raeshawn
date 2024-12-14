package org.example;

import org.example.commands.MenuOptionCommand;

import java.util.Scanner;

public class MainCli {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "P@ssw0rd.12345";

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu(){
        System.out.println("Maven CLI Tool. Please to use help for available commands.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you wish to log into the Maven CLI? Y or N ");
        String option = scanner.nextLine();
        switch(option){
            case "Y","y":
                System.out.println("Please enter your login credentials");
                System.out.println("Username: ");
                String user = scanner.nextLine();
                System.out.println("Password: ");
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
                        System.out.println("Username: ");
                        user = scanner.nextLine();
                        System.out.println("Password: ");
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