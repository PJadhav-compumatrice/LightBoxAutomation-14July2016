package RegressionSuite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC23ToTC26 extends CommonFunctions{

	@Test(priority = 41, description = "TC: Load lightbox URL ")
	  public void beforeTest() throws InterruptedException, IOException {
		    initialize();
			//	selectBrowser();	
		    File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			
		    driver.get("http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=80bef1ce-2032-4070-91f7-bf7649486811&lsessguid=2360691e-4deb-4b5c-aae4-11ac0ce5b1ee");
		    driver.manage().window().maximize();
			Thread.sleep(18000);
	  }
	
	  @Test(priority = 42, description = "TC 23: Verify WATER WELLS Tab")
	  public void verifyTitle() throws InterruptedException, IOException
	  {
		  System.out.println("Verify WATER WELLS Tab is displayed on top bar in right panel and when clicked, WATER WELLS records are displayed in table");
		  APP_LOGS.debug("Verify WATER WELLS tab is displayed on top bar in right panel and when clicked, WATER WELLS records are displayed in table \n");
		  
		  ////Clicking on PHYSICAL SETTINGS SubTab
		  System.out.println("Clicking on PHYSICAL SETTINGS Tab.");
		  APP_LOGS.debug("Clicking on PHYSICAL SETTINGS Tab.\n");
		  Thread.sleep(8000);
		  WebElement physical_settings_tab_ele = driver.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
		  HighlightElement(driver,physical_settings_tab_ele);
		  physical_settings_tab_ele.click();
		  Thread.sleep(3000);
		  System.out.println("Clicking on WATER WELLS Tab.");
		  APP_LOGS.debug("Clicking on WATER WELLS Tab.\n");
		  WebElement water_wells_subtab_ele = driver.findElement(By.xpath(OR.getProperty("water_wells_subtab")));
		  HighlightElement(driver,water_wells_subtab_ele);
		  Thread.sleep(5000);
		  water_wells_subtab_ele.click();
		  Thread.sleep(6000);
	  
		  //check whether tab title is displayed correctly or not.
		  WebElement soil_data_title = driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/h4"));
		  HighlightElement(driver,soil_data_title);
		  Thread.sleep(5000);
		
		  String waterdata_title_text = soil_data_title.getText();
		  
		  if(waterdata_title_text.trim().contains("WATER WELLS"))
		  {
			System.out.println("Title is displayed correctly.");
			System.out.println("Title text: "+waterdata_title_text);
			System.out.println("Test case status: Pass \n");
		  }else
		  {
			  System.out.println("Title is not displayed correctly.");
			  System.out.println("Test case status: Fail \n");
		  }
	  
	  }

	  //Verify Highlight Flag Filter on List view records.
	  @Test(priority = 43, description = "TC 24: Verify Highlight Filter on WATER WELLS")
	  public void verifyHighLightFlagFilter() throws InterruptedException, IOException
	  {
		  System.out.println("Verify Highlight Flag Filter on List view records. ");
		  APP_LOGS.debug("Verify Highlight Flag Filter on List view records.\n");
	  
		  ////Clicking on PHYSICAL SETTINGS SubTab
		  System.out.println("Clicking on PHYSICAL SETTINGS Tab.");
		  APP_LOGS.debug("Clicking on PHYSICAL SETTINGS Tab.\n");
		  Thread.sleep(8000);
		  WebElement physical_settings_tab_ele = driver.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
		  HighlightElement(driver,physical_settings_tab_ele);
		  physical_settings_tab_ele.click();
		  Thread.sleep(3000);
		  System.out.println("Clicking on WATER WELLS Tab.");
		  APP_LOGS.debug("Clicking on WATER WELLS Tab.\n");
		  WebElement water_data_subtab_ele = driver.findElement(By.xpath(OR.getProperty("water_wells_subtab")));
		  HighlightElement(driver,water_data_subtab_ele);
		  Thread.sleep(5000);
		  water_data_subtab_ele.click();
		  Thread.sleep(6000);
		  
		    
        //Calculating number of records displayed in list view from table rows
		  
		  //verify any filter is been applied, if yes remove it
		  //verify any filter is been applied, if yes remove it
		  System.out.println("Verify any filter is been applied, if yes remove it.");
		  try
		  {
			 WebElement db_filter = driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[3]/a[2]"));
			 HighlightElement(driver,db_filter);
			 db_filter.click();	
			 System.out.println("DB Filter removed.");
			 Thread.sleep(5000);
		  }catch(Exception e)
		  {
			  //as no filter is applied, do nothing
			  System.out.println("No DB Filter was applied.");
		  }
		 
		 
		 
		
		  try
		  {
			 WebElement flag_filter = driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[3]/a[1]"));
			 HighlightElement(driver,flag_filter);
			 flag_filter.click();	
			 System.out.println("Flag Filter applied.");
			 Thread.sleep(5000);
		  }catch(Exception e)
		  {
			  //as no filter is applied, do nothing
			  System.out.println("No Flag Filter was applied.");
		  }
		  
		  //Check record count displayed at the top of table
		  WebElement record_count_note = driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[1]"));
		  HighlightElement(driver,record_count_note);
		  Thread.sleep(5000);
		  String note = record_count_note.getText();
		  String count[] = note.split("\\s+");
		  System.out.println("List view record count displayed at top of list view before any filter :"+count[0]);
		  try
		  {
		  //Marking two record with flag green
		  System.out.println("Marking two record with flag green");
		  WebElement ele = driver.findElement(By.xpath(".//*[@id='toggleIconWaterWellFilter97f22f6a-54b8-45a3-9e46-bc21873e9bf3']"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleFilterWaterWellDiv97f22f6a-54b8-45a3-9e46-bc21873e9bf3']/div[4]/span[1]"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleIconWaterWellFilter9c950c86-4032-4ac7-983a-7e6a6fde08f5']"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleFilterWaterWellDiv9c950c86-4032-4ac7-983a-7e6a6fde08f5']/div[4]/span[1]"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		    
		  //Applying filter on Highlight flag filter
		  System.out.println("Applying filter on Highlight flag filter");
		  WebElement highlight_flagfilter_dropdown = driver.findElement(By.xpath(".//*[@id='FlagWaterWell']/div/span/i"));
		  HighlightElement(driver,highlight_flagfilter_dropdown);
		 // Thread.sleep(5000);
		  highlight_flagfilter_dropdown.click();
		  Thread.sleep(6000);
		  
		  //selecting green flag
		  WebElement flag_green = driver.findElement(By.xpath(".//*[@id='WellsFlagFilter2']"));
		  HighlightElement(driver,flag_green);
		  Thread.sleep(5000);
		  flag_green.click();
		  Thread.sleep(6000);
		  
		//Check record count displayed at the top of table
		  System.out.println("Check record count displayed at the top of table when filter is applied.");
		  record_count_note = driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[1]"));
		  HighlightElement(driver,record_count_note);
		  Thread.sleep(5000);
		  note = record_count_note.getText();
		  String count1[] = note.split("\\s+");
		  System.out.println("List view record count displayed at top of list view when flag filter is applied:"+count1[0]);
		  int c1 = Integer.parseInt(count[0]);
		  int c2 = Integer.parseInt(count1[0]);
		 
		  if((c1-c2)==2)
		  {
			  System.out.println("Count displayed at top is correct.");
			  System.out.println("Test case status: Pass");
			  Thread.sleep(5000);
			  //remove flag filter
			  HighlightElement(driver,driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[3]/a[1]")));
			  driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[3]/a[1]")).click();
			  Thread.sleep(6000);
		  }else
		  {
			  System.out.println("Count is wrong.");
			  System.out.println("Test case status: Fail");
		  }
		  
		  
		  driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[5]/a")).click();
		  Thread.sleep(5000);
	  
	  }catch(Exception e)
	  {
		  System.out.println(""+e.getMessage());
	  }

	  
}
	  
	//Verify Slideout panel for table list view records. 
	  @Test(priority = 44, description = "TC 25: Verify Slideout Panel for WATER WELLS")
	  public void verifySlideOut() throws InterruptedException, IOException
	  {
		  System.out.println("Verify Slideout panel for table list view records. ");
		  APP_LOGS.debug("Verify Slideout panel for table list view records. \n");
		  
		 		  
		  //Remove any filters if are.
		  removeSavedFilters();
		  
		   Thread.sleep(5000);
		  //Clicking on first record to view slideout panel for that record.
		  System.out.println("Clicking on first record to view slideout panel for that record.");
		  APP_LOGS.debug("Clicking on first record to view slideout panel for that record.");
		  
		  WebElement first_record_listview_ele = driver.findElement(By.xpath(".//*[@id='waterWellRecord97f22f6a-54b8-45a3-9e46-bc21873e9bf3']/td[3]"));
		  HighlightElement(driver,first_record_listview_ele);
		  Thread.sleep(5000);
		  first_record_listview_ele.click();
		  Thread.sleep(16000);
		  
		  //Verify whether slideout panel is displayed or not.
		  System.out.println("Verify whether slideout panel is displayed or not.");
		  APP_LOGS.debug("Verify whether slideout panel is displayed or not.\n");
		  
		  System.out.println(""+driver.findElement(By.xpath(OR.getProperty("slideout_panel"))).getAttribute("style"));
		  if(driver.findElement(By.xpath(OR.getProperty("slideout_panel"))).getAttribute("style").contains("display: block;"))
		  {
			  System.out.println("Slideout panel is displayed.");
			  APP_LOGS.debug("Slideout panel is displayed.\n");
			  //verify 
			  System.out.println("Verify slideout panel information");
			  APP_LOGS.debug("Verify slideout panel information.\n");
			  
			 
	  
}else
  {
	  System.out.println("Slideout panel is not displayed.");
	  APP_LOGS.debug("Slideout panel is not displayed.\n");
	}
		  
}
	  //Verify popout link on slideout panel.
	  @Test(priority = 45, description ="TC 26: Verify POPOUT link")
	  public void verifyPopoutLink() throws InterruptedException
	  {
		  System.out.println("Verify popout link on slideout panel.");
		  APP_LOGS.debug("Verify popout link on slideout panel. \n");
		  
		  System.out.println("Verify whether Popout link is displayed on slideout panel or not.");
		  APP_LOGS.debug("Verify whether Popout link is displayed on slideout panel or not. \n");
		  
		  WebElement popout_link = driver.findElement(By.xpath(OR.getProperty("popout_link")));
		  HighlightElement(driver,popout_link);
		  Thread.sleep(5000);
		 
		  System.out.println("Link Text : "+driver.findElement(By.xpath(OR.getProperty("popout_link"))).getText());
		  
		  //clicking on link
		  System.out.println("Clicking on popout link.");
		  popout_link.click();
		  Thread.sleep(15000);
		  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		  driver.switchTo().window(tabs2.get(1));
		    
		    //verify whether popout link is displayed or not.
		    System.out.println("Verify whether popout link is displayed or not.");
		    if(driver.getCurrentUrl().contains("propertydetails"))
		    {
		    	System.out.println("Proprty details page is displayed.");
		    	System.out.println("Test case status: Pass");
		    }
		    else
		    {
		    	System.out.println("Proprty details page is not displayed.");
		    	System.out.println("Test case status: Fail");
		    }
		    
		    Thread.sleep(5000);
		    driver.close();
		
		    driver.switchTo().window(tabs2.get(0));
		  
		  
		  
	  }
	  
	  @Test(priority = 46,description = "TC :Close lbx url")
			public void CloseWindow()
			{
				driver.close();
			}
}
