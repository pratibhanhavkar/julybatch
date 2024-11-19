package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabCartPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

public class SwagLabCartTest {
	 WebDriver driver;
	@BeforeMethod
	
	public void lunchApplication() {
		driver= Browser.openBrowser();
		SwagLabLoginPage swaglabloginpage = new SwagLabLoginPage(driver);
		swaglabloginpage.enterusername("standard_user");
		swaglabloginpage.enterpassword("secret_sauce");
		swaglabloginpage.clickonlogin();
	
	}
	@Test
	
	public void VerifyIfUserIsAbleToAddProductToCart() {
		SwagLabHomePage swaglabhomepage = new SwagLabHomePage(driver);
		SwagLabCartPage swaglabcartpage = new SwagLabCartPage(driver);
		
		swaglabhomepage.clickOnAddtocart(1);
		String productname = swaglabhomepage.getProductsName(0);
		swaglabhomepage.clickOnCart();
		Assert.assertEquals(swaglabcartpage.getcartItem(),1);
	    Assert.assertEquals(swaglabcartpage.getProductname(0),productname);
		driver.navigate().back();
		
		swaglabhomepage.clickOnAddtocart(1);
		String productname1 = swaglabhomepage.getProductsName(1);
		swaglabhomepage.clickOnCart();
		Assert.assertEquals(swaglabcartpage.getcartItem(),2);
		Assert.assertEquals(swaglabhomepage.getProductsName(1), productname1);
		driver.navigate().back();
		
		swaglabhomepage.clickOnAddtocart(2);
		String productname2 = swaglabhomepage.getProductsName(2);
		swaglabhomepage.clickOnCart();
		Assert.assertEquals(swaglabcartpage.getcartItem(),3);
		Assert.assertEquals(swaglabhomepage.getProductsName(2), productname2);
		driver.navigate().back();
		
		swaglabhomepage.clickOnAddtocart(3);
		String productname3 = swaglabhomepage.getProductsName(3);
		swaglabhomepage.clickOnCart();
		Assert.assertEquals(swaglabcartpage.getcartItem(),4);
		Assert.assertEquals(swaglabhomepage.getProductsName(3), productname3);
		driver.navigate().back();
		
		swaglabhomepage.clickOnAddtocart(4);
		String productname4 = swaglabhomepage.getProductsName(4);
		swaglabhomepage.clickOnCart();
		Assert.assertEquals(swaglabcartpage.getcartItem(),5);
		Assert.assertEquals(swaglabhomepage.getProductsName(4), productname4);
		driver.navigate().back();
		

		swaglabhomepage.clickOnAddtocart(5);
		String productname5 = swaglabhomepage.getProductsName(5);
		swaglabhomepage.clickOnCart();
		Assert.assertEquals(swaglabcartpage.getcartItem(),6);
		Assert.assertEquals(swaglabhomepage.getProductsName(5), productname5);
		driver.navigate().back();
		
	}
	@Test
	public void VerifyClickOnCartIconCartIsDisplayed() {
		SwagLabHomePage swaglabhomepage = new SwagLabHomePage(driver);
		swaglabhomepage.clickOnCart();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
    	}

}
