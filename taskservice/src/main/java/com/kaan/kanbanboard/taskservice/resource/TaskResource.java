package com.kaan.kanbanboard.taskservice.resource;

import com.kaan.kanbanboard.taskservice.model.TaskDTO;
import com.kaan.kanbanboard.taskservice.model.User;
import com.kaan.kanbanboard.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class TaskResource {

    @Autowired
    TaskService taskService;

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<TaskDTO> findTaskById(@PathVariable("taskId") Long taskId, HttpServletRequest request) {
        return new ResponseEntity<TaskDTO>(taskService.findById(taskId, request), HttpStatus.OK);
    }

}
