package GaneshTest;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageFactory.Checkout;
import pageFactory.LoginPage;
import pageFactory.ProductCatalogue;
import pageFactory.cartPage;
import testcomponent.Retry;
import testcomponent.baseTest;

public class ErrorValidation extends baseTest{
	static WebDriver driver;

	@Test(retryAnalyzer = Retry.class)
	public void testOrder1() throws IOException, InterruptedException
	{
		String productname="ZARA COAT 3";
		lp.login("gmadane@yopmail.com","Te@123");	
		System.out.print(lp.errormessage());
        Assert.assertEquals("Incorrect email or password.", lp.errormessage());
        System.out.println("Hello Retry");
			  
	  }
	

}
