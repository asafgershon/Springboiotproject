package com.example.appserver.Backend.ServiceLayer;

import com.example.appserver.Backend.BusinessLayer.Calender.calenderFacade;
import com.example.appserver.Backend.BusinessLayer.User.UserFacade;
import com.example.appserver.Backend.ServiceLayer.Calender.calenderService;
import com.example.appserver.Backend.ServiceLayer.ToDo.TaskService;
import com.example.appserver.Backend.ServiceLayer.User.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service // This tells Spring to manage this class as a bean
public class ServiceFactory {

    public UserService us;
    public TaskService ts;
    public calenderService cs;

    public ServiceFactory() {
        UserFacade uf = new UserFacade();
        calenderFacade cf = new calenderFacade(uf);
        us = new UserService(uf);
        cs = new calenderService(cf);
        ts = new TaskService(uf, cf);
    }

    public Response Register(String name, String username, String password){
        return us.Register(name,username,password);
    }

    public Response Login(String username, String password){
        return us.LogIn(username,password);
    }

    public Response LogOut(String username){
        return us.LogOut(username);
    }

    public Response SetPreference(String username, int startDay, int endDay, int breakTime, int workScene){
        return us.SetPreference(username, startDay, endDay, breakTime,workScene);
    }

    public Response AddBigEvent(String username, String name, String description, java.util.Date Date, int reminder){
        return us.AddBigEvent(username,name,description,Date,reminder);
    }

    public Response CreateBoard(String username,String name){
        return ts.createBoard(username,name);
    }

    public Response addTask(UUID boardId, String name, int timeEstimate, int ergency, Date dueDate, Date startDate){
        return ts.addTask(boardId,name,timeEstimate,ergency,dueDate,startDate);
    }

    public Response createTopic(String username, String name){
        return cs.createTopic(username,name);
    }

    public Response createappoinment(UUID topicId,String name, String description, String location, Date date, int startHour, int duration){
        return cs.addappoinment(topicId,name,description,location,date,startHour,duration);
    }

    public Response getBoardsByUsername(String username){
        return ts.getBoardsByUsername(username);
    }
}
