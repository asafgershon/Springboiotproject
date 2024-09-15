package com.example.appserver.Backend.DAO;

import java.util.Date;
import java.util.UUID;

public class TaskDAO {

    private UUID taskId;
    private UUID boardId;
    public String name;
    public boolean completed;
    public int timeEstimate;
    public int ergency;
    public Date dueDate;
    public Date startDate;

    private boolean Ispresist;
    private Boardcontroller controller;

    public TaskDAO(UUID boardId,UUID taskId,String name,boolean completed,int timeEstimate,int ergency,Date dueDate,Date startDate) {
        this.boardId = boardId;
        this.taskId = taskId;
        this.name = name;
        this.completed = completed;
        this.timeEstimate = timeEstimate;
        this.ergency = ergency;
        this.dueDate = dueDate;
        this.startDate = startDate;
        controller = new Boardcontroller();
        Ispresist = false;
    }

    public UUID getBoardId(){
        return boardId;
    }

    public UUID getTaskId(){
        return taskId;
    }

    public String getName(){
        return name;
    }

    public boolean getCompleted(){
        return completed;
    }

    public int getTimeEstimate(){
        return timeEstimate;
    }

    public int getErgency(){
        return ergency;
    }

    public Date getDueDate(){
        return dueDate;
    }

    public Date getStartDate(){
        return startDate;
    }


    public void persist()
    {
        if (this.Ispresist)
        {
            throw new IllegalArgumentException("the user already in the saved");
        }
        this.controller.addTask(this);
        this.Ispresist = true;
    }
}
