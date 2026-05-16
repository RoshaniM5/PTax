package com.mpro.ptax.driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import com.epam.healenium.SelfHealingDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverManager {

	 private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    private DriverManager() {
	        // Prevent object creation
	    }

//	    public static void initDriver() {
//	        driver.set(new ChromeDriver());   // or your browser
//	    }
	    
	    public static void initDriver() {
	    	 if (driver.get() == null) {

	    	        ChromeOptions options = new ChromeOptions();

	    	        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
	    	        options.setAcceptInsecureCerts(true);
	    	        options.addArguments("--ignore-certificate-errors");
	    	        options.addArguments("--start-maximized");
	    	        
//	    	        WebDriver delegate = new ChromeDriver(options);
//
//	    	        // 2. Wrap with Healenium
//	    	        SelfHealingDriver healingDriver = SelfHealingDriver.create(delegate);
//
//	    	        // 3. Store in ThreadLocal
//	    	        driver.set(healingDriver);
	    	        driver.set(new ChromeDriver(options));
	    	    }
	    }

	    public static WebDriver getDriver() {
	    	WebDriver drv = driver.get();
	        if (drv == null) {
	            throw new RuntimeException(
	                "WebDriver is NULL on Thread: " + Thread.currentThread().getId()
	            );
	        }
	        return drv;
	    }

	    public static void quitDriver() {
	        if (driver.get() != null) {
	            driver.get().quit();
	            driver.remove();
	        }
	    }
	}
	
