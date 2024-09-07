package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent{

	WebDriver driver;
	    @FindBy(id = "userEmail")
	     WebElement userEmail;

	    @FindBy(id = "userPassword")
	     WebElement userPassword;

	    @FindBy(id = "login")
	     WebElement loginButton;
	    
	    @FindBy(css = "[class*='flyInOut']")
	     WebElement loginerrormessage;

	    public LoginPage(WebDriver driver) {
	    	super(driver);
	        PageFactory.initElements(driver, this);
	        this.driver=driver;
	    }

	    public ProductCatalogue login(String email, String password) {
	        userEmail.sendKeys(email);
	        userPassword.sendKeys(password);
	        loginButton.click();
	        ProductCatalogue pc=new ProductCatalogue(driver);
	        return pc;
	    }
	    
	    public void navigate()
	    {
	    	
			driver.get("https://rahulshettyacademy.com/client");

	    }
	    
	    public String errormessage()
	    {
	    	waitForWebElementToAppear(loginerrormessage);
	    	String error=loginerrormessage.getText();
	    	return error;
	    }
	    
	
}
