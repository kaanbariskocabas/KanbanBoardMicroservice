package com.kaan.kanbanboard.authservice.app.datagenerator;

import com.kaan.kanbanboard.authservice.backend.model.Role;
import com.kaan.kanbanboard.authservice.backend.model.User;
import com.kaan.kanbanboard.authservice.backend.model.type.RoleType;
import com.kaan.kanbanboard.authservice.backend.repository.RoleRepository;
import com.kaan.kanbanboard.authservice.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Kaan Kocabas
 */
@Component
public class DataGenerator {

    private List<User> users = new ArrayList<>();
    private Set<Role> roles = new HashSet<>();

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository,
                                      RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        return args -> {
            if (hasData(userRepository)) {
                System.out.println("Using existing database");
                return;
            }
            System.out.println("... generating roles");
            createRoles(roleRepository);
            System.out.println("... generating users");
            createUsers(userRepository, bCryptPasswordEncoder, roleRepository);
            System.out.println("... generating todos");
        };
    }

    private void createRoles(RoleRepository roleRepository) {
        roles.add(roleRepository.save(new Role(RoleType.ROLE_ADMIN)));
        roles.add(roleRepository.save(new Role(RoleType.ROLE_USER)));
    }

    private void createUsers(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                             RoleRepository roleRepository) {
        users.add(userRepository
                .save(new User("kaan", "kocabas", bCryptPasswordEncoder.encode("kaan"),
                        "kk@gmail.com", roles)));
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role(RoleType.ROLE_USER));
        User user2 = new User();
        user2.setEmail("user@user.com");
        Role role = roleRepository.findByRole(RoleType.ROLE_USER).get();
        user2.addRole(role);
        user2.setPassword(bCryptPasswordEncoder.encode("user"));
        users.add(userRepository.save(user2));
    }

    private boolean hasData(UserRepository userRepository) {
        return userRepository.count() != 0L;
    }

}
