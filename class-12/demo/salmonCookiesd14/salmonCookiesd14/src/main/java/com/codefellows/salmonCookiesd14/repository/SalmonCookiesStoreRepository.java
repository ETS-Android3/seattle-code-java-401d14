package com.codefellows.salmonCookiesd14.repository;

import com.codefellows.salmonCookiesd14.model.SalmonCookiesStore;
import org.springframework.data.jpa.repository.JpaRepository;

// Step 4: Make a repository interface with the class to put in the db along with the ID type
public interface SalmonCookiesStoreRepository extends JpaRepository<SalmonCookiesStore, Long>
{
  // (Optional) Step 5: Create methods with this syntax: findBy<EXACT VARIABLE NAME GOES HERE>(<EXACT VARIABLE NAME GOES HERE>)
  public SalmonCookiesStore findByStoreName(String storeName);
}
