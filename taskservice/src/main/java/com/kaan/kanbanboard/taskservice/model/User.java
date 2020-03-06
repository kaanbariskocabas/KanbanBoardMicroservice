package com.kaan.kanbanboard.taskservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String email;
    private String firstname;
    private String lastname;
}