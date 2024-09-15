package com.example.appserver.Backend.BusinessLayer.Calender;

import com.example.appserver.Backend.DAO.appoinmentDAO;

import java.util.Date;
import java.util.UUID;

public class appointmentBL {

    private UUID appointmentID;
    private final UUID topicid;
    private String name;
    private String description;
    private String location;
    private Date date;
    private int startHour;
    private int duration;

    private appoinmentDAO appointmentDAO;

    public appointmentBL(UUID topicId, String name, String description, String location, Date date, int startHour, int duration) {
        this.topicid = topicId;
        this.appointmentID = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.startHour = startHour;
        this.duration = duration;
        this.appointmentDAO = new appoinmentDAO(appointmentID,topicId,name,description,location,date,startHour,duration);
        appointmentDAO.persist();
    }

    public UUID getId() {
        return appointmentID;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
