package org.example.model;

import java.util.ArrayList;

public class User {
    public String getUsername() {
        return this.username; }
    public void setUsername(String username) {
        this.username = username; }
    String username;
    public String getPassword() {
        return this.password; }
    public void setPassword(String password) {
        this.password = password; }
    String password;
    public String getEmail() {
        return this.email; }
    public void setEmail(String email) {
        this.email = email; }
    String email;
    public ArrayList<String> getGroups() {
        return this.groups; }
    public void setGroups(ArrayList<String> groups) {
        this.groups = groups; }
    ArrayList<String> groups;
    public boolean getAdmin() {
        return this.admin; }
    public void setAdmin(boolean admin) {
        this.admin = admin; }
    boolean admin;
    public boolean getProfile_updatable() {
        return this.profile_updatable; }
    public void setProfile_updatable(boolean profile_updatable) {
        this.profile_updatable = profile_updatable; }
    boolean profile_updatable;
    public boolean getInternal_password_disabled() {
        return this.internal_password_disabled; }
    public void setInternal_password_disabled(boolean internal_password_disabled) {
        this.internal_password_disabled = internal_password_disabled; }
    boolean internal_password_disabled;
    public boolean getDisable_ui_access() {
        return this.disable_ui_access; }
    public void setDisable_ui_access(boolean disable_ui_access) {
        this.disable_ui_access = disable_ui_access; }
    boolean disable_ui_access;
}
