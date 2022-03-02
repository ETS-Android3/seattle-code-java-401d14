package com.codefellows.salmonCookiesd14.controller;

import com.codefellows.salmonCookiesd14.model.Employee;
import com.codefellows.salmonCookiesd14.model.SalmonCookiesStore;
import com.codefellows.salmonCookiesd14.repository.EmployeeRepository;
import com.codefellows.salmonCookiesd14.repository.SalmonCookiesStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EmployeeController
{
  @Autowired
  EmployeeRepository employeeRepository;
  @Autowired
  SalmonCookiesStoreRepository salmonCookiesStoreRepository;

  @PostMapping("/add-employee")
  public RedirectView addEmployee(long storeId, String name, int payPerHour)
  {
    SalmonCookiesStore employedAtStore = salmonCookiesStoreRepository.getById(storeId);
    Employee employeeToAdd = new Employee(name, payPerHour);
    employeeToAdd.setEmployedAtStore(employedAtStore);
    employeeRepository.save(employeeToAdd);

    return new RedirectView("/");  // TODO: make this work better
  }

  @GetMapping("/view-employees/{storeId}")
  public String viewEmployees(@PathVariable long storeId, Model m)
  {
    SalmonCookiesStore store = salmonCookiesStoreRepository.getById(storeId);
    m.addAttribute("employees", store.getEmployeesAtThisStore());
    return "/view-employees.html";
  }
}
