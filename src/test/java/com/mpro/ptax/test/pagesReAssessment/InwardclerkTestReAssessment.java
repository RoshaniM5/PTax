package com.mpro.ptax.test.pagesReAssessment;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Assessment.Inwardclerk;
import com.mpro.ptax.pageobject.Assessment.Supdt;
import com.mpro.ptax.pages.dashboard.Dashboard;
import com.mpro.ptax.test.auth.LoginTestFlow;
import com.mpro.ptax.test.base.BaseTest;
import com.mpro.ptax.test.validations.BaseValidations;

public class InwardclerkTestReAssessment extends BaseTest{

	private LoginTestFlow login;
	private GlobalButtons globalbuttons;
	private Dashboard dashboard;
	private Inwardclerk inwardClerk;
	private BasePage basepage;
	private BaseValidations validate;
	private Supdt supdt;
	
	  @BeforeMethod(alwaysRun =true)
	    public void initFlow() {
		  	login = new LoginTestFlow(); 
	        globalbuttons = new GlobalButtons();
	        dashboard = new Dashboard();
	        inwardClerk = new Inwardclerk();
	        basepage= new BasePage();
	        validate= new BaseValidations();
	        supdt= new Supdt();
	  }
	  
	  @Test(groups={"Sanity", "inward"}, alwaysRun =true)
		public void verifySacInwardClerkFlow() throws InterruptedException {
		  
		    log.info("Testing WI Flow Test");
			login.loginAs(UserRole.Supdt);
			log.info("ZoomedIn");
			basepage.zoomOut(75);  
			basepage.waitForLoaderToDisappear();
			log.info("Clicking cross icon on global buttons");
			globalbuttons.clickcrossIcon();
			log.info("Inward Selected Successfully");
			basepage.selectLatestInward();
//			log.info("ScrollDown is working correctly");
//			basepage.scrollUp();
		    log.info("Data Entered Successfully in dysupdt");
		    supdt.openSupdt();
		    log.info("Executing Inward Clerk flow");
		    
		    log.info("login successfull");
		    login.loginAs(UserRole.Inwardclerk);
		    
		    log.info("ZoomedIn");
		    basepage.zoomOut(75);
		    
		    basepage.waitForLoaderToDisappear();
		    log.info("Clicking cross icon on global buttons");
		    globalbuttons.clickcrossIcon();
		    log.info("Opening Assessment from Dashboard");
		    dashboard.openAssessment();
		    log.info("Opening Inward from Dashboard");
		    dashboard.openInwardForm();
		    log.info("Opening Inward from Dashboard");
		    inwardClerk.openSacInward();
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