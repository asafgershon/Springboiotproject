package com.example.appserver.Backend.ServiceLayer.Calender;

import com.example.appserver.Backend.BusinessLayer.Calender.appointmentBL;
import com.example.appserver.Backend.BusinessLayer.Calender.topicBL;

import java.util.ArrayList;
import java.util.List;

public class topicSL {

    public String name;
    public List<appointmentSL> appointments;

    public topicSL(topicBL topic){
        this.name = topic.getName();
        List<appointmentBL> newapp = topic.getAppointments();
        this.appointments = new ArrayList<>();
        for(appointmentBL ap : newapp){
            appointments.add(new appointmentSL(ap));
        }
    }
}
