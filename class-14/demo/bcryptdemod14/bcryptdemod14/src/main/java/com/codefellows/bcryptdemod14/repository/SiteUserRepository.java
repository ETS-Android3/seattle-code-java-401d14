package com.codefellows.bcryptdemod14.repository;

import com.codefellows.bcryptdemod14.model.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long>
{
  SiteUser findByUsername(String username);
}
