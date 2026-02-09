package com.mpro.ptax.test.dataprovider;

import org.testng.annotations.DataProvider;

import com.mpro.ptax.Utils.PropertyUtils;

public class LoginDataProvider {

	@DataProvider(name= "invalidLoginData")
	public static Object[][] invalidLoginData(){
		
		return new Object[][] {
			
		{
			PropertyUtils.get("invalid_username"),
			PropertyUtils.get("common_password"), 
			PropertyUtils.get("login_Error_Message"),
		},
				
		{
			PropertyUtils.get("invalid_username"),
            PropertyUtils.get("invalid_password"), 
            PropertyUtils.get("login_Error_Message")
		},
		
		{
			PropertyUtils.get("Inwardclerk.username"),
            PropertyUtils.get("invalid_password"),
            PropertyUtils.get("login_Error_Message")
		}
	};
		
}
}

