package com.mpro.ptax.fullAssessmentflow;

import com.mpro.ptax.Utils.CredentialUtil;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Supdt;
import com.mpro.ptax.pages.auth.Login;

public class SupdtFlow{
				
	    private Login loginflow= new Login();
	    private BasePage basepage = new BasePage();
	    private GlobalButtons globalbuttons = new GlobalButtons();	
		private Supdt supdt = new Supdt();
		
	    public void executeSupdt() throws Exception {

	    	String username = CredentialUtil.getUsername(UserRole.Supdt);
	    	String password = CredentialUtil.getPassword();
	    	
	    	loginflow.openUrl();
	    	loginflow.login(username, password);
	        basepage.zoomOut(75);
	        basepage.waitForLoaderToDisappear();
	        globalbuttons.clickcrossIcon();
	        basepage.scrollDown();
	        basepage.selectLatestInward();
	        supdt.openSupdt();       
			
	    }
	}

