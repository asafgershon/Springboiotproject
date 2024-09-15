package com.example.appserver.Backend.DAO;

import java.util.UUID;

public class topicDAO {

    private UUID topicId;
    private String username;
    private String name;
    private boolean Ispresist;
    private calenderController controller;

    public topicDAO(UUID topicId,String username, String name) {
        this.topicId = topicId;
        this.username = username;
        this.name = name;
        Ispresist = false;
        controller = new calenderController();
    }

    public UUID getTopicId() {
        return topicId;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void persist()
    {
        if (this.Ispresist)
        {
            throw new IllegalArgumentException("the user already in the saved");
        }
        this.controller.createTopic(this);
        this.Ispresist = true;
    }
}
