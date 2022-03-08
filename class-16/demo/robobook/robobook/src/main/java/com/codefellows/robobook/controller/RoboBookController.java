package com.codefellows.robobook.controller;

import com.codefellows.robobook.model.RoboUser;
import com.codefellows.robobook.repository.RoboUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

// Cheat Sheet 2: Make a controller
@Controller
public class RoboBookController
{
  @Autowired
  RoboUserRepository roboUserRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  private HttpServletRequest request;

  // Cheat Sheet 7A: Make a login page route
  @GetMapping("/login")
  public String getLoginPage()
  {
    return "login.html";
  }

  // Cheat Sheet 6A: Make a signup page route
  @GetMapping("/signup")
  public String getSignupPage()
  {
    return "signup.html";
  }

  // Cheat Sheet 8A: Make a home page route
  @GetMapping("/")
  public String getHomePage(Principal p, Model m)
  {
    if (p != null)  // only really necessary on pages where the user may not be logged in
    {
      String username = p.getName();
      RoboUser roboUser = roboUserRepository.findByUsername(username);
      String nickName = roboUser.getNickName();

      m.addAttribute("username", username);
      m.addAttribute("nickname", nickName);
    }
    return "index.html";
  }

  @PostMapping("/signup")
  public RedirectView createUser(String username, String nickName, String password)
  {
    RoboUser roboUser = new RoboUser();
    roboUser.setUsername(username);
    roboUser.setNickName(nickName);
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
