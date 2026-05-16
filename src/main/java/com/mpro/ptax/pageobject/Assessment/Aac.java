package com.mpro.ptax.pageobject.Assessment;

import org.openqa.selenium.By;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class Aac extends BasePage{


	GlobalButtons globalbuttons = new GlobalButtons();
	
    private static final By form_Type_Dropdown  				= By.xpath("//select[@id='formType']");
	private static final By status_Dropdown_aac					= By.xpath("//select[@id='action']");
	private static final By forwardTo__Dropdown_aac				= By.xpath("//select[@id='ptaadTuserid' and @ng-model='mInward.ptaadTuserid']");
	private static final By submit_aac			    			= By.xpath("//button[@id='btnSubmit']");
	private static final By logoutDropdown_Aac					= By.xpath("//a[normalize-space()='Suraj Den Yadhav']");
	
			
	@Step("Aac Approved details")
    public void openAac() throws InterruptedException {
    	
		waitForDropdownToPopulate(form_Type_Dropdown);
		Allure.step("Select Form Type", () -> {
		selectFromDropdown(form_Type_Dropdown,"New Assessment");
		});
		
		waitForDropdownToPopulate(form_Type_Dropdown);
		
		Allure.step("Select Status", () -> {
		selectFromDropdown(status_Dropdown_aac, "Approve");
		});
		
		Allure.step("Select Forward To user", () -> {
		selectFromDropdown(forwardTo__Dropdown_aac, "Sanjay Baban Surve [wi1.a]");
		});
		
		Allure.step("Click Submit button", () -> {
		click(submit_aac);
		});
		
		waitForOverlaysToDisappear();
		waitForLoaderToDisappear();
		
		Allure.step("Open logout dropdown", () -> {
		click(logoutDropdown_Aac);
		});
		
		Allure.step("Logout from application", () -> {
		globalbuttons.Logout();
		});
		
	}		
	
  }



