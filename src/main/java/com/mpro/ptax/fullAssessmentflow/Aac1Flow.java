package com.mpro.ptax.fullAssessmentflow;

import com.mpro.ptax.Utils.CredentialUtil;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Aac1;
import com.mpro.ptax.pages.auth.Login;

public class Aac1Flow{
	
	 private Login loginflow= new Login();
	 private BasePage basepage = new BasePage();
	 private GlobalButtons globalbuttons = new GlobalButtons();	
	 private Aac1 aac1 = new Aac1();
	 
	public void executeAac1() throws InterruptedException {
	

    	String username = CredentialUtil.getUsername(UserRole.Aac);
    	String password = CredentialUtil.getPassword();
    	
    	loginflow.openUrl();
    	loginflow.login(username, password);
        basepage.zoomOut(75);
        basepage.waitForLoaderToDisappear();
        globalbuttons.clickcrossIcon();
        basepage.scrollDown();
        basepage.selectLatestInward();
        aac1.openAac1();
	}  

}
