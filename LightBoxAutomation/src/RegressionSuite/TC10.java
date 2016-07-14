package RegressionSuite;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC10 extends CommonFunctions{
	/*@Test(priority = 16, description = "TC: Load lightbox URL ")
	  public void beforeTest() throws InterruptedException, IOException {
		    initialize();
//			selectBrowser();	
		    File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			
		    driver.get("http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=80bef1ce-2032-4070-91f7-bf7649486811&lsessguid=2360691e-4deb-4b5c-aae4-11ac0ce5b1ee");
		    driver.manage().window().maximize();
			Thread.sleep(10000);
	  }
*/
	 //Verify List width feature in lightbox
	  @Test(priority = 17, description="TC 10: Verify LIST WIDTH feature")
	  public void verifyListWidthFeature() throws InterruptedException
	  {
		  System.out.println("Verify List width feature in lightbox ");
		  APP_LOGS.debug("Verify List width feature in lightbox\n");
	  
		  //Clicking on width dropdown
		  System.out.println("Clicking on width dropdown.");
		  APP_LOGS.debug("Clicking on width dropdown.\n");
		  WebElement width_dropdown = driver.findElement(By.xpath(OR.getProperty("width_dropdown")));
		  HighlightElement(driver,width_dropdown);
		  width_dropdown.click();
		  Thread.sleep(5000);
		  
		  //Selecting 60% as width percentage for displaying list view.
		  System.out.println("Selecting 60% as width percentage for displaying list view.");
		  APP_LOGS.debug("Selecting 60% as width percentage for displaying list view.\n");
		  WebElement sixty_percent = driver.findElement(By.xpath(OR.getProperty("60pct")));
		  HighlightElement(driver,driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[2]/ul/li[8]")));
		  sixty_percent.click();
		  Thread.sleep(5000);
		  //Verify whether width is set for list view
		  System.out.println("Verifying whether width is set correct by checking style attribute");
		  APP_LOGS.debug("Verifying whether width is set correct by checking style attribute\n");
		  System.out.println(""+driver.findElement(By.xpath(OR.getProperty("side_bar_panel"))).getAttribute("style"));
		  if(driver.findElement(By.xpath(OR.getProperty("side_bar_panel"))).getAttribute("style").contains("824.6px"))
		  {
			System.out.println("Style attribute is set to width: 824.6px");
			 APP_LOGS.debug("Style attribute is set to width: 824.6px\n");
			System.out.println("Width is successfully set to 60%.");
			 APP_LOGS.debug("Width is successfully set to 60%.\n");
			System.out.println("Test case status: Pass\n");
			 APP_LOGS.debug("Test case status: Pass\n");
		  }else
		  {
			  System.out.println("Error...width is not set correctly.\n");
			  APP_LOGS.debug("Error...width is not set correctly.\n");
		  }
		  
		  //Selecting 55% as width percentage for displaying list view.
		  System.out.println("Selecting 55% as width percentage for displaying list view.");
		  APP_LOGS.debug("Selecting 55% as width percentage for displaying list view.\n");
		  WebElement fiftyfive_percent = driver.findElement(By.xpath(OR.getProperty("55pct")));
		  HighlightElement(driver,driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[2]/ul/li[7]")));
		  fiftyfive_percent.click();
		  Thread.sleep(5000);
		//Verify whether width is set for list view
		  System.out.println("Verifying whether width is set correct by checking style attribute");
		  APP_LOGS.debug("Verifying whether width is set correct by checking style attribute\n");
		  if(driver.findElement(By.xpath(OR.getProperty("side_bar_panel"))).getAttribute("style").contains("756.3px"))
		  {
			System.out.println("Style attribute is set to width: 756.3px");
			 APP_LOGS.debug("Style attribute is set to width: 756.3px\n");
			System.out.println("Width is successfully set to 55%.");
			 APP_LOGS.debug("Width is successfully set to 55%.\n");
			System.out.println("Test case status: Pass\n");
			 APP_LOGS.debug("Test case status: Pass\n");
		  }else
		  {
			  System.out.println("Error...width is not set correctly.\n");
			  APP_LOGS.debug("Error...width is not set correctly.\n");
		  }
		  
		  //Selecting 50% as width percentage for displaying list view.
		  System.out.println("Selecting 50% as width percentage for displaying list view.");
		  APP_LOGS.debug("Selecting 50% as width percentage for displaying list view.\n");
		  WebElement fifty_percent = driver.findElement(By.xpath(OR.getProperty("50pct")));
		  HighlightElement(driver,driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[2]/ul/li[6]")));
		  fifty_percent.click();
		  Thread.sleep(5000);
		//Verify whether width is set for list view
		  System.out.println("Verifying whether width is set correct by checking style attribute");
		  APP_LOGS.debug("Verifying whether width is set correct by checking style attribute\n");
		  if(driver.findElement(By.xpath(OR.getProperty("side_bar_panel"))).getAttribute("style").contains("688px"))
		  {
			System.out.println("Style attribute is set to width: 688px");
			 APP_LOGS.debug("Style attribute is set to width: 688px\n");
			System.out.println("Width is successfully set to 50%.");
			 APP_LOGS.debug("Width is successfully set to 50%.\n");
			System.out.println("Test case status: Pass\n");
			 APP_LOGS.debug("Test case status: Pass\n");
		  }else
		  {
			  System.out.println("Error...width is not set correctly.\n");
			  APP_LOGS.debug("Error...width is not set correctly.\n");
		  }
		  
		  //Selecting 45% as width percentage for displaying list view.
		  System.out.println("Selecting 45% as width percentage for displaying list view.");
		  APP_LOGS.debug("Selecting 45% as width percentage for displaying list view.\n");
		  WebElement fourtyfive_percent = driver.findElement(By.xpath(OR.getProperty("45pct")));
		  HighlightElement(driver,driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[2]/ul/li[5]")));
		  fourtyfive_percent.click();
		  Thread.sleep(5000);
		//Verify whether width is set for list view
		  System.out.println("Verifying whether width is set correct by checking style attribute");
		  APP_LOGS.debug("Verifying whether width is set correct by checking style attribute\n");
		  if(driver.findElement(By.xpath(OR.getProperty("side_bar_panel"))).getAttribute("style").contains("619.7px"))
		  {
			System.out.println("Style attribute is set to width: 619.7px");
			 APP_LOGS.debug("Style attribute is set to width: 619.7px\n");
			System.out.println("Width is successfully set to 45%.");
			 APP_LOGS.debug("Width is successfully set to 45%.\n");
			System.out.println("Test case status: Pass\n");
			 APP_LOGS.debug("Test case status: Pass\n");
		  }else
		  {
			  System.out.println("Error...width is not set correctly.\n");
			  APP_LOGS.debug("Error...width is not set correctly.\n");
		  }
		  
		  //Selecting 40% as width percentage for displaying list view.
		  System.out.println("Selecting 40% as width percentage for displaying list view.");
		  APP_LOGS.debug("Selecting 40% as width percentage for displaying list view.\n");
		  WebElement fourty_percent = driver.findElement(By.xpath(OR.getProperty("40pct")));
		  HighlightElement(driver,driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[2]/ul/li[4]")));
		  fourty_percent.click();
		  Thread.sleep(5000);
		//Verify whether width is set for list view
		  System.out.println("Verifying whether width is set correct by checking style attribute");
		  APP_LOGS.debug("Verifying whether width is set correct by checking style attribute\n");
		  if(driver.findElement(By.xpath(OR.getProperty("side_bar_panel"))).getAttribute("style").contains("551.4px"))
		  {
			System.out.println("Style attribute is set to width: 551.4px");
			 APP_LOGS.debug("Style attribute is set to width: 551.4px\n");
			System.out.println("Width is successfully set to 40%.");
			 APP_LOGS.debug("Width is successfully set to 40%.\n");
			System.out.println("Test case status: Pass\n");
			 APP_LOGS.debug("Test case status: Pass\n");
		  }else
		  {
			  System.out.println("Error...width is not set correctly.\n");
			  APP_LOGS.debug("Error...width is not set correctly.\n");
		  }
		  
		  //Selecting 35% as width percentage for displaying list view.
		  System.out.println("Selecting 35% as width percentage for displaying list view.");
		  APP_LOGS.debug("Selecting 35% as width percentage for displaying list view.\n");
		  WebElement thirtyfive_percent = driver.findElement(By.xpath(OR.getProperty("35pct")));
		  HighlightElement(driver,driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[2]/ul/li[3]")));
		  thirtyfive_percent.click();
		  Thread.sleep(5000);
		//Verify whether width is set for list view
		  System.out.println("Verifying whether width is set correct by checking style attribute");
		  APP_LOGS.debug("Verifying whether width is set correct by checking style attribute\n");
		  if(driver.findElement(By.xpath(OR.getProperty("side_bar_panel"))).getAttribute("style").contains("483.1px"))
		  {
			System.out.println("Style attribute is set to width: 483.1px");
			 APP_LOGS.debug("Style attribute is set to width: 483.1px\n");
			System.out.println("Width is successfully set to 35%.");
			 APP_LOGS.debug("Width is successfully set to 35%.\n");
			System.out.println("Test case status: Pass\n");
			 APP_LOGS.debug("Test case status: Pass\n");
		  }else
		  {
			  System.out.println("Error...width is not set correctly.\n");
			  APP_LOGS.debug("Error...width is not set correctly.\n");
		  }
		  
		  //Selecting 30% as width percentage for displaying list view.
		  System.out.println("Selecting 30% as width percentage for displaying list view.");
		  APP_LOGS.debug("Selecting 30% as width percentage for displaying list view.\n");
		  WebElement thirty_percent = driver.findElement(By.xpath(OR.getProperty("30pct")));
		  HighlightElement(driver,driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[2]/ul/li[2]")));
		  thirty_percent.click();
		  Thread.sleep(5000);
		//Verify whether width is set for list view
		  System.out.println("Verifying whether width is set correct by checking style attribute");
		  APP_LOGS.debug("Verifying whether width is set correct by checking style attribute\n");
		  if(driver.findElement(By.xpath(OR.getProperty("side_bar_panel"))).getAttribute("style").contains("414.8px"))
		  {
			System.out.println("Style attribute is set to width: 414.8px");
			 APP_LOGS.debug("Style attribute is set to width: 414.8px\n");
			System.out.println("Width is successfully set to 30%.");
			 APP_LOGS.debug("Width is successfully set to 30%.\n");
			System.out.println("Test case status: Pass\n");
			 APP_LOGS.debug("Test case status: Pass\n");
		  }else
		  {
			  System.out.println("Error...width is not set correctly.\n");
			  APP_LOGS.debug("Error...width is not set correctly.\n");
		  }
	  }
	  
	  @Test(priority = 18, description = "TC: Close lbx url")
		public void CloseWindow()
		{
			driver.close();
		}
}
