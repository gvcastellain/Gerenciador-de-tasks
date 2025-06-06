package com.example.tasksManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tasksManager.models.Task;
import com.example.tasksManager.models.User;
import com.example.tasksManager.repositories.TaskRepository;
import com.example.tasksManager.repositories.UserRepository;

@Service
public class TaskService {
    @Autowired private TaskRepository taskRepository;
    @Autowired private UserRepository userRepository;

    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task createTask(Long userId, Task task) {
        User user = userRepository.findById(userId).orElseThrow();
        task.setUser(user);
        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task newTask) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setTitulo(newTask.getTitulo());
        task.setDescricao(newTask.getDescricao());
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public Task getTask(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow();
    }
}
