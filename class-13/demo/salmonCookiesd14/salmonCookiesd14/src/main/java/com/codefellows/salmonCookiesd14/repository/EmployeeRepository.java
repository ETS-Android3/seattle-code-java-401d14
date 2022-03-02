package com.codefellows.salmonCookiesd14.repository;

import com.codefellows.salmonCookiesd14.model.Employee;
import com.codefellows.salmonCookiesd14.model.SalmonCookiesStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
}
