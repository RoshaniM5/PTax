package com.mpro.ptax.pageobject;

import org.openqa.selenium.By;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.model.WiData;

import io.qameta.allure.Step;

public class Wi extends BasePage{


	GlobalButtons globalbuttons = new GlobalButtons();

	private static final By title_Dropdown  		= By.xpath("//select[@id='ptashTitle']");
	private static final By owner_Name				= By.xpath("//input[@id= 'ptashAssesfname' and @ng-model='Property.ptashAssesfname']");
	private static final By prop_Description		= By.xpath("//input[@id='ptashPropdesc']");
	private static final By save_To_Drafts			= By.xpath("//button[@id='btnSaveToDraft']");
	private static final By street_Name				= By.xpath("//input[@id='ptashStreetnm']");
	private static final By Location				= By.xpath("//input[@id='ptashLocationnm']");
	private static final By pincode					= By.xpath("//input[@id='ptashPincode']");
	private static final By zone					= By.xpath("//select[@id='ptashZoneid']");
	private static final By sub_Zone				= By.xpath("//select[@id='ptashSubzoneid']");
	private static final By cs_cts_no				= By.xpath("//input[@id='ptashCtsno']");
//	private static final By billing_Type			= By.xpath("//select[@id='ptashBilltype']");
	private static final By new_Flatwise_details	= By.xpath("//button[@id= 'btnAddFlatDetail' and @class='btn btn-default  mar-top-0px ng-binding']");
	private static final By serial_No				= By.xpath("//input[@id='ptasdUnitsrno']");
	private static final By flat_No					= By.xpath("//input[@id='ptasdFunitno']");
	private static final By inspection_Date			= By.xpath("//input[@id='ptasdInspdate']");
	private static final By date_of_Effect			= By.xpath("//input[@id='ptasdDoeffect']");
//	private static final By structure_Type			= By.xpath("//select[@id='ptasdStructype']");
	private static final By user_category_SDRR		= By.xpath("//select[@id='ptasdUsrctgid']");
	private static final By user_sub_category		= By.xpath("//select[@id='ptasdSusubctgid']");
//	private static final By floor					= By.xpath("//select[@id='ptasdFloorid']");
//	private static final By nature_Type_Building	= By.xpath("//select[@id='ptasdNtbid']");
	private static final By fsi_Factor				= By.xpath("//select[@id='ptasdFsifact']");
	private static final By meter_Unmeter			= By.xpath("//select[@id='ptasdMetertype']");
	private static final By tax_Code			    = By.xpath("//select[@id='ptawdTaxcode']");
	private static final By total_Carpet_Area	    = By.xpath("//input[@id='ptasdTcptarea']");
	private static final By fsi_As_Per_Court	    = By.xpath("//select[@id='ptawdNewfsi']");
	private static final By submit_Button	    	= By.xpath("//button[@id= 'btnFlatDtlSubmit' and @ng-click='onClickFlatDtlSubmit()']");
	private static final By section_Dropdown	    = By.xpath("//select[@id='ptashSectid' and @ng-model='SACNo.ptashSectid']");
	private static final By sac_No				    = By.xpath("//input[@id='propertyNo']");
	private static final By get_Sac_No				= By.xpath("//button[@id='btnGetSACNo']");
	private static final By forward_To				= By.xpath("//select[@id='ptaadTuserid']");
	private static final By Done				    = By.xpath("//button[@id='btnDone']");
	private static final By logoutDropdown_Aac		= By.xpath("//a[normalize-space()='Sanjay Baban Surve']");
//	private static final By successMsg              = By.xpath("//div[contains(text(),'Successfully Updated Details')]");
	@Step("Owner Details Filled Successfully")
	public void fileWIfileDetails(WiData data) throws InterruptedException {
    	
    	selectFromDropdown(title_Dropdown, data.getTitle());
    	waitForDropdownToPopulate(title_Dropdown);
        Input(owner_Name, data.getOwnerName());
        Input(prop_Description, data.getPropertyDescription());
//      click(save_To_Drafts);
//      acceptAlert();
        scrollDown();
        Input(street_Name, data.getStreetName());
        Input(Location, data.getLocation());
        Input(pincode, data.getPincode());
        selectFromDropdown(zone, data.getZone());
        waitForDropdownToPopulate(zone);
        selectFromDropdown(sub_Zone, data.getSubZone());
        waitForDropdownToPopulate(sub_Zone);
        Input(cs_cts_no, data.getCsCtsNo());
        scrollDown();

    }
	@Step("Property Details is entered correctly")
    public void fileWIfileDetailsNew() throws InterruptedException {
    	
    	waitForLoaderToDisappear();
    	click1(new_Flatwise_details);
    	Input(serial_No, "1");
    	Input(flat_No, "1");
    	Input(inspection_Date, "11/06/2022");
    	Input(date_of_Effect, "11/04/2022");
        click(user_category_SDRR);
    	selectFromDropdown(user_category_SDRR, "LAND");
    	waitForDropdownToPopulate(user_category_SDRR);
        waitForDropdownToPopulate(user_sub_category);
    	selectFromDropdown(user_sub_category, "Land - residential LND 01");
    	click(fsi_Factor);
	    selectFromDropdown(fsi_Factor, "Admissible");
	    scrollDown();
	    click(meter_Unmeter);
    	selectFromDropdown(meter_Unmeter, "Unmetered");
    	click(tax_Code);
        waitForDropdownToPopulate(tax_Code);
    	selectFromDropdown(tax_Code, "All - Tax code 4001");
    	Input(total_Carpet_Area, "01");
    	click(fsi_As_Per_Court);
    	click(fsi_As_Per_Court);
    	selectFromDropdown(fsi_As_Per_Court, "1");
    	handleAlertIfPresent();
    	scrollToElementInsideModal(submit_Button);
    	handleAlertIfPresent();
    	click1(submit_Button);
    	acceptAlert();
    	scrollUp();
    	handleAlertIfPresent();
    	globalbuttons.clickSave();
        acceptAlert();
        click1(save_To_Drafts);
        acceptAlert();
        handleAlertIfPresent();
        globalbuttons.clickSave();
        acceptAlert();
        waitForDropdownToPopulate(section_Dropdown);
        selectFromDropdown(section_Dropdown,"01");
    	Input(sac_No, "2345");
    	click(get_Sac_No);
        waitForDropdownToPopulate(forward_To);
    	selectFromDropdown(forward_To, "Tulashiram Sitaram Pawade [dysupdt1.a]");
    	handleAlertIfPresent();
    	click(Done);
    	acceptAlert();
    	click(logoutDropdown_Aac);
    	globalbuttons.Logout();
    	
    }
    
    public String getSuccessMessage() {
        return getAlertTextAndAccept();
    }
}   
