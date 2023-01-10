package com.example.ihmproject;

public class User {
    private int ID;
    private String Username;
    private String Password;

    public User() {
    }

    public User(int ID, String username, String password) {
        this.ID = ID;
        Username = username;
        Password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
