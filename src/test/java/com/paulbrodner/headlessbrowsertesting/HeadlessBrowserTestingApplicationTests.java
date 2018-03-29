package com.paulbrodner.headlessbrowsertesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadlessBrowserTestingApplicationTests {

	@Autowired 
	WebDriverFactory driverFactory;
	WebDriver driver;
	
	@Test
	public void contextLoads() {
	}	

	@Test
	public void ableToOpenGooglePage() throws Exception {
		driver = driverFactory.getObject();
		driver.get("http://www.google.com");

		assertEquals("Google", driver.getTitle());
	}

}
