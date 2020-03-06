package com.kaan.kanbanboard.taskservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime creationDate = LocalDateTime.now();
    private LocalDateTime endDate;
    private Long userId;

    public Task(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public Task(String title, String content, LocalDateTime endDate, Long userId) {
        this.title = title;
        this.content = content;
        this.endDate = endDate;
        this.userId = userId;
    }
}
