package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports CreatedExtentReports() {
	ExtentReports report = new ExtentReports();
		ExtentSparkReporter sparkreport= new ExtentSparkReporter("extentreport.html");
		report.attachReporter(sparkreport);
		report.setSystemInfo("CreatedBy","ABC");
		report.setSystemInfo("TestSuite", "Regression");
		return report;

}
	}
