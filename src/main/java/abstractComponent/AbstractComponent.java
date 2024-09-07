package abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFactory.cartPage;
import pageFactory.orderHistory;

public class AbstractComponent {

	
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement clickCart;
	
	 @FindBy(xpath  = "//button[@routerlink='/dashboard/myorders']")
     WebElement order;
	
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForWebElementToAppear(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(element));	
		
	}
	
	public void waitForElementToAppear()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));	
		
	}
	public void waitForElementToDisAppear(By finBy)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(finBy));

	}
	public cartPage goToCartPage()
	{
   	 clickCart.click();
   	 cartPage cp=new cartPage(driver);
	 return cp;

	}
	
	public orderHistory clickonorder() throws InterruptedException
    {    	
        order.click();
        orderHistory oh=new orderHistory(driver);
        return oh;
    }
	

}
