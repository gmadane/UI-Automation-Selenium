package GaneshTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {

	
	ExtentSparkReporter esr;
	ExtentReports extentReport;
	@BeforeTest
	public void config()
	{
		String reportpath=System.getProperty("user.dir")+"\\reports\\index.html";
		esr=new ExtentSparkReporter(reportpath);
		esr.config().setReportName("Web Automation Report");
		esr.config().setDocumentTitle("TestResults");
	    extentReport=new ExtentReports();
		extentReport.attachReporter(esr);	
		extentReport.setSystemInfo("Tester","Ganesh Madane");
	}
	
	//@Test
	public void Test1()
	{
		ExtentTest ext = extentReport.createTest("Initail Demo");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		System.out.println(driver.getTitle());
		//ext.addScreenCaptureFromPath("");
		//ext.fail("expected string does not match");
		
		extentReport.flush();
		
	}
	
}
