package RegressionSuite;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC06ToTC09 extends CommonFunctions{
/*	@Test(priority = 10, description = "TC: Load lightbox URL ")
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
	 //Verify whether all tabs are displayed in right panel list view
	 //Verify SUMMARY TAB is displayed or not.
	  @Test(priority = 11, description="TC 06: Verify SUMMARY TAB")
	  public void verifySummaryTab() throws InterruptedException
	  {
		  System.out.println("Verify SUMMARY Tab is displayed in right panel ");
		  APP_LOGS.debug("Verify SUMMARY Tab is displayed in right panel\n");
		  
		  System.out.println("Clicking on SUMMARY Tab.");
		  APP_LOGS.debug("Clicking on SUMMARY Tab.\n");
		  try
		  {
		  WebElement summary_tab_ele = driver.findElement(By.xpath(OR.getProperty("summary_tab")));
		  System.out.println("Tab name :"+summary_tab_ele.getText().trim());
		  APP_LOGS.debug("Tab name :"+summary_tab_ele.getText().trim()+"\n");
		  HighlightElement(driver,summary_tab_ele);
		  driver.findElement(By.xpath(OR.getProperty("summary_tab"))).click();
		  Thread.sleep(3000);
		  }
		  catch(Exception e)
		  {
			  System.out.println("Error while clicking SUMMARY Tab");
		  }
	  
	  }
	  
	//Verify FINDINGS TAB is displayed or not.
	  @Test(priority = 12, description="TC 07: Verify FINDINGS Tab")
	  public void verifyFINDINGSTab() throws InterruptedException
	  {
		  System.out.println("Verify FINDINGS Tab is displayed in right panel ");
		  APP_LOGS.debug("Verify FINDINGS Tab is displayed in right panel\n");
		  
		  System.out.println("Clicking on FINDINGS Tab.");
		  APP_LOGS.debug("Clicking on FINDINGS Tab.\n");
		  try
		  {
		  WebElement findings_tab_ele = driver.findElement(By.xpath(OR.getProperty("findings_tab")));
		  System.out.println("Tab name :"+findings_tab_ele.getText().trim());
		  APP_LOGS.debug("Tab name :"+findings_tab_ele.getText().trim()+"\n");
		  HighlightElement(driver,findings_tab_ele);
		  driver.findElement(By.xpath(OR.getProperty("findings_tab"))).click();
		  Thread.sleep(3000);
		  }
		  catch(Exception e)
		  {
			  System.out.println("Error while clicking FINDINGS Tab");
		  }
		  
		  try
		  {
		  WebElement map_findings_subtab_ele = driver.findElement(By.xpath(OR.getProperty("map_finding_subtab")));
		  System.out.println("Sub Tab name :"+map_findings_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+map_findings_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,map_findings_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...MAP FINDINGS Tab is not present");
		  }
	  
		  try
		  {
		  WebElement orphans_subtab_ele = driver.findElement(By.xpath(OR.getProperty("orphans_subtab")));
		  System.out.println("Sub Tab name :"+orphans_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+orphans_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,orphans_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...ORPHANS Tab is not present");
		  }
	  }
	  
	//Verify PHYSICAL SETTINGS TAB is displayed or not.
	  @Test(priority = 13, description="TC 08: Verify PHYSICAL SETTINGS Tab")
	  public void verifyPHYSICALSETTINGSTab() throws InterruptedException
	  {
		  System.out.println("Verify PHYSICAL SETTINGS Tab is displayed in right panel ");
		  APP_LOGS.debug("Verify PHYSICAL SETTINGS Tab is displayed in right panel\n");
		  
		  System.out.println("Clicking on PHYSICAL SETTINGS Tab.");
		  APP_LOGS.debug("Clicking on PHYSICAL SETTINGS Tab.\n");
		  try
		  {
		  WebElement physical_settings_tab_ele = driver.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
		  System.out.println("Tab name :"+physical_settings_tab_ele.getText().trim());
		  APP_LOGS.debug("Tab name :"+physical_settings_tab_ele.getText().trim()+"\n");
		  HighlightElement(driver,physical_settings_tab_ele);
		  driver.findElement(By.xpath(OR.getProperty("physical_settings_tab"))).click();
		  Thread.sleep(3000);
		  }
		  catch(Exception e)
		  {
			  System.out.println("Error while clicking PHYSICAL SETTINGS Tab");
		  }
		  
		  try
		  {
		  WebElement aquiflow_subtab_ele = driver.findElement(By.xpath(OR.getProperty("aquiflow_subtab")));
		  System.out.println("Sub Tab name :"+aquiflow_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+aquiflow_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,aquiflow_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...AQUIFLOW Tab is not present");
		  }
	  
		  try
		  {
		  WebElement water_wells_subtab_ele = driver.findElement(By.xpath(OR.getProperty("water_wells_subtab")));
		  System.out.println("Sub Tab name :"+water_wells_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+water_wells_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,water_wells_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...WATER WELLS Tab is not present");
		  }
		  
		  try
		  {
		  WebElement oilgas_wells_subtab_ele = driver.findElement(By.xpath(OR.getProperty("oilgas_wells_subtab")));
		  System.out.println("Sub Tab name :"+oilgas_wells_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+oilgas_wells_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,oilgas_wells_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...OIL&GAS WELLS Tab is not present");
		  }
		  
		  try
		  {
		  WebElement soildata_subtab_ele = driver.findElement(By.xpath(OR.getProperty("soil_data_subtab")));
		  System.out.println("Sub Tab name :"+soildata_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+soildata_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,soildata_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...SOIL DATA Tab is not present");
		  }
	  }  
	//Verify OTHER TAB is displayed or not.
	  @Test(priority = 14, description="TC 09: Verify OTHER Tab")
	  public void verifyOTHERTab() throws InterruptedException
	  {
		  System.out.println("Verify OTHER Tab is displayed in right panel ");
		  APP_LOGS.debug("Verify OTHER Tab is displayed in right panel\n");
		  
		  System.out.println("Clicking on OTHER Tab.");
		  APP_LOGS.debug("Clicking on OTHER Tab.\n");
		  try
		  {
		  WebElement other_tab_ele = driver.findElement(By.xpath(OR.getProperty("other_tab")));
		  System.out.println("Tab name :"+other_tab_ele.getText().trim());
		  APP_LOGS.debug("Tab name :"+other_tab_ele.getText().trim()+"\n");
		  HighlightElement(driver,other_tab_ele);
		  driver.findElement(By.xpath(OR.getProperty("other_tab"))).click();
		  Thread.sleep(3000);
		  }
		  catch(Exception e)
		  {
			  System.out.println("Error while clicking OTHER Tab");
		  }
		  try
		  {
		  WebElement building_permits_subtab_ele = driver.findElement(By.xpath(OR.getProperty("building_permits_subtab")));
		  System.out.println("Sub Tab name :"+building_permits_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+building_permits_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,building_permits_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...BUILDING PERMITS Tab is not present");
		  }
	  
		  
	  }
	  
	/*  @Test(priority = 15, description = "TC: Close lbx url")
		public void CloseWindow()
		{
			driver.close();
		}*/
}
