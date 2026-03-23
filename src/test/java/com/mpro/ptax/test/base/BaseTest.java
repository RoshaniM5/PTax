package com.mpro.ptax.test.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.driver.DriverManager;

public class BaseTest {

	protected static Logger log;
    protected WebDriver driver;
    protected BasePage basepage;

    @BeforeClass
    public void setUp() {
    	log=LogManager.getLogger(this.getClass());
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        basepage= new BasePage();
    }

//    @AfterClass
//    public void tearDown() {
//        DriverManager.quitDriver();
//    }
    
   }

