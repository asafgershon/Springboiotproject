package com.example.appserver.Backend.BusinessLayer.Calender;

import com.example.appserver.Backend.DAO.topicDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class topicBL {

    private final UUID id;
    public String name;
    public List<appointmentBL> appointments;
    public topicDAO topicDAO;

    public topicBL(String username,String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.appointments = new ArrayList<>();
        this.topicDAO = new topicDAO(id,username,name);
        topicDAO.persist();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<appointmentBL> getAppointments() {
        return appointments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAppointment(appointmentBL appointment) {
        this.appointments.add(appointment);
    }

    public void removeAppointment(appointmentBL appointment) {
        this.appointments.remove(appointment);
    }
}
