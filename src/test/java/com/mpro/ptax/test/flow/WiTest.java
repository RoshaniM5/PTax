//package com.mpro.ptax.test.flow;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.mpro.ptax.Utils.ReadExcel;
//import com.mpro.ptax.base.BasePage;
//import com.mpro.ptax.components.GlobalButtons;
//import com.mpro.ptax.pageobject.Aac;
//import com.mpro.ptax.pageobject.Wi;
//import com.mpro.ptax.projectFlow.LoginFlow;
//import com.mpro.ptax.test.base.BaseTest;
//
//public class WiTest extends BaseTest{
//	
//	private LoginFlow login;
//	private GlobalButtons globalbuttons;
//	private Aac aac;
//	private BasePage basepage;
//	private Wi wi;
//	
//	@BeforeTest
//	public void initFlow() {
//		login = new LoginFlow();
//		globalbuttons = new GlobalButtons();
//		aac= new Aac();
//		basepage = new BasePage();
//		wi=new Wi();
//	}
//	
//	@Test(dependsOnGroups = "AacFlow")
//	public void VerifyWiFlow() throws IOException {
//		
//		log.info("Testing WI Flow Test");
//		
//		ReadExcel excel =  new ReadExcel("C:\\Users\\rmulunde\\Desktop\\WI Data.xlsx");
//
//		    List<Map<String, String>> wiData = excel.getData("WI");
//
//		    for (Map<String, String> data : wiData) {
//
//		        log.info("Executing WI for Owner : " + data.get("OwnerName"));
//
//		        wi.fileWIfileDetails(data);
//		       Wi.fileWIfileDetails(data);
//		       WI.fileWIfileDetails(data);
//		    }
//
//		log.info("Record seleted successfully");
//		basepage.selectLatestInward();
//		
//		log.info("Logout completed successfully");
//		globalbuttons.Logout();
//	}
//}
//
