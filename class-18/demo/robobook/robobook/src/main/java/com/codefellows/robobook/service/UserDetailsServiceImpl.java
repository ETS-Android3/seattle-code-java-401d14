package com.codefellows.robobook.service;

import com.codefellows.robobook.repository.RoboUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Cheat Sheet 3: Implement UserDetailsServiceImpl based on UserDetailsService
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
  @Autowired
  RoboUserRepository roboUserRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
  {
    return roboUserRepository.findByUsername(username);
  }
}
