package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pojo.Browser;

public class SwagLabLoginPage {
	@FindBy (xpath="//input[@id='user-name']")private WebElement username;
	@FindBy (xpath="//input[@id='password']")private WebElement password;
	@FindBy (xpath="//input[@id='login-button']")private WebElement login;
    @FindBy (xpath="//h3[@data-test='error']")private WebElement warningmessage;
    
    public SwagLabLoginPage(WebDriver driver){
    	PageFactory.initElements(driver, this);
    	 }
    public void enterusername(String user){
    	username.sendKeys(user);
    }
    public void enterpassword(String pass) {
    	password.sendKeys(pass);
    }
    public void clickonlogin() {
    	login.click();
    }
    
    public boolean isWarningLabelisDisplayed() {
    	try {
    		return warningmessage.isDisplayed();
    	}
    	catch (Exception e) {
    		return false;
    	}
    }
    public String getwarningmessage(){
    	return warningmessage.getText();
  	}

}
