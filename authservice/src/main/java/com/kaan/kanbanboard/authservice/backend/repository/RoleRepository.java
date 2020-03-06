package com.kaan.kanbanboard.authservice.backend.repository;

import com.kaan.kanbanboard.authservice.backend.model.Role;
import com.kaan.kanbanboard.authservice.backend.model.type.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Kaan Kocabas
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRole(RoleType roleType);

}
