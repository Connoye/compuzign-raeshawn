package org.example.commands;


import org.example.services.APIService;

public class StorageCommand {

    private final APIService apiService;

    public StorageCommand(String token) {
        this.apiService = new APIService(token);
    }

    /**
     * Call API Service to execute an endpoint that will retrieve the storage information
     */
    public void executeGetStorageInfo() {
        try {
            String storageInfo = apiService.getStorageInfo();
            System.out.println("Storage Details:\n" + storageInfo);
        } catch (Exception e) {
            System.err.println("Error fetching storage details: " + e.getMessage());
        }
    }

}
