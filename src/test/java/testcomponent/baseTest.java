package testcomponent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageFactory.LoginPage;

public class baseTest {
	public WebDriver driver;
    public LoginPage lp;
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\global.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
		driver=new ChromeDriver();
		
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	@BeforeMethod
	public LoginPage lunchApplication() throws IOException
	{
		driver=initializeDriver();
		lp=new LoginPage(driver);
		lp.navigate();		
		return lp;
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	public List<HashMap<String, String>> getjsonToMap(String filepath) throws IOException
	{
		String jsoncontent=FileUtils.readFileToString(
				new File(filepath),StandardCharsets.UTF_8);
		
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>() {
		});
		
		return data;

		}
	
	public String getScreenshot(String testcasesName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"\\reports"+testcasesName+".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+"\\reports"+testcasesName+".png";
	}
	


}
