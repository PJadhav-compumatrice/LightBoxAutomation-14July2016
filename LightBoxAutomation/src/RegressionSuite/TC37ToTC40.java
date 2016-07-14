package RegressionSuite;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC37ToTC40 extends CommonFunctions{

	@Test(priority = 61,description = "TC: Load lightbox URL ")
	  public void beforeTest() throws InterruptedException, IOException {
		    initialize();
			//	selectBrowser();	
		    File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			
		    driver.get("http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=ccc9b265-ec91-4c09-baed-6a00367fae39&lsessguid=f2a67e05-9af2-4a2d-9409-686ef35529b8");
		    driver.manage().window().maximize();
			Thread.sleep(18000);
	  }
	  @Test(priority = 62, description = "TC 37: Verify OTHER Tab")
	  public void verifyOTHERDataTab() throws InterruptedException, IOException
	  {
		  System.out.println("Verify OTHER Tab is displayed on top bar in right panel and when clicked, SOIL DATA records are displayed in table");
		  APP_LOGS.debug("Verify OTHER tab is displayed on top bar in right panel and when clicked, SOIL DATA records are displayed in table \n");
		  
		  ////Clicking on OTHER SubTab
		  System.out.println("Clicking on OTHER Tab.");
		  APP_LOGS.debug("Clicking on OTHER Tab.\n");
		  WebElement other_tab_ele = driver.findElement(By.xpath(OR.getProperty("other_tab")));
		  HighlightElement(driver,other_tab_ele);
		  driver.findElement(By.xpath(OR.getProperty("other_tab"))).click();
		  Thread.sleep(3000);
		  System.out.println("Clicking on BUILDING PERMITS Tab.");
		  APP_LOGS.debug("Clicking on BUILDING PERMITS Tab.\n");
		  WebElement building_permits_subtab_ele = driver.findElement(By.xpath(OR.getProperty("building_permits_subtab")));
		  HighlightElement(driver,building_permits_subtab_ele);
		  Thread.sleep(5000);
		  building_permits_subtab_ele.click();
		  Thread.sleep(6000);
	  
		  //check whether tab title is displayed correctly or not.
		  WebElement soil_data_title = driver.findElement(By.xpath(".//*[@id='sidebar']/div[3]/div[1]/div/div/h4"));
		  HighlightElement(driver,soil_data_title);
		  Thread.sleep(5000);
		
		  String soildata_title_text = soil_data_title.getText();
		  
		  if(soildata_title_text.trim().contains("BUILDING PERMITS"))
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
	  @Test(priority = 63, description = "TC 38: Verify Hightlight Filter on OTHER ")
	  public void verifyHighLightFlagFilter() throws InterruptedException
	  {
		  System.out.println("Verify Highlight Flag Filter on List view records. ");
		  APP_LOGS.debug("Verify Highlight Flag Filter on List view records.\n");
	  
		  ////Clicking on OTHER SubTab
		  System.out.println("Clicking on OTHER Tab.");
		  APP_LOGS.debug("Clicking on OTHER Tab.\n");
		  WebElement other_tab_ele = driver.findElement(By.xpath(OR.getProperty("other_tab")));
		  HighlightElement(driver,other_tab_ele);
		  driver.findElement(By.xpath(OR.getProperty("other_tab"))).click();
		  Thread.sleep(3000);
		  System.out.println("Clicking on BUILDING PERMITS Tab.");
		  APP_LOGS.debug("Clicking on BUILDING PERMITS Tab.\n");
		  WebElement building_permits_subtab_ele = driver.findElement(By.xpath(OR.getProperty("building_permits_subtab")));
		  HighlightElement(driver,building_permits_subtab_ele);
		  Thread.sleep(5000);
		  building_permits_subtab_ele.click();
		  Thread.sleep(6000);
		  
		    
        //Calculating number of records displayed in list view from table rows
		  
		  //verify any filter is been applied, if yes remove it
		  System.out.println("Verify any filter is been applied, if yes remove it.");
		
		  
		  try
		  {
			 WebElement flag_filter = driver.findElement(By.xpath(".//*[@id='sidebar']/div[3]/div[1]/div/div/span[2]/a"));
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
		  WebElement record_count_note = driver.findElement(By.xpath(".//*[@id='sidebar']/div[3]/div[1]/div/div/span[1]"));
		  HighlightElement(driver,record_count_note);
		  Thread.sleep(5000);
		  String note = record_count_note.getText();
		  String count[] = note.split("\\s+");
		  System.out.println("List view record count displayed at top of list view before any filter :"+count[0]);
		  
		  //Marking two record with flag green
		  System.out.println("Marking two record with flag green");
		  WebElement ele = driver.findElement(By.xpath(".//*[@id='toggleIconBuldingFilter33932285-b3a5-4948-877a-363e5c52a7f9']"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleFilterBuldingDiv33932285-b3a5-4948-877a-363e5c52a7f9']/div[4]/span[1]"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleIconBuldingFilter9506f3ed-03c8-4ff4-ab73-3e6489f0d855']"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleFilterBuldingDiv9506f3ed-03c8-4ff4-ab73-3e6489f0d855']/div[4]/span[1]"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		    
		  //Applying filter on Highlight flag filter
		  System.out.println("Applying filter on Highlight flag filter");
		  WebElement highlight_flagfilter_dropdown = driver.findElement(By.xpath(".//*[@id='flagBuildPerm']/div/span/i"));
		  HighlightElement(driver,highlight_flagfilter_dropdown);
		 // Thread.sleep(5000);
		  highlight_flagfilter_dropdown.click();
		  Thread.sleep(6000);
		  
		  //selecting green flag
		  WebElement flag_green = driver.findElement(By.xpath(".//*[@id='BuildingPermitFlagFilter2']"));
		  HighlightElement(driver,flag_green);
		  Thread.sleep(5000);
		  flag_green.click();
		  Thread.sleep(6000);
		  
		//Check record count displayed at the top of table
		  System.out.println("Check record count displayed at the top of table when filter is applied.");
		  record_count_note = driver.findElement(By.xpath(".//*[@id='sidebar']/div[3]/div[1]/div/div/span[1]"));
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
			  System.out.println("Test case status: Pass \n");
		  }else
		  {
			  System.out.println("Count is wrong.");
			  System.out.println("Test case status: Fail \n");
		  }
		  
		  
		  driver.findElement(By.xpath(".//*[@id='sidebar']/div[3]/div[1]/div/div/span[2]/a")).click();
		  Thread.sleep(5000);
	  }

	  
  	//Verify Slideout panel for table list view records. 
	  @Test(priority = 64, description = "TC 39: Verify Slideout panel for OTHER ")
	  public void verifySlideOut() throws InterruptedException, IOException
	  {
		  System.out.println("Verify Slideout panel for table list view records. ");
		  APP_LOGS.debug("Verify Slideout panel for table list view records. \n");
		  
		
		    Thread.sleep(5000);
		    
		  //Clicking on first record to view slideout panel for that record.
		  System.out.println("Clicking on first record to view slideout panel for that record.");
		  APP_LOGS.debug("Clicking on first record to view slideout panel for that record.");
		  
		  WebElement first_record_listview_ele = driver.findElement(By.xpath(".//*[@id='buldingRecord33932285-b3a5-4948-877a-363e5c52a7f9']/td[3]"));
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
			 			  
			  System.out.println("Verify slideout panel has correct site information as on list view record i.e. SITE NAME and ADDRESS information.");
			  APP_LOGS.debug("Verify slideout panel has correct site information as on list view record i.e. SITE NAME and ADDRESS information.\n");
			  
			  WebElement address_data = driver.findElement(By.xpath(".//*[@id='buldingRecord33932285-b3a5-4948-877a-363e5c52a7f9']/td[3]"));
			  HighlightElement(driver,address_data);
			  Thread.sleep(5000);
			  WebElement city_data = driver.findElement(By.xpath(".//*[@id='buldingRecord33932285-b3a5-4948-877a-363e5c52a7f9']/td[4]"));
			  HighlightElement(driver,address_data);
			  Thread.sleep(5000);
			  System.out.println("Address :"+address_data.getText());
			  APP_LOGS.debug("Address :"+address_data.getText()+"\n");
			  //  System.out.println("City :"+city_data.getText());
			 // APP_LOGS.debug("City :"+city_data.getText()+"\n");
			  //System.out.println("\n");
			  
			  System.out.println("Information on Slideout Panel :");
			  APP_LOGS.debug("Information on Slideout Panel : \n");
			  WebElement slideout_panel_info = driver.findElement(By.xpath(".//*[@id='headerPanel']/div[1]/div/div/div[1]/b[1]/span[1]"));
			  HighlightElement(driver,slideout_panel_info);
			  Thread.sleep(5000);
			  
			  System.out.println(""+slideout_panel_info.getText().trim());
			  APP_LOGS.debug(""+slideout_panel_info.getText().trim()+"\n");
			  Thread.sleep(5000);
			  System.out.println("\n");
			  int flag = 0;
			  String info[] = slideout_panel_info.getText().split("\\s+");
			  if(address_data.getText().trim().contains(info[0].trim()))
			  {
				System.out.println("ADDRESS matched correctly.");  
				APP_LOGS.debug("ADDRESS matched correctly.");
			  }else
			  {
				  flag = 1;
				  System.out.println("ADDRESS do not match!");
				  APP_LOGS.debug("ADDRESS do not match!");
			  }
			  
					  
			  if(flag == 0)
			  {
				  System.out.println("Address is displayed correct.");
				  APP_LOGS.debug("Address is displayed correct.");
				  System.out.println("Test case status: Pass \n");
				  APP_LOGS.debug("Test case status: Pass \n");
			  }
			  else
			  {
				  System.out.println("Error...address do not match.");
				  APP_LOGS.debug("Error...address do not match.");
				  System.out.println("Test case status: Fail\n");
				  APP_LOGS.debug("Test case status: Fail\n");
			  }
		  
		  
  }else
  {
	  System.out.println("Slideout panel is not displayed.");
	  APP_LOGS.debug("Slideout panel is not displayed.\n");
	}
		  
}

	  @Test(priority = 65, description = "TC 40: Verify DIST/DIR link on Slideout ")
	  public void verifyDistDirLink() throws InterruptedException, IOException
	  {
		  System.out.println("VCheck DIST/DIR info is displayed or not.");
		  APP_LOGS.debug("Check DIST/DIR info is displayed or not. \n");
		  
		  WebElement dist_dir_link = driver.findElement(By.xpath(".//*[@id='headerPanel']/div[1]/div/div/div[2]/div/div[2]/a/span[2]"));
		  HighlightElement(driver,dist_dir_link);
		  Thread.sleep(5000);
		  dist_dir_link.click();
		  Thread.sleep(16000);
		  
		  System.out.println("Check DIST/DIR info is displayed or not.");
		  if(driver.findElement(By.xpath(".//*[@id='expandDetails']")).getAttribute("class").contains("bg-detail-blue"))
		  {
			  System.out.println("Link text changed to : "+dist_dir_link.getText());
			  System.out.println("DIST/DIR information is displayed on screen.");
			 System.out.println("Test case status: Pass \n");
		  }else{
			  System.out.println("DIST/DIR information is not displayed on screen.");
				 System.out.println("Test case status: Fail \n");
		  }
	  
		 
	  
	  }  
	  
	  @Test(priority = 66, description = "TC : Close lbx url")
		public void CloseWindow()
		{
			driver.close();
		}  
	  
}
