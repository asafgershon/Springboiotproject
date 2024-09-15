package com.example.appserver.Backend.DAO;

import java.util.Date;
import java.util.UUID;

public class appoinmentDAO {

    private UUID appointmentID;
    private UUID topicid;
    private String name;
    private String description;
    private String location;
    private Date date;
    private int startHour;
    private int duration;

    private boolean Ispresist;
    private calenderController controller;

    public appoinmentDAO(UUID appointmentID,UUID topicid, String name, String description, String location, Date date, int startHour, int duration) {
        this.appointmentID = appointmentID;
        this.topicid = topicid;
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.startHour = startHour;
        this.duration = duration;
        this.Ispresist = false;
        this.controller = new calenderController();
    }

    public UUID getAppointmentID() {
        return appointmentID;
    }

    public UUID getTopicID() {
        return topicid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getDuration() {
        return duration;
    }

    public void persist()
    {
        if (this.Ispresist)
        {
            throw new IllegalArgumentException("the user already in the saved");
        }
        this.controller.addappoinment(this);
        this.Ispresist = true;
    }
}
