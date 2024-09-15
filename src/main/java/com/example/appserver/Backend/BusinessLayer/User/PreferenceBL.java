package com.example.appserver.Backend.BusinessLayer.User;

import com.example.appserver.Backend.DAO.PreferenceDAO;
import com.example.appserver.Backend.Model.UserPreferences;

public class PreferenceBL {
    public int startDay;
    public int endDay;
    public int breakTime;
    public int workScene;
    private PreferenceDAO preferenceDAO;

    // Constructor to initialize preferences with provided values and persist them
    public PreferenceBL(String username, int startDay, int endDay, int breakTime, int BreakNumber) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.breakTime = breakTime;
        this.workScene = BreakNumber;
        this.preferenceDAO = new PreferenceDAO(username, startDay, endDay, breakTime, workScene);
        this.preferenceDAO.persist();
    }

    // Constructor to initialize preferences using UserPreferences object
    public PreferenceBL(UserPreferences preferences) {
        this.startDay = preferences.getStartDay();
        this.endDay = preferences.getEndDay();
        this.breakTime = preferences.getBreakTime();
        this.workScene = preferences.getWorkScene();
    }

    // Default constructor
    public PreferenceBL() {
        this.startDay = 0;
        this.endDay = 0;
        this.breakTime = 0;
        this.workScene = 0;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(int breakTime) {
        this.breakTime = breakTime;
    }

    public int getWorkScene() {
        return workScene;
    }

    public void setWorkScene(int workScene) {
        this.workScene = workScene;
    }

}
