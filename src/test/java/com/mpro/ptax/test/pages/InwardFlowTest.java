package com.mpro.ptax.test.pages;

import java.util.concurrent.TimeoutException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Inwardclerk;
import com.mpro.ptax.pages.dashboard.Dashboard;
import com.mpro.ptax.test.auth.LoginTestFlow;
import com.mpro.ptax.test.base.BaseTest;
import com.mpro.ptax.test.validations.BaseValidations;

 class InwardFlowTest extends BaseTest{
	
	private LoginTestFlow login;
	private GlobalButtons globalbuttons;
	private Dashboard dashboard;
	private Inwardclerk inwardClerk;
	private BasePage basepage;
	private BaseValidations validate;
	  @BeforeMethod
	    public void initFlow() {
		  	login = new LoginTestFlow(); 
	        globalbuttons = new GlobalButtons();
	        dashboard = new Dashboard();
	        inwardClerk = new Inwardclerk();
	        basepage= new BasePage();
	        validate= new BaseValidations();
	  }
	  
	
	@Test(groups="Sanity-Inward", priority=1)
	public void verifyInwardClerkFlow() throws TimeoutException, InterruptedException {
		
		 log.info("Starting Inward Clerk Flow Test");

		    log.info("Executing Inward Clerk flow");
		    login.loginAs(UserRole.Inwardclerk);
		    
		    log.info("ZoomedIn");
		    basepage.zoomOut(75);
		    
		    basepage.waitForLoaderToDisappear();
		    
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
			    
//			log.info("Alert message closed successfully");
//			basepage.acceptAlert();
			
			String alertMessage = basepage.getAlertMessage();
			log.info("Alert Message : " + alertMessage);
			validate.validateSaveAlert(alertMessage);
			validate.assertAllValidations();
			
			log.info("Popup closed successfully");
			dashboard.closePopup();
		    
		    log.info("Logout completed successfully");
			dashboard.Logout();
			
		}
		
	}
	
