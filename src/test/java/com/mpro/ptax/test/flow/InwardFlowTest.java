package com.mpro.ptax.test.flow;

import java.util.concurrent.TimeoutException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.pageobject.Inwardclerk;
import com.mpro.ptax.pages.dashboard.Dashboard;
import com.mpro.ptax.projectFlow.LoginFlow;
import com.mpro.ptax.test.base.BaseTest;

public class InwardFlowTest extends BaseTest{
	
	private LoginFlow login;
	private GlobalButtons globalbuttons;
	private Dashboard dashboard;
	private Inwardclerk inwardClerk;
	
	  @BeforeMethod
	    public void initFlow() {
		  	login = new LoginFlow(); 
	        globalbuttons = new GlobalButtons();
	        dashboard = new Dashboard();
	        inwardClerk = new Inwardclerk();
	  }
	  
	
	@Test(groups="InwardFlow")
	public void verifyInwardClerkFlow() throws TimeoutException, InterruptedException {
		
		 log.info("Starting Inward Clerk Flow Test");

		    log.info("Executing Inward Clerk flow");
		    login.InwardClerk();
		    
		    log.info("ZoomedIn");
		    basepage.zoomOut(75);

		    log.info("Clicking cross icon on global buttons");
		    globalbuttons.clickcrossIcon();

		    log.info("Opening Assessment from Dashboard");
		    dashboard.openAssessment();

		    log.info("Opening Inward from Dashboard");
		    dashboard.openInward();

		    log.info("Opening Inward form from Inward Clerk page");
		    inwardClerk.openInward();

		    log.info("Test execution completed successfully");
			globalbuttons.clickSave();
			
			log.info("Alert message closed successfully");
			basepage.acceptAlert();
			
			log.info("Popup closed successfully");
			dashboard.closePopup();
		    
		    log.info("Logout completed successfully");
			dashboard.Logout();
			
		}
		
	}
	
