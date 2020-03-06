package com.kaan.kanbanboard.taskservice.service;

import com.kaan.kanbanboard.taskservice.model.User;
import com.kaan.kanbanboard.taskservice.util.JwtConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JwtConstants jwtConstants;

    @Override
    public User getUser(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(jwtConstants.tokenHeader, token);
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<User> re = restTemplate.exchange(jwtConstants.userPath, HttpMethod.GET, entity, User.class);
        return re.getBody();
    }
}
