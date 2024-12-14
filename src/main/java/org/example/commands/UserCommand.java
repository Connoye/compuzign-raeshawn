package org.example.commands;

import org.example.services.APIService;

import java.io.IOException;

public class UserCommand {
    private final APIService apiService;

    public UserCommand(String token) {
        this.apiService = new APIService(token);
    }

    /**
     * Call API Service to execute an endpoint that will retrieve all existing user details
     */
    public void executeGetUser() {
        try {
            String userDetails = apiService.getAllUsers();
            System.out.println("User Details:\n" + userDetails);
        } catch (IOException e) {
            System.err.println("Error fetching user details: " + e.getMessage());
        }
    }

    /**
     * Call API Service to execute an endpoint that will create a new user
     * @param username String
     * @param password String
     * @param email String
     */
    public void executeAddNewUser(String username, String password, String email){
        try {
            String userDetails = apiService.addNewUserAccount(username,password,email);
            System.out.println("New user Details:\n" + userDetails);
        } catch (IOException e) {
            System.err.println("Error saving user details: " + e.getMessage());
        }
    }


    /**
     * Call API Service to execute an endpoint that will delete an existing user details
     * @param username String
     */
  public void executeDeleteUser(String username){
        try {
            String userDetails = apiService.deleteUserAccount(username);
            System.out.println("Delete User:\n" + userDetails);
        } catch (IOException e) {
            System.err.println("Error deleting user details: " + e.getMessage());
        }
    }


}
