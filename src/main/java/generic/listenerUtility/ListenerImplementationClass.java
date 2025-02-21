package generic.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
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

import generic.baseTest.BaseClass;
import generic.webDriverUtility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener, ISuiteListener {

	// ThreadLocal to ensure each thread (test) gets its own ExtentTest instance

	//public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Configaturation");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		// Spark Report Config  
		ExtentSparkReporter spark =  new ExtentSparkReporter("./AdvanceReport/Report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);
		
		/* add Environment & Create Test */
		report = new ExtentReports();
		report.attachReporter(spark);
		//report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome-132");
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
		report.setSystemInfo("User Name", System.getProperty("user.name"));
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report BackUp");		
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=========" + result.getMethod().getMethodName() + "======START====");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName()+"===> STARTED <===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=========" + result.getMethod().getMethodName() + "======END====");
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName()+"===> COMPLETED <===");
		UtilityClassObject.getTest().pass(MarkupHelper.createLabel("Extent Report - PASS", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		TakesScreenshot edriver = (TakesScreenshot) BaseClass.staticDriver;
		String srcfilePath = edriver.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(srcfilePath, testName+"_"+time);
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName()+"===> FAILED <===");
		UtilityClassObject.getTest().fail(MarkupHelper.createLabel("Extent Report - FAIL", ExtentColor.RED));

	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
}
