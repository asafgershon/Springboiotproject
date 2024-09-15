package com.example.appserver;

import com.example.appserver.Backend.BusinessLayer.ToDo.BoardBL;
import com.example.appserver.Backend.ServiceLayer.ServiceFactory;
import com.example.appserver.Backend.ServiceLayer.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

public class preferencetest {

    private ServiceFactory serviceFactory;

    @BeforeEach
    public void initTest() {
        serviceFactory = new ServiceFactory();
    }

    @Test
    public void testsetpreferencetest() {
        //register new user
        Response response = serviceFactory.Register("asaf","asaf","Asaf12");
        serviceFactory.SetPreference("asaf",4,3,5,7);
    }

    @Test
    public void testaddbigevent(){
        Response response = serviceFactory.Register("asaf","asaf","Asaf12");
        Date d1 = new Date(2008,10,20);
        serviceFactory.AddBigEvent("asaf","birthday","mom",d1,7);
    }

    @Test
    public void testcreateboard(){
        Date d1 = new Date(2008,10,20);
        serviceFactory.CreateBoard("asaf","birthday");
    }

    @Test
    public void testaddTask(){
        Date d1 = new Date(2008,10,20);
        Response<BoardBL> board = serviceFactory.CreateBoard("asaf","birthday");
        Date d2 = new Date(2008,10,22);
        UUID u1 = UUID.randomUUID();
        serviceFactory.addTask(u1, "birthday",23,3,d1,d2);
    }

    @Test
    public void testcreatenewtopic(){
        serviceFactory.createTopic("asaf","birthday");
    }

    @Test
    public void testaddappointment(){
        Date d1 = new Date(2008,10,20);
        UUID u1 = UUID.randomUUID();
        serviceFactory.createappoinment(u1,"asd","mefef","fqwfq",d1,2,234);
    }
}