package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCartPage {
	@FindBy (xpath ="//div[@class='cart_item']")private List<WebElement>CartItem;
	@FindBy (xpath ="//div[@class=\'inventory_item_name\']") private List<WebElement>ProductName;
	@FindBy (xpath = "//div[@class=\'inventory_item_price\']")private List<WebElement>ProductPrice;
	@FindBy (xpath = "//button[@class=\'btn_secondary btn_inventory\']")private List<WebElement>Remove;
	@FindBy (xpath = "//a[@class=\'btn_action checkout_button\']")private WebElement CheckOut;
	
	public SwagLabCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getcartItem() {
		return CartItem.size();
	
	}
	public String getProductname(int index) {
		return ProductName.get(index).getText();
	}
	public void getProductPrice(int index) {
		ProductPrice.get(index).getText();
	}
	public double[] getAllProductPrice(int index) {
		double[] price = new double [ProductName.size()];
		for(int i=0;i<ProductName.size();i++)
		{
			String amount = ProductPrice.get(i).getText().substring(1);
			price[i]=Double.parseDouble(amount);
		}
		return price;
	}
	public void ClickOnRemoveButton(int index) {
		Remove.get(index).getText();
	}
	public boolean  IsProductDisplayed(int index) {
		boolean result = Remove.get(index).isDisplayed();
		return result;
	}
	
	public void ClickOnCheckoutButton() {
		CheckOut.click();
	}

}
