package com.mpro.ptax.test.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.mpro.ptax.Utils.CaptureScreenshot;

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

	        // 📸 Capture Screenshot
	        CaptureScreenshot.takeScreenshot();
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("SKIPPED: " + result.getName());
	    }
	}

