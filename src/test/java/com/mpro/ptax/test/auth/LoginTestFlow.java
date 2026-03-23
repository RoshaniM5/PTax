package com.mpro.ptax.test.auth;

import com.mpro.ptax.Utils.CredentialUtil;
import com.mpro.ptax.enums.UserRole;
import com.mpro.ptax.pages.auth.Login;


public class LoginTestFlow {
	
	private Login login; 
	
	public LoginTestFlow() {
        
		this.login = new Login();
        
    }
	public void loginAs(UserRole role) {

	    login.openUrl();
	    login.login(
	        CredentialUtil.getUsername(role),
	        CredentialUtil.getPassword()
	    );
	}
	
//	public void InwardClerk() {
//		
//		login.openUrl();
//		login.login(CredentialUtil.getUsername(UserRole.Inwardclerk), CredentialUtil.getPassword());
//	}
//
//	public void Aac() {
//		login.openUrl();
//		login.login(CredentialUtil.getUsername(UserRole.Aac), CredentialUtil.getPassword());
//	}
//	
//	public void WI() {
//		login.openUrl();
//		login.login(CredentialUtil.getUsername(UserRole.Wi), CredentialUtil.getPassword());
//	}
//	
//	public void Dysupdt() {
//		login.openUrl();
//		login.login(CredentialUtil.getUsername(UserRole.Dysupdt), CredentialUtil.getPassword());
//	}
//	
//	public void Supdt() {
//		login.openUrl();
//		login.login(CredentialUtil.getUsername(UserRole.Supdt), CredentialUtil.getPassword());
//	}
	
}
