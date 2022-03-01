package com.codefellows.salmonCookiesd14.model;

import javax.persistence.*;
import java.time.LocalDate;

// Step 1: Add an Entity annotation
@Entity
public class SalmonCookiesStore
{
  // Step 3: Add a default constructor if one is not present
  public SalmonCookiesStore()
  {

  }

  public SalmonCookiesStore(String storeName, int averageNumberOfCookiesPerDay, LocalDate storeOpeningDate)
  {
    this.storeName = storeName;
    this.averageNumberOfCookiesPerDay = averageNumberOfCookiesPerDay;
    this.storeOpeningDate = storeOpeningDate;
  }

  // Step 2: Add an ID
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)  // can use AUTO too if you prefer
  long id;
  @Column(columnDefinition="text")
  String storeName;
  int averageNumberOfCookiesPerDay;
  LocalDate storeOpeningDate;

  public String getStoreName()
  {
    return storeName;
  }

  public void setStoreName(String storeName)
  {
    this.storeName = storeName;
  }

  public int getAverageNumberOfCookiesPerDay()
  {
    return averageNumberOfCookiesPerDay;
  }

  public void setAverageNumberOfCookiesPerDay(int averageNumberOfCookiesPerDay)
  {
    this.averageNumberOfCookiesPerDay = averageNumberOfCookiesPerDay;
  }

  public LocalDate getStoreOpeningDate()
  {
    return storeOpeningDate;
  }

  public void setStoreOpeningDate(LocalDate storeOpeningDate)
  {
    this.storeOpeningDate = storeOpeningDate;
  }
}
