package com.example.appserver.Backend.DAO;

import java.util.UUID;

public class BoardDAO {

    public String username;
    public UUID id;
    public String name;
    private boolean Ispresist;
    private Boardcontroller controller;

    public BoardDAO(String username, UUID id, String name) {
        this.username = username;
        this.id = id;
        this.name = name;
        Ispresist = false;
        controller = new Boardcontroller();
    }

    public String getUsername() {
        return username;
    }

    public UUID getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void persist()
    {
        if (this.Ispresist)
        {
            throw new IllegalArgumentException("the user already in the saved");
        }
        this.controller.addBoard(this);
        this.Ispresist = true;
    }
}
