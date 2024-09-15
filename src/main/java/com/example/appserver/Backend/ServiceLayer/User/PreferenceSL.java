package com.example.appserver.Backend.ServiceLayer.User;

import com.example.appserver.Backend.BusinessLayer.User.PreferenceBL;

public class PreferenceSL {
    public int startDay;
    public int endDay;
    public int breakTime;
    public int workScene;

    public PreferenceSL(int startDay, int endDay, int breakTime, int workScene) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.breakTime = breakTime;
        this.workScene = workScene;
    }

    public PreferenceSL(PreferenceBL p) {
        this.startDay = p.getStartDay();
        this.endDay = p.getEndDay();
        this.breakTime = p.getBreakTime();
        this.workScene = p.getWorkScene();
    }

}
