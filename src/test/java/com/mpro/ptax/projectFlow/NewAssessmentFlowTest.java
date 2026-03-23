package com.mpro.ptax.projectFlow;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mpro.ptax.fullAssessmentflow.Aac1Flow;
import com.mpro.ptax.fullAssessmentflow.AacFlow;
import com.mpro.ptax.fullAssessmentflow.DysupdtFlow;
import com.mpro.ptax.fullAssessmentflow.InwardFlow;
import com.mpro.ptax.fullAssessmentflow.SupdtFlow;
import com.mpro.ptax.fullAssessmentflow.wiFlow;
import com.mpro.ptax.model.WiData;
import com.mpro.ptax.test.base.BaseTest;
import com.mpro.ptax.test.dataprovider.WIDataProvider;

import io.qameta.allure.Description;

public class NewAssessmentFlowTest extends BaseTest{
 
		
	    private InwardFlow inwardflow;
	    private AacFlow aacflow;
	    private wiFlow wiflow;
	    private DysupdtFlow dysupdtflow;
	    private SupdtFlow supdtflow;
	    private Aac1Flow Aac1flow;
	    
	    @BeforeMethod
	    public void setup() {
	          
	        inwardflow= new InwardFlow();
	        aacflow= new AacFlow();
	        wiflow= new wiFlow();
	        dysupdtflow= new DysupdtFlow();
	        supdtflow = new SupdtFlow();
	        Aac1flow = new Aac1Flow();
	    }

	    
	    
	    @Test(priority = 1)
	    @Description("Verify inward number is generated successfully")
	    public void inwardFlow() throws Exception {
	    	inwardflow.executeInward();
	        log.info("Inward No. generated successfully");
	    }
	    
	    @Test(priority = 2)
	    @Description("Verify AAC approves the inward")
	    public void aacFlow() throws Exception {
	    	aacflow.executeaac();
	    	log.info("Aac Approved the Inward");
	        
	    }
	    
	    @Test(priority = 3, dataProvider="WIDataProvider",  dataProviderClass = WIDataProvider.class)
	    @Description("Verify WI details submission with multiple data sets")
	    public void WiFlow(WiData data) throws Exception {
	    	wiflow.executeWi(data);
	    	log.info("Wi details filled successfully");
	        
	    }
	    
	    @Test(priority = 4)
	    @Description("Verify DySupdt Approves the inward")
	    public void Dysupdt() throws Exception {
	    	dysupdtflow.executeDysupdt();
	    	log.info("Dysupdt details filled successfully");
	    	log.info("Dy details filled successfully");
	        
	    }
	    
	    @Test(priority = 5)
	    @Description("Verify Supdt Approves the inward")
	    public void Supdt() throws Exception {
	    	supdtflow.executeSupdt();	
	    	log.info("Supdt details filled successfully");
	        
	    }
	    
	    @Test(priority = 6)
	    @Description("Verify Final AAC Approval")
	    public void aacFlow1() throws Exception {
	    	Aac1flow.executeAac1();
	    	log.info("Aac Approved the Inward");
	        
	    }
	}
	    

