package com.mpro.ptax.test.pageWorkflow;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mpro.ptax.Utils.CredentialUtil;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Assessment.Inwardclerk;
import com.mpro.ptax.pageobject.Assessment.Supdt;
import com.mpro.ptax.pageobject.Workflow.WTDeletion;
import com.mpro.ptax.pageobject.Workflow.WTLevy;
import com.mpro.ptax.pages.dashboard.Dashboard;
import com.mpro.ptax.test.auth.LoginTestFlow;
import com.mpro.ptax.test.base.BaseTest;
import com.mpro.ptax.test.validations.BaseValidations;

	public class WTLevyWorkFlow extends BaseTest{

		private LoginTestFlow login;
		private GlobalButtons globalbuttons;
		private Dashboard dashboard;
		private Inwardclerk inwardClerk;
		private BasePage basepage;
		private BaseValidations validate;
		private WTDeletion wtdeletion;
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
		        wtdeletion= new WTDeletion();
		        
		  }
		  
		  @Test(groups={"Sanity", "WTLevy"}, alwaysRun =true)
			public void verifySacInwardwithWTLevy() throws InterruptedException {
			    	
			    	
			    	String username1 = CredentialUtil.getUsername(UserRole.Inwardclerk);
			    	String password1 = CredentialUtil.getPassword();
			    	String username2 = CredentialUtil.getUsername(UserRole.Wi);
			    	String password2 = CredentialUtil.getPassword();
			    	String username3 = CredentialUtil.getUsername(UserRole.Dysupdt);
			    	String password3 = CredentialUtil.getPassword();
			    	String username4 = CredentialUtil.getUsername(UserRole.Supdt);
			    	String password4 = CredentialUtil.getPassword();
			    	String username5 = CredentialUtil.getUsername(UserRole.Aac);
			    	String password5 = CredentialUtil.getPassword();
			    	
			    	login.loginAs(UserRole.Supdt);
			        basepage.zoomOut(75);
			        basepage.waitForLoaderToDisappear();
			        globalbuttons.clickcrossIcon();
			        
			        dashboard.openAssessment();
			        
			        dashboard.openInwardForm();
			        inwardClerk.openSacInward();
			        globalbuttons.clickSave();
			        basepage.acceptAlert();
			        dashboard.closePopup();
			        dashboard.Logout();
			        basepage.acceptAlert();
			        
			        login.loginAs(UserRole.Supdt);
			        basepage.zoomOut(75);
			        basepage.waitForLoaderToDisappear();
					globalbuttons.clickcrossIcon();
					
			    	wtdeletion.verifyFormTypeForWTDeletion();
			    	wtdeletion.verifyWTDeletion();
				 
				    }
			}


