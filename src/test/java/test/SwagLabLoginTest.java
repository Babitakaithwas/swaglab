package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginPage;
import utility.Baseclass;
import utility.paramaterization;
@Listeners(utility.Listeners.class)
public class SwagLabLoginTest extends Baseclass{
	
	
	@BeforeMethod
	public void openBrowser() {
	driver= Browser.launchChrome();
	}
	
	@Test
	public void SwagLabLoginTest() throws EncryptedDocumentException, IOException {
		LoginPage loginpage= new LoginPage(driver);
		String user=paramaterization.getExcelData("credentials", 0, 0);
		String pass= paramaterization.getExcelData("credentials", 1, 0);
		loginpage.enterUserName(user);
		loginpage.enterPassword(pass);
		loginpage.clickOnLogin();
		String expectedUrl ="https://www.saucedemo.com/inventory.html";
		String actualUrl =driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		
		 }

}
