package com.mpro.ptax.test.pages;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Dysupdt;
import com.mpro.ptax.test.auth.LoginTestFlow;
import com.mpro.ptax.test.base.BaseTest;

public class dysupdtTest extends BaseTest{

	private LoginTestFlow login;
	private GlobalButtons globalbuttons;
	private BasePage basepage;
	private Dysupdt dysupdt; 
	
	@BeforeMethod
	public void initFlow() {
		login 			= new LoginTestFlow();
		globalbuttons 	= new GlobalButtons();
		basepage 		= new BasePage();
		dysupdt			= new Dysupdt();
	}
	
	@Test(groups="Sanity-Dysupdt", priority=4)
	public void VerifyWiFlow() throws IOException, InterruptedException {
		
		log.info("Testing WI Flow Test");
		login.loginAs(UserRole.Dysupdt);
		
		log.info("ZoomedIn");
		basepage.zoomOut(75);
		    
		basepage.waitForLoaderToDisappear();
		 
		log.info("Clicking cross icon on global buttons");
		globalbuttons.clickcrossIcon();
		 
		log.info("Inward Selected Successfully");
		basepage.selectLatestInward();
		
//		log.info("ScrollDown is working correctly");
//	    basepage.scrollUp();
	    
	    log.info("Data Entered Successfully in dysupdt");
	    dysupdt.openDysupdt();
	   
		
	    
	}
	
}
