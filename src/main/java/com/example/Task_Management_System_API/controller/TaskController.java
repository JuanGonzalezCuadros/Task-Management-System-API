package com.example.Task_Management_System_API.controller;

import com.example.Task_Management_System_API.dto.TaskDTO;
import com.example.Task_Management_System_API.model.Task;
import com.example.Task_Management_System_API.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDto, Principal principal) {
        return ResponseEntity.ok(taskService.createTask(taskDto, principal.getName()));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(Principal principal) {
        return ResponseEntity.ok(taskService.getUserTasks(principal.getName()));
    }
}
