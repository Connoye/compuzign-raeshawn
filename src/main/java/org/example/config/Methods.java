package org.example.config;

public enum Methods {
    get_users("Returns the list of users."),
    create_user("Creates a new Access user"),
    delete_user("Delete an existing Access user."),
    get_repos("Get all repository details"),
    create_repo("Creates a new local repository in Artifactory with the provided configuration"),
    sys_ping("Get a simple status response about the state of Artifactory."),
    sys_version("Get system version"),
    storage_info("Returns storage summary information regarding binaries, file store and repositories."),
    exit("Exit CLI program");

    private final String description;
    Methods(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }
}
