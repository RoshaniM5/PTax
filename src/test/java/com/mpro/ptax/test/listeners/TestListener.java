package com.mpro.ptax.test.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.mpro.ptax.Utils.AttachScreenshot;
import com.mpro.ptax.driver.DriverManager;

public class TestListener implements ITestListener {

	    @Override
	    public void onTestStart(ITestResult result) {
	        System.out.println("STARTED: " + result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("PASSED: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {

	        System.out.println("FAILED: " + result.getName());
	        
	        // ✅ Attach screenshot to Allure
	        AttachScreenshot.attachScreenshot(DriverManager.getDriver(), result.getName());
	    }
	    
	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("SKIPPED: " + result.getName());
	    }
	}

