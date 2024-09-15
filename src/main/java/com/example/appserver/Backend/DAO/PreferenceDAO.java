package com.example.appserver.Backend.DAO;

public class PreferenceDAO {
    public String username;
    public int startDay;
    public int endDay;
    public int breakTime;
    public int workScene;
    private boolean Ispresist;
    private UserController controller;

    public PreferenceDAO(String username,int startDay, int endDay, int breakTime, int workScene) {
        this.username = username;
        this.startDay = startDay;
        this.endDay = endDay;
        this.breakTime = breakTime;
        this.workScene = workScene;
        controller = new UserController();
        Ispresist = false;
    }

    public String getUsername() {
        return username;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public int getWorkScene() {
        return workScene;
    }

    public void persist()
    {
        if (this.Ispresist)
        {
            throw new IllegalArgumentException("the user already in the saved");
        }
        this.controller.addPreference(this);
        this.Ispresist = true;
    }
}
