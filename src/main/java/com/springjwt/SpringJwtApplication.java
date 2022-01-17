package com.springjwt;

import com.springjwt.models.entities.AppUser;
import com.springjwt.models.entities.Role;
import com.springjwt.services.UserService;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringJwtApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringJwtApplication.class, args);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  CommandLineRunner run(UserService userService) {
    return args -> {
      userService.saveRole(new Role(null, "ROLE_USER"));
      userService.saveRole(new Role(null, "ROLE_ADMIN"));
      userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

      userService.saveUser(new AppUser(null, "Jhon Dhoe", "jhon", "12345",new ArrayList<>()));
      userService.saveUser(new AppUser(null, "Jim Carry", "jim", "12345",new ArrayList<>()));
      userService.saveUser(new AppUser(null, "Trent Arnold", "arnold", "12345",new ArrayList<>()));

      userService.addRoleToUser("jhon", "ROLE_USER");
      userService.addRoleToUser("jim", "ROLE_ADMIN");
      userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
    };
  }
}
