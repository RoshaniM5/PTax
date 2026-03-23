package com.mpro.ptax.fullAssessmentflow;

import com.mpro.ptax.Utils.CredentialUtil;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.model.WiData;
import com.mpro.ptax.pageobject.Wi;
import com.mpro.ptax.pages.auth.Login;


public class wiFlow {

	private Login loginflow= new Login();
	private GlobalButtons globalbuttons = new GlobalButtons();
	private BasePage basepage = new BasePage();
	private Wi wi = new Wi();
		
	    public void executeWi(WiData data) throws Exception {

	    	String username = CredentialUtil.getUsername(UserRole.Wi);
	    	String password = CredentialUtil.getPassword();
	    	
	    	loginflow.openUrl();
	    	loginflow.login(username, password);
	        basepage.zoomOut(75);
	        globalbuttons.clickcrossIcon();
	        basepage.selectLatestInward();
	        basepage.scrollUp();
	        wi.fileWIfileDetails(data);
	        wi.fileWIfileDetailsNew();
	        
	    }
	}


