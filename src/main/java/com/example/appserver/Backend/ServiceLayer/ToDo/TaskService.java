package com.example.appserver.Backend.ServiceLayer.ToDo;

import com.example.appserver.Backend.BusinessLayer.Calender.calenderFacade;
import com.example.appserver.Backend.BusinessLayer.ToDo.BoardBL;
import com.example.appserver.Backend.BusinessLayer.ToDo.TaskBL;
import com.example.appserver.Backend.BusinessLayer.ToDo.TaskFacade;
import com.example.appserver.Backend.BusinessLayer.User.UserFacade;
import com.example.appserver.Backend.ServiceLayer.Response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TaskService {

    public TaskFacade tf;

    public TaskService(UserFacade u, calenderFacade cf) {
        tf = new TaskFacade(u,cf);
    }

    public Response createBoard(String username, String name){
        try{
            BoardBL board = tf.createBoard(username,name);
            Response<BoardSL> response = new Response<>(new BoardSL(board));
            return response;
        }
        catch(Exception e){
            Response error = new Response(true,e.getMessage());
            return error;
        }
    }

    public Response addTask(UUID boardId, String name, int timeEstimate, int ergency, Date dueDate, Date startDate){
        try{
            TaskBL task = tf.addTask(boardId,name,timeEstimate,ergency,dueDate,startDate);
            Response<TaskSL> response = new Response<>(new TaskSL(task));
            return response;
        }
        catch(Exception e){
            Response error = new Response(true,e.getMessage());
            return error;
        }
    }

    public Response getBoardsByUsername(String username){
        List<BoardBL> board = tf.getBoardsByUsername(username);
        List<BoardSL> result = new ArrayList<>();
        for(BoardBL boardBL : board){
            result.add(new BoardSL(boardBL));
        }
        return new Response<>(result);
    }
}
