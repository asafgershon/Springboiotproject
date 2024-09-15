package com.example.appserver.Backend.BusinessLayer.Calender;

import com.example.appserver.Backend.BusinessLayer.User.UserFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class calenderFacade {

    private UserFacade uf;
    private static final Logger logger = LoggerFactory.getLogger(calenderFacade.class);
    private final Map<UUID, topicBL> topics;

    public calenderFacade(UserFacade uf) {
        this.uf = uf;
        this.topics = new HashMap<>();
    }

    public topicBL createTopic(String username, String topicname){
        topicBL newtopic = new topicBL(username,topicname);
        topics.put(newtopic.getId(),newtopic);
        return newtopic;
    }

    public appointmentBL addappoinment(UUID topicId, String name, String description, String location, Date date, int startHour, int duration){
        appointmentBL newappo = new appointmentBL(topicId,name,description,location,date,startHour,duration);
        topicBL topic = topics.get(topicId);
        topic.addAppointment(newappo);
        return newappo;
    }

    public TimeSlot findAvailableTimeSlot(UUID topicId, int requiredMinutes) {
        topicBL topic = topics.get(topicId);

        if (topic == null) {
            logger.debug("Topic not found!");
            return null;
        }

        Date currentTime = new Date(); // Start checking from now
        for (appointmentBL appointment : topic.getAppointments()) {
            Date appointmentStart = appointment.getDate();
            Date appointmentEnd = new Date(appointmentStart.getTime() + appointment.getDuration() * 60 * 1000);
            long gap = appointmentStart.getTime() - currentTime.getTime();

            if (gap >= requiredMinutes * 60 * 1000) { // Convert minutes to milliseconds
                return new TimeSlot(currentTime, new Date(currentTime.getTime() + requiredMinutes * 60 * 1000));
            }
            currentTime = appointmentEnd;
        }

        // Check if there's time after the last appointment
        return new TimeSlot(currentTime, new Date(currentTime.getTime() + requiredMinutes * 60 * 1000));
    }
}
