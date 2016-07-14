package RegressionSuite;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC05 extends CommonFunctions {
	/* @Test(priority = 7, description = "TC: Load lightbox URL ")
	  public void beforeTest() throws InterruptedException, IOException {
		    initialize();
		//	selectBrowser();	
			 File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				driver = new ChromeDriver();
				
		    driver.get("http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=80bef1ce-2032-4070-91f7-bf7649486811&lsessguid=2360691e-4deb-4b5c-aae4-11ac0ce5b1ee");
		    driver.manage().window().maximize();
			Thread.sleep(10000);
	  }
	  */
	 @Test(priority = 8,description = "TC 05: Verify HIDE/SHOW list view functionality" )
	  public void listViewExpandCollapse() throws InterruptedException
	  {
		  System.out.println("Verify whether hide/show list view button is displayed and functioning correctly ");
		  APP_LOGS.debug("Verify whether hide/show list view button is displayed and functioning correctly\n");
		  Actions action = new Actions(driver);
		  WebElement hide_show_button = driver.findElement(By.xpath(OR.getProperty("hide_list_button")));
		  action.moveToElement(hide_show_button).build().perform();
		 
		  Thread.sleep(15000);
		  String toolTipText = hide_show_button.getAttribute("title");
		  System.out.println("Button Tooltip :"+toolTipText);
		  //clicking on hide list button
		  hide_show_button.click();
		  Thread.sleep(12000);
		  int flag = 0;
		  
		  System.out.println(""+driver.findElement(By.xpath(".//*[@id='sidebar']")).getAttribute("style"));
		  //verify whether list is not displayed
		  //check whether right panel style is hidden
		  if(driver.findElement(By.xpath(".//*[@id='sidebar']")).getAttribute("style").contains("display: none;"))
		  {
			  System.out.println("List view closed successfully.");
			  
		  }
		  else
		  {
			  System.out.println("List view is not closed.");
			  flag = 1;
		  }
		  Thread.sleep(6000);
		  //clicking on show list button
		  System.out.println("\nClicking on show list view button.");
		  driver.findElement(By.xpath(OR.getProperty("show_list_button"))).click();
		  Thread.sleep(13000);
		  
		  System.out.println(""+driver.findElement(By.xpath(".//*[@id='sidebar']")).getAttribute("style"));
		  //verify whether list is displayed
		  //check whether right panel style is visible
		  if(driver.findElement(By.xpath(".//*[@id='sidebar']")).getAttribute("style").contains("display: block;"))
		  {
			  System.out.println("List view opened successfully.");
			  flag = 0;
			 
		  }
		  else
		  {
			  System.out.println("List view is still closed.");
			  flag = 1;
			  
		  }
				  
		  if(flag == 0)
		  {
			  System.out.println("Test case status: Pass \n");
		  }else
		  {
			  System.out.println("Test case status: Fail \n");
		  }
	  }
	 
	/* @Test(priority = 9, description = "TC: Close lbx url")
		public void CloseWindow()
		{
			driver.close();
		}*/
}
