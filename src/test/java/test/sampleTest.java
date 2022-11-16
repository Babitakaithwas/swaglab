package test;


import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class sampleTest {
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void ConfigureReports() {
		report= Reports.CreatedExtentReports();
	
	}
	
	@Test
	public void Test1() {
		test = report.createTest("test1");//create report
		System.out.println("test1");
	}
	@Test  (dependsOnMethods = "Test3") 
	public void Test2() {
		test = report.createTest("test2");//create report
		System.out.println("test2");
		}
	
	@Test  (timeOut = 1000 )
	public void Test3() throws InterruptedException {
		test= report.createTest("test3");//create report
		Thread.sleep(2000);
		System.out.println("test3");
	}
		
	@AfterTest
	public void publishResult (ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
		{
		test.log(Status.PASS,result.getName());	
			}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getName());
		}
		else {
			test.log(Status.SKIP,result.getName());
		}
	}
	@AfterTest
	public void createReport() {
		report.flush();
	}
	
	}


