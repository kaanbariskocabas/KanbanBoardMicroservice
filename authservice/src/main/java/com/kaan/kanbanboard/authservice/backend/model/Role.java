package com.kaan.kanbanboard.authservice.backend.model;

import com.kaan.kanbanboard.authservice.backend.model.type.RoleType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue
    private Long roleId;

    @Enumerated(EnumType.STRING)
    private RoleType role = RoleType.ROLE_USER;

    public Role() {
    }

    public Role(RoleType role) {
        this.role = role;
    }
}
