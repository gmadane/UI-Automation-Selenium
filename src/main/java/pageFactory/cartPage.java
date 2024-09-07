package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class cartPage extends AbstractComponent{

	WebDriver driver;
	    @FindBy(css = ".totalRow button")
	     WebElement checkout;

	     @FindBy(css = ".cartSection h3")
	     List<WebElement> productTitles;
	     
	     @FindBy(xpath = "(//i[@class='fa fa-search'])[2]")
	     WebElement SelectCountry;
	 

	    public cartPage(WebDriver driver) {
	    	super(driver);
	        PageFactory.initElements(driver, this);
	        this.driver=driver;
	    }

	    public Boolean productDisplayOrder(String productName) throws InterruptedException {
	    	Thread .sleep(3000);
			Boolean mata=productTitles.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));   
			//getText().equalsIgnoreCase("Order Placed Successfully");
	        return mata;
	    }
	    
	    public Checkout checkout() throws InterruptedException
	    {
	    	Actions action=new Actions(driver);
	    	action.moveToElement(checkout).click().perform();
	    	Thread .sleep(3000);
	    	action.sendKeys(driver.findElement(By.cssSelector(".form-group .text-validated")), "India").build().perform();
	    	Thread .sleep(3000);
	    	SelectCountry.click();
	    	Checkout chk=new Checkout(driver);

	    	return chk;

	    }
	
}
