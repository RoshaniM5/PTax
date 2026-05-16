package com.mpro.ptax.projectFlow;

import org.testng.annotations.Test;

import com.mpro.ptax.driver.DriverManager;
import com.mpro.ptax.fullAssessmentflow.Aac1Flow;
import com.mpro.ptax.fullAssessmentflow.AacFlow;
import com.mpro.ptax.fullAssessmentflow.DysupdtFlow;
import com.mpro.ptax.fullAssessmentflow.InwardFlow;
import com.mpro.ptax.fullAssessmentflow.SupdtFlow;
import com.mpro.ptax.fullAssessmentflow.wiFlow;
import com.mpro.ptax.model.WiData;
import com.mpro.ptax.test.base.BaseTest;
import com.mpro.ptax.test.dataprovider.WIDataProvider;

public class NewAssessmentFlow1 extends BaseTest{
	
	@Test(groups = {"Regression"},  dataProvider = "WIDataProvider",
		      dataProviderClass = WIDataProvider.class, alwaysRun =true)
	public void completeAssessmentFlow(WiData data) throws Exception {
		
		 System.out.println("Inside Test - Driver: " + DriverManager.getDriver());

		 try {

		        System.out.println("Driver: " + DriverManager.getDriver());

		        new InwardFlow().executeInward();
		        new AacFlow().executeaac();
		        new wiFlow().executeWi(data);
		        new DysupdtFlow().executeDysupdt();
		        new SupdtFlow().executeSupdt();
		        new Aac1Flow().executeAac1();

		    } catch (Exception e) {
		        System.out.println("===== ERROR OCCURRED =====");
		        e.printStackTrace(); 
		        throw e;
		    }
		}

}
