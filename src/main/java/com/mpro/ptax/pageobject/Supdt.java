package com.mpro.ptax.pageobject;

import org.openqa.selenium.By;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;

import io.qameta.allure.Step;

public class Supdt extends BasePage{

	GlobalButtons globalbuttons = new GlobalButtons();
	
	private static final By forwardTo__Dropdown_supdt	= By.xpath("//select[@id='ptaadTuserid' and @name='ptaadTuserid']");
	private static final By Done_supdt			    = By.xpath("//button[@id='btnDone' and @ng-click='onClickDone()']");
	private static final By logoutDropdown_supdt		= By.xpath("//a[normalize-space()='Ujwal Tukaram Hatankar']");
	@Step("Supdt Approved Details")
    public void openSupdt() {
    	
    
    	globalbuttons.clickSave();
    	acceptAlert();
    	globalbuttons.selectStatus("Forward");
		selectFromDropdown(forwardTo__Dropdown_supdt, "Suraj Den Yadhav [aac.a]");
		click(Done_supdt);
		waitForLoaderToDisappear();
		acceptAlert();
		click(logoutDropdown_supdt);
		globalbuttons.Logout();
		
    }
}
