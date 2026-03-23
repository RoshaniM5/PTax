package com.mpro.ptax.Utils;

import org.testng.ITestListener;
import org.testng.ITestResult;


	public class TestListener implements ITestListener {

	   
	    public void onTestFailure(ITestResult result) {

	        System.out.println("Test Failed: " + result.getName());

	        CaptureScreenshot.takeScreenshot(); 
	    }
	}

