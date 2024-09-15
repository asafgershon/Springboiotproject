package com.example.appserver.Backend.ServiceLayer.Calender;

import com.example.appserver.Backend.BusinessLayer.Calender.appointmentBL;

import java.util.Date;

public class appointmentSL {

    private String name;
    private String description;
    private String location;
    private Date date;
    private int startHour;
    private int duration;

    public appointmentSL(appointmentBL app){
        name = app.getName();
        description = app.getDescription();
        location = app.getLocation();
        date = app.getDate();
        startHour = app.getStartHour();
        duration = app.getDuration();
    }
}
