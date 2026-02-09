package com.mpro.ptax.pageobject;

import org.openqa.selenium.By;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;

public class Aac extends BasePage{


	GlobalButtons globalbuttons = new GlobalButtons();
	
    private static final By form_Type_Dropdown  	= By.xpath("//select[@id='formType']");
	private static final By status_Dropdown_aac		= By.xpath("//select[@id='action']");
	private static final By forwardTo__Dropdown_aac	= By.xpath("//select[@id='ptaadTuserid']");
	private static final By submit_aac			    = By.xpath("//button[@id='btnSubmit']");
	private static final By logoutDropdown_Aac		= By.xpath("//a[normalize-space()='Suraj Den Yadhav']");
	
    public void openAac() {

		selectFromDropdown(form_Type_Dropdown, "New Assessment");
		selectFromDropdown(status_Dropdown_aac, "Approve");
		selectFromDropdown(forwardTo__Dropdown_aac, "Sanjay Baban Surve [wi1.a]");
		click(submit_aac);
		click(logoutDropdown_Aac);
		
		
    }
}


