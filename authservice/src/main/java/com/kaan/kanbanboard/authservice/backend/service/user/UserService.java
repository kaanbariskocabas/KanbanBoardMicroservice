package com.kaan.kanbanboard.authservice.backend.service.user;

import com.kaan.kanbanboard.authservice.backend.model.User;

/**
 * @author Kaan Kocabas
 *
 */
public interface UserService {

public User addUser(User user);

	User findByEmail(String email);
	
}
