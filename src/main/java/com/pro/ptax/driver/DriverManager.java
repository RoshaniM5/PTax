package com.pro.ptax.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverManager {

	 private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    private DriverManager() {
	        // Prevent object creation
	    }

	    public static void initDriver() {
	        if (driver.get() == null) {
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

	    public static void quitDriver() {
	        if (driver.get() != null) {
	            driver.get().quit();
	            driver.remove();
	        }
	    }
	}
	
