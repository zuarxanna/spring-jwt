package com.springjwt.models.repository;

import com.springjwt.models.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
  AppUser findByUsername(String username);
}
