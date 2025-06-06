package com.example.tasksManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tasksManager.models.User;
import com.example.tasksManager.repositories.UserRepository;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;

    public List<User> getAll() { return userRepository.findAll(); }
    public User getById(Long id) { return userRepository.findById(id).orElseThrow(); }
    public User create(User user) { return userRepository.save(user); }
    public void delete(Long id) { userRepository.deleteById(id); }
    
}
