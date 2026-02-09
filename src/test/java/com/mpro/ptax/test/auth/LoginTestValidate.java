package com.mpro.ptax.test.auth;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mpro.ptax.Utils.CaptureScreenshot;
import com.mpro.ptax.pages.auth.Login;
import com.mpro.ptax.test.base.BaseTest;
import com.mpro.ptax.test.dataprovider.LoginDataProvider;



	public class LoginTestValidate extends BaseTest{
		
		  private Login login;
	   
	    
	    @BeforeMethod
	    public void setup() {
	    	log.info("Initializing LoginTest Setup");
	        login = new Login();
	       
	    }
	  
	    @Test(dataProvider = "invalidLoginData",  dataProviderClass = LoginDataProvider.class, description = "Verify error message for invalid login attempts")
	    public void shouldShowErrorMessageWhenLoginCredentialsAreInvalid(String username, String password, String expectedErrorMessage)
	    	 
	    {
	    	
	    	
	    	    login.openUrl();
	    	    login.login(username, password);

	    	    log.info("Starting invalid login test");
	            log.debug("Test data -> Username: , Password: ", username, password);
	            
	    	    String actualError =
	    	            CaptureScreenshot.captureMessage(Login.loginErrorMessage, 10);

	    	    log.info("Captured error message: ", actualError);
	    	    
	    	    Assert.assertNotNull(actualError, "Login error message did not appear");
	    	    
	    	    Assert.assertTrue(
	    	            actualError.contains(expectedErrorMessage),
	    	            "Unexpected error message. Actual: " + actualError
	    	    );
	    	  
	    	    log.info("Validation passed for username: ", username);
	    	}
	      
	 }
	    
	
