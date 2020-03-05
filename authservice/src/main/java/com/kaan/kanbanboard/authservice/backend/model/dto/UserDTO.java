package com.kaan.kanbanboard.authservice.backend.model.dto;

import com.kaan.kanbanboard.authservice.backend.model.Role;
import com.kaan.kanbanboard.authservice.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String firstname;
    private String lastname;
    private String email;
    private Set<Role> roles;
    private boolean isActive;

    public UserDTO(User user) {
        super();
        if (user != null) {
            this.userId = user.getUserId();
            this.firstname = user.getFirstname();
            this.lastname = user.getLastname();
            this.email = user.getEmail();
            this.roles = user.getRoles();
            this.isActive = user.isActive();
        }
    }
}
