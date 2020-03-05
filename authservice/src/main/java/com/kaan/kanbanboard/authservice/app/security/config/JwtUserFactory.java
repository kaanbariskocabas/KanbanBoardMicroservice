package com.kaan.kanbanboard.authservice.app.security.config;

import com.kaan.kanbanboard.authservice.app.security.config.jwt.JwtUser;
import com.kaan.kanbanboard.authservice.backend.model.Role;
import com.kaan.kanbanboard.authservice.backend.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUserId(),
                user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRoles()),
                user.isActive(),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
                .collect(Collectors.toList());
    }
}
