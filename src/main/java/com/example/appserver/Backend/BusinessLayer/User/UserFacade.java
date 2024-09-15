package com.example.appserver.Backend.BusinessLayer.User;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class UserFacade{

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserFacade.class);
    private Map<String, UserBL> users;

    public UserFacade(){
        users = new HashMap<>();
    }

    public UserBL Register(String name,String username, String password){
        if(username.isEmpty()){
            logger.debug("enter invalid user name");
            throw new IllegalArgumentException("user name is empty");
        }
        if(name.isEmpty()){
            logger.debug("enter invalid user name");
            throw new IllegalArgumentException("name is empty");
        }
        if(users.containsKey(username)){
            logger.debug("enter invalid user name");
            throw new IllegalArgumentException("username is already in use");
        }
        if(ValidPassword(password)){
            logger.debug("enter invalid user name");
            throw new IllegalArgumentException("password is valid");
        }
        UserBL user = new UserBL(name, username, password);
        users.put(username,user);
        logger.info(username + " registered successfully");
        return user;
    }

    public UserBL LogIn(String username, String password){
        UserBL user = users.get(username);
        if(user == null){
            logger.info(username + " dont exist");
            throw new IllegalArgumentException("username dont exist");
        }
        if(user.CurrectPassword(password)){
            user.LogIn();
            logger.info(username + " is logged in");
            return user;
        }
        else{
            throw new IllegalArgumentException("username and password dont matched");
        }
    }

    public boolean LogOut(String username){
        UserBL user = users.get(username);
        if(user == null || !user.isLogegedin()){
            return false;
        }
        else{
            user.LogOut();
            logger.info(username + " is logged out");
            return true;
        }
    }

    private boolean ValidPassword(String password){
        if (password == null || password.length() <= 6) {
            return false; // Password must be longer than 6 characters
        }

        boolean hasDigit = Pattern.compile("\\d").matcher(password).find();
        boolean hasLower = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasUpper = Pattern.compile("[A-Z]").matcher(password).find();

        return hasDigit && hasLower && hasUpper;
    }

    public PreferenceBL SetPreference(String username, int startDay, int endDay, int breakTime, int workScene) {
        PreferenceBL pref = new PreferenceBL(username,startDay, endDay, breakTime, workScene);
        UserBL user = users.get(username);
        user.SetPreference(pref);
        logger.info(username + " set preference");
        return pref;
    }

    public BigEventBL AddBigEvent(String username, String name, String description, Date Date, int reminder) {
        BigEventBL event = new BigEventBL(username, name, description, Date, reminder);
        UserBL user = users.get(username);
        user.addBigEvent(event);
        logger.info(username + " add big event");
        return event;
    }

    public void loaduser(UserBL user){
        users.put(user.GetUsername(),user);
        logger.info(user.GetUsername() + " loaded");
    }
}
