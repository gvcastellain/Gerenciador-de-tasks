package com.example.tasksManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tasksManager.models.Task;
import com.example.tasksManager.services.TaskService;

@RestController
@RequestMapping("/users/{userId}/tasks")
public class TaskController {
    @Autowired private TaskService taskService;

    @GetMapping public List<Task> getTasks(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }

    @PostMapping public Task create(@PathVariable Long userId, @RequestBody Task task) {
        return taskService.createTask(userId, task);
    }

    @GetMapping("/{taskId}") public Task get(@PathVariable Long taskId) {
        return taskService.getTask(taskId);
    }

    @PutMapping("/{taskId}") public Task update(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping("/{taskId}") public void delete(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}

