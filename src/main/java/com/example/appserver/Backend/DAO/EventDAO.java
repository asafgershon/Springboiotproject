package com.example.appserver.Backend.DAO;

import java.util.UUID;

public class EventDAO {

    public UUID id;
    public String username;
    public String name;
    public String description;
    public java.util.Date Date;
    public int reminder;
    private boolean Ispresist;
    private UserController controller;

    public EventDAO(UUID Id,String username, String name, String description, java.util.Date Date, int reminder) {
        this.id = Id;
        this.username = username;
        this.name = name;
        this.description = description;
        this.Date = Date;
        this.reminder = reminder;
        controller = new UserController();
        Ispresist = false;
    }

    public UUID getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public java.sql.Date getSQLDate() {
        return new java.sql.Date(Date.getTime());
    }

    public int getReminder() {
        return reminder;
    }

    public void persist()
    {
        if (this.Ispresist)
        {
            throw new IllegalArgumentException("the user already in the saved");
        }
        this.controller.addEvent(this);
        this.Ispresist = true;
    }

}
