package com.springjwt.controller;

import com.springjwt.models.entities.AppUser;
import com.springjwt.models.entities.Role;
import com.springjwt.services.UserService;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<AppUser>>getUsers() {
    return ResponseEntity.ok().body(userService.getUsers());
  }

  @PostMapping("/users")
  public ResponseEntity<AppUser>saveUser(@RequestBody AppUser user) {
    return new ResponseEntity<AppUser>(
        userService.saveUser(user),
        HttpStatus.CREATED
    );
  }

  @PostMapping("/roles")
  public ResponseEntity<Role>saveRole(@RequestBody Role role) {
    return new ResponseEntity<Role>(
        userService.saveRole(role),
        HttpStatus.CREATED
    );
  }

  @PostMapping("users/add-role")
  public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form) {
    userService.addRoleToUser(form.getUsername(), form.getRoleName());
    return ResponseEntity.ok().build();
  }
}

@Data
class RoleToUserForm{
  private String username;
  private String roleName;
}
