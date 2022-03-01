package com.codefellows.salmonCookiesd14.controller;

import com.codefellows.salmonCookiesd14.model.SalmonCookiesStore;
import com.codefellows.salmonCookiesd14.repository.SalmonCookiesStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class SalmonCookiesController
{
  // Step 6: Autowire an instance of the controller
  @Autowired
  SalmonCookiesStoreRepository salmonCookiesStoreRepository;

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
  public String getRootPage(Model m)
  {
    List<SalmonCookiesStore> stores = salmonCookiesStoreRepository.findAll();
    m.addAttribute("stores", stores);
    m.addAttribute("testString", "Testing");

    return "index.html";
  }

  @PostMapping("/addCookiesStore")
  public RedirectView addCookieStore(String storeName,
                               int averageNumberOfCookiesPerDay,
                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate storeOpeningDate)
  {
    SalmonCookiesStore store = new SalmonCookiesStore(storeName, averageNumberOfCookiesPerDay, storeOpeningDate);
    salmonCookiesStoreRepository.save(store);
    return new RedirectView("/");
  }
}
