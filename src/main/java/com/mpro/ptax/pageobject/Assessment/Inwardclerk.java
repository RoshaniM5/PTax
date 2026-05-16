package com.mpro.ptax.pageobject.Assessment;

import org.openqa.selenium.By;

import com.mpro.ptax.Utils.TestDataStore;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;


public class Inwardclerk extends BasePage{
	
	public String sac_No;
	
	GlobalButtons globalbuttons = new GlobalButtons();
	
	private static final By Inward_Type_menu_Dropdown 	= By.xpath("//select[@id='inwardTypeId' and @ng-model='page']");
    private static final By Title_menu_Dropdown  		= By.id("ptindTitle");
	private static final By Applicant		     		= By.id("ptindFname");
	private static final By uploadDocInput				= By.id("uploadFile");
	private static final By SacInward_with_MSR			= By.xpath("//input[@ng-model='mInward.ptindSacno']");
	
	
	@Step("Fill Inward Form")
    public void openInward() {
    
    	waitForLoaderToDisappear();
    	
    	Allure.step("Select Inward Type: Inward", () -> {
		selectFromDropdown(Inward_Type_menu_Dropdown, "Inward");
    	});
    	
    	Allure.step("Select Title: ", () -> {
		selectFromDropdown(Title_menu_Dropdown, "Mr.");
    	});
    	
    	Allure.step("Enter Applicant Name: ", () -> {
		Input(Applicant, "Gupta");	
    	});
    	
    	Allure.step("Upload Document", () -> {
		uploadFile(uploadDocInput,"C:\\Users\\rmulunde\\Downloads\\144315_User-Master.pdf");
    	});
    }
	
	
	@Step("Fill Sac_Inward Form")
	public void openSacInward() throws InterruptedException {
	    
		Allure.step("Wait for page to load", () -> {
    	waitForLoaderToDisappear();
		});
		
		Allure.step("Select Inward Type", () -> {
		selectFromDropdown(Inward_Type_menu_Dropdown, "Sac Inward");
		});
		
		waitForLoaderToDisappear();
		       
		String sac = TestDataStore.getSacNo();

		if (sac == null || sac.isEmpty()) {
			throw new RuntimeException("SAC No not available");
		}

		// Combine SAC + MSR
		String sacWithMsr = sac + "0000";
		System.out.println("Final SAC+MSR: " + sacWithMsr);
		
		Allure.step("Enter SAC with MSR", () -> {
		Input(SacInward_with_MSR, sacWithMsr);
		});
		
		waitForDropdownToPopulate(Title_menu_Dropdown);
		
		Allure.step("Select Title", () -> {
		selectFromDropdown(Title_menu_Dropdown,"Mr.");
		});
		
		Allure.step("Enter Applicant Name", () -> {
		Input(Applicant, "Gupta");	
		});
		
		Allure.step("Upload Document", () -> {
		uploadFile(uploadDocInput, "C:\\Users\\rmulunde\\Downloads\\144315_User-Master.pdf");
		});
		System.out.println("All details filled for Inward");
    }
	
}



		
	

