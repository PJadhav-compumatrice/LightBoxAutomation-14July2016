package RegressionSuite;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC18ToTC22 extends CommonFunctions {

	@Test(priority = 34, description = "TC: Load lightbox URL ")
	public void beforeTest() throws InterruptedException, IOException {
		initialize();
		// selectBrowser();
		File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();

		driver.get(
				"http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=80bef1ce-2032-4070-91f7-bf7649486811&lsessguid=2360691e-4deb-4b5c-aae4-11ac0ce5b1ee");
		driver.manage().window().maximize();
		Thread.sleep(15000);
	}

	// Verify ORPHANS tab is displayed on top bar in right panel and when
	// clicked, ORPHANS records are displayed in table
	@Test(priority = 35, description = "TC 18: Verify ORPHAN Tab")
	public void verifyTitle() throws InterruptedException, IOException {
		System.out.println(
				"Verify ORPHANS tab is displayed on top bar in right panel and when clicked, ORPHANS   records are displayed in table");
		APP_LOGS.debug(
				"Verify ORPHANS tab is displayed on top bar in right panel and when clicked, ORPHANS   records are displayed in table \n");

		// Clicking on ORPHANS SubTab
		System.out.println("Clicking on FINDINGS Tab.");
		APP_LOGS.debug("Clicking on FINDINGS Tab.\n");
		WebElement findings_tab_ele = driver.findElement(By.xpath(OR.getProperty("findings_tab")));
		HighlightElement(driver, findings_tab_ele);
		findings_tab_ele.click();
		Thread.sleep(8000);

		System.out.println("Clicking on ORPHANS Tab.");
		APP_LOGS.debug("Clicking on ORPHANS Tab.\n");
		WebElement orphans_subtab_ele = driver.findElement(By.xpath(OR.getProperty("orphans_subtab")));
		HighlightElement(driver, orphans_subtab_ele);
		Thread.sleep(8000);
		orphans_subtab_ele.click();
		Thread.sleep(9000);

		// check whether tab title is displayed correctly or not.
		WebElement orphans_title = driver.findElement(By.xpath(OR.getProperty("orphans_tab_title")));
		HighlightElement(driver, orphans_title);
		Thread.sleep(5000);

		String orphans_title_text = orphans_title.getText();

		if (orphans_title_text.trim().contains("ORPHANS")) {
			System.out.println("Title is displayed correctly.");
			System.out.println("Title text: " + orphans_title_text);
			System.out.println("Test case status: Pass \n");
		} else {
			System.out.println("Title is not displayed correctly.");
			System.out.println("Test case status: Fail \n");
		}

	}

	// Verify ORPHANS records count in list view and on map
	@Test(priority = 36, description = "TC 19: Verify Record count for ORPHANS")
	public void verifyORPHANRecordCount() throws InterruptedException {
		System.out.println("Verify ORPHANS records count in list view and on map ");
		APP_LOGS.debug("Verify ORPHANS records count in list view and on map\n");

		// Calculating number of records displayed in list view from table rows

		// verify any filter is been applied, if yes remove it
		try {
			WebElement db_filter = driver.findElement(By.xpath(OR.getProperty("db_filterby_link")));
			HighlightElement(driver, db_filter);
			db_filter.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
		}
		try {
			WebElement address_filter = driver.findElement(By.xpath(OR.getProperty("address_filterby_link")));
			HighlightElement(driver, address_filter);
			address_filter.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
		}
		try {
			WebElement relElevation_filter = driver.findElement(By.xpath(OR.getProperty("relelev_filterby_link")));
			HighlightElement(driver, relElevation_filter);
			relElevation_filter.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
		}
		try {
			WebElement dist_filter = driver.findElement(By.xpath(OR.getProperty("dist_filterby_link")));
			HighlightElement(driver, dist_filter);
			dist_filter.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
		}
		try {
			WebElement dist_mile_filter = driver.findElement(By.xpath(OR.getProperty("dist_mile_filterby_link")));
			HighlightElement(driver, dist_mile_filter);
			dist_mile_filter.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
		}
		try {
			WebElement flag_filter = driver.findElement(By.xpath(OR.getProperty("flag_filterby_link")));
			HighlightElement(driver, flag_filter);
			flag_filter.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
		}

		// Check record count displayed at the top of table
		WebElement record_count_note = driver.findElement(By.xpath(OR.getProperty("records_count_at_top")));
		HighlightElement(driver, record_count_note);
		Thread.sleep(5000);
		String note = record_count_note.getText();
		String count[] = note.split("\\s+");
		System.out.println("List view record count displayed at top of list view :" + count[0]);

	}

	// Verify column adjustment feature for table list view for ORPHANS.
	@Test(priority = 37, description = "TC 20: Verify Add/Remove Column Feature")
	public void verifyColumnAdjustmentFeature() throws InterruptedException {
		Thread.sleep(7000);

		// Verify columns displayed in table
		System.out.println("Verify columns displayed in table");
		APP_LOGS.debug("Verify columns displayed in table \n");

		System.out.println("Displayed columns are as following: ");
		List<WebElement> orphan_column_list = driver.findElements(By.xpath(OR.getProperty("orphan_columns_list")));
		for (WebElement ele : orphan_column_list) {
			if (ele.getAttribute("style").contains("width: 0px;")) {
				// System.out.println(""+ele.getText()+" column is not
				// displayed.");

			} else {
				System.out.println("" + ele.getText() + " column is displayed.");
			}
		}

		System.out.println("Check whether Site Name column is displayed or not.");
		try {
			WebElement sitename_column = driver.findElement(By.xpath(OR.getProperty("sitename_column")));
			if (sitename_column.getAttribute("style").contains("width: 0px;")) {
				System.out.println("Site Name Column is not displayed.");
				System.out.println("Checking checkbox for Site Name Column to check checkbox for Site Name column");

				Thread.sleep(6000);

				// clicking on columns dropdown
				WebElement column_dropdown_ele = driver
						.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div/div/span/i"));
				HighlightElement(driver, column_dropdown_ele);
				Thread.sleep(5000);
				column_dropdown_ele.click();
				Thread.sleep(6000);

				WebElement sitename_column_chckbx = driver
						.findElement(By.xpath(OR.getProperty("orphan_site_name_checkbox")));
				HighlightElement(driver, sitename_column_chckbx);
				Thread.sleep(5000);
				sitename_column_chckbx.click();
				Thread.sleep(6000);

				// clicking outside of window
				driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
				Thread.sleep(5000);

				// verify whether Site Name column is displayed now or not
				if (sitename_column.getAttribute("style").contains("width: 0px;")) {
					System.out.println("Site Name Column is not displayed");
					System.out.println("Test case status: Fail \n");
				} else {
					System.out.println("Site Name Column is now displayed");
					System.out.println("Width : " + sitename_column.getAttribute("style"));
					System.out.println("Test case status: Pass\n");

					System.out.println(
							"Unchecking checknbox again to verify whether Site Name column gets removed or not. ");

					// clicking on columns dropdown
					// clicking on columns dropdown

					HighlightElement(driver, column_dropdown_ele);
					Thread.sleep(5000);
					column_dropdown_ele.click();
					Thread.sleep(6000);

					HighlightElement(driver, sitename_column_chckbx);
					Thread.sleep(5000);
					sitename_column_chckbx.click();
					Thread.sleep(6000);

					// clcking outside of window
					driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
					Thread.sleep(5000);

					// verify whether DB column is removed now or not
					if (sitename_column.getAttribute("style").contains("width: 0px;")) {
						System.out.println("Site Name Column is not displayed");
						System.out.println("Test case status: Pass \n");
					} else {
						System.out.println("Site Name Column is displayed");
						System.out.println("Width : " + sitename_column.getAttribute("style"));
						System.out.println("Test case status: Fail\n");
					}
				}
			} else {
				System.out.println("Site Name Column is displayed.");
				System.out.println("Checking checkbox for Site Name Column to uncheck Site Name column checkbox.");
				Thread.sleep(6000);
				// clicking on columns dropdown
				WebElement column_dropdown_ele = driver
						.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div/div/span/i"));
				HighlightElement(driver, column_dropdown_ele);
				Thread.sleep(5000);
				column_dropdown_ele.click();
				Thread.sleep(6000);

				WebElement sitename_column_chckbx = driver
						.findElement(By.xpath(OR.getProperty("orphan_site_name_checkbox")));
				HighlightElement(driver, sitename_column_chckbx);
				Thread.sleep(5000);
				sitename_column_chckbx.click();
				Thread.sleep(6000);

				// clicking outside of window
				driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
				Thread.sleep(5000);
				// verify whether Site Name column is removed or not
				if (sitename_column.getAttribute("style").contains("width: 0px;")) {
					System.out.println("Site Name Column is not displayed");
					System.out.println("Test case status: Pass\n");

					System.out
							.println("Checking checknbox again to verify whether Site Name column gets added or not. ");

					// clicking on columns dropdown

					HighlightElement(driver, column_dropdown_ele);
					Thread.sleep(5000);
					column_dropdown_ele.click();
					Thread.sleep(6000);

					HighlightElement(driver, sitename_column_chckbx);
					Thread.sleep(5000);
					sitename_column_chckbx.click();
					Thread.sleep(6000);

					// clicking outside of window
					driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
					Thread.sleep(5000);

					// verify whether Site Name column is displayed now or not
					if (sitename_column.getAttribute("style").contains("width: 0px;")) {
						System.out.println("Site Name Column is not displayed");
						System.out.println("Test case status: Fail \n");
					} else {
						System.out.println("Site Name Column is displayed");
						System.out.println("Width : " + sitename_column.getAttribute("style"));
						System.out.println("Test case status: Pass\n");
					}
				} else {
					System.out.println("Site Name Column is still displayed");
					System.out.println("Width : " + sitename_column.getAttribute("style"));
					System.out.println("Test case status: Fail\n");

				}
			}

		} catch (Exception e) {

		}
	}

	// Verify Slideout panel for table list view records.
	@Test(priority = 38, description = "TC 21: Verify Slideout Panel for ORPHANS")
	public void verifyHighlightFilter() throws InterruptedException {
		 System.out.println("Verify Highlight Flag Filter on List view records.");
		  APP_LOGS.debug("Verify Highlight Flag Filter on List view records.\n");
	      Thread.sleep(7000);
		  //Clicking on ORPHANS SubTab
		  System.out.println("Clicking on FINDINGS Tab.");
		  APP_LOGS.debug("Clicking on FINDINGS Tab.\n");
		  WebElement findings_tab_ele = driver.findElement(By.xpath(OR.getProperty("findings_tab")));
		  HighlightElement(driver,findings_tab_ele);
		  findings_tab_ele.click();
		  Thread.sleep(10000);
		  
		  System.out.println("Clicking on ORPHANS Tab.");
		  APP_LOGS.debug("Clicking on ORPHANS Tab.\n");
		  WebElement orphans_subtab_ele = driver.findElement(By.xpath(OR.getProperty("orphans_subtab")));
		  HighlightElement(driver,orphans_subtab_ele);
		  Thread.sleep(8000);
		  orphans_subtab_ele.click();
		  Thread.sleep(10000);
		  
		  //verify any filter is been applied, if yes remove it
		  System.out.println("Verify any filter is been applied, if yes remove it.");
		  Thread.sleep(10000);
		  /*try
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
			  System.out.println("No Distance(ml) Filter is removed.");
		  }*/
		
		  try
		  {
			 System.out.println("1");
			 WebElement flag_filter = driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[2]/a/i"));
			 if(flag_filter.isDisplayed())
			 {
			 HighlightElement(driver,flag_filter);
			 System.out.println("2");
			 flag_filter.click();	
			 System.out.println("Flag Filter applied.");
			 Thread.sleep(7000);
			 }else
			 {
				 System.out.println("No Flag Filter is removed.");
			 }
		  }catch(Exception e)
		  {
			  //as no filter is applied, do nothing
			  System.out.println(""+e.getMessage());
			  System.out.println("No Flag Filter is removed.");
		  }
		  
		  //Check record count displayed at the top of table
		  WebElement record_count_note = driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div/span[1]"));
		  HighlightElement(driver,record_count_note);
		  Thread.sleep(5000);
		  String note = record_count_note.getText();
		  String count[] = note.split("\\s+");
		  System.out.println("List view record count displayed at top of list view before any filter :"+count[0]);
		  
		  //Marking two records with flag green
		  System.out.println("Marking two record with flag green");
		  WebElement ele = driver.findElement(By.xpath(".//*[@id='toggleIconOrphanFilter4df1ec3f-f691-42de-9c88-61acd4df6c26']"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleFilterOrphanDiv4df1ec3f-f691-42de-9c88-61acd4df6c26']/div[4]/span[1]"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleIconOrphanFilter8933a6f6-cc94-40cd-b3cd-47f0145646c0']"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		  
		  ele = driver.findElement(By.xpath(".//*[@id='toggleFilterOrphanDiv8933a6f6-cc94-40cd-b3cd-47f0145646c0']/div[4]/span[1]"));
		  HighlightElement(driver,ele);
		  ele.click();
		  Thread.sleep(4000);
		    
		  //Applying filter on Highlight flag filter
		  System.out.println("Applying filter on Highlight flag filter");
		  WebElement highlight_flagfilter_dropdown = driver.findElement(By.xpath(".//*[@id='flagOrphan']/div/span/i"));
		  HighlightElement(driver,highlight_flagfilter_dropdown);
		  // Thread.sleep(5000);
		  highlight_flagfilter_dropdown.click();
		  Thread.sleep(6000);
		  
		  //selecting green flag
		  WebElement flag_green = driver.findElement(By.xpath(".//*[@id='OrphansFlagFilter2']"));
		  HighlightElement(driver,flag_green);
		  Thread.sleep(5000);
		  flag_green.click();
		  Thread.sleep(6000);
		  
		//Check record count displayed at the top of table
		  System.out.println("Check record count displayed at the top of table when filter is applied.");
		  record_count_note = driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div/span[1]"));
		  HighlightElement(driver,record_count_note);
		  Thread.sleep(5000);
		  note = record_count_note.getText();
		  System.out.println(""+note);
		  String count1[] = note.split("\\s+");
		  System.out.println("List view record count displayed at top of list view when flag filter is applied:"+count1[0]);
		  int c1 = Integer.parseInt(count[0]);
		  int c2 = Integer.parseInt(count1[0]);
		 
		  if((c1-c2)==2)
		  {
			  System.out.println("Count displayed at top is correct.");
			  System.out.println("Test case status: Pass");
		  }else
		  {
			  System.out.println("Count is wrong.");
			  System.out.println("Test case status: Fail");
		  }
		  

	}

	// Verify Slideout panel for table list view records.
	@Test(priority = 39, description = "TC 22: Verify Slideout panel for ORPHANS")
	public void verifySlideout() {
		System.out.println("Verify Slideout panel for table list view records. ");
		APP_LOGS.debug("Verify Slideout panel for table list view records. \n");

	}

	@Test(priority = 40, description = "TC :Close lbx url")
	public void CloseWindow() {
		driver.close();
	}
}
