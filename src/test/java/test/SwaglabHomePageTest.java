package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

public class SwaglabHomePageTest {
	WebDriver driver;
	@BeforeMethod
	
	public void lunchApplication() {
		driver = Browser.openBrowser();
		SwagLabLoginPage  swaglabloginpage = new  SwagLabLoginPage(driver);
		swaglabloginpage.enterusername("standard_user");
		swaglabloginpage.enterpassword("secret_sauce");
		swaglabloginpage.clickonlogin();
		 }
	
	
	@Test
   public void VerifysortFeatureZtoA() {
		 SwagLabHomePage swaglabhomepage = new  SwagLabHomePage(driver);
		 swaglabhomepage.sortProducts("Name (Z to A)");
		 String[] names= swaglabhomepage.getAllProductsName();
		 swaglabhomepage.sortProducts("Name (A to Z)");
		 String[] sortednames = swaglabhomepage.getAllProductsName();
		 
 		 Assert.assertEquals(names[0], sortednames[5]);
		 Assert.assertEquals(names[1], sortednames[4]);
		 Assert.assertEquals(names[2], sortednames[3]);
		 Assert.assertEquals(names[3], sortednames[2]);
		 Assert.assertEquals(names[4], sortednames[1]);
		 Assert.assertEquals(names[5], sortednames[0]);
	}
	@Test
	public void VerifysortfeatureforPriceHightoLow() {
		SwagLabHomePage swaglabhomepage = new SwagLabHomePage(driver);
				swaglabhomepage.sortProducts("Price (high to low)");
				double [] Price = swaglabhomepage.getAllProductPrice();
				Assert.assertTrue((Price[0]>=Price[1] && Price[1]>=Price[2]&& Price[2]>=Price[3] && Price[3]>=Price[4] && Price[4]>=Price[5]));
	}
	@Test
	public void VerifysortfeatureforPriceLowToHigh() {
		SwagLabHomePage swaglabhomepage = new SwagLabHomePage(driver);
				swaglabhomepage.sortProducts("Price (low to high)");
				double [] Price = swaglabhomepage.getAllProductPrice();
				Assert.assertTrue((Price[0]<=Price[1] && Price[1]<=Price[2]&& Price[2]<=Price[3] && Price[3]<=Price[4] && Price[4]<=Price[5]));
	}
	}
