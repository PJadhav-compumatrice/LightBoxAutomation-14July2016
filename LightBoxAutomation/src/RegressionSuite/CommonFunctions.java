package RegressionSuite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CommonFunctions {
	public static WebDriver driver;
	public static Logger APP_LOGS = null;
	public static Properties OR	= null;
	
	public void selectBrowser() throws IOException
	{
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Enter browser name to run your script: ");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String browserName = bf.readLine();
		if(browserName.trim().equalsIgnoreCase("chrome"))
		{
			File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("ie"))
		{
			File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\IEDriverServer_x64_2.48.0//IEDriverServer.exe"); 
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			
		}
		else if(browserName.trim().equalsIgnoreCase("safari"))
		{
			
		}
		else if(browserName.trim().equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Please enter valid browser name!!!");
			selectBrowser();
		}
	}
	
	public void initialize() throws IOException
	{
		OR = new Properties();
		FileInputStream fil = null;
		fil = new FileInputStream(new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\src\\OR.properties"));
		OR.load(fil);
		APP_LOGS = Logger.getLogger("devpinoyLogger");
	
	}
	// Element highlighter code
	public static void HighlightElement(WebDriver driver, WebElement element) throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style',arguments[1]);", element,"border: 5px solid red;");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", element,"");
	   
	}
	
	public void removeSavedFilters() throws IOException
	{
		 //verify any filter is been applied, if yes remove it
		  System.out.println("Verify any filter is been applied, if yes remove it.");
		  try
		  {
			 WebElement db_filter = driver.findElement(By.xpath(OR.getProperty("db_filterby_link")));
			 HighlightElement(driver,db_filter);
			 db_filter.click();	
			 System.out.println("DB Filter removed.");
			 Thread.sleep(5000);
		  }catch(Exception e)
		  {
			  //as no filter is applied, do nothing
			  System.out.println("No DB Filter is applied.");
		  }
		  try
		  {
			 WebElement address_filter = driver.findElement(By.xpath(OR.getProperty("address_filterby_link")));
			 HighlightElement(driver,address_filter);
			 address_filter.click();
			 System.out.println("Address Filter removed.");
			 Thread.sleep(5000);
		  }catch(Exception e)
		  {
			  //as no filter is applied, do nothing
			  System.out.println("No Address Filter is applied.");
		  }
		  try
		  {
			 WebElement relElevation_filter = driver.findElement(By.xpath(OR.getProperty("relelev_filterby_link")));
			 HighlightElement(driver,relElevation_filter);
			 relElevation_filter.click();
			 System.out.println("Relative Elevation Filter removed.");
			 Thread.sleep(5000);
		  }catch(Exception e)
		  {
			  //as no filter is applied, do nothing
			  System.out.println("No Relative Filter is applied.");
		  }
		  try
		  {
			 WebElement dist_filter = driver.findElement(By.xpath(OR.getProperty("dist_filterby_link")));
			 HighlightElement(driver,dist_filter);
			 dist_filter.click();
			 System.out.println("Distance(ft) Filter removed.");
			 Thread.sleep(5000);
		  }catch(Exception e)
		  {
			  //as no filter is applied, do nothing
			  System.out.println("No Distance(ft) Filter is applied.");
		  }
		  try
		  {
			 WebElement dist_mile_filter = driver.findElement(By.xpath(OR.getProperty("dist_mile_filterby_link")));
			 HighlightElement(driver,dist_mile_filter);
			 dist_mile_filter.click();
			 System.out.println("Distance(ml) Filter applied.");
			 Thread.sleep(5000);
		  }catch(Exception e)
		  {
			  //as no filter is applied, do nothing
			  System.out.println("No Distance(ml) Filter is applied.");
		  }
		  try
		  {
			 WebElement flag_filter = driver.findElement(By.xpath(OR.getProperty("flag_filterby_link")));
			 HighlightElement(driver,flag_filter);
			 flag_filter.click();	
			 System.out.println("Flag Filter applied.");
			 Thread.sleep(5000);
		  }catch(Exception e)
		  {
			  //as no filter is applied, do nothing
			  System.out.println("No Flag Filter is applied.");
		  }
		  
	}
	}
