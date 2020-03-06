package com.kaan.kanbanboard.taskservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TaskDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime creationDate = LocalDateTime.now();
    private LocalDateTime endDate;
    private Long userId;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.title = task.getContent();
        this.creationDate = task.getCreationDate();
        this.endDate = task.getEndDate();
        this.userId = task.getUserId();
    }

    public Task getTask(TaskDTO taskDTO) {
        Task task = new Task();
        task
                .builder()
                .content(taskDTO.getContent())
                .creationDate(taskDTO.getCreationDate())
                .endDate(taskDTO.getEndDate())
                .id(taskDTO.getId())
                .title(taskDTO.getTitle())
                .userId(taskDTO.userId)
                .build();
        return task;
    }
}
