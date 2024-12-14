package org.example.commands;


import org.example.services.APIService;

public class RepositoryCommand {

    private final APIService apiService;

    public RepositoryCommand(String token) {
        this.apiService = new APIService(token);
    }

    /**
     * Call the API service to execute an endpoint to retrieve all existing repositories
     */
    public void executeGetRepositories() {
        try {
            String repoDetails= apiService.getAllRepositories();
            System.out.println("Repository Details:\n" + repoDetails);
        } catch (Exception e) {
            System.err.println("Error fetching repository details: " + e.getMessage());
        }
    }

    /**
     * Call API Service to execute an endpoint to create a new repository
     * @param repoName String
     */
    public void executeAddNewRepository(String repoName) {
        try {
            String repoDetails = apiService.addNewRepository(repoName);
            System.out.println("Repository Details:\n" + repoDetails);
        } catch (Exception e) {
            System.err.println("Error adding new local repository details: " + e.getMessage());
        }
    }
}
