package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports  createReport() {
    ExtentSparkReporter  htmlReports = new ExtentSparkReporter("SwaglanTestReporter.html");
    ExtentReports reports = new ExtentReports();
    reports.attachReporter(htmlReports);
    reports.setSystemInfo("ProjectName", "swaglab");
    reports.setSystemInfo("owner", "Arise");
	return reports;
    
    
	} 
		
	

}
