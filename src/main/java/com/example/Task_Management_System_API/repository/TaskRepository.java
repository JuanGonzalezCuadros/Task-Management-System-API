package com.example.Task_Management_System_API.repository;

import com.example.Task_Management_System_API.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>  {
    List<Task> findByUserId(Long userId);
}
