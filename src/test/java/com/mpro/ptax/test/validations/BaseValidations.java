package com.mpro.ptax.test.validations;

import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;

public class BaseValidations {
	
	protected SoftAssert softassert= new SoftAssert();
	String expectedText = "Successfully saved details";

	
	@Step("Validate Record Saved Successfully alert message")
	public void validateSaveAlert(String actualMessage) {

	    softassert.assertTrue(actualMessage.contains(expectedText),
	            "Save alert message mismatch. Actual Message:" +actualMessage);
	}

	public void assertAllValidations(){
		softassert.assertAll();
		
		
	}
}
