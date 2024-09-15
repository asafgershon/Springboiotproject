package com.example.appserver.Backend.ServiceLayer.ToDo;

import com.example.appserver.Backend.BusinessLayer.ToDo.BoardBL;
import com.example.appserver.Backend.BusinessLayer.ToDo.TaskBL;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BoardSL {

    public UUID id;
    public String name;
    public List<TaskSL> tasks;
    public List<TaskSL> finishedTasks;

    public BoardSL(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
        this.finishedTasks = new ArrayList<>();
    }

    public BoardSL(BoardBL boardBL){
        this.id = boardBL.getId();
        this.name = boardBL.getName();
        this.tasks = new ArrayList<>();
        this.finishedTasks = new ArrayList<>();
        List<TaskBL> taskBLs = boardBL.getTasks();
        for(TaskBL taskBL : taskBLs){
            TaskSL newtask = new TaskSL(taskBL);
            this.tasks.add(newtask);
        }
        List<TaskBL> finish = boardBL.getTasks();
        for(TaskBL taskBL : finish){
            TaskSL newtsask = new TaskSL(taskBL);
            this.finishedTasks.add(newtsask);
        }
    }

    public void addTask(TaskSL task) {
        this.tasks.add(task);
    }

    public void FinishTask(TaskSL task) {
        this.tasks.remove(task);
        this.finishedTasks.add(task);
    }

    public void DeleteTask(TaskSL task) {
        if(this.tasks.contains(task)) {
            this.tasks.remove(task);
        }
        else{
            this.finishedTasks.remove(task);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskSL> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskSL> tasks) {
        this.tasks = tasks;
    }

    public List<TaskSL> getFinishedTasks() {
        return finishedTasks;
    }

    public void setFinishedTasks(List<TaskSL> finishedTasks) {
        this.finishedTasks = finishedTasks;
    }

    public long getId(){
        return Long.valueOf(id.toString());
    }
}
