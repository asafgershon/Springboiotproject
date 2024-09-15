package com.example.appserver.Backend.BusinessLayer.ToDo;

import java.util.Date;

public class TaskPreferenceBL {

    public int timeEstimate;
    public int ergency;
    public Date dueDate;
    public Date startDate;

    public TaskPreferenceBL(int timeEstimate, int ergency, Date dueDate, Date startDate) {
        this.timeEstimate = timeEstimate;
        this.ergency = ergency;
        this.dueDate = dueDate;
        this.startDate = startDate;
    }

    public int getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(int timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public int getErgency() {
        return ergency;
    }

    public void setErgency(int ergency) {
        this.ergency = ergency;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
