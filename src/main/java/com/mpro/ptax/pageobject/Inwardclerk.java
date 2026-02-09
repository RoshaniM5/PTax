package com.mpro.ptax.pageobject;

import org.openqa.selenium.By;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;

public class Inwardclerk extends BasePage{
	
	
	GlobalButtons globalbuttons = new GlobalButtons();
	
	
	private static final By Inward_menu_Dropdown 	= By.id("inwardTypeId");
    private static final By Title_menu_Dropdown  	= By.id("ptindTitle");
	private static final By Applicant		     	= By.id("ptindFname");
	private static final By uploadDocInput			= By.id("uploadFile");
	
    public void openInward() {
		selectFromDropdown(Inward_menu_Dropdown, "Inward");
		selectFromDropdown(Title_menu_Dropdown, "Mr.");
		Input(Applicant, "Gupta");	
		uploadFile(uploadDocInput,"C:\\Users\\rmulunde\\Downloads\\144315_User-Master.pdf");
		
    }
}
