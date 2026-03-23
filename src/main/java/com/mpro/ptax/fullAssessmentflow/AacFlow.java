package com.mpro.ptax.fullAssessmentflow;

import com.mpro.ptax.Utils.CredentialUtil;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pageobject.Aac;
import com.mpro.ptax.pages.auth.Login;


public class AacFlow {

	private Login loginflow= new Login();
	private BasePage basepage = new BasePage();
	private GlobalButtons globalbuttons = new GlobalButtons();	
	private Aac aac = new Aac();
			
	public void executeaac() throws Exception {

		String username = CredentialUtil.getUsername(UserRole.Aac);
		String password = CredentialUtil.getPassword();
		    	
		loginflow.openUrl();
		loginflow.login(username, password);
		basepage.zoomOut(75);
		basepage.waitForLoaderToDisappear();
		globalbuttons.clickcrossIcon();
		basepage.scrollDown();
		basepage.selectLatestInward();
		aac.openAac();
		        
	}
}




