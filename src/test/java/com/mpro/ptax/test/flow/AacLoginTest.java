package com.mpro.ptax.test.flow;

import java.util.concurrent.TimeoutException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.pageobject.Aac;
import com.mpro.ptax.projectFlow.LoginFlow;
import com.mpro.ptax.test.base.BaseTest;

public class AacLoginTest extends BaseTest {

	private LoginFlow login;
	private GlobalButtons globalbuttons;
	private Aac aac;
	
	  @BeforeMethod
	    public void initFlow() {
	        login 			= new LoginFlow(); 
	        globalbuttons 	= new GlobalButtons();
	        aac				= new Aac();
	        
	  }
	  
	
	@Test(dependsOnGroups = "InwardFlow")
	public void verifyAacFlow() throws TimeoutException, InterruptedException {
		
		 log.info("Starting Aac Flow Test");
		 	
		 
		    log.info("Executing Aac flow");
		    login.Aac();

		    log.info("ZoomedIn");
		    basepage.zoomOut(75);
		    
		    log.info("Clicking cross icon on global buttons");
		    globalbuttons.clickcrossIcon();
		    
		    log.info("Scrolled down and clicked successfully");
		    basepage.scrollDown();
		    
		    log.info("Inward Selected successfully");
		    basepage.selectLatestInward();
		    
		    log.info("Selected all required details successfully");
		    aac.openAac();
		  
		    log.info("Logout completed successfully");
			globalbuttons.Logout();
			
		}
		
	}
	

  
    

  


