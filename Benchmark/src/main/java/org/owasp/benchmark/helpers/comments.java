user statistics

Updated date time

history - active and deleted
//*[@id="edit-submit-project-scan"]


$x("")package ASAP.ASAPSEC.Testcases;


import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import ASAP.ASAPSEC.AddProjectDetailsPage;
import ASAP.ASAPSEC.DashboardPage;
import ASAP.ASAPSEC.DataInputProvider;
import ASAP.ASAPSEC.DevLoginPage;
import ASAP.ASAPSEC.LoginPage;
import ASAP.ASAPSEC.ScanPage;
import ASAP.ASAPSEC.SelfHealPage;
import ASAP.ASAPSEC.Testbase;
import ASAP.ASAPSEC.UploadProject;



public  class TC01_DockerSmokeTestCase extends Testbase {

	LoginPage loginPage;
	ScanPage  scanPage;
	AddProjectDetailsPage addDetails;
	UploadProject uploadPro;
	DashboardPage dashBoard;
	
	SelfHealPage selfheal;
	
	
	
	public TC01_DockerSmokeTestCase() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	
	@BeforeSuite
	public void  initbrowse()  {
		
		initBrowser();
		
	}
	
	@BeforeClass
	public void  ExtentReports() {
		initReport();
		
	}

	
	
	
	@Test(priority=1)
	public void TC1_loginASAP()
	{
		try {	
			logger= extent.createTest("TC1_loginASAP");
			logger.log(Status.INFO, "Starting Execution");
		
			ImplicitWait(30);
			//loginPage = new LoginPage();
			//loginPage.loginASAP();
			
			
		} catch (Exception e) {
			
			e.getMessage();
			System.out.println(e);
			Assert.fail("Error");
		} 

			 
	}
	
	@Test(priority=2,dataProvider="fetchData")
	public void TC02_ASAP_Docker_Smoke(String ProjectTitle,String ProjectDesc,String MangerName,String ContactEmail,String Technology,String ProjectPath)
	{
		try {	
			logger= extent.createTest("TC02_ASAP_Docker_Smoke");
			logger.log(Status.INFO, "Starting Execution");

			ImplicitWait(30);
			
			/*scanPage = new ScanPage();
			addDetails = new AddProjectDetailsPage();
			uploadPro = new UploadProject();
			dashBoard = new DashboardPage();
			selfheal = new SelfHealPage();
			*/

			scanPage.addProject();

			addDetails.AddDetails(ProjectTitle,ProjectDesc,MangerName,ContactEmail,Technology);
			uploadPro.projectInput(ProjectPath);

			scanPage.selectProjectScan();

			dashBoard.noOfVuln();
			dashBoard.downloadExclReport();
			dashBoard.downloadHtmlReport();	
			dashBoard.downloadPDF();

			dashBoard.falsePositive();


			selfheal.projectSelection();
			selfheal.vulnerabilityDetails();
			selfheal.applySelfHeal();
			selfheal.selfHealDetails();



		} catch (Exception e) {

			e.getMessage();
			Assert.fail("Error in Running TestCase");
		} 


	
		
		
		
	}
	
		

	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenPath=captureScreenShot(driver, result.getName());
		//	logger.log(Status.FAIL,"TestCase Fail");
			try {
				logger.fail("Failed ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenPath).build());
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			logger.pass("Test case Pass");	
		}

		
	}
	@AfterClass
	 public void afterClass()
	{
		try{
			Thread.sleep(3000);
			extent.flush();

			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c= DriverManager.getConnection( "jdbc:odbc:abc","root","root");
s=c.createStatement();
rs= s.executeQuery("select * from exam");
//s=c.createStatement();
//s=c.createStatement();
//s=c.createStatement();
//s=c.createStatement();

//s=c.createStatement();
s=c.createStatement();
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//c= DriverManager.getConnection( "jdbc:odbc:abc","root","root");
//s=c.createStatement();
//rs= s.executeQuery("select * from exam");

}catch(Exception e) { System.out.println(e); }
b1= new Button("Submit");
b2= new Button("Start");
b1.addActionListener(this);
b2.addActionListener(this);
t1= new TextArea(100,100);
g= new CheckboxGroup();
c1= new Checkbox("Option1",g, true);
c2= new Checkbox("Option2",g, false);
c3= new Checkbox("Option3",g, false);
add(t1);
add(c1);
add(c2);
add(c3);
add(b1);
add(b2);

setLayout( new GridLayout(4,4));
addWindowListener(this);
setVisible(true);
setSize(400,400);
setLocation(0,0);
}


	}
	
	
	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		String TESTDATA_SHEET_PATH = prop.getProperty("Excelpath") ;
		return DataInputProvider.getSheet(TESTDATA_SHEET_PATH);		
	}
	
	
}
