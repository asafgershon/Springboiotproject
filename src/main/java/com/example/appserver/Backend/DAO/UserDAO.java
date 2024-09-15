package com.example.appserver.Backend.DAO;

public class UserDAO {

    private String name;
    private String username;
    private String Password;
    private boolean Ispresist;
    private UserController controller;

    public UserDAO(String name, String username, String Password) {
        this.name = name;
        this.username = username;
        this.Password = Password;
        this.Ispresist = false;
        this.controller = new UserController();
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return Password;
    }

    public void persist()
    {
        if (this.Ispresist)
        {
            throw new IllegalArgumentException("the user already in the saved");
        }
        this.controller.addUser(this);
        this.Ispresist = true;
    }
}
