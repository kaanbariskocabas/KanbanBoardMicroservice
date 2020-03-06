package com.kaan.kanbanboard.taskservice.service;

import com.kaan.kanbanboard.taskservice.model.Task;
import com.kaan.kanbanboard.taskservice.model.TaskDTO;
import com.kaan.kanbanboard.taskservice.model.User;
import com.kaan.kanbanboard.taskservice.repository.TaskRepository;
import com.kaan.kanbanboard.taskservice.util.JwtConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserService userService;

    @Autowired
    JwtConstants jwtConstants;

    @Override
    public TaskDTO findById(Long taskId, HttpServletRequest request) {
        Task task = taskRepository.findById(taskId).get();
        String token = request.getHeader(jwtConstants.tokenHeader);
        if (token != null) {
            User user = userService.getUser(token);
            if (user.getUserId() == task.getUserId()) {
                return new TaskDTO(task);
            }
            throw new RuntimeException("Task does not belong to this user");
        }
        throw new RuntimeException("Not Authenticated!");
    }

}
