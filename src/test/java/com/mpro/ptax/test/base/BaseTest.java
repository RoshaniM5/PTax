package com.mpro.ptax.test.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.mpro.ptax.base.BasePage;
import com.pro.ptax.driver.DriverManager;

public class BaseTest {

	protected static Logger log;
    protected WebDriver driver;
    protected BasePage basepage;

    @BeforeMethod
    public void setUp() {
    	log=LogManager.getLogger(this.getClass());
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        basepage= new BasePage();
    }

//    @AfterMethod
//    public void tearDown() {
//        DriverManager.quitDriver();
//    }
}

