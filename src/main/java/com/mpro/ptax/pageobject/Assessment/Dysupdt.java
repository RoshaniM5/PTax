package com.mpro.ptax.pageobject.Assessment;

import org.openqa.selenium.By;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class Dysupdt extends BasePage{

		GlobalButtons globalbuttons = new GlobalButtons();
		
		
		private static final By forwardTo__Dropdown_dysupdt	= By.xpath("//select[@id='ptaadTuserid' and @name='ptaadTuserid']");
		private static final By Done_dysupdt			    = By.xpath("//button[@id='btnDone' and @ng-click='onClickDone()']");
		private static final By logoutDropdown_dysupdt		= By.xpath("//a[normalize-space()='Tulashiram Sitaram Pawade']");
		
		@Step("DYSUPDT Approval and Forward Flow")
	    public void openDysupdt() {
	    	
			
			handleAlertIfPresent();
			Allure.step("Save current record", () -> {
	    	globalbuttons.clickSave();
	    	acceptAlert();
			});
			Allure.step("Select status as Forward", () -> {
	    	globalbuttons.selectStatus("Forward");
			});
			
			Allure.step("Select forward user", () -> {
	    	waitForDropdownToPopulate(forwardTo__Dropdown_dysupdt);
			selectFromDropdown(forwardTo__Dropdown_dysupdt, "Ujwal Tukaram Hatankar [supdt1.a]");
			});
			
			Allure.step("Complete forward action", () -> {
			click(Done_dysupdt);
			waitForLoaderToDisappear();
			});
			
			Allure.step("Logout from application", () -> {
			acceptAlert();
			acceptAlert();
			click(logoutDropdown_dysupdt);
			globalbuttons.Logout();
			});
			
	    }
	}




