package test;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabLoginPage;

public class SwagLabLoginTest {
   WebDriver driver;
   
	@BeforeMethod
	public void lunchApplication() {
		
		driver = Browser.openBrowser();
	}
	
	@Test
    public void verifyIfUserIsAbleTologinWithValidCredentials(){
		 SwagLabLoginPage swaglabloginpage = new SwagLabLoginPage(driver);
			swaglabloginpage.enterusername("standard_user");
			swaglabloginpage.enterpassword("secret_sauce");
			swaglabloginpage.clickonlogin();
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		}
			
		
    @Test
	public void verifyIfWarningMessageIsForLockedOutUser(){
    	SwagLabLoginPage swaglabloginpage = new SwagLabLoginPage(driver);
    	swaglabloginpage.enterusername("locked_out_user");
    	swaglabloginpage.enterpassword("secret_sauce");
    	swaglabloginpage.clickonlogin();		
        Assert.assertEquals(swaglabloginpage.getwarningmessage(), "Epic sadface: Sorry, this user has been locked out.");
	}

}
