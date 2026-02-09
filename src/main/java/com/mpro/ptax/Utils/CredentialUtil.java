package com.mpro.ptax.Utils;

import com.mpro.ptax.enums.UserRole;

public class CredentialUtil {

	public static String getUsername(UserRole role) {
		
		switch(role) {
		
		case Inwardclerk:
			return ReadConfig.get("Inwardclerk.username");
				
		case Wi:
			String activeWi = ReadConfig.get("W.active");
			return ReadConfig.get(activeWi + ".username");
			 
		case Dysupdt:
			return ReadConfig.get("Dysupdt.username");
			
		case Supdt:
			return ReadConfig.get("Supdt.username");
			
		case Aac:
			return ReadConfig.get("aac.username");
			
		default:
			return ReadConfig.get(role.name().toLowerCase()+ ".username");
		}
		
	}
	
	public static String getPassword() {
		return ReadConfig.get("common_password");
	
	}
}
