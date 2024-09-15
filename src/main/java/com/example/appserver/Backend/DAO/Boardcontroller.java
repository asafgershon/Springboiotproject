package com.example.appserver.Backend.DAO;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Boardcontroller {

    private final String connectionString;

    public Boardcontroller() {
        Path path = Paths.get("src", "main", "resources", "PerAssDB").toAbsolutePath();
        this.connectionString = "jdbc:sqlite:" + path.toString();
    }

    public boolean addBoard(BoardDAO boardDAO) {
        String insertSQL = "INSERT INTO Boards" + " (boardId, username, name) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set parameters
            preparedStatement.setString(2, boardDAO.getUsername());
            preparedStatement.setString(1, boardDAO.getId().toString());
            preparedStatement.setString(3, boardDAO.getName());

            // Execute the insert statement
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("The connection to the database failed", e);
        }
    }

    public boolean addTask(TaskDAO taskDAO) {
        String insertSQL = "INSERT INTO Task" + " (taskId, boardId, name, completed, timeEstimate, urgency, dueDate, startDate) VALUES (?, ?, ?, ?, ?, ? , ? , ?)";
        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set parameters
            preparedStatement.setString(1, taskDAO.getTaskId().toString());
            preparedStatement.setString(2, taskDAO.getBoardId().toString());
            preparedStatement.setString(3, taskDAO.getName());
            preparedStatement.setBoolean(4, taskDAO.getCompleted());
            preparedStatement.setInt(5, taskDAO.getTimeEstimate());
            preparedStatement.setInt(6, taskDAO.getErgency());
            preparedStatement.setDate(7, new java.sql.Date(taskDAO.getDueDate().getTime()));
            preparedStatement.setDate(7, new java.sql.Date(taskDAO.getDueDate().getTime()));

            // Execute the insert statement
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("The connection to the database failed", e);
        }
    }
}
