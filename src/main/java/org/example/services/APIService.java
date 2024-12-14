package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class APIService {
    private static final String JFROG_API_BASE_URL = "https://trialh3yw33.jfrog.io/access/api";
    private static final String JFROG_API_URL = "https://trialh3yw33.jfrog.io/artifactory/api";
    private final String bearerToken;
    private static final Logger logger = LoggerFactory.getLogger(APIService.class);

    public APIService(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    private String executeRequest(ClassicHttpRequest request) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            request.setHeader("Authorization", "Bearer " + bearerToken);

            return httpClient.execute(request, response -> {
                int status = response.getCode();
                if (status >= 200 && status < 300) {
                    if(status != 204) {
                        return new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
                    }
                    return String.valueOf(status);
                } else {
                    throw new IOException("Request failed with status " + status);
                }
            });
        }
    }

    public String pingSystem() throws Exception {
        HttpGet request = new HttpGet(JFROG_API_BASE_URL + "/v1/system/ping");
        return executeRequest(request);
    }

    public String versionSystem() throws Exception {
        HttpGet request = new HttpGet(JFROG_API_BASE_URL + "/v1/system/version");
        return executeRequest(request);
    }

    public String getAllUsers() throws IOException {
        HttpGet request = new HttpGet(JFROG_API_BASE_URL + "/v2/users");
        return executeRequest(request);
    }

    public String addNewUserAccount(String username, String password, String email) throws IOException {
        HttpPost request = new HttpPost(JFROG_API_BASE_URL + "/v2/users");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> newUser = new HashMap<>();
        newUser.put("admin",false);
        newUser.put("username",username);
        newUser.put("password",password);
        newUser.put("email",email);
        newUser.put("profile_updatable",true);
        newUser.put("internal_password_disabled",false);
        newUser.put("disable_ui_access",false);
        newUser.put("groups",new ArrayList<>(Collections.singletonList("readers")));

        request.setEntity(new StringEntity(objectMapper.writeValueAsString(newUser), ContentType.APPLICATION_JSON));
        return executeRequest(request);
    }

    public String deleteUserAccount(String username) throws IOException {
        HttpDelete request = new HttpDelete(JFROG_API_BASE_URL + "/v2/users/" + username);
        return executeRequest(request);
    }

    public String getAllRepositories() throws Exception {
        HttpGet request = new HttpGet(JFROG_API_URL + "/repositories");
        return executeRequest(request);
    }

    public String getStorageInfo() throws Exception {
        HttpGet request = new HttpGet(JFROG_API_URL + "/storageinfo");
        return executeRequest(request);
    }


    public String addNewRepository(String repoName) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpPut request = new HttpPut(JFROG_API_URL + "/repositories/" + repoName);
        Map<String, String> payload = new HashMap<>();
        payload.put("rclass","local");
        request.setEntity(new StringEntity(objectMapper.writeValueAsString(payload), ContentType.APPLICATION_JSON));
        return executeRequest(request);
    }

}
