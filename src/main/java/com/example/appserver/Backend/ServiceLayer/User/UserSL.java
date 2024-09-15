package com.example.appserver.Backend.ServiceLayer.User;

import com.example.appserver.Backend.BusinessLayer.User.UserBL;
import com.example.appserver.Backend.ServiceLayer.Calender.topicSL;
import com.example.appserver.Backend.ServiceLayer.ToDo.BoardSL;

import java.util.ArrayList;
import java.util.List;

public class UserSL {

    public String name;
    public String username;
    public PreferenceSL preference;
    public List<BigEventSL> events;
    public List<topicSL> topicSLS;
    public List<String> friends;

    public UserSL(String name, String username) {
        this.name = name;
        this.username = username;
        events = new ArrayList<>();
        topicSLS = new ArrayList<>();
        friends = new ArrayList<>();
    }

    public UserSL(UserBL user){
        this.name = user.GetName();
        this.username = user.GetUsername();
        this.events = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    public void SetPreference(PreferenceSL preference) {
        this.preference = preference;
    }

    public void AddEvent(BigEventSL event) {
        events.add(event);
    }

    public void RemoveEvent(BigEventSL event) {
        events.remove(event);
    }

    public void AddFriend(String friend) {
        friends.add(friend);
    }

    public void RemoveFriend(String friend) {
        friends.remove(friend);
    }

}
