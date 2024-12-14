package org.example.commands;

import org.example.services.APIService;

import java.io.IOException;

public class UserCommand {
    private final APIService apiService;

    public UserCommand(String token) {
        this.apiService = new APIService(token);
    }

    public void executeGetUser() {
        try {
            String userDetails = apiService.getAllUsers();
            System.out.println("User Details:\n" + userDetails);
        } catch (IOException e) {
            System.err.println("Error fetching user details: " + e.getMessage());
        }
    }

    public void executeAddNewUser(String username, String password, String email){
        try {
            String userDetails = apiService.addNewUserAccount(username,password,email);
            System.out.println("New user Details:\n" + userDetails);
        } catch (IOException e) {
            System.err.println("Error saving user details: " + e.getMessage());
        }
    }


  public void executeDeleteUser(String username){
        try {
            String userDetails = apiService.deleteUserAccount(username);
            System.out.println("Delete User:\n" + userDetails);
        } catch (IOException e) {
            System.err.println("Error deleting user details: " + e.getMessage());
        }
    }


}
