package com.example.appserver.Backend.controller;

import com.example.appserver.Backend.ServiceLayer.Response;
import com.example.appserver.Backend.ServiceLayer.ServiceFactory;
import com.example.appserver.Backend.Model.User;
import com.example.appserver.Backend.Model.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.prefs.Preferences;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private ServiceFactory serviceFactory;

    // Handle user registration requests
    @PostMapping("/register")
    public ResponseEntity<Response<User>> register(@RequestBody UserCredentials credentials) {
        // Extract the credentials
        String name = credentials.getName();
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // Call the registration logic in the service layer
        Response<User> response = serviceFactory.Register(name, username, password);

        if (response.isError()) {
            // Return 400 Bad Request with the error message
            return ResponseEntity.badRequest().body(response);
        }

        // Return 201 Created with the registered user information
        return ResponseEntity.status(201).body(response);
    }

    // Handle login requests
    @PostMapping("/login")
    public ResponseEntity<Response<User>> login(@RequestBody UserCredentials credentials) {
        // Extract the credentials
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // Call the login logic in the service layer
        Response<User> response = serviceFactory.Login(username, password);

        if (response.isError()) {
            // Return 400 Bad Request with the error message
            return ResponseEntity.badRequest().body(response);
        }

        // Return 200 OK with the login response
        return ResponseEntity.ok(response);
    }

    // Handle setting user preferences
    @PostMapping("/setPreferences")
    public ResponseEntity<Response<UserPreferences>> SetPreference(@RequestBody UserPreference preferences) {
        // Extract user preferences
        String username = preferences.getUsername();
        int startDay = preferences.getStartDay();
        int endDay = preferences.getEndDay();
        int breakTime = preferences.getBreakTime();
        int workScene = preferences.getWorkScene();

        // Call the preference-setting logic in the service layer
        Response<UserPreferences> response = serviceFactory.SetPreference(username, startDay, endDay, breakTime, workScene);

        if (response.isError()) {
            // Return 400 Bad Request with the error message
            return ResponseEntity.badRequest().body(response);
        }

        // Return 200 OK indicating the preferences were set successfully
        return ResponseEntity.ok(response);
    }
}

class UserCredentials {
    private String name;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// New class to hold user preferences
class UserPreference {
    private String username; // Add username to associate preferences
    private int startDay;    // Start time in minutes
    private int endDay;      // End time in minutes
    private int breakTime;   // Break time in minutes
    private int workScene;    // Work scene duration in minutes

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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