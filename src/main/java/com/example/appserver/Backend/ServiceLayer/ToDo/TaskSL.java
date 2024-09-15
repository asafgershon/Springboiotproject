package com.example.appserver.Backend.ServiceLayer.ToDo;

import com.example.appserver.Backend.BusinessLayer.ToDo.TaskBL;
import com.example.appserver.Backend.BusinessLayer.ToDo.TaskPreferenceBL;

public class TaskSL {

    public String name;
    public boolean complete;
    public TaskPreferenceSL preference;

    public TaskSL(String name) {
        this.name = name;
        this.complete = false;
        this.preference = null;
    }

    public TaskSL(TaskBL taskBL){
        this.name = taskBL.getName();
        this.complete = taskBL.isCompleted();
        TaskPreferenceBL preferenceBL = taskBL.getPreference();
        this.preference = new TaskPreferenceSL(preferenceBL);
    }

    public void FinishTask(){
        this.complete = true;
    }

    public void SetPreference(TaskPreferenceSL preference){
        this.preference = preference;
    }
}
