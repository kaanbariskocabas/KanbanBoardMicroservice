package com.kaan.kanbanboard.taskservice.service;

import com.kaan.kanbanboard.taskservice.model.User;

public interface UserService {
    public User getUser(String token);
}
