package com.mpro.ptax.test.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.mpro.ptax.Utils.AttachScreenshot;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.driver.DriverManager;
@Listeners(com.mpro.ptax.test.listeners.TestListener.class)
public class BaseTest {

	protected static Logger log;
    protected WebDriver driver;
    

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    	
    	log=LogManager.getLogger(this.getClass());
    	System.out.println("Thread ID: " + Thread.currentThread().getId());

        DriverManager.initDriver();

        driver = DriverManager.getDriver();
        
        System.out.println("Driver after init: " + driver);
        
        driver.manage().window().maximize();
        
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        DriverManager.quitDriver();
//    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
        	AttachScreenshot.attachScreenshot(driver, result.getName());
        }
    }
    
   }

