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

public class Checkout extends AbstractComponent{

	WebDriver driver;
	    @FindBy(css = ".action__submit")
	     WebElement checkout;

	    public Checkout(WebDriver driver) {
	    	super(driver);
	        PageFactory.initElements(driver, this);
	        this.driver=driver;
	    }
      public Boolean checkorderplaced()
      {
	   Boolean match=driver.findElement(By.xpath("//div[@aria-label='Order Placed Successfully']")).getText().equalsIgnoreCase("Order Placed Successfully");
	   return match;
      }
	 
	    
	    public void checkout() throws InterruptedException
	    {
	    	Actions action=new Actions(driver);
	       	WebElement elementa = driver.findElement(By.cssSelector(".action__submit"));
	    	action.moveToElement(elementa).click().perform();
	    	Thread .sleep(3000);

	    }
	
}
