package com.mpro.ptax.driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverManager {

	 private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    private DriverManager() {
	        // Prevent object creation
	    }

	    public static void initDriver() {
	        if (driver.get() == null) { 
	        	
	        	ChromeOptions options = new ChromeOptions();

	        	options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
	            // Accept insecure certificates (important for 8443 UAT)
	            options.setAcceptInsecureCerts(true);

	            // Ignore SSL errors
	            options.addArguments("--ignore-certificate-errors");

	            // Optional but recommended for Angular apps
	            options.addArguments("--start-maximized");
	            driver.set(new ChromeDriver());
	           
	        }
	    }

	    public static WebDriver getDriver() {
	        if (driver.get() == null) {
	            throw new RuntimeException(
	                "WebDriver is NULL. Did you forget to call DriverManager.initDriver()?"
	            );
	        }
	        return driver.get();
	    }
}
//	    public static void quitDriver() {
//	        if (driver.get() != null) {
//	            driver.get().quit();
//	            driver.remove();
//	        }
//	    }
//	}
	
