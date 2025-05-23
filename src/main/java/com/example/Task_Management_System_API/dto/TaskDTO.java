package com.example.Task_Management_System_API.dto;

import java.time.LocalDate;

public class TaskDTO {
    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDate dueDate;

    public TaskDTO(String title, String description, String status, String priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
