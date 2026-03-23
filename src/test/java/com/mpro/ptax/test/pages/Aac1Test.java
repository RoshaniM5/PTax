package com.mpro.ptax.test.pages;

import java.util.concurrent.TimeoutException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Aac1;
import com.mpro.ptax.test.auth.LoginTestFlow;
import com.mpro.ptax.test.base.BaseTest;

public class Aac1Test extends BaseTest{
	

	private LoginTestFlow login;
	private GlobalButtons globalbuttons;
	private Aac1 aac1;
	
	  @BeforeMethod
	    public void initFlow() {
	        login 			= new LoginTestFlow(); 
	        globalbuttons 	= new GlobalButtons();
	        aac1			= new Aac1();
	        
	  }
	  
	@Test(groups="Sanity-Aac", priority=5)
	public void verifyAacFlow() throws TimeoutException, InterruptedException {
		
		 log.info("Starting Aac Flow Test");
		 	

		    log.info("Executing Aac flow");
		    login.loginAs(UserRole.Aac);

		    log.info("ZoomedIn");
		    basepage.zoomOut(75);
		    
		    basepage.waitForLoaderToDisappear();
		    
		    log.info("Clicking cross icon on global buttons");
		    globalbuttons.clickcrossIcon();
		    
		    log.info("Scrolled down and clicked successfully");
		    basepage.scrollDown();
		    
		    log.info("Inward Selected successfully");
		    basepage.selectLatestInward();
		    
		    log.info("Selected all required details successfully");
		    aac1.openAac1();
			
		}
		
	}

