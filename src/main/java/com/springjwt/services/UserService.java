package com.springjwt.services;

import com.springjwt.models.entities.Role;
import com.springjwt.models.entities.AppUser;
import java.util.List;

public interface UserService {
  AppUser saveUser(AppUser user);
  Role saveRole(Role role);
  void addRoleToUser(String username, String roleName);
  AppUser getUser(String username);
  List<AppUser>getUsers();

}
