package com.kaan.kanbanboard.taskservice.config.datagenerator;

import com.kaan.kanbanboard.taskservice.model.Task;
import com.kaan.kanbanboard.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(TaskRepository taskRepository) {
        return args -> {
            if (hasData(taskRepository)) {
                System.out.println("Using existing database");
                return;
            }
            System.out.println("... generating tasks");
            createTasks(taskRepository);
        };
    }

    private void createTasks(TaskRepository taskRepository) {
        taskRepository.save(new Task("Generated Title 1", "Generated content 1", 3L));
        taskRepository.save(new Task("Generated Title 2", "Generated content 2", 4L));
    }

    private boolean hasData(TaskRepository taskRepository) {
        return taskRepository.count() != 0L;
    }
}
