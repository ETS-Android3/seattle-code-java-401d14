package com.codefellows.robobook.repository;

import com.codefellows.robobook.model.RoboUser;
import org.springframework.data.jpa.repository.JpaRepository;

// Cheat Sheet 1B: Make a repository for users
public interface RoboUserRepository extends JpaRepository<RoboUser, Long>
{
  RoboUser findByUsername(String username);
}
