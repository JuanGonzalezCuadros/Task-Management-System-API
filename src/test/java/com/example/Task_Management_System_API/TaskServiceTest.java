package com.example.Task_Management_System_API;

import com.example.Task_Management_System_API.dto.TaskDTO;
import com.example.Task_Management_System_API.model.Task;
import com.example.Task_Management_System_API.model.User;
import com.example.Task_Management_System_API.repository.TaskRepository;
import com.example.Task_Management_System_API.repository.UserRepository;
import com.example.Task_Management_System_API.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void testCreateTask() {
        TaskDTO dto = new TaskDTO("Test Task", "Description", "Pending", "High", LocalDate.now());
        User user = new User();
        user.setId(1L);
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(taskRepository.save(any(Task.class))).thenAnswer(i -> i.getArgument(0));

        Task task = taskService.createTask(dto, "user");

        assertEquals("Test Task", task.getTitle());
        assertEquals(user, task.getUser());
    }

    @Test
    public void testGetUserTasks() {
        User user = new User();
        user.setId(1L);
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(taskRepository.findByUserId(1L)).thenReturn(List.of(new Task()));

        List<Task> tasks = taskService.getUserTasks("user");

        assertEquals(1, tasks.size());
    }
}
