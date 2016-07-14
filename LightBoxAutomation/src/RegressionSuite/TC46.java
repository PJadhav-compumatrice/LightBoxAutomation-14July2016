package RegressionSuite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC46 extends CommonFunctions{
	@Test(priority = 77, description = "TC: Load lightbox URL")
	  public void beforeTest() throws InterruptedException, IOException {
		    initialize();
		//	selectBrowser();	
			//	selectBrowser();	
		    File file = new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		    driver.get("http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=80bef1ce-2032-4070-91f7-bf7649486811&lsessguid=2360691e-4deb-4b5c-aae4-11ac0ce5b1ee");
		    driver.manage().window().maximize();
			Thread.sleep(18000);
					
	  }
	
	 //Verify drawing tool gets opened when clicked on link or not.
	@Test(priority = 78, description = "TC 46: Verify Drawing Tool")
	  public void verifyAddRemoveColumnFilter() throws InterruptedException
	  {
		  System.out.println("Verify drawing tool gets opened when clicked on link or not.");
		  APP_LOGS.debug("Verify drawing tool gets opened when clicked on link or not.\n");
		  
		  //clicking on draw link
		  System.out.println("Clicking on Drawing Tool link.");
		  WebElement drawing_tool_link = driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[1]/li[1]/a"));
		  HighlightElement(driver,drawing_tool_link);
		  drawing_tool_link.click();
		  drawing_tool_link.click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(7000);
        
		  
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		  driver.switchTo().window(tabs2.get(1));
		    
		    //verify whether drawing tool is displayed or not.
		    System.out.println("Verify whether drawing tool is displayed or not.");
		    if(driver.getTitle().contains("EDR Imagery / Drawing Tool"))
		    {
		    	System.out.println("Webpage title matched!!!");
		    	System.out.println("Drawing Tool is displayed.");
		    	  	
		    	System.out.println("Test case status: Pass");
		    }
		    else
		    {
		    	System.out.println("Drawing Tool is not displayed.");
		    	System.out.println("Test case status: Fail");
		    }
		    
		    Thread.sleep(5000);
		    driver.close();
		
		    driver.switchTo().window(tabs2.get(0));
		    Thread.sleep(8000);  
		  
		  
		  
	  }
	  @Test(priority = 79, description = "TC : Close lbx url")
			public void CloseWindow()
			{
				driver.close();
			}
	  
}
