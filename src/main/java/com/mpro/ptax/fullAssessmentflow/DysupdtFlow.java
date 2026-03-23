package com.mpro.ptax.fullAssessmentflow;

import com.mpro.ptax.Utils.CredentialUtil;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Dysupdt;
import com.mpro.ptax.pages.auth.Login;

public class DysupdtFlow{
				
	    private Login loginflow= new Login();
	    private BasePage basepage = new BasePage();
	    private GlobalButtons globalbuttons = new GlobalButtons();	
		private Dysupdt dysupdt = new Dysupdt();
		
	    public void executeDysupdt() throws Exception {

	    	String username = CredentialUtil.getUsername(UserRole.Dysupdt);
	    	String password = CredentialUtil.getPassword();
	    	
	    	loginflow.openUrl();
	    	loginflow.login(username, password);
	        basepage.zoomOut(75);
	        basepage.waitForLoaderToDisappear();
	        globalbuttons.clickcrossIcon();
	        basepage.scrollDown();
	        basepage.selectLatestInward();
	        dysupdt.openDysupdt();       
			
	    }
	}

