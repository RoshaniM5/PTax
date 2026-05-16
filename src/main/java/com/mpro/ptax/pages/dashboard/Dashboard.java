package com.mpro.ptax.pages.dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;

public class Dashboard extends BasePage{
	
	
	GlobalButtons globalbuttons = new GlobalButtons();
	
	private By assessmentMenu 			= By.xpath("//span[text()='Assessment']/ancestor::a"); 
	private By Inward 					= By.xpath("//a[normalize-space()='Inward']");
	private By logoutDropdown_Inward 	= By.xpath("//a[contains(normalize-space(.),'Sanjay Suresh Mirajkar')]");
	private By close_popup				= By.xpath("//button[@id='btnCancels']");
	
//	private By dashboardText			= By.xpath("//h1[contains(text(), 'Dashboard')]");
	
	
	public void openAssessment() {
		waitForModalToDisappear();
		clickWhenVisible(assessmentMenu);	
	}
	
	public void openInwardForm() throws InterruptedException {
		waitForModalToDisappear();
		clickWhenVisible(Inward);
	}
	
	public void closePopup() {
	
		 try {

		        WebDriverWait wait =
		                new WebDriverWait(getDriver(), Duration.ofSeconds(5));

		        WebElement popup =
		                wait.until(ExpectedConditions.presenceOfElementLocated(close_popup));

		        if (popup.isDisplayed()) {
		            popup.click();
		        }

		    } catch (TimeoutException e) {

		        System.out.println("Popup not present");
		    }
	}
	
	public void Logout() {
		
		click(logoutDropdown_Inward);
		globalbuttons.Logout();
	
	}
	
}

