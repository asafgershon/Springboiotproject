package com.example.appserver.Backend.BusinessLayer.ToDo;

import com.example.appserver.Backend.BusinessLayer.Calender.TimeSlot;
import com.example.appserver.Backend.BusinessLayer.Calender.calenderFacade;
import com.example.appserver.Backend.BusinessLayer.User.UserFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class TaskFacade {

    private UserFacade uf;
    private calenderFacade calender;
    private static final Logger logger = LoggerFactory.getLogger(TaskFacade.class);
    private final Map<UUID, BoardBL> boards;
    
    public TaskFacade(UserFacade uf, calenderFacade calender) {
        this.uf = uf;
        this.calender = calender;
        this.boards = new HashMap<>();
    }

    public BoardBL createBoard(String username, String name) {
        BoardBL newboard = new BoardBL(username,name);
        boards.put(newboard.getId(),newboard);
        return newboard;
    }

    public TaskBL addTask(UUID Boardid, String name, int timeEstimate, int ergency, Date dueDate, Date startDate) {
        TaskPreferenceBL pref = new TaskPreferenceBL(timeEstimate,ergency,dueDate,startDate);
        TaskBL newtask = new TaskBL(Boardid,name,pref);
        BoardBL board = boards.get(Boardid);
        board.addTask(newtask);
        return newtask;
    }

    public BoardBL getBoard(UUID boardId) {
        return boards.get(boardId);
    }

    public void updateBoard(BoardBL board) {
        if (boards.containsKey(board.getId())) {
            boards.put(board.getId(), board);
        } else {
            throw new IllegalArgumentException("Board with ID " + board.getId() + " does not exist.");
        }
    }

    public void removeBoard(UUID boardId) {
        boards.remove(boardId);
    }

    public Map<UUID, BoardBL> getAllBoards() {
        return new HashMap<>(boards); // Return a copy to prevent external modification
    }

    public boolean autoScheduleTask(UUID topicId, String taskName, String description, String location, Date date, int duration) {
        TimeSlot slot = calender.findAvailableTimeSlot(topicId, duration);

        if (slot == null) {
            logger.debug("No available time slot found!");
            return false;
        }

        // Schedule the task at the found time slot
        calender.addappoinment(topicId, taskName, description, location, slot.getStartTime(), slot.getStartTime().getHours(), duration);
        logger.info("Task scheduled successfully at " + slot.getStartTime());
        return true;
    }

    public List<BoardBL> getBoardsByUsername(String username){
        List<BoardBL> boards = new ArrayList<>();
        for(BoardBL board : boards){
            if(board.getOwner().equals(username)){
                boards.add(board);
            }
        }
        return boards;
    }
}
