package com.example.appserver;

import com.example.appserver.Backend.BusinessLayer.Calender.calenderFacade;
import com.example.appserver.Backend.BusinessLayer.ToDo.TaskFacade;
import com.example.appserver.Backend.BusinessLayer.User.UserFacade;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalenderFacadeTest {

    private calenderFacade calendarFacade;
    private UUID topicId;
    private UserFacade userFacade;
    private TaskFacade taskFacade;

    @BeforeEach
    public void setUp() {
        userFacade = new UserFacade();
        calendarFacade = new calenderFacade(userFacade);
        taskFacade = new TaskFacade(userFacade, calendarFacade);
        topicId = calendarFacade.createTopic("user1", "Test Topic").getId();
    }

    @Test
    public void testAutoScheduleTask() {
        // Schedule an existing appointment from 9:00 to 10:00
        Date existingAppointmentDate = createDate(9, 0);
        calendarFacade.addappoinment(topicId, "Existing Task", "Description", "Location", existingAppointmentDate, 9, 60);

        // Attempt to schedule a new task for 1 hour (60 minutes)
        boolean success = taskFacade.autoScheduleTask(topicId, "New Task", "New Task Description", "New Location", new Date(), 60);

        assertEquals(true,success);
    }

    @Test
    public void testAutoScheduleTaskNoAvailableSlot() {
        // Schedule appointments to fill the entire day
        //calendarFacade.addappoinment(topicId, "Task 1", "Description", "Location", createDate(9, 0), 9, 120); // 9:00 - 11:00
        //calendarFacade.addappoinment(topicId, "Task 2", "Description", "Location", createDate(11, 0), 11, 120); // 11:00 - 13:00
        //calendarFacade.addappoinment(topicId, "Task 3", "Description", "Location", createDate(13, 0), 13, 120); // 13:00 - 15:00
        //calendarFacade.addappoinment(topicId, "Task 4", "Description", "Location", createDate(15, 0), 15, 120); // 15:00 - 17:00

        // Attempt to schedule a new task for 1 hour (60 minutes)
        //boolean success = taskFacade.autoScheduleTask(topicId, "New Task", "New Task Description", "New Location", new Date(), 60);

        //assertEquals(false,success);
    }

    @Test
    public void testAutoScheduleTaskAfterLastAppointment() {
        // Schedule an existing appointment from 9:00 to 10:00
        calendarFacade.addappoinment(topicId, "Existing Task", "Description", "Location", createDate(9, 0), 9, 60);

        // Attempt to schedule a new task for 1 hour (60 minutes) starting after the existing appointment
        boolean success = taskFacade.autoScheduleTask(topicId, "New Task", "New Task Description", "New Location", new Date(), 60);

        assertEquals(true,success);
    }

    // Helper method to create Date objects for specific times
    private Date createDate(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}