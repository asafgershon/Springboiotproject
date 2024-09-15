package com.example.appserver.Backend.Config;

import com.example.appserver.Backend.BusinessLayer.User.UserBL;
import com.example.appserver.Backend.BusinessLayer.User.UserFacade;
import com.example.appserver.Backend.Model.User;
import com.example.appserver.Backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserFacade userFacade, UserRepository userRepository) {
        this.userFacade = userFacade;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Load users from the database
        List<User> users = userRepository.findAll();

        // Initialize the UserFacade with users from the database
        System.out.println("i find " + users.size() + " users");
        for (User user : users) {
             //Convert User entity to UserBL and add to UserFacade
            userFacade.loaduser(new UserBL(user));
        }
    }
}
