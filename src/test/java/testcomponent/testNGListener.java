package testcomponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.extentReporterNG;

public class testNGListener extends baseTest implements ITestListener
{
    ExtentTest test;
	ExtentReports extent=extentReporterNG.extentreportNg();
	ThreadLocal <ExtentTest>extent_test=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {

		test=extent.createTest(result.getMethod().getMethodName());
		extent_test.set(test);
		
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        
    	test.log(Status.PASS,"Test is passsed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    extent_test.get().fail(result.getThrowable());
     String filepath=null;
     
     try {
		driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		
	} catch (Exception e1) {
		e1.printStackTrace();
	} 
     try {
		filepath=getScreenshot(result.getMethod().getMethodName(),driver);
	} catch (IOException e) {
		e.printStackTrace();
	}
     
     test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
      extent.flush();
    }
}
