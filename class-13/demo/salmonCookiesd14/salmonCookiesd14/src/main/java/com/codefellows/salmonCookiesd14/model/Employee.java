package com.codefellows.salmonCookiesd14.model;

import javax.persistence.*;

@Entity
public class Employee
{
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  long id;
  String name;
  int payPerHour;

  @ManyToOne
  SalmonCookiesStore employedAtStore;

  public Employee()
  {

  }

  public Employee(String name, int payPerHour)
  {
    this.name = name;
    this.payPerHour = payPerHour;
  }

  public SalmonCookiesStore getEmployedAtStore()
  {
    return employedAtStore;
  }

  public void setEmployedAtStore(SalmonCookiesStore employedAtStore)
  {
    this.employedAtStore = employedAtStore;
  }

  public long getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getPayPerHour()
  {
    return payPerHour;
  }

  public void setPayPerHour(int payPerHour)
  {
    this.payPerHour = payPerHour;
  }
}
