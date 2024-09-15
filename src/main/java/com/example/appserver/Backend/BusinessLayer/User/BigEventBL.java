package com.example.appserver.Backend.BusinessLayer.User;

import com.example.appserver.Backend.DAO.EventDAO;
import com.example.appserver.Backend.Model.BigEvent;

import java.util.UUID;

public class BigEventBL {

    private final UUID id;
    public String name;
    public String description;
    public java.util.Date Date;
    public int reminder;
    private EventDAO eventDAO;

    public BigEventBL(String username,String name, String description, java.util.Date Date, int reminder) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.Date = Date;
        this.reminder = reminder;
        this.eventDAO = new EventDAO(id,username, name, description, Date, reminder);
        eventDAO.persist();
    }

    // Constructor to initialize BigEventBL using a BigEvent model object
    public BigEventBL(BigEvent event) {
        this.id = event.getId();          // Use the id from BigEvent
        this.name = event.getName();
        this.description = event.getDescription();
        this.Date = event.getDate();
        this.reminder = event.getReminder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public int getReminder() {
        return reminder;
    }

    public void setReminder(int reminder) {
        this.reminder = reminder;
    }
}
