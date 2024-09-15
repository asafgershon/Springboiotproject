package com.example.appserver.Backend.ServiceLayer.Calender;

import com.example.appserver.Backend.BusinessLayer.Calender.appointmentBL;
import com.example.appserver.Backend.BusinessLayer.Calender.calenderFacade;
import com.example.appserver.Backend.BusinessLayer.Calender.topicBL;
import com.example.appserver.Backend.ServiceLayer.Response;

import java.util.Date;
import java.util.UUID;

public class calenderService {

    public calenderFacade cf;

    public calenderService(calenderFacade cf){
        this.cf = cf;
    }

    public Response createTopic(String username, String topicname) {
        try{
            topicBL topic = cf.createTopic(username,topicname);
            Response<topicSL> response = new Response<>(new topicSL(topic));
            return response;
        }
        catch(Exception e){
            Response error = new Response(true,e.getMessage());
            return error;
        }
    }

    public Response addappoinment(UUID topicId, String name, String description, String location, Date date, int startHour, int duration) {
        try{
            appointmentBL appointmentBL = cf.addappoinment(topicId, name, description, location, date, startHour, duration);
            Response<appointmentSL> response = new Response<>(new appointmentSL(appointmentBL));
            return response;
        }
        catch(Exception e){
            Response error = new Response(true,e.getMessage());
            return error;
        }
    }

}
