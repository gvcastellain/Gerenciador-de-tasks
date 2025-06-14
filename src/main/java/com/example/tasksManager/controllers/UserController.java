package com.example.tasksManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tasksManager.models.User;
import com.example.tasksManager.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired private UserService userService;

    @GetMapping public List<User> getAll() { return userService.getAll(); }
    @GetMapping("/{id}") public User get(@PathVariable Long id) { return userService.getById(id); }
    @PostMapping public User create(@RequestBody User user) { return userService.create(user); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { userService.delete(id); }
}

