package com.codefellows.robobook.controller;

import com.codefellows.robobook.model.RoboUser;
import com.codefellows.robobook.repository.RoboUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

// Cheat Sheet 2: Make a controller
@Controller
public class RoboBookController
{
  @Autowired
  RoboUserRepository roboUserRepository;

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public static class ResourceNotFoundException extends RuntimeException {

  }

  // Cheat Sheet 8A: Make a home page route
  @GetMapping("/")
  public String getHomePage(Principal p, Model m, RedirectAttributes redir)
  {
    boolean isError = false;

    if (p != null)  // only really necessary on pages where the user may not be logged in
    {
      String username = p.getName();
      RoboUser roboUser = roboUserRepository.findByUsername(username);
      String nickName = roboUser.getNickName();

      m.addAttribute("username", username);
      m.addAttribute("nickname", nickName);
    }

    if(isError)
    {
      m.addAttribute("errorMessage", "Testing the error");
      redir.addAttribute("errorMessage", "This is the 404 error message I made");
      throw new ResourceNotFoundException();
    }

    return "index.html";
  }

  @GetMapping("/test")
  public String getTheTestPageSoICanSeeTestStuffBecauseILikeIt(Principal p, Model m)
  {
    if (p != null)
    {
      String username = p.getName();
      m.addAttribute("username", username);
    }

    return "test.html";
  }

  @GetMapping("/roboprofile/{id}")
  public String getProfileInfoForUser(@PathVariable long id, Principal p, Model m)
  {
    if (p != null)  // only really necessary on pages where the user may not be logged in
    {
      String username = p.getName();
      m.addAttribute("username", username);
    }

    RoboUser lookingUpUser = roboUserRepository.getById(id);
    String lookingUpUsername;
    try
    {
      lookingUpUsername = lookingUpUser.getUsername();
    }
    catch (EntityNotFoundException enfe)
    {
      m.addAttribute("errorMessage", "Could not find a user for that id!");
      return "robo-profile.html";
    }
    String loggedInUsername = p.getName();
    m.addAttribute("loggedInUsername", loggedInUsername);
    m.addAttribute("lookingUpUserId", id);
    m.addAttribute("lookingUpUsername", lookingUpUsername);
    m.addAttribute("lookingUpUserBirthday", lookingUpUser.getBirthday());

    if(!loggedInUsername.equals("RoboEd"))
      return "index.html";
    else
      return "robo-profile.html";
  }
}
