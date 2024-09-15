package com.example.appserver.Backend.ServiceLayer.ToDo;

import com.example.appserver.Backend.BusinessLayer.ToDo.TaskPreferenceBL;

import java.util.Date;

public class TaskPreferenceSL {

    public int timeEstimate;
    public int ergency;
    public Date dueDate;
    public Date startDate;

    public TaskPreferenceSL(TaskPreferenceBL taskPreferenceBL){
        this.timeEstimate = taskPreferenceBL.getTimeEstimate();
        this.ergency = taskPreferenceBL.getErgency();
        this.dueDate = taskPreferenceBL.getDueDate();
        this.startDate = taskPreferenceBL.getStartDate();
    }
}
