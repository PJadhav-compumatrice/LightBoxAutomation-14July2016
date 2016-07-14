package RegressionSuite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC32ToTC36 extends CommonFunctions{
	@Test(priority = 54,description = "TC: Load lightbox URL ")
	  public void beforeTest() throws InterruptedException, IOException {
		    initialize();
			//	selectBrowser();	
		    File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			
		    driver.get("http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=c1e55202-663b-4ee6-b499-e797deb72d2d&lsessguid=c27800db-307d-4a66-9fdd-78d2b95c171b");
		    driver.manage().window().maximize();
			Thread.sleep(18000);
	  }
	
	  @Test(priority = 55, description = "TC 32: Verify SOIL DATA Tab")
	  public void verifyFilters() throws InterruptedException, IOException
	  {
		  System.out.println("Verify SOIL DATA Tab is displayed on top bar in right panel and when clicked, SOIL DATA records are displayed in table");
		  APP_LOGS.debug("Verify SOIL DATA tab is displayed on top bar in right panel and when clicked, SOIL DATA records are displayed in table \n");
		  
		  ////Clicking on PHYSICAL SETTINGS SubTab
		  System.out.println("Clicking on PHYSICAL SETTINGS Tab.");
		  APP_LOGS.debug("Clicking on PHYSICAL SETTINGS Tab.\n");
		  Thread.sleep(8000);
		  WebElement physical_settings_tab_ele = driver.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
		  HighlightElement(driver,physical_settings_tab_ele);
		  physical_settings_tab_ele.click();
		  Thread.sleep(3000);
		  System.out.println("Clicking on SOIL DATA Tab.");
		  APP_LOGS.debug("Clicking on SOIL DATA Tab.\n");
		  WebElement soil_data_subtab_ele = driver.findElement(By.xpath(OR.getProperty("soil_data_subtab")));
		  HighlightElement(driver,soil_data_subtab_ele);
		  Thread.sleep(5000);
		  soil_data_subtab_ele.click();
		  Thread.sleep(6000);
	  
		  //check whether tab title is displayed correctly or not.
		  WebElement soil_data_title = driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/h4"));
		  HighlightElement(driver,soil_data_title);
		  Thread.sleep(5000);
		
		  String soildata_title_text = soil_data_title.getText();
		  
		  if(soildata_title_text.trim().contains("SOIL DATA"))
		  {
			System.out.println("Title is displayed correctly.");
			System.out.println("Title text: "+soildata_title_text);
			System.out.println("Test case status: Pass \n");
		  }else
		  {
			  System.out.println("Title is not displayed correctly.");
			  System.out.println("Test case status: Fail \n");
		  }
	  
	  }
	  
	 //Verify Highlight Flag Filter on List view records.
	  @Test(priority = 56, description ="TC 33: Verify Highlight Filter on SOIL DATA")
	  public void verifyHighLightFlagFilter() throws InterruptedException
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
		  System.out.println("Clicking on SOIL DATA Tab.");
		  APP_LOGS.debug("Clicking on SOIL DATA Tab.\n");
		  WebElement soil_data_subtab_ele = driver.findElement(By.xpath(OR.getProperty("soil_data_subtab")));
		  HighlightElement(driver,soil_data_subtab_ele);
		  Thread.sleep(5000);
		  soil_data_subtab_ele.click();
		  Thread.sleep(6000);
		  
		    
        //Calculating number of records displayed in list view from table rows
		  
		  //verify any filter is been applied, if yes remove it
		  System.out.println("Verify any filter is been applied, if yes remove it.");
		 
		
		
		  try
		  {
			 WebElement flag_filter = driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[4]/a"));
			 HighlightElement(driver,flag_filter);
			 flag_filter.click();	
			 System.out.println("Flag Filter applied.");
			 Thread.sleep(5000);
		  }catch(Exception e)
		  {
			  //as no filter is applied, do nothing
			  System.out.println("No Flag Filter is removed.");
		  }
		  
		  //Check record count displayed at the top of table
		  WebElement record_count_note = driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[1]"));
		  HighlightElement(driver,record_count_note);
		  Thread.sleep(5000);
		  String note = record_count_note.getText();
		  String count[] = note.split("\\s+");
		  System.out.println("List view record count displayed at top of list view before any filter :"+count[0]);
		  
		  //Marking two record with flag green
		  System.out.println("Marking two record with flag green");
		  WebElement ele = driver.findElement(By.xpath(".//*[@id='toggleIconSoilFilter31cf733e-1333-4e79-abe0-5cab9cb67644']"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleFilterSoilDiv31cf733e-1333-4e79-abe0-5cab9cb67644']/div[4]/span[1]"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleIconSoilFilter758abc1f-7730-4c7d-ad11-d5ac40195604']"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleFilterSoilDiv758abc1f-7730-4c7d-ad11-d5ac40195604']/div[4]/span[1]"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		    
		  //Applying filter on Highlight flag filter
		  System.out.println("Applying filter on Highlight flag filter");
		  WebElement highlight_flagfilter_dropdown = driver.findElement(By.xpath(".//*[@id='flagSoil']/div/span/i"));
		  HighlightElement(driver,highlight_flagfilter_dropdown);
		 // Thread.sleep(5000);
		  highlight_flagfilter_dropdown.click();
		  Thread.sleep(6000);
		  
		  //selecting green flag
		  WebElement flag_green = driver.findElement(By.xpath(".//*[@id='SoilFlagFilter2']"));
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
			  HighlightElement(driver,driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[4]/a")));
			  driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[4]/a")).click();
			  Thread.sleep(6000);
		  }else
		  {
			  System.out.println("Count is wrong.");
			  System.out.println("Test case status: Fail");
		  }
		  
		  
		  driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[5]/a")).click();
		  Thread.sleep(5000);
	  }

	//Verify Slideout panel for table list view records. 
	  @Test(priority = 57, description = "TC 34: Verify Slideout Panel for SOIL DATA")
	  public void verifySlideOut() throws InterruptedException, IOException
	  {
		  System.out.println("Verify Slideout panel for table list view records. ");
		  APP_LOGS.debug("Verify Slideout panel for table list view records. \n");
		  
		 		  
		 
		  
		   Thread.sleep(5000);
		  //Clicking on first record to view slideout panel for that record.
		  System.out.println("Clicking on first record to view slideout panel for that record.");
		  APP_LOGS.debug("Clicking on first record to view slideout panel for that record.");
		  
		  WebElement first_record_listview_ele = driver.findElement(By.xpath(".//*[@id='soilDataRecord31cf733e-1333-4e79-abe0-5cab9cb67644']/td[2]"));
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
			  
			  WebElement soil_data_title = driver.findElement(By.xpath(".//*[@id='headerPanel']/div[1]/div/div/div[1]/b[2]"));
			  HighlightElement(driver,soil_data_title);
	
	  
}else
  {
	  System.out.println("Slideout panel is not displayed.");
	  APP_LOGS.debug("Slideout panel is not displayed.\n");
	}
		  
}
	  
	  //Verify popout link on slideout panel.
	  @Test(priority = 58, description = "TC 35: Verify Popout link for SOIL DATA")
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
	  

	  //Verify soil information popup link slideout panel
	  @Test(priority = 59, description = "TC 36: Verify Soil Information link on Slideout")
	  public void verifySoilInformation() throws InterruptedException
	  {
		  System.out.println("Verify soil information popup link slideout panel.");
		  APP_LOGS.debug("Verify soil information popup link slideout panel\n");
		  
		  System.out.println("Clicking on Soil Layer Information link.");
		  APP_LOGS.debug("Clicking on Soil Layer Information link.\n");
		  
		  
		  WebElement soil_layer_info_link = driver.findElement(By.xpath(".//*[@id='divaddinfo']/ul/div/div[9]/div/b/a"));
		  HighlightElement(driver,soil_layer_info_link);
		  Thread.sleep(5000);
		 
		  System.out.println("Link Text : "+soil_layer_info_link.getText());
		  
		  //clicking on link
		  System.out.println("Clicking on popout link.");
		  soil_layer_info_link.click();
		  Thread.sleep(7000);
		  System.out.println("Soil Information popup is displayed.");
	
		  //verify whether popup is displayed or nt
	/*	  if(driver.findElement(By.xpath("html/body/div[18]/div/div")).isDisplayed())
		  {
			  Thread.sleep(5000);
			  System.out.println("Soil Information popup is displayed.");
			  System.out.println("Information displayed on popup is : ");
			  System.out.println("Soil Information Table : "+driver.findElement(By.xpath(".//*[@id='soilInfo']/table/tbody/tr")).getText());
			  Thread.sleep(5000);
		  }else
		  {
			  System.out.println("Soil information popup is not displayed.");
			    
		  }
		*/  
		  
	  } 
	  
	  @Test(priority = 60, description = "TC : Close lbx url")
			public void CloseWindow()
			{
				driver.close();
			}
}
