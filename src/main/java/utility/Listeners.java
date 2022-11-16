package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Baseclass implements ITestListener {
	WebDriver driver;
	public void onTestStart(ITestResult result) {
		System.out.println("test started"+ result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("test passed"+ result.getName());
	}
//	public void onTestFailure(ITestResult result) {
//		//System.out.println("test Fail"+ result .getName());
//		try {
//			Screenshot.clickScreenshot(driver, result.getName());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	//}
	public void onTestSkipped(ITestResult result) {
		System.out.println("test skip"+result.getName());
	}
	}
