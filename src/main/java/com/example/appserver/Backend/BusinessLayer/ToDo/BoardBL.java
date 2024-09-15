package com.example.appserver.Backend.BusinessLayer.ToDo;

import com.example.appserver.Backend.DAO.BoardDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BoardBL {

    private String Owner;
    private final UUID id;
    public String name;
    public List<TaskBL> tasks;
    public List<TaskBL> finishedTasks;
    public BoardDAO boardDAO;

    public BoardBL(String username, String name) {
        this.Owner = username;
        this.id = UUID.randomUUID();
        this.name = name;
        this.tasks = new ArrayList<>();
        this.finishedTasks = new ArrayList<>();
        this.boardDAO = new BoardDAO(username,id,name);
        this.boardDAO.persist();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addTask(TaskBL task) {
        this.tasks.add(task);
    }

    public List<TaskBL> getTasks() {
        return new ArrayList<>(tasks); // Return a copy to prevent external modification
    }

    public void removeTask(UUID taskId) {
        tasks.removeIf(task -> task.getId().equals(taskId));
    }

    public TaskBL getTask(UUID taskId) {
        return tasks.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElse(null);
    }

    public void FinishTask(TaskBL task) {
        this.tasks.remove(task);
        this.finishedTasks.add(task);
    }

    public List<TaskBL> getFinishedTasks(){
        return finishedTasks;
    }

    public String getOwner() {
        return Owner;
    }
}
