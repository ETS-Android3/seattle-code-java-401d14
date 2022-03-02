package com.codefellows.salmonCookiesd14;

import com.codefellows.salmonCookiesd14.controller.SalmonCookiesController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// Make sure you import these manually for your unit tests
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc  // Don't forget to add this for MockMvc object!
class SalmonCookiesd14ApplicationTests {

  @Autowired
  MockMvc mockMvc;

	@Test
	void contextLoads() {
    SalmonCookiesController testController = new SalmonCookiesController();
    assertNotNull(testController, "Test controller was null!");
	}

  @Test
  void testHomePage() throws Exception
  {
    System.out.println("Starting to test home page");
    mockMvc.perform(get("/"))
      .andDo(print())  // enable for debugging
      .andExpect(content().string(containsString("<div>All the best cookies for salmon!!!</div>")))
      .andExpect(content().string(containsString("value=\"Add Store\">")))
      .andExpect(status().isOk());
  }

  @Test
  void testCreateCookieStore() throws Exception
  {
    System.out.println("Starting to test cookie store creation POST");
    mockMvc.perform(post("/addCookiesStore/")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        .param("storeName", "A Cookie Store")
        .param("averageNumberOfCookiesPerDay", "20")
        .param("storeOpeningDate", "1999-11-22")
      )
      .andDo(print())
      .andExpect(redirectedUrl("/"))
      .andExpect(status().isFound());
  }

}
