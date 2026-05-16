package com.mpro.ptax.projectFlow;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mpro.ptax.fullAssessmentflow.Aac1Flow;
import com.mpro.ptax.fullAssessmentflow.AacFlow;
import com.mpro.ptax.fullAssessmentflow.DysupdtFlow;
import com.mpro.ptax.fullAssessmentflow.InwardFlow;
import com.mpro.ptax.fullAssessmentflow.SupdtFlow;
import com.mpro.ptax.fullAssessmentflow.wiFlow;
import com.mpro.ptax.fullReAssessmentflow.InwardFlowReAssessment;
import com.mpro.ptax.fullWorkflow.WTDeletionFlow;
import com.mpro.ptax.model.WiData;
import com.mpro.ptax.test.auth.LoginTestFlow;
import com.mpro.ptax.test.base.BaseTest;
import com.mpro.ptax.test.dataprovider.WIDataProvider;

public class WTDeletionTestFlow extends BaseTest{
	
	private LoginTestFlow login;
	private InwardFlow inwardflow;
	private AacFlow Aacflow;
	private wiFlow wiflow;
	private DysupdtFlow dysupdtflow;
	private SupdtFlow supdtflow;
	private Aac1Flow Aac1flow;
	private InwardFlowReAssessment inwardReassessment;
	private WTDeletionFlow wtdeletionflow;
	
	@BeforeMethod(alwaysRun = true)
	public void initFlow() {
		
		login = new LoginTestFlow(); 
		inwardflow = new InwardFlow();
		Aacflow = new AacFlow();
		wiflow  = new wiFlow();
		dysupdtflow = new DysupdtFlow();
		supdtflow	= new SupdtFlow();
		Aac1flow = new Aac1Flow();
		inwardReassessment = new InwardFlowReAssessment();
		wtdeletionflow = new WTDeletionFlow();
	}
	
	@Test(groups={"Regression", "Wi"}, alwaysRun =true, dataProvider = "WIDataProvider", dataProviderClass = WIDataProvider.class)
	public void verifyWTDeletionFlow(WiData data) throws Exception {

	    inwardflow.executeInward();
	    Aacflow.executeaac();
	    wiflow.executeWi(data);
	    dysupdtflow.executeDysupdt();
	    supdtflow.executeSupdt();
	    Aac1flow.executeAac1();
	    wtdeletionflow.executeWTDeletionWorkflow(data);
	    

	}
}


