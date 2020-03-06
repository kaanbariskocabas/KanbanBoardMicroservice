package com.kaan.kanbanboard.taskservice.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtConstants {
    @Value("${userApi.path}")
    public String userPath;

    @Value("${jwt.header}")
    public String tokenHeader;

    public JwtConstants() {
    }

}
