package com.mpro.ptax.components;

import org.openqa.selenium.By;
import com.mpro.ptax.base.BasePage;

public class GlobalButtons extends BasePage{
	
	private static final By view 			= By.xpath("//button[@id='btnView82']");
	private static final By save			= By.xpath("//button[@id='btn_orgsave']");
	private static final By closeButton		= By.xpath("//button[@id='btn_orgcan']");
	private static final By crossIcon 		= By.xpath("//span[@ng-click='modalKpilClose()']");
	private static final By uploadDocInput	= By.id("uploadFile");
	private static final By Logout			= By.xpath("//a[@ng-click='logout()']");
	
	 
	public void clickView() {
		click(view);
	}
	
	public void uploadDoc(String filepath) {
//		click(uploadDocInput);
		Input(uploadDocInput, filepath);
	}
	
	public void clickClose() {
		click(closeButton);
	}
	
	public void Logout() {
		click(Logout);
	}
	
	public void clickcrossIcon() throws InterruptedException {
		
		closePopupUsingESC();
		Thread.sleep(1000);
	    // If popup still visible, click on cross icon
	    if (isDisplayed(crossIcon)) {
	        click(crossIcon);
	    }
	}

	public void clickSave() {
		safeClick(save);
	}
	
}
