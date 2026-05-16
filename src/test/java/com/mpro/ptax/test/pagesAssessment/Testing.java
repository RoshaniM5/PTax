package com.mpro.ptax.test.pagesAssessment;

import java.util.concurrent.TimeoutException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Assessment.Aac;
import com.mpro.ptax.test.auth.LoginTestFlow;
import com.mpro.ptax.test.base.BaseTest;

public class Testing extends BaseTest {
	

		private LoginTestFlow login;
		private GlobalButtons globalbuttons;
		private Aac aac;
		
		
		  @BeforeMethod(alwaysRun =true)
		    public void initFlow() {
		        login 			= new LoginTestFlow(); 
		        globalbuttons 	= new GlobalButtons();
		        aac				= new Aac();
		        
		  }
		  
		  
		@Test(groups={"Akshay"}, alwaysRun =true)
		public void verifyAacFlow() throws TimeoutException, InterruptedException {
			
			System.out.println("This is akshay testing");
			}
			
		}
		

	  
	    


