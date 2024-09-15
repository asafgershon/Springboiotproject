package com.example.appserver.Backend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Preference")
public class UserPreferences {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "username")
    private String username;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @Column(name = "start_day")
    private int startDay;

    @Column(name = "end_day")
    private int endDay;

    @Column(name = "break_time")
    private int breakTime;

    @Column(name = "work_scene")
    private int workScene;

    // Default constructor
    public UserPreferences() {}

    // Constructor
    public UserPreferences(String username, int startDay, int endDay, int breakTime, int workScene) {
        this.username = username;
        this.startDay = startDay;
        this.endDay = endDay;
        this.breakTime = breakTime;
        this.workScene = workScene;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
