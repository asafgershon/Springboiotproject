package com.example.appserver.Backend.ServiceLayer.User;

import com.example.appserver.Backend.BusinessLayer.User.BigEventBL;

import java.util.Date;

public class BigEventSL {

    public String name;
    public String description;
    public Date Date;
    public int reminder;

    public BigEventSL(String name, String description, Date Date, int reminder) {
        this.name = name;
        this.description = description;
        this.Date = Date;
        this.reminder = reminder;
    }

    public BigEventSL(BigEventBL event) {
        this.name = event.getName();
        this.description = event.getDescription();
        this.Date = event.getDate();
        this.reminder = event.getReminder();
    }
}
