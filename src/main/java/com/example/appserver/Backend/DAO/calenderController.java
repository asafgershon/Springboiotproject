package com.example.appserver.Backend.DAO;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class calenderController {

    private final String connectionString;

    public calenderController() {
        Path path = Paths.get("src", "main", "resources", "PerAssDB").toAbsolutePath();
        this.connectionString = "jdbc:sqlite:" + path.toString();
    }

    public boolean createTopic(topicDAO topicDAO) {
        String insertSQL = "INSERT INTO CalendarTopic" + " (topicId, username, name) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set parameters
            preparedStatement.setString(1, topicDAO.getTopicId().toString());
            preparedStatement.setString(2, topicDAO.getUsername());
            preparedStatement.setString(3, topicDAO.getName());

            // Execute the insert statement
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("The connection to the database failed", e);
        }
    }

    public boolean addappoinment(appoinmentDAO appoinmentDAO) {
        String insertSQL = "INSERT INTO Appointment" + " (appointmentID, topicid, name, description,location,date,startHour,duration) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set parameters
            preparedStatement.setString(1, appoinmentDAO.getAppointmentID().toString());
            preparedStatement.setString(2, appoinmentDAO.getTopicID().toString());
            preparedStatement.setString(3, appoinmentDAO.getName());
            preparedStatement.setString(4, appoinmentDAO.getDescription());
            preparedStatement.setString(5, appoinmentDAO.getLocation());
            preparedStatement.setDate(6, new java.sql.Date(appoinmentDAO.getDate().getTime()));
            preparedStatement.setInt(7, appoinmentDAO.getStartHour());
            preparedStatement.setInt(8, appoinmentDAO.getDuration());

            // Execute the insert statement
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("The connection to the database failed", e);
        }
    }

}
