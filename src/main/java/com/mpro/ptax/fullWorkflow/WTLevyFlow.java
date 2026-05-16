package com.mpro.ptax.fullWorkflow;

import com.mpro.ptax.Utils.CredentialUtil;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.model.WiData;
import com.mpro.ptax.pageobject.Assessment.Aac;
import com.mpro.ptax.pageobject.Assessment.Aac1;
import com.mpro.ptax.pageobject.Assessment.Dysupdt;
import com.mpro.ptax.pageobject.Assessment.Inwardclerk;
import com.mpro.ptax.pageobject.Assessment.Supdt;
import com.mpro.ptax.pageobject.Assessment.Wi;
import com.mpro.ptax.pageobject.Workflow.WTLevy;
import com.mpro.ptax.pages.auth.Login;
import com.mpro.ptax.pages.dashboard.Dashboard;

public class WTLevyFlow {

			private Login loginflow= new Login();
		    private BasePage basepage = new BasePage();
		    private GlobalButtons globalbuttons = new GlobalButtons();
		    private Inwardclerk inwardClerk = new Inwardclerk();
		    private Dashboard dashboard = new Dashboard();
		    private Aac aac = new Aac();
		    private Wi wi = new Wi();
		    private Dysupdt dysupdt = new Dysupdt();
		    private Supdt supdt = new Supdt();
		    private Aac1 aac1 = new Aac1();
		    private WTLevy wtlevy = new WTLevy();
		    public void executeWTLevyWorkflow(WiData data) throws Exception {
		    	
		    	
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
		    	
		    	loginflow.openUrl();
		    	loginflow.login(username1, password1);
		        basepage.zoomOut(75);
		        basepage.waitForLoaderToDisappear();
		        globalbuttons.clickcrossIcon();
		        
		        dashboard.openAssessment();
		        
		        dashboard.openInwardForm();
		        inwardClerk.openSacInward();
		        globalbuttons.clickSave();
		        System.out.println("Inward created Suceessfully");
		        basepage.acceptAlert();
		        dashboard.closePopup();
		        dashboard.Logout();
		        basepage.acceptAlert();
		        
		        loginflow.login(username2, password2);
		        basepage.zoomOut(75);
		        basepage.waitForLoaderToDisappear();
				globalbuttons.clickcrossIcon();
				basepage.selectLatestInward();
				wtlevy.verifyFormTypeForWTLevy();
				wtlevy.verifyWTLevy();
				
//			    basepage.scrollUp();
//		        wi.verifyWIFormTypeForReAssessment();
//				basepage.zoomOut(75);
//				basepage.selectLatestInward();
//			    wi.verifyReasonForReAssessment();
			    
			    loginflow.login(username3, password3);
		        basepage.zoomOut(75);
		        basepage.waitForLoaderToDisappear();
				globalbuttons.clickcrossIcon();
				basepage.selectLatestInward();
//			    basepage.scrollUp();
			    dysupdt.openDysupdt();
			    		
			    loginflow.login(username4, password4);
		        basepage.zoomOut(75);
		        basepage.waitForLoaderToDisappear();
				globalbuttons.clickcrossIcon();
				basepage.selectLatestInward();
//			    basepage.scrollUp();
				supdt.openSupdtReAssessment();
			    
			    loginflow.login(username5, password5);
		        basepage.zoomOut(75);
		        basepage.waitForLoaderToDisappear();
				globalbuttons.clickcrossIcon();
				basepage.selectLatestInward();
//			    basepage.scrollUp();
				aac1.openAac1();
			    
			 
			    }
		}




