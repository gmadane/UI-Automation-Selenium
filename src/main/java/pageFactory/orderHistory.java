package pageFactory;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class orderHistory extends AbstractComponent{

         WebDriver driver;
	     @FindBy(css = ".cartSection h3")
	     List<WebElement> productTitles;
	     
	     @FindBy(css = "tr td:nth-child(3)")
	     List<WebElement> productNamelist;
	 

	    public orderHistory(WebDriver driver) {
	    	super(driver);
	    	this.driver=driver;
	        PageFactory.initElements(driver, this);
	        
	    }

	    public Boolean productnameList(String productName) throws InterruptedException {
	    	Thread .sleep(3000);
			Boolean match=productNamelist.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));   
			//getText().equalsIgnoreCase("Order Placed Successfully");
	        return match;
	    }
	    
	    
	
}
