package com.example.appserver.Backend.BusinessLayer.User;

import com.example.appserver.Backend.DAO.UserDAO;
import com.example.appserver.Backend.Model.BigEvent;
import com.example.appserver.Backend.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserBL {

    private String name;
    private String username;
    private String Password;
    private PreferenceBL preference;
    private List<BigEventBL> events;
    private List<String> friends;
    private boolean Logegedin;
    private UserDAO userDAO;

    public UserBL(String name, String username, String pass) {
        this.name = name;
        this.Password = pass;
        this.username = username;
        events = new ArrayList<>();
        friends = new ArrayList<>();
        Logegedin = false;
        this.preference = new PreferenceBL();
        this.userDAO = new UserDAO(name,username,pass);
        this.userDAO.persist();
    }

    public UserBL(User user){
        this.name = user.getName();
        this.username = user.getUsername();
        this.preference = new PreferenceBL(user.getPreferences());
        this.Password = user.getPassword();
        this.friends = new ArrayList<>();
        for(BigEvent event : user.getBigEvents()){
            events.add(new BigEventBL(event));
        }

    }

    public void SetPrefernce(PreferenceBL preference){
        this.preference = preference;
    }

    public String getPassword(){
        return Password;
    }

    public void addBigEvent(BigEventBL event){
        events.add(event);
    }

    public void addFriend(String friend){
        friends.add(friend);
    }

    public void RemoveBigEvent(BigEventBL event){
        events.remove(event);
    }

    public void RemoveFriend(String friend){
        friends.remove(friend);
    }

    public String GetName(){
        return name;
    }

    public String GetUsername(){
        return username;
    }

    public void LogIn(){
        Logegedin = true;
    }

    public void LogOut(){
        Logegedin = false;
    }

    public boolean isLogegedin(){
        return Logegedin;
    }

    public boolean CurrectPassword(String password){
        return Password.equals(password);
    }

    public void SetPreference(PreferenceBL preference){
        this.preference = preference;
    }
}
