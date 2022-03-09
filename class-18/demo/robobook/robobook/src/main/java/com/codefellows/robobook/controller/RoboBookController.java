package com.codefellows.robobook.controller;

import com.codefellows.robobook.model.RoboUser;
import com.codefellows.robobook.repository.RoboUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
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
import java.util.HashSet;
import java.util.Set;

// Cheat Sheet 2: Make a controller
@Controller
public class RoboBookController
{
  @Autowired
  RoboUserRepository roboUserRepository;

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "A test message that says the resource wasn't found")
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
      RoboUser currentRoboUser = roboUserRepository.findByUsername(username);
      String nickName = currentRoboUser.getNickName();

      // Start by creating employees and managers by hand!

      /*Set<RoboUser> robotsWhoAreMyEmployees = currentRoboUser.getRobotsWhoAreMyEmployees();

      RoboUser dave = roboUserRepository.findByUsername("RoboDave");
      robotsWhoAreMyEmployees.add(dave);  // can only save from the perspective of management! Because that's the way the JOIN table is structured

      RoboUser kevin = roboUserRepository.findByUsername("Kevin");
      RoboUser josh = roboUserRepository.findByUsername("Joshua");

      // Don't try to save from the employee side! It won't work in our setup
      // robotsWhoManageMe.add(kevin);  THIS DOESN'T WORK, DON'T DO IT
      // robotsWhoManageMe.add(josh);  THIS ALSO DOESN'T WORK

      kevin.getRobotsWhoAreMyEmployees().add(currentRoboUser);
      josh.getRobotsWhoAreMyEmployees().add(currentRoboUser);

      roboUserRepository.save(currentRoboUser);*/

      m.addAttribute("username", username);
      m.addAttribute("nickname", nickName);
    }

    if(isError)
    {
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

    String username = p.getName();
    m.addAttribute("username", username);
    RoboUser currentlyBrowsingUser = roboUserRepository.findByUsername(username);
    m.addAttribute("currentlyBrowsingId",currentlyBrowsingUser.getId() );
    m.addAttribute("profileId", id);

    RoboUser lookingUpUser = roboUserRepository.getById(id);
    m.addAttribute("robotsThatManageProfileUser", lookingUpUser.getRobotsWhoManageMe());
    m.addAttribute("robotsThatAreEmployedByProfileUser", lookingUpUser.getRobotsWhoAreMyEmployees());
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

  // Currently browsing user will manage the user that has profileId
  @PutMapping("manage-user/{profileId}")
  RedirectView manageAUser(@PathVariable long profileId, Principal p)
  {
    RoboUser currentlyBrowsingUser = roboUserRepository.findByUsername(p.getName());
    RoboUser profileUser = roboUserRepository.getById(profileId);

    currentlyBrowsingUser.getRobotsWhoAreMyEmployees().add(profileUser);
    roboUserRepository.save(currentlyBrowsingUser);

    return new RedirectView("/roboprofile/" + profileId);
  }

  // Currently browsing user will be employed by the user that has profileId
  @PutMapping("employ-user/{profileId}")
  RedirectView employAUser(@PathVariable long profileId, Principal p)
  {
    RoboUser currentlyBrowsingUser = roboUserRepository.findByUsername(p.getName());
    RoboUser profileUser = roboUserRepository.getById(profileId);

    profileUser.getRobotsWhoAreMyEmployees().add(currentlyBrowsingUser);
    roboUserRepository.save(profileUser);

    return new RedirectView("/roboprofile/" + profileId);
  }
}
