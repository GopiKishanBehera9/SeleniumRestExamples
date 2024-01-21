package ExtentReportUsingListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	public void configureReport() {
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
	}
	
	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("On Start method invoked...");
	}
	
	
	public void onFinish(ITestContext Result) {
		System.out.println("On Finish method invoked....");
		reports.flush();
	}
	
	
	//When test case get failed, this method is called.
	public void onTestFailure(ITestResult Result) {
		System.out.println("Name of test method failed: "+ Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: "+Result.getName(),ExtentColor.AMBER));
	}
	
	//When Test case get skipped, this method is called.
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of test method Skipped: "+ Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is: "+Result.getName(),ExtentColor.PURPLE));
	}
	
	//When test case get Started, this method is called.
	public void onTestStart(ITestResult Result) {
		
		
	}
	
	//When test case get passed, this method is called
	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of test method successfully executed: "+ Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Pass test case is: "+Result.getName(),ExtentColor.INDIGO));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		System.out.println();
	}

}
