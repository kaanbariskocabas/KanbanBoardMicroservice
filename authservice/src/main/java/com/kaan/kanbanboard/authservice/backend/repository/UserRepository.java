package com.kaan.kanbanboard.authservice.backend.repository;

import com.kaan.kanbanboard.authservice.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Kaan Kocabas
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);

    public User findOneByEmailIgnoreCase(String email);

//	public List<User> findByRoles(Set<Role> roles);

}
