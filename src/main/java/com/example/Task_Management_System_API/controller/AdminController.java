package com.example.Task_Management_System_API.controller;

import com.example.Task_Management_System_API.model.User;
import com.example.Task_Management_System_API.repository.TaskRepository;
import com.example.Task_Management_System_API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired private UserService userService;
    @Autowired private TaskRepository taskRepository;

    @GetMapping("/dashboard")
    public ResponseEntity<?> dashboard() {
        List<Map<String, Object>> data = new ArrayList<>();
        for (User user : userService.getAllUsers()) {
            Map<String, Object> map = new HashMap<>();
            map.put("username", user.getUsername());
            map.put("taskCount", user.getTasks().size());
            data.add(map);
        }
        return ResponseEntity.ok(data);
    }
}
