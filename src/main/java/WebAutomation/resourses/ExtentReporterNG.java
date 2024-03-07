package WebAutomation.resourses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	
	public static ExtentReports getReportObject()
	{
		
		 String path = System.getProperty("user.dir")+"//Report//index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automation Test");
			reporter.config().setDocumentTitle("Automation Test Result");
			
			ExtentReports extents = new ExtentReports();
			extents.attachReporter(reporter);
			extents.setSystemInfo("Quality Analyst", "Anith vc");
			return extents;
	}

}
