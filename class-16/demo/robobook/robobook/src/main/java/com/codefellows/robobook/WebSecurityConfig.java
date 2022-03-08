package com.codefellows.robobook;

import com.codefellows.robobook.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Cheat Sheet 5: Add a WebSecurityConfig file (please see lab doc for starter code)
// Don't forget to set up the password encoder in the controller later!
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    return bCryptPasswordEncoder;
  }

  @Override
  protected void configure(final AuthenticationManagerBuilder authManagerBuilder) throws Exception {
    authManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  // Below here is where you configure login, logout, and authorization
  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http
      .cors().disable()
      .csrf().disable()
      .authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers("/signup").permitAll()
        .antMatchers("/resources/**").permitAll()
        .antMatchers("/css/**").permitAll()
        .anyRequest().authenticated()
      .and()
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/")
      .and()
        .logout()
        .logoutSuccessUrl("/login");
  }
}
