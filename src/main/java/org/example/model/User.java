package org.example.model;

import java.util.ArrayList;

public class User {
    public void setUsername(String username) {
        this.username = username; }
    String username;
    public void setPassword(String password) {
        this.password = password; }
    String password;
    public void setEmail(String email) {
        this.email = email; }
    String email;
    public void setGroups(ArrayList<String> groups) {
        this.groups = groups; }
    ArrayList<String> groups;
    public void setAdmin(boolean admin) {
        this.admin = admin; }
    boolean admin;
    public void setProfile_updatable(boolean profile_updatable) {
        this.profile_updatable = profile_updatable; }
    boolean profile_updatable;
    public void setInternal_password_disabled(boolean internal_password_disabled) {
        this.internal_password_disabled = internal_password_disabled; }
    boolean internal_password_disabled;
    public void setDisable_ui_access(boolean disable_ui_access) {
        this.disable_ui_access = disable_ui_access; }
    boolean disable_ui_access;
}
