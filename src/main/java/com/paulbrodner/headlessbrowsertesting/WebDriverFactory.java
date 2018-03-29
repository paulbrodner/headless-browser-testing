package com.paulbrodner.headlessbrowsertesting;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebDriverFactory implements FactoryBean<WebDriver> {

	@Value("${webdriver.hub}")
	private URL webdriverHubUrl;
	
	@Value("${webdriver.browser.name}")
	private String webdriverBrowserName;

	@Override
	public WebDriver getObject() throws Exception {
		Capabilities capabilities = fromWebDriverBrowserName(webdriverBrowserName);
		
		WebDriver driver = new RemoteWebDriver(webdriverHubUrl, capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	@Override
	public Class<?> getObjectType() {
		return WebDriver.class;
	}
	
	private Capabilities fromWebDriverBrowserName(String browserName) {
		switch (webdriverBrowserName.toLowerCase()) {
		case "firefox":
			return new FirefoxOptions();			
		case "chrome":
			return DesiredCapabilities.chrome();
		default:
			throw new RuntimeException("Please add appropriate WebDriver Capabilties for this Web Browser Type: " + browserName);		
		}		
	}
}
