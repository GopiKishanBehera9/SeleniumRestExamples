package TestNG_ExtentReport;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class BasicExtentReportClass {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentSparkReporter("TestNG_ExtentReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add environment details
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("user", "Prachi");
		reports.setSystemInfo("Browser", "chrome");
		
		//Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
	}
	@Test
	public void LaunchBrowser() {
		//create test
		test = reports.createTest("Launch browser and open url");
		Assert.assertTrue(true); //Test Passed
	}
	
	@Test
	public void VerifyTitle() {
		//create test
		test = reports.createTest("VerifyTitle");
		Assert.assertTrue(false); //Test failed
	}
	
	@Test
	public void VerifyLogo() {
		//create test
		test = reports.createTest("VerifyLogo");
		Assert.assertTrue(true); //Test passed
	}
	
	@Test
	public void VerifyEmail() {
		//create test
		test = reports.createTest("Verify Email");
		throw new SkipException("skipping this test case with exception..");
	}
	
	@Test
	public void VerifyUserName() {
		//create test
		test = reports.createTest("Verify UserName");
		Assert.assertTrue(true);  //test pass
	}
	
	@AfterMethod
	public void getTestResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.CYAN));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.ORANGE));
		}
	}
	@AfterTest
	public void tearDown() {
		reports.flush();
	}
}
