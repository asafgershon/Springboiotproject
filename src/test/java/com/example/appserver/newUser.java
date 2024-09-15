package com.example.appserver;

import com.example.appserver.Backend.ServiceLayer.ServiceFactory;
import com.example.appserver.Backend.ServiceLayer.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class newUser {

    private ServiceFactory serviceFactory;

    @BeforeEach
    public void initTest() {
        serviceFactory = new ServiceFactory();
    }

    @Test
    public void deleteTest(){
        Path path = Paths.get("src", "main", "resources", "PerAssDB").toAbsolutePath();
        String connectionString = "jdbc:sqlite:" + path.toString();
        String deleteSQL = "DELETE FROM User";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            // Execute the delete statement
            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("The connection to the database failed", e);
        }
    }

    @Test
    public void testCreateUser() {
        //register new user
        Response response = serviceFactory.Register("asaf","asaf","Asaf12");
        Assertions.assertEquals(false,response.isError());
    }

    @Test
    public void testlogin(){
        Response response = serviceFactory.Register("asaf","asaf","Asaf12");
        Response response2 = serviceFactory.Login("asaf","Asaf12");
        Assertions.assertEquals(false,response.isError());
    }


    @Test
    public void tesRegisterUser() {
        //register new user
        Response response = serviceFactory.Register("asaf","asaf","Asaf12");
        Assertions.assertEquals(false,response.isError());

        //register the same user name - fail
        Response response1 = serviceFactory.Register("asaf","asaf","Asaf122");
        Assertions.assertEquals(true,response1.isError());

        //register with invalid password
        response1 = serviceFactory.Register("asaf","asaf","123");
        Assertions.assertEquals(true,response1.isError());

        response1 = serviceFactory.Register("asaf","asaf","a1234");
        Assertions.assertEquals(true,response1.isError());

        response1 = serviceFactory.Register("asaf","asaf","asffqeewf");
        Assertions.assertEquals(true,response1.isError());

        response1 = serviceFactory.Register("asaf","asaf","ADsdfwef");
        Assertions.assertEquals(true,response1.isError());

        //register with null / empty option - 2 test for each option
        response1 = serviceFactory.Register("asaf","asaf","");
        Assertions.assertEquals(true,response1.isError());

        response1 = serviceFactory.Register("","asaf","asaf1");
        Assertions.assertEquals(true,response1.isError());

        response1 = serviceFactory.Register("asaf","","asaf1");
        Assertions.assertEquals(true,response1.isError());

        response1 = serviceFactory.Register(null,"asaf","asaf1");
        Assertions.assertEquals(true,response1.isError());

        response1 = serviceFactory.Register("asaf",null,"asaf1");
        Assertions.assertEquals(true,response1.isError());

        response1 = serviceFactory.Register("asaf","asaf",null);
        Assertions.assertEquals(true,response1.isError());
    }

}