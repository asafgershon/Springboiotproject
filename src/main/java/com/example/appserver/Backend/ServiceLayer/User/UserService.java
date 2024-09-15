package com.example.appserver.Backend.ServiceLayer.User;

import com.example.appserver.Backend.BusinessLayer.User.BigEventBL;
import com.example.appserver.Backend.BusinessLayer.User.PreferenceBL;
import com.example.appserver.Backend.BusinessLayer.User.UserBL;
import com.example.appserver.Backend.BusinessLayer.User.UserFacade;
import com.example.appserver.Backend.ServiceLayer.Response;

public class UserService {

    public UserFacade uf;

    public UserService(UserFacade uf) {
        this.uf = uf;
    }

    public Response Register(String name, String username, String Password){
        try{
            UserBL newUser = uf.Register(name,username,Password);
            UserSL user = new UserSL(newUser);
            Response<UserSL> response = new Response<>(user);
            return response;
        }
        catch(Exception e){
            Response error = new Response(true,e.getMessage());
            return error;
        }
    }

    public Response LogIn(String username, String Password){
        try{
            UserBL result = uf.LogIn(username,Password);
            UserSL user = new UserSL(result);
            Response<UserSL> error = new Response(user);
            return error;
        }
        catch(Exception e){
            Response error = new Response(true,e.getMessage());
            return error;
        }
    }

    public Response LogOut(String username){
        try{
            boolean result = uf.LogOut(username);
            if(result){
                Response response = new Response(true);
                return response;
            }
            else {
                Response error = new Response(false);
                return error;
            }
        }
        catch(Exception e){
            Response error = new Response(true,e.getMessage());
            return error;
        }
    }

    public Response SetPreference(String username, int startDay, int endDay, int breakTime, int workScene) {
        try{
            PreferenceBL preference = uf.SetPreference(username, startDay, endDay, breakTime, workScene);
            Response<PreferenceSL> response = new Response<>(new PreferenceSL(preference));
            return response;
        }
        catch(Exception e){
            Response error = new Response(true,e.getMessage());
            return error;
        }
    }

    public Response AddBigEvent(String email, String name, String description, java.util.Date Date, int reminder){
        try{
            BigEventBL event = uf.AddBigEvent(email,name,description,Date,reminder);
            Response<BigEventSL> response = new Response<>(new BigEventSL(event));
            return response;
        }
        catch(Exception e){
            Response error = new Response(true,e.getMessage());
            return error;
        }
    }

}
