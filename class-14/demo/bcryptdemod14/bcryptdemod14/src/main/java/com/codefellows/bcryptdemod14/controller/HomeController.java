package com.codefellows.bcryptdemod14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController
{
  @GetMapping("/home/{username}")
  public String getHomePage(@PathVariable String username, Model m)
  {
    m.addAttribute("username", username);
    return "home.html";
  }
}
