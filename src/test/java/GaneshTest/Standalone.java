package GaneshTest;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.Checkout;
import pageFactory.LoginPage;
import pageFactory.ProductCatalogue;
import pageFactory.cartPage;
import pageFactory.orderHistory;
import testcomponent.baseTest;

public class Standalone extends baseTest{
	static WebDriver driver;
    public String productname="ZARA COAT 3";
    
	@Test(dataProvider = "emailCredential")
//	public void testOrder(String useremail, String password) throws IOException, InterruptedException
	public void testOrder(HashMap<String, String> map) throws IOException, InterruptedException

	{
		
		//ProductCatalogue pc=lp.login(useremail,password);
		ProductCatalogue pc=lp.login(map.get("email"),map.get("password"));
		Thread.sleep(1000);	
        pc.getProductList();
		pc.getProductbyname(map.get("product"));
		pc.addProductToCart(map.get("product"));
		cartPage cp=pc.goToCartPage();		
	    Boolean prod_display= cp.productDisplayOrder(map.get("product"));		
		Assert.assertTrue(prod_display);
		Checkout chk=cp.checkout();
	  	chk.checkout();	
	  	Boolean match=chk.checkorderplaced();
	  	Assert.assertTrue(match);
	
		}
	
	@Test(dependsOnMethods = {"testOrder"} ,dataProvider = "emailCredential")
	public void OrderHistory(HashMap<String, String> map) throws IOException, InterruptedException
	{     		
		ProductCatalogue pc=lp.login(map.get("email"),map.get("password"));	
		
		orderHistory oh=pc.clickonorder();
		Boolean match=oh.productnameList(map.get("product"));
        org.testng.Assert.assertTrue(match);
	}
	
	@DataProvider(name="emailCredential")
	public Object[][] dataRead() throws IOException
	{
		/*
		 * Map<String, String> map=new HashMap<String , String>(); map.put("email",
		 * "gmadane@yopmail.com"); map.put("password", "Test@123"); map.put("product",
		 * "ZARA COAT 3");
		 */
		
		//Object[][] obj=new Object[1][2];
		//obj[0][0]="gmadane@yopmail.com";
		//obj[0][1]="Test@123";
    
		List<HashMap<String,String>> data= getjsonToMap(System.getProperty("user.dir")+"\\src\\test\\java\\data\\data.json");
		return new Object[][] {{data.get(0)}};
	}
	
	
	
}
