//package com.mpro.ptax.pageobject;
//
//import java.util.Map;
//
//import org.openqa.selenium.By;
//
//import com.mpro.ptax.base.BasePage;
//import com.mpro.ptax.components.GlobalButtons;
//
//public class Wi extends BasePage{
//
//
//	GlobalButtons globalbuttons = new GlobalButtons();
//
//	private static final By title_Dropdown  		= By.xpath("//select[@id='ptashTitle']");
//	private static final By owner_Name				= By.xpath("//input[@id='ptashAssesfname']");
//	private static final By prop_Description		= By.xpath("//input[@id='ptashPropdesc']");
//	private static final By save_To_Drafts			= By.xpath("//button[@id='btnSaveToDraft']");
//	private static final By street_Name				= By.xpath("//input[@id='ptashStreetnm']");
//	private static final By Location				= By.xpath("//input[@id='ptashLocationnm']");
//	private static final By pincode					= By.xpath("//input[@id='ptashPincode']");
//	private static final By zone					= By.xpath("//select[@id='ptashZoneid']");
//	private static final By sub_Zone				= By.xpath("//select[@id='ptashSubzoneid']");
//	private static final By cs_cts_no				= By.xpath("//input[@id='ptashCtsno']");
//	private static final By billing_Type			= By.xpath("//select[@id='ptashBilltype']");
//	private static final By logoutDropdown_Aac		= By.xpath("//a[normalize-space()='Suraj Den Yadhav']");
//	
//    public void fileWIfileDetails(Map<String, String> data) {
//    	
//		selectFromDropdown(title_Dropdown, data.get("Title"));
//		Input(owner_Name, data.get("Owner/Org Name"));
//		Input(prop_Description, data.get("Property Description"));
//		click(save_To_Drafts);
//		Input(street_Name, data.get("Street Name"));
//		Input(Location, data.get("Location"));
//		Input(pincode, data.get("Pincode"));
//		selectFromDropdown(zone, data.get("Zone"));
//		selectFromDropdown(sub_Zone, data.get("Sub Zone"));
//		Input(cs_cts_no, data.get("CS/CTS No."));
//		selectFromDropdown(billing_Type, data.get("Billing Type"));
//		
//    }
//}
