package com.kaan.kanbanboard.taskservice.service;

import com.kaan.kanbanboard.taskservice.model.TaskDTO;

import javax.servlet.http.HttpServletRequest;

public interface TaskService {
    public TaskDTO findById(Long taskId, HttpServletRequest request);
}
