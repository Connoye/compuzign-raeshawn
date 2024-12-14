package org.example.commands;

import org.example.services.APIService;

public class SystemCommand{

    private final APIService apiService;

    public SystemCommand(String token) {
        this.apiService = new APIService(token);
    }

    /**
     * Call API Service to execute an endpoint that will ping the system
     */
    public void executeSystemPing() {
        try {
            String pingSystem = apiService.pingSystem();
            System.out.println("System ping:\n" + pingSystem);
        } catch (Exception e) {
            System.err.println("Error pinging system: " + e.getMessage());
        }
    }


    /**
     * Call API Service to execute an endpoint that will retrieve the system version
     */
    public void executeSystemVersion() {
        try {
            String versionSystem = apiService.versionSystem();
            System.out.println("System version:\n" + versionSystem);
        } catch (Exception e) {
            System.err.println("Error fetching systems version: " + e.getMessage());
        }
    }




}
