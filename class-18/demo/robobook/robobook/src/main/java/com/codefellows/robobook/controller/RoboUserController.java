package com.codefellows.robobook.controller;

import com.codefellows.robobook.model.RoboUser;
import com.codefellows.robobook.repository.RoboUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDate;

@Controller
public class RoboUserController
{
  @Autowired
  RoboUserRepository roboUserRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  private HttpServletRequest request;

  // Cheat Sheet 7A: Make a login page route
  @GetMapping("/login")
  public String getLoginPage(Model m, Principal p)
  {
    if (p != null)  // only really necessary on pages where the user may not be logged in
    {
      String loggedInUser = p.getName();
      m.addAttribute("username", loggedInUser);
    }
    return "login.html";
  }

  // Cheat Sheet 6A: Make a signup page route
  @GetMapping("/signup")
  public String getSignupPage(Model m, Principal p)
  {
    if (p != null)  // only really necessary on pages where the user may not be logged in
    {
      String loggedInUser = p.getName();
      m.addAttribute("username", loggedInUser);
    }
    return "signup.html";
  }

  @PostMapping("/signup")
  public RedirectView createUser(Principal p, Model m, String username, String nickName, String password, @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate birthday)
  {
    RoboUser roboUser = new RoboUser();
    roboUser.setUsername(username);
    roboUser.setNickName(nickName);
    roboUser.setBirthday(birthday);
    String hashedPassword = passwordEncoder.encode(password);
    roboUser.setPassword(hashedPassword);

    roboUserRepository.save(roboUser);

    // Automatically log the user in if the user saved correctly
    authWithHttpServletRequest(username, password);

    return new RedirectView("/");
  }

  public void authWithHttpServletRequest(String username, String password)
  {
    try
    {
      request.login(username, password);
    } catch (ServletException se)
    {
      System.out.println("Error while logging in.");
      se.printStackTrace();
    }
  }
}
