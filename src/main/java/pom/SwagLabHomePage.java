package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
public class SwagLabHomePage {
	
	@FindBy (xpath = "//div[@class='inventory_item_name']")private List<WebElement> ProductsName;
	@FindBy (xpath ="//div[@class='inventory_item_price']")private List<WebElement>ProductsPrice;
	@FindBy (xpath ="//button[@class='btn_primary btn_inventory']")private List<WebElement>AddToCart;
	@FindBy (xpath="//select[@class='product_sort_container']")private WebElement sort;
	@FindBy(xpath= "//a[@class='bm-item menu-item']")private WebElement menu;
	@FindBy (xpath="//a[text()='About']")private WebElement about;
	@FindBy(xpath="//a[text()='Logout']")private WebElement logout;
	@FindBy (xpath = "//div[@class='shopping_cart_container']")private WebElement cart;
	public SwagLabHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    public String getProductsName(int index) {
    	return ProductsName.get(index).getText();
    }
    
    public String[] getAllProductsName() {
    	String [] names = new String[ProductsName.size()];
    	for(int i=0 ; i<=ProductsName.size();i++)
    	{
    		names[i] = ProductsName.get(i).getText();
    	}
    	return names;
    }
    
    public String getProductsPrice(int index) {
    	return ProductsPrice.get(index).getText();
    }
    public double[] getAllProductPrice() {
    	double [] price = new double[ProductsName.size()];
    	for(int i=0 ; i<ProductsName.size();i++)
    	{
    	 String amount = ProductsPrice.get(i).getText().substring(1);
    		price[i] = Double.parseDouble(amount);
    	}
    	return price;
    }
    
    public void clickOnAddtocart(int index) {
    	AddToCart.get(index).click();
    }
    public void sortProducts(String text) {
    	Select select = new Select(sort);
    	select.deselectByVisibleText(text);
    			
    }
    public void clickOnCart() {
    	cart.click();
    }
    public void clickOnMenu() {
    	menu.click();
    }
    public void clickOnAbout() {
    	about.click();
    }
    public void clickLogout() {
    	logout.click();
    }
}
