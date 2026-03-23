package com.mpro.ptax.pageobject;

import org.openqa.selenium.By;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;

import io.qameta.allure.Step;

public class Dysupdt extends BasePage{

		GlobalButtons globalbuttons = new GlobalButtons();
		
		
		private static final By forwardTo__Dropdown_dysupdt	= By.xpath("//select[@id='ptaadTuserid' and @name='ptaadTuserid']");
		private static final By Done_dysupdt			    = By.xpath("//button[@id='btnDone' and @ng-click='onClickDone()']");
		private static final By logoutDropdown_dysupdt		= By.xpath("//a[normalize-space()='Tulashiram Sitaram Pawade']");
		@Step("Dysupdt Approved Details")
	    public void openDysupdt() {
	    	
	    	
	    	globalbuttons.clickSave();
	    	acceptAlert();
	    	globalbuttons.selectStatus("Forward");
			selectFromDropdown(forwardTo__Dropdown_dysupdt, "Ujwal Tukaram Hatankar [supdt1.a]");
			click(Done_dysupdt);
			waitForLoaderToDisappear();
			acceptAlert();
			click(logoutDropdown_dysupdt);
			globalbuttons.Logout();
			
	    }
	}




