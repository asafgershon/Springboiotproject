package com.example.appserver.Backend.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserController {

    private final String connectionString;

    public UserController() {
        Path path = Paths.get("src", "main", "resources", "PerAssDB").toAbsolutePath();
        this.connectionString = "jdbc:sqlite:" + path.toString();
    }

    public boolean addUser(UserDAO userDAO) {
        String insertSQL = "INSERT INTO User" + " (name, username, password) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set parameters
            preparedStatement.setString(1, userDAO.getName());
            preparedStatement.setString(2, userDAO.getUsername());
            preparedStatement.setString(3, userDAO.getPassword());

            // Execute the insert statement
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("The connection to the database failed", e);
        }
    }

    public boolean addPreference(PreferenceDAO preferenceDAO) {
        String insertSQL = "INSERT INTO Preference " + " (username, start_day, end_day, break_time, work_scene) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set parameters
            preparedStatement.setString(1, preferenceDAO.getUsername());
            preparedStatement.setInt(2, preferenceDAO.getStartDay());
            preparedStatement.setInt(3, preferenceDAO.getEndDay());
            preparedStatement.setInt(4, preferenceDAO.getBreakTime());
            preparedStatement.setInt(5, preferenceDAO.getWorkScene());

            // Execute the insert statement
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("The connection to the database failed", e);
        }
    }

    public boolean updatePreference(PreferenceDAO preferenceDAO) {
        String updateSQL = "UPDATE Preference SET start_day = ?, end_day = ?, break_time = ?, work_scene = ? WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            // Set parameters
            preparedStatement.setInt(1, preferenceDAO.getStartDay());
            preparedStatement.setInt(2, preferenceDAO.getEndDay());
            preparedStatement.setInt(3, preferenceDAO.getBreakTime());
            preparedStatement.setInt(4, preferenceDAO.getWorkScene());
            preparedStatement.setString(5, preferenceDAO.getUsername());

            // Execute the update statement
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("The connection to the database failed", e);
        }
    }

    public boolean addEvent(EventDAO eventDAO) {
        String insertSQL = "INSERT INTO Event " + " (id,username, name, description, eventDate, reminder) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set parameters
            preparedStatement.setString(1, eventDAO.getId().toString());
            preparedStatement.setString(2, eventDAO.getUsername());
            preparedStatement.setString(3, eventDAO.getName());
            preparedStatement.setString(4, eventDAO.getDescription());
            preparedStatement.setDate(5, eventDAO.getSQLDate());
            preparedStatement.setInt(6, eventDAO.getReminder());

            // Execute the insert statement
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("The connection to the database failed", e);
        }
    }

    public boolean updateEvent(EventDAO eventDAO) {
        String updateSQL = "UPDATE Event SET name = ?, description = ?, task_date = ?, reminder = ? WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            // Set parameters
            preparedStatement.setString(1, eventDAO.getName());
            preparedStatement.setString(2, eventDAO.getDescription());
            preparedStatement.setDate(3, eventDAO.getSQLDate());
            preparedStatement.setInt(4, eventDAO.getReminder());
            preparedStatement.setString(5, eventDAO.getUsername());

            // Execute the update statement
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("The connection to the database failed", e);
        }
    }
}