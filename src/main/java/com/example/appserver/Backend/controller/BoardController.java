package com.example.appserver.Backend.controller;

import com.example.appserver.Backend.Model.Board;
import com.example.appserver.Backend.ServiceLayer.Response;
import com.example.appserver.Backend.ServiceLayer.ServiceFactory;
import com.example.appserver.Backend.ServiceLayer.ToDo.BoardSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    private ServiceFactory serviceFactory;

    @PostMapping("/create")
    public ResponseEntity<Response<Board>> createBoard(@RequestBody BoardCredentials credentials) {
        String username = credentials.getUsername();
        String name = credentials.getName();
        Response<Board> response = serviceFactory.CreateBoard(username, name);

        if (response.isError()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Board>> getBoardsByUser(@PathVariable String username) {
        List<Board> boards = (List<Board>) serviceFactory.getBoardsByUsername(username).getReturnValue();
        return ResponseEntity.ok(boards);
    }
}

class BoardCredentials {
    private String name;
    private String username;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
