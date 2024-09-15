package com.example.appserver.Backend.BusinessLayer.Calender;

import java.util.Date;

public class TimeSlot {
    private Date startTime;
    private Date endTime;

    public TimeSlot(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public boolean overlapsWith(TimeSlot other) {
        return startTime.before(other.getEndTime()) && endTime.after(other.getStartTime());
    }

    public long getDurationInMinutes() {
        long diff = endTime.getTime() - startTime.getTime();
        return diff / (60 * 1000); // Convert milliseconds to minutes
    }

    @Override
    public String toString() {
        return "TimeSlot [startTime=" + startTime + ", endTime=" + endTime + "]";
    }
}
