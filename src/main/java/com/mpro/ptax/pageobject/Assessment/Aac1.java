package com.mpro.ptax.pageobject.Assessment;

import org.openqa.selenium.By;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class Aac1 extends BasePage{
			
	GlobalButtons globalbuttons = new GlobalButtons();
		
	private static final By Done_dysupdt		= By.xpath("//button[@id='btnDone' and @ng-click='onClickDone()']");
	private static final By logoutDropdown_Aac  = By.xpath("//a[normalize-space()='Suraj Den Yadhav']");
	private static final By view_Temp_Bill		= By.xpath("//button[@id='btnViewTempBill']");                                                             
	
	@Step("Final Approval Successfully Done by AAC")
    public void openAac1() throws InterruptedException {
    	
		Allure.step("Wait for page to load", () -> {
		waitForLoaderToDisappear();
		});
		
		Allure.step("Save current record", () -> {
    	globalbuttons.clickSave();
    	acceptAlert();
		});
		
		Allure.step("View temporary bill", () -> {
    	click(view_Temp_Bill);
    	acceptAlert();
//    	waitForNumberOfWindows(2);
    	handleReportandReturn();
		});
		
		Allure.step("Select status as Approve", () -> {
    	globalbuttons.selectStatus("Approve");
		});
		
		Allure.step("Complete approval action", () -> {
    	click1(Done_dysupdt);
		waitForLoaderToDisappear();
		});
		
		Allure.step("Logout from application", () -> {
		acceptAlert();
		acceptAlert();
		click(logoutDropdown_Aac);
		globalbuttons.Logout();
		});
		
    }
}


