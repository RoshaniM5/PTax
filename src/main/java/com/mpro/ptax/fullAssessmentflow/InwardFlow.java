package com.mpro.ptax.fullAssessmentflow;

import com.mpro.ptax.Utils.CredentialUtil;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Inwardclerk;
import com.mpro.ptax.pages.auth.Login;
import com.mpro.ptax.pages.dashboard.Dashboard;

public class InwardFlow{

	    private Login loginflow= new Login();
	    private BasePage basepage = new BasePage();
	    private GlobalButtons globalbuttons = new GlobalButtons();
	    private Inwardclerk inwardClerk = new Inwardclerk();
	    private Dashboard dashboard = new Dashboard();
	    
	    public void executeInward() throws Exception {

	    	String username = CredentialUtil.getUsername(UserRole.Inwardclerk);
	    	String password = CredentialUtil.getPassword();
	    	
	    	loginflow.openUrl();
	    	loginflow.login(username, password);
	        basepage.zoomOut(75);
	        basepage.waitForLoaderToDisappear();
	        globalbuttons.clickcrossIcon();
	        
	        dashboard.openAssessment();
	        dashboard.openInward();
	        inwardClerk.openInward();
	        globalbuttons.clickSave();
	        basepage.acceptAlert();
	        dashboard.closePopup();
	        dashboard.Logout();
	    }
	}

