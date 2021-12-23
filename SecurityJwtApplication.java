package com.example.securityjwt;

import com.example.securityjwt.domain.Role;
import com.example.securityjwt.domain.User;
import com.example.securityjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole((new Role(null, "ROLE_USER")));
            userService.saveRole((new Role(null, "ROLE_MANAGER")));
            userService.saveRole((new Role(null, "ROLE_ADMIN")));
            userService.saveRole((new Role(null, "ROLE_SUPER_ADMIN")));

            userService.saveUser(new User(null, "John Travolta", "john", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "will", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Jim Carry", "jim", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Arnold Shwarzeneger", "arnold", "12345", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("john", "ROLE_MANAGER");
            userService.addRoleToUser("will", "ROLE_MANAGER");
            userService.addRoleToUser("jim", "ROLE_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_USER");
            userService.addRoleToUser("arnold", "ROLE_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
        };
    }
}
