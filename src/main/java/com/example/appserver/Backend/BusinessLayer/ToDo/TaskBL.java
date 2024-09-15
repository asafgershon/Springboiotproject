package com.example.appserver.Backend.BusinessLayer.ToDo;

import com.example.appserver.Backend.DAO.TaskDAO;

import java.util.UUID;

public class TaskBL {
    private final UUID id;
    public String name;
    public boolean completed;
    public TaskPreferenceBL preference;
    public TaskDAO taskDAO;

    public TaskBL(UUID Boardid,String name, TaskPreferenceBL preference) {
        this.id = UUID.randomUUID(); // Generates a unique identifier
        this.name = name;
        this.completed = false;
        this.preference = preference;
        this.taskDAO = new TaskDAO(Boardid,id,name,completed,preference.getTimeEstimate(),preference.getErgency(),preference.getDueDate(),preference.getStartDate());
        this.taskDAO.persist();
    }

    public UUID getId() {
        return id;
    }

    public void FinishTask(){
        this.completed = true;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public TaskPreferenceBL getPreference() {
        return preference;
    }

    public void SetPreference(TaskPreferenceBL preference){
        this.preference = preference;
    }
}
