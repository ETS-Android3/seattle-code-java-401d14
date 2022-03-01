package com.codefellows.salmonCookiesd14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeachingController
{
  @ResponseBody
  @GetMapping("teaching/hello-world")  // don't start with forward slash or it'll mess up Heroku
  public String helloMethod()
  {
    return "<strong>Hello world!</strong>";  // returning exact text goes with @ResponseBody
  }

  @GetMapping("teaching/best-friends")
  public String bffMethod(Model bestModelNameEverGoesHere)  // not the "M" in MVC, which is confusing!
  {
    bestModelNameEverGoesHere.addAttribute("name", "Ed");  // named the same thing as the template
    bestModelNameEverGoesHere.addAttribute("numberOfYears", 15);
    bestModelNameEverGoesHere.addAttribute("whatPersonDoes", "An awesome software dev");
    return "best-friend.html";  // returning the name of the template file goes with @GetMapping (no need for @ResponseBody)
  }
}
