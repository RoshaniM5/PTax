package com.mpro.ptax.test.pagesAssessment;

import java.util.concurrent.TimeoutException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Assessment.Aac;
import com.mpro.ptax.test.auth.LoginTestFlow;
import com.mpro.ptax.test.base.BaseTest;

public class AacLoginTest extends BaseTest {

	private LoginTestFlow login;
	private GlobalButtons globalbuttons;
	private Aac aac;
	private BasePage basepage;
	
	  @BeforeMethod(alwaysRun =true)
	    public void initFlow() {
	        login 			= new LoginTestFlow(); 
	        globalbuttons 	= new GlobalButtons();
	        aac				= new Aac();
	        basepage		= new BasePage();
	  }
	  
	@Test(groups={"Sanity", "Aac", "sanity"}, alwaysRun =true)
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
		    aac.openAac();
			
		}
		
	}
	

  
    

  


