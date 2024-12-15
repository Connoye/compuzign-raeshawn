package org.example.commands;

import org.example.config.Methods;

import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class MenuOptionCommand {

    private static  final String TOKEN = "eyJ2ZXIiOiIyIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYiLCJraWQiOiJYenpvRy1JLXp6dnlRcThQV1pHenVERmM4eHNuRHJKM200SEl6RzcyeS0wIn0.eyJzdWIiOiJqZmFjQDAxamVqbTVhNmQ2czVxMTB5NWp6MWcxbTg2L3VzZXJzL2dvcmNvbiIsInNjcCI6ImFwcGxpZWQtcGVybWlzc2lvbnMvdXNlciIsImF1ZCI6IipAKiIsImlzcyI6ImpmZmVAMDFqZWptNWE2ZDZzNXExMHk1anoxZzFtODYiLCJpYXQiOjE3MzM3MTE0NzMsImp0aSI6IjA5ZTRhMzkzLWYzOGEtNGRlNy1hNTM2LTg4OTM0NjM2NDU0OSIsInRpZCI6ImEwZHMzdXQzbmxjeWQifQ.Apqcq7Grs2L04KOR0D1dF1KhPGp8UKYJJs0vpdyOa4-uMPDVSXZOnBrtYVSqMStTKw2Ufc_vcwKWfA1xh9b90yzW9sN4xJ-SNhfxg94LbrByR6p9TWIo0E085L_az8xD8x66kizcaHIfETsLIeyQdXvGmiIuNyeHI7omJdW6NGks0JnXypjq7i5B0-6giAUr9qejp8yUn8AHQ0wjhDWIudFZSM-21FQCy31cGz4QTklsZg15O6ArGyettKxY21_5EzHqb58XeBDfcNoRSa7RG1zzLlwomkUu5D80PihutV4k0i-pqMfhriCtRyAbr1Zbb0Sneuc2UdRMlr5kvXPwKQ";//System.getenv("TOKEN_KEY");

    /**
     * Display a list of commands available
     */
    public static void displayMethodNames() {
            System.out.println();
            System.out.println("Available CLI Methods:");
            System.out.println();
            System.out.printf("%-20s %-50s%n", "Command", "Description");
            System.out.println("---------------------------------------------------------------");
            for (Methods method : Methods.values()) {
                System.out.printf("%-20s %-50s%n", method.name(), method.getDescription());
            }
            System.out.println("---------------------------------------------------------------");

            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.print("Select a command: ");
            String command = scanner.nextLine();

            if(command.isEmpty()) {
                System.out.println("Please enter a valid command.");
                displayMethodNames();
            }else{
                commandOption(command);
            }
    }

    /**
     * Accept user command request and return the appropriate response
     * @param command String
     */
    public static void commandOption(String command){
            String username;
            String password;
            String email;
            switch (command) {
                case "get_users":
                    new UserCommand(TOKEN).executeGetUser();
                    break;
                case "create_user":
                    username = usernameValidation();
                    password = passwordValidation();
                    email = emailValidation();
                    new UserCommand(TOKEN).executeAddNewUser(username, password, email);
                    break;
                case "delete_user":
                    username = usernameValidation();
                    new UserCommand(TOKEN).executeDeleteUser(username);
                    break;
                case "get_repos":
                    new RepositoryCommand(TOKEN).executeGetRepositories();
                    break;
                case "create_repo":
                    System.out.println("Enter repository name: ");
                    String repoName = repoNameValidation();
                    new RepositoryCommand(TOKEN).executeAddNewRepository(repoName);
                    break;
                case "sys_ping":
                    new SystemCommand(TOKEN).executeSystemPing();
                    break;
                case "sys_version":
                    new SystemCommand(TOKEN).executeSystemVersion();
                    break;
                case "storage_info":
                    new StorageCommand(TOKEN).executeGetStorageInfo();
                    break;
                case "exit":
                    System.out.println("Thank you for using our Maven CLI. Goodbye!");
                    exit(0);
                    break;
                default:
                    System.out.println("You have entered an invalid command.");
            }
            displayMethodNames();
    }

    /**
     * Evaluate and return a valid password
     * @return String
     */
    public static String passwordValidation(){
        passwordRequirement();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (password == null) {
            System.out.println("Please enter a valid password.");
            passwordValidation();
        }else {

            // Pattern class contains matcher() method
            // to find matching between given password
            // and regular expression.
            if (!p.matcher(password).matches()) {
                System.out.println("Please enter a valid password.");
                passwordValidation();
            }
        }
        return password;
    }


    /**
     * Display password requirements for creating new user account
     */
    public static void passwordRequirement(){
        System.out.println("""
                - It contains at least 8 characters and at most 20 characters.
                - It contains at least one digit.
                - It contains at least one upper case alphabet.
                - It contains at least one lower case alphabet.
                - It contains at least one special character which includes !@#$%&*()-+=^.
                - It doesn’t contain any white space.""");
    }

    /**
     * Display username requirements for creating new user account
     */
    public static void usernameRequirement(){
        System.out.println("""
                - The username consists of 5 to 30 characters inclusive. If the username
                consists of less than 5 or greater than 30 characters, then it is an invalid username.
                - The username can only contain alphanumeric characters and underscores (_). Alphanumeric characters
                describe the character set consisting of lowercase characters [a – z], uppercase characters [A – Z], and digits [0 – 9].
                - The first character of the username must be an alphabetic character, i.e., either lowercase character
                [a – z] or uppercase character [A – Z].""");
    }

    /**
     * Display the requirements for creating a new repository
     */
    public static void repositoryRequirement(){
        System.out.println("""
                - A mandatory identifier for the repository that must be unique.
                - It cannot contain spaces or special characters.
                - Name cannot be empty.
                - Name cannot contain the following characters.
                - Name cannot start with the following: Jfrog-system-reserved or Jfrog-artifactory-system.
                - Name cannot end with the following: -cache.
                - Min number of characters for local repositories is 8.
                - Max number of characters for local repositories is 64.""");
    }

    /**
     * Evaluate and return a valid username
     * @return String
     */
    public static String usernameValidation(){
        usernameRequirement();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        // Regex to check valid username.
        String regex = "^[A-Za-z]\\w{4,29}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the username is empty
        // return false
        if (username == null) {
            System.out.println("Please enter a valid username.");
            usernameValidation();
        }else {

            // Pattern class contains matcher() method
            // to find matching between given username
            // and regular expression.
            if (!p.matcher(username).matches()) {
                System.out.println("Please enter a valid username.");
                usernameValidation();
            }
        }
        return username;
    }

    /**
     * Evaluate and return a valid repository name
     * @return String
     */
    public static String repoNameValidation(){
        repositoryRequirement();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter repository name: ");
        String repoName = scanner.nextLine();
        // Regex to check valid repository name.
        String regex = "^[A-Za-z]\\w{8,63}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the repository name is empty
        // return false
        if (repoName == null) {
            System.out.println("Please enter a valid repository name.");
            repoNameValidation();
        }else {

            // Pattern class contains matcher() method
            // to find matching between given repository name
            // and regular expression.
            if (!p.matcher(repoName).matches()) {
                System.out.println("Please enter a valid repository name.");
                repoNameValidation();
            }
        }
        return repoName;
    }
    /**
     * evaluate and return a valid formatted email address
     * @return String
     */
    public static String emailValidation(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        // Regular expression to match valid email formats
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the email is empty
        if (email == null) {
            System.out.println("Please enter a valid email.");
            emailValidation();
        }else {

            // Pattern class contains matcher() method
            // to find matching between given email
            // and regular expression.
            if (!p.matcher(email).matches()) {
                System.out.println("Please enter a valid email.");
                emailValidation();
            }
        }
        return email;
    }
}
