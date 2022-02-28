package com.codefellows.salmonCookiesd14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SalmonCookiesController
{
  @GetMapping("cookie/{cookieName}")
  public String getCookieStuff(Model m, @PathVariable String cookieName, int numberOfCookies,
      String monsterName)  // same as GetMapping path variable name
  {
    m.addAttribute("numOfCookies", numberOfCookies);  // comes in as a query param
    m.addAttribute("monsterName", monsterName);
    m.addAttribute("theCookieNameStringVariable", cookieName);
    return "cookie.html";
  }

  @GetMapping("/")
  public String getRootPage()
  {
    return "index.html";
  }
}
