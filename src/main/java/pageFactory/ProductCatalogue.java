package pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	WebDriver driver;
	
	
	 public ProductCatalogue(WebDriver driver) {
		    super(driver);
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }
	
	@FindBy(css = ".mb-3")
    List<WebElement> productlist;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement clickCart;
	
	By productsby=By.cssSelector(".mb-3");
	By addtoCart=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("#toast-container");
	By waittodisappearele=By.xpath("//div[@aria-label='Product Added To Cart']");
	
	
     public List<WebElement> getProductList() {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        return productlist;        
	    }
     
     public WebElement getProductbyname(String productName)
     {
 		WebElement prod= getProductList().stream().filter(prodd->prodd.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
     }
     
     public void addProductToCart(String productName)
     {  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	 WebElement prod=getProductbyname(productName);
    	 prod.findElement(addtoCart).click();
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
    	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-label='Product Added To Cart']")));
    	
    	
     }

        
}
