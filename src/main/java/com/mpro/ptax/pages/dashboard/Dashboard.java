package com.mpro.ptax.pages.dashboard;

import org.openqa.selenium.By;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;

public class Dashboard extends BasePage{
	
	
	GlobalButtons globalbuttons = new GlobalButtons();
	
	private By assessmentMenu 			= By.xpath("//span[text()='Assessment']/ancestor::a"); 
	private By Inward 					= By.xpath("//a[contains(@ui-sref,'manualInward')]");
	private By logoutDropdown_Inward 	= By.xpath("//a[contains(normalize-space(.),'Sanjay Suresh Mirajkar')]");
	private By close_popup				= By.xpath("//button[@id='btnCancels']");
	
//	private By dashboardText			= By.xpath("//h1[contains(text(), 'Dashboard')]");
	
	
	public void openAssessment() {
		
		click(assessmentMenu);	
	}
	
	public void openInward() throws InterruptedException {
		
		clickWhenVisible(Inward);
	}
	
	public void closePopup() {
		
		click(close_popup);
	}
	
	public void Logout() {
		
		click(logoutDropdown_Inward);
		globalbuttons.Logout();
	
	}
	
}

