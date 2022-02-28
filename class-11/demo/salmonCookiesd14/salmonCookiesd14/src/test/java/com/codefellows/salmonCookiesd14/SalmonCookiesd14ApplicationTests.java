package com.codefellows.salmonCookiesd14;

import com.codefellows.salmonCookiesd14.controller.SalmonCookiesController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalmonCookiesd14ApplicationTests {

	@Test
	void contextLoads() {
    SalmonCookiesController testController = new SalmonCookiesController();
    assertNotNull(testController, "Test controller was null!");
	}

}
