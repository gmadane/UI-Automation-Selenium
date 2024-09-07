package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNG {
	
	public static ExtentReports extentreportNg()
	{
		String reportpath=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter esr=new ExtentSparkReporter(reportpath);
		esr.config().setReportName("Web Automation Report");
		esr.config().setDocumentTitle("TestResults");
		ExtentReports extentReport=new ExtentReports();
		extentReport.attachReporter(esr);	
		extentReport.setSystemInfo("Tester","Ganesh Madane");
		return extentReport;
	}

}
