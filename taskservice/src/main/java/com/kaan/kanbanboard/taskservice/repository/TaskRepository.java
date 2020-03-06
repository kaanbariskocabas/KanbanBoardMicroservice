package com.kaan.kanbanboard.taskservice.repository;

import com.kaan.kanbanboard.taskservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByUserId(Long userId);
}
