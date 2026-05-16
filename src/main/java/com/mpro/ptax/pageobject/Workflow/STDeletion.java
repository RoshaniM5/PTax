package com.mpro.ptax.pageobject.Workflow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mpro.ptax.base.BasePage;
import com.mpro.ptax.components.GlobalButtons;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class STDeletion extends BasePage{

	GlobalButtons globalbuttons = new GlobalButtons();

	private static final By save_To_Drafts					= By.xpath("//button[@id='btnSaveToDraft']");
	private static final By date_of_Effect					= By.xpath("//input[@id='ptasdDoeffect']");
	private static final By forward_To						= By.xpath("//select[@id='ptaadTuserid']");
	private static final By submit_WI			    		= By.xpath("(//button[@id='btnSubmit'])[2]");
	private static final By form_Type_Dropdown_Form_Type    = By.xpath("//select[@id='formType']");
	private static final By save_Button						= By.xpath("//button[@id='btn_orgsave']");
//	private static final By scroll_D						= By.xpath("(//section[@class='modal ng-scope'])[1]");
	private static final By revision_Year					= By.xpath("//select[@id='ptfswRevisionyearid']");
	private static final By allow_sanction_NO				= By.xpath("//select[@id='ptasdIsSancReq']");
	private static final By sanction_No						= By.xpath("//input[@id='ptasdSanctionNo']");
	private static final By ccn_No						    = By.xpath("//input[@id='ptasdWccnno']");
	private static final By checkbox						= By.xpath("//input[@id='chkUnits0']/following-sibling::div");
	private static final By apply_Button					= By.xpath("//button[@id='btnAddFlatDetail']");
	private static final By Done				    		= By.xpath("//button[@id='btnDone']");
	private static final By logoutDropdown_WI				= By.xpath("//a[normalize-space()='Sanjay Baban Surve']");
	
	 	@Step("Set record status to Workflow WT")
	 	public void verifyFormTypeForSTDeletion() {
	 		
	 		  Allure.step("Select latest inward record", () -> {

	 		        boolean inwardOpened = selectLatestInward();

	 		        if (!inwardOpened) {
	 		            throw new RuntimeException("Unable to open latest inward");
	 		        }

	 		        System.out.println("Inward opened successfully");
	 		    });

	 		    waitForLoaderToDisappear();

	 		    waitForDropdownToPopulate(form_Type_Dropdown_Form_Type);

	 		    Allure.step("Select workflow as form type", () -> {
	 		        selectFromDropdown(form_Type_Dropdown_Form_Type,
	 		                "ST Deletion (City)");
	 		    });

	 		Allure.step("Submit WI form type", () -> {
	 		click(submit_WI);
	 		});
	 	}
	    
	    @Step("Fill WI Form for Workflow STDeletion")
		public void verifySTDeletion() throws InterruptedException {
	    	
	    	
	    	 waitForLoaderToDisappear();
	    	    handleModal();

	    	    Allure.step("Select latest inward record", () -> {

	 		        boolean inwardOpened = selectLatestInward();

	 		        if (!inwardOpened) {
	 		            throw new RuntimeException("Unable to open latest inward");
	 		        }

	 		        System.out.println("Inward opened successfully");
	 		    });

	 		    waitForLoaderToDisappear();
	    	    new WebDriverWait(driver, Duration.ofSeconds(20))
	    	            .until(ExpectedConditions.elementToBeClickable(revision_Year));

		      
	    	Allure.step("Select revisionYear", () -> {
	    	
	 	 	selectFromDropdown(revision_Year, "YEAR 2015-2025");
	 	 	});
	    	 
	 		Allure.step("Enter DateofEffect", () -> {
	 		Input(date_of_Effect, "07/04/2022");
	        });
	 		
	 		Allure.step("Enter CCN no.", () -> {
		 	Input(ccn_No, "123456789");
		    });
	 		
	 		Allure.step("Select Type of sanction no", () -> {
		 	selectFromDropdown(allow_sanction_NO, "Required");
		 	});
	 		
	 		Allure.step("Select revisionYear", () -> {
			Input(sanction_No, "123456789123456");
			});
	 		
	 		Allure.step("Select checkbox", () -> {
			click(checkbox);
			});
	 		
	 		Allure.step("Click Apply", () -> {
	 		click(apply_Button);
			});
	 		
	 		Allure.step("Click on save", () -> {
		 	click(save_Button);
			});
	 		
	 		acceptAlert();
	 		click1(save_To_Drafts);
	 		acceptAlert();
	 		
	 		Allure.step("Click on save", () -> {
			click(save_Button);
			});
	 		
	 		Allure.step("Click on save", () -> {
	 		selectFromDropdown(forward_To, "Tulashiram Sitaram Pawade [dysupdt1.a]");
			});
	 		
	 		Allure.step("Click on Done", () -> {
			click(Done);
			acceptAlert();
			acceptAlert();
			});
				
			Allure.step("Logout from application", () -> {
			click(logoutDropdown_WI);
			globalbuttons.Logout();
			});
	    }
	    
}




