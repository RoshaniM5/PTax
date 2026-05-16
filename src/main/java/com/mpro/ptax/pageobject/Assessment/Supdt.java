package com.mpro.ptax.pageobject.Assessment;

import org.openqa.selenium.By;
import com.mpro.ptax.Utils.TestDataStore;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class Supdt extends BasePage{

	GlobalButtons globalbuttons = new GlobalButtons();
	
	private static final By forwardTo__Dropdown_supdt	= By.xpath("//select[@id='ptaadTuserid' and @name='ptaadTuserid']");
	private static final By Done_supdt			    	= By.xpath("//button[@id='btnDone' and @ng-click='onClickDone()']");
	private static final By logoutDropdown_supdt		= By.xpath("//a[normalize-space()='Ujwal Tukaram Hatankar']");
	private static final By sacNo_Label					= By.xpath("(//h3[contains(text(), 'AX')])[1]");
	
	
	@Step("SUPDT Approval and Forward Flow")
    public void openSupdt() {
		
		Allure.step("Save current record", () -> {
    	globalbuttons.clickSave();
    	acceptAlert();
		});
		
    	String sac_No= getText(sacNo_Label).trim();
    	Allure.step("Capture SAC number from UI", () -> {
    	if (sac_No.isEmpty()) {
    	    throw new RuntimeException("SAC No not captured");
    	    
    	}
    	System.out.println("Sac No: " + sac_No);
		TestDataStore.setSacNo(sac_No);
    	});
		
    	Allure.step("Select status as Forward", () -> {
    	globalbuttons.selectStatus("Forward");
    	});
    	
    	Allure.step("Select forward user", () -> {
    	click(forwardTo__Dropdown_supdt);
		selectFromDropdown(forwardTo__Dropdown_supdt, "Suraj Den Yadhav [aac.a]");
    	});
    	
    	Allure.step("Complete forward action", () -> {
		click(Done_supdt);
		waitForLoaderToDisappear();
    	});
    	
    	Allure.step("Handle confirmation alerts", () -> {
		acceptAlert();
		acceptAlert();
    	});
    	
    	Allure.step("Logout from application", () -> {
		click(logoutDropdown_supdt);
		globalbuttons.Logout();
    	});
		
    }
	
	@Step("supdt Approval for Re-assessment")
	public void openSupdtReAssessment() {
		
		Allure.step("Save current record", () -> {
		globalbuttons.clickSave();
		acceptAlert();
		});
		
		Allure.step("Select status as Forward", () -> {
		globalbuttons.selectStatus("Forward");
		});
		
		Allure.step("Select forward user", () -> {
		selectFromDropdown(forwardTo__Dropdown_supdt, "Suraj Den Yadhav [aac.a]");
		});
		
		Allure.step("Complete forward action", () -> {
		click(Done_supdt);
		});
		
		Allure.step("Logout from application", () -> {
		waitForLoaderToDisappear();
		acceptAlert();
		acceptAlert();
		click(logoutDropdown_supdt);
		globalbuttons.Logout();
		});
		
		
	}
}
