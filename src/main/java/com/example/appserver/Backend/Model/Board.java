package com.example.appserver.Backend.Model;

import com.example.appserver.Backend.BusinessLayer.ToDo.BoardBL;
import com.example.appserver.Backend.ServiceLayer.ToDo.BoardSL;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Boards")
public class Board {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "boardId")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
