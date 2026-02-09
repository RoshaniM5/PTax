package com.mpro.ptax.projectFlow;

import com.mpro.ptax.Utils.CredentialUtil;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pages.auth.Login;
import com.mpro.ptax.pages.dashboard.Dashboard;

public class LoginFlow {
	
	private Login login; 
	private Dashboard dashboard;
	private GlobalButtons globalbuttons;
	
	public LoginFlow() {
        
		this.login = new Login();
        this.dashboard = new Dashboard();
        this.globalbuttons = new GlobalButtons();
    }
	
	public void InwardClerk() {
		
		login.openUrl();
		login.login(
				
				CredentialUtil.getUsername(UserRole.Inwardclerk),
				CredentialUtil.getPassword());
	}

	public void Aac() {
		login.openUrl();
		login.login(CredentialUtil.getUsername(UserRole.Aac), CredentialUtil.getPassword());
	}
	
	public void WI() {
		login.openUrl();
		login.login(CredentialUtil.getUsername(UserRole.Wi), CredentialUtil.getPassword());
	}
	
	public void Dysupdt() {
		login.openUrl();
		login.login(CredentialUtil.getUsername(UserRole.Dysupdt), CredentialUtil.getPassword());
	}
	
	public void Supdt() {
		login.openUrl();
		login.login(CredentialUtil.getUsername(UserRole.Supdt), CredentialUtil.getPassword());
	}
	
}
