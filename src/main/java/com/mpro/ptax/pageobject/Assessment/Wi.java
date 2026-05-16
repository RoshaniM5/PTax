package com.mpro.ptax.pageobject.Assessment;

import org.openqa.selenium.By;
import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import com.mpro.ptax.model.WiData;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class Wi extends BasePage{


	GlobalButtons globalbuttons = new GlobalButtons();

	private static final By title_Dropdown  		= By.xpath("//select[@id='ptashTitle']");
	private static final By owner_Name				= By.xpath("//input[@id='ptashAssesfname' and @ng-model='Property.ptashAssesfname']");
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
	private static final By water_connection_NO	    = By.xpath("//input[@id='ptasdWccnno']");
	private static final By tax_Code			    = By.xpath("//select[@id='ptawdTaxcode']");
	private static final By total_Carpet_Area	    = By.xpath("//input[@id='ptasdTcptarea']");
	private static final By fsi_As_Per_Court	    = By.xpath("//select[@id='ptawdNewfsi']");
	private static final By submit_Button	    	= By.xpath("//button[@id= 'btnFlatDtlSubmit' and @ng-click='onClickFlatDtlSubmit()']");
	private static final By section_Dropdown	    = By.xpath("//select[@id='ptashSectid' and @ng-model='SACNo.ptashSectid']");
	private static final By sac_No				    = By.xpath("//input[@id='propertyNo']");
	private static final By get_Sac_No				= By.xpath("//button[@id='btnGetSACNo']");
	private static final By forward_To				= By.xpath("//select[@id='ptaadTuserid']");
	private static final By Done				    = By.xpath("//button[@id='btnDone']");
	private static final By logoutDropdown_WI		= By.xpath("//a[normalize-space()='Sanjay Baban Surve']");
//	private static final By successMsg              = By.xpath("//div[contains(text(),'Successfully Updated Details')]");
	private static final By submit_WI			    = By.xpath("(//button[@id='btnSubmit'])[2]");
	private static final By form_Type_Dropdown_ReAssessment = By.xpath("//select[@id='formType']");
	private static final By edit_Button				= By.xpath("//table//tr//button[@id='rowmodify1']");
	private static final By reasonOfReAssessment	= By.xpath("//select[@id='ptasdReasonid']");
	private static final By save_Button				= By.xpath("//button[@id='btn_orgsave']");
//	private static final By scroll_D				= By.xpath("(//section[@class='modal ng-scope'])[1]");
	private static final By submit_flatdetails		= By.xpath("//button[@id='btnFlatDtlSubmit']");
	
	
	@Step("Owner Details Filled Successfully")      
	public void fileWIfileDetails(WiData data) throws InterruptedException {
    	
		waitForLoaderToDisappear();
		Allure.step("Select Title", () -> {
			waitForDropdownToPopulate(title_Dropdown);
    	selectFromDropdown(title_Dropdown, data.getTitle());
		});
		
    	waitForDropdownToPopulate(title_Dropdown);
    	
    	Allure.step("Enter Owner Name", () -> {
        Input(owner_Name, data.getOwnerName());
    	});
    	
    	Allure.step("Enter Property Description", () -> {
        Input(prop_Description, data.getPropertyDescription());
    	});
    	
//      click(save_To_Drafts);
//      acceptAlert();
        scrollDown();
        
        Allure.step("Enter Street Name", () -> {
        Input(street_Name, data.getStreetName());
        });
        
        Allure.step("Enter Location", () -> {
        Input(Location, data.getLocation());
        });
        
        Allure.step("Enter Pincode", () -> {
        Input(pincode, data.getPincode());
        });
        
        Allure.step("Select Zone", () -> {
        selectFromDropdown(zone, data.getZone());
        });

        waitForLoaderToDisappear();
        waitForDropdownToPopulate(zone);
        
        waitForDropdownToPopulate(sub_Zone);
        Allure.step("Select Sub Zone", () -> {
        selectFromDropdown(sub_Zone, data.getSubZone());
        });
        
        waitForDropdownToPopulate(sub_Zone);
        
        Allure.step("Select cs_cts_no", () -> {
        Input(cs_cts_no, data.getCsCtsNo());
        }); 
        scrollDown();

    }
	
	@Step("Fill Flat-wise WI Details and Submit Flow")
    public void fileWIfileDetailsNew() throws InterruptedException {
    	
    	waitForLoaderToDisappear();
    	Allure.step("Open Flat-wise details section", () -> {
    	click1(new_Flatwise_details);
    	});
    	
    	Allure.step("Enter basic flat details", () -> {
    	Input(serial_No, "1");
    	Input(flat_No, "1");
    	Input(inspection_Date, "07/05/2022");
    	Input(date_of_Effect, "07/04/2022");
    	});
    	
    	Allure.step("Select user category and sub-category", () -> {
        click(user_category_SDRR);
        waitForDropdownToPopulate(user_category_SDRR);
    	selectFromDropdown(user_category_SDRR, "LAND");
    	waitForDropdownToPopulate(user_category_SDRR);
        waitForDropdownToPopulate(user_sub_category);
        selectFromDropdown(user_sub_category, "Land - residential LND 01");
    	});
    	
    	Allure.step("Select FSI factor", () -> {
    	click(fsi_Factor);
    	selectFromDropdown(fsi_Factor, "Admissible");
    	});
    	
    	Allure.step("Scroll to meter section", () -> {
	    scrollDown();
    	});
    	
    	Allure.step("Select meter type", () -> {
	    click(meter_Unmeter);
	    selectFromDropdown(meter_Unmeter, "Unmetered");
    	});
    	
    	Allure.step("Select tax code", () -> {
    	click(tax_Code);
        waitForDropdownToPopulate(tax_Code);
    	selectFromDropdown(tax_Code, "All - Tax code 4001");
    	 });
    	 
    	Allure.step("Enter carpet area", () -> { 
    	Input(total_Carpet_Area, "01");
    	});
    	
    	Allure.step("Select FSI as per court", () -> {
    	click(fsi_As_Per_Court);
    	click(fsi_As_Per_Court);
    	selectFromDropdown(fsi_As_Per_Court, "1");
    	handleAlertIfPresent();
    	});
    	
    	Allure.step("Submit flat details", () -> {
    	scrollToElementInsideModal(submit_Button);
    	handleAlertIfPresent();
    	click1(submit_Button);
    	acceptAlert();
    	});
    	
    	Allure.step("Save and draft actions", () -> {
    	scrollUp();
    	handleAlertIfPresent();
    	globalbuttons.clickSave();
        acceptAlert();
        click1(save_To_Drafts);
        acceptAlert();
        handleAlertIfPresent();
        globalbuttons.clickSave();
        acceptAlert();
    	});
    	
    	Allure.step("Fill section and SAC details", () -> {
        waitForDropdownToPopulate(section_Dropdown);
        selectFromDropdown(section_Dropdown,"01");
    	Input(sac_No, "2345");
    	click(get_Sac_No);
    	});
    	
    	Allure.step("Select forward user", () -> {
        waitForDropdownToPopulate(forward_To);
    	selectFromDropdown(forward_To, "Tulashiram Sitaram Pawade [dysupdt1.a]");
    	});
    	
    	Allure.step("Complete submission", () -> {
    	handleAlertIfPresent();
    	clickTo(Done);
    	acceptAlert();
    	});
    	
    	Allure.step("Logout from application", () -> {
    	click(logoutDropdown_WI);
    	globalbuttons.Logout();
    	});
    }
	
    public String getSuccessMessage() {
        return getAlertTextAndAccept();
    }
    
    @Step("Set record status to Re-Assessment")
	public void verifyWIFormTypeForReAssessment() {
		
		waitForDropdownToPopulate(form_Type_Dropdown_ReAssessment);
		Allure.step("Select Re-Assessment as form type", () -> {
		selectFromDropdown(form_Type_Dropdown_ReAssessment,"Re-Assessment");
		});
		Allure.step("Submit WI form type", () -> {
		click(submit_WI);
		});
	}
    
    @Step("Add Reason for Re-Assessment and complete flow")
	public void verifyReasonForReAssessment() throws InterruptedException {
		
    	Allure.step("Select latest inward record", () -> {
    	selectLatestInward();
    	});
    	Allure.step("Scroll to top", () -> {
    	scrollUp();
    	});
    	Allure.step("Open edit form", () -> {
    	clickWhenVisible(edit_Button);
    	});
    	Allure.step("Select reason for re-assessment", () -> {
		selectFromDropdown(reasonOfReAssessment,"Rectification");
    	});
    	
		waitForPageStable();
		Allure.step("Submit flat details", () -> {
		clickWithScrollAndRetry(submit_flatdetails);
		});
		
		Allure.step("Save and draft actions", () -> {
		click(save_Button);
	
		acceptAlert();
		click1(save_To_Drafts);
		acceptAlert();
		click(save_Button);
		acceptAlert();
		});
		
		Allure.step("Select forward user", () -> {
		waitForDropdownToPopulate(forward_To);
	    selectFromDropdown(forward_To, "Tulashiram Sitaram Pawade [dysupdt1.a]");
		});
		
		Allure.step("Complete submission", () -> {
	    handleAlertIfPresent();
    	clickTo(Done);
    	acceptAlert();
    	acceptAlert();
		});
		
		Allure.step("Logout from application", () -> {
    	safeClick(logoutDropdown_WI);
    	globalbuttons.Logout();
	});
  }
    
    @Step("verify TestCase for Connection-Metered Type with User category-LAND")
    public void verifyMeterConnectionDetails() throws InterruptedException {
    	
    	waitForLoaderToDisappear();
    	Allure.step("Open Flat-wise details section", () -> {
    	click1(new_Flatwise_details);
    	});
    	
    	Allure.step("Enter basic flat details", () -> {
    	Input(serial_No, "1");
    	Input(flat_No, "1");
    	Input(inspection_Date, "07/05/2022");
    	Input(date_of_Effect, "07/04/2022");
    	});
    	
    	Allure.step("Select user category and sub-category", () -> {
        click(user_category_SDRR);
        waitForDropdownToPopulate(user_category_SDRR);
    	selectFromDropdown(user_category_SDRR, "LAND");
    	waitForDropdownToPopulate(user_category_SDRR);
        waitForDropdownToPopulate(user_sub_category);
        selectFromDropdown(user_sub_category, "Land - residential LND 01");
    	});
    	
    	Allure.step("Select FSI factor", () -> {
    	click(fsi_Factor);
    	selectFromDropdown(fsi_Factor, "Admissible");
    	});
    	
    	Allure.step("Scroll to meter section", () -> {
	    scrollDown();
    	});
    	
    	Allure.step("Select meter type", () -> {
    	click(meter_Unmeter);
    	selectFromDropdown(meter_Unmeter, "Metered");
    	});
    		
    	Allure.step("Select meter type", () -> {
    	Input(water_connection_NO, "645354");
    	});
    	
    	Allure.step("Select tax code", () -> {
    	click(tax_Code);
        waitForDropdownToPopulate(tax_Code);
    	selectFromDropdown(tax_Code, "All - Tax code 4001");
    	 });
    	 
    	Allure.step("Enter carpet area", () -> { 
    	Input(total_Carpet_Area, "01");
    	});
    	
    	Allure.step("Select FSI as per court", () -> {
    	click(fsi_As_Per_Court);
    	click(fsi_As_Per_Court);
    	selectFromDropdown(fsi_As_Per_Court, "1");
    	handleAlertIfPresent();
    	});
    	
    	Allure.step("Submit flat details", () -> {
    	scrollToElementInsideModal(submit_Button);
    	handleAlertIfPresent();
    	click1(submit_Button);
    	acceptAlert();
    	});
    	
    	Allure.step("Save and draft actions", () -> {
    	scrollUp();
    	handleAlertIfPresent();
    	globalbuttons.clickSave();
        acceptAlert();
        click1(save_To_Drafts);
        acceptAlert();
        handleAlertIfPresent();
        globalbuttons.clickSave();
        acceptAlert();
    	});
    	
    	Allure.step("Fill section and SAC details", () -> {
        waitForDropdownToPopulate(section_Dropdown);
        selectFromDropdown(section_Dropdown,"01");
    	Input(sac_No, "2345");
    	click(get_Sac_No);
    	});
    	
    	Allure.step("Select forward user", () -> {
        waitForDropdownToPopulate(forward_To);
    	selectFromDropdown(forward_To, "Tulashiram Sitaram Pawade [dysupdt1.a]");
    	});
    	
    	Allure.step("Complete submission", () -> {
    	handleAlertIfPresent();
    	clickTo(Done);
    	acceptAlert();
    	});
    	
    	Allure.step("Logout from application", () -> {
    	click(logoutDropdown_WI);
    	globalbuttons.Logout();
    	});
    }
    
    	
}
    

