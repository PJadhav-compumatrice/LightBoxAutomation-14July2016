package RegressionSuite;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC01ToTC04 extends CommonFunctions {
	  @Test(priority = 1, description = "TC: Load lightbox URL ")
	  public void beforeTest() throws InterruptedException, IOException {
		    initialize();
			//	selectBrowser();	
		    File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			
		    driver.get("http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=80bef1ce-2032-4070-91f7-bf7649486811&lsessguid=2360691e-4deb-4b5c-aae4-11ac0ce5b1ee");
		    driver.manage().window().maximize();
			Thread.sleep(15000);
	  }
	  
	  //Verify whether all tabs are displayed
	  @Test(priority = 2, description = "TC 01: Verify Historical Tab")
	  public void verifyHISTORICALTab() throws InterruptedException
	  {
		  System.out.println("Verify whether all sub-tabs are displayed for HISTORICAL Tab ");
		  APP_LOGS.debug("Verify whether all sub-tabs are displayed for HISTORICAL Tab\n");
		  System.out.println("Clicking on HISTORICAL Tab.");
		  APP_LOGS.debug("Clicking on HISTORICAL Tab.\n");
		  try
		  {
		  WebElement historical_tab_ele = driver.findElement(By.xpath(OR.getProperty("historical_tab")));
		  System.out.println("Tab name :"+historical_tab_ele.getText().trim());
		  APP_LOGS.debug("Tab name :"+historical_tab_ele.getText().trim()+"\n");
		  HighlightElement(driver,historical_tab_ele);
		  driver.findElement(By.xpath(OR.getProperty("historical_tab"))).click();
		  Thread.sleep(3000);
		  }
		  catch(Exception e)
		  {
			  System.out.println("Error while clicking HISTORICAL Tab");
			  APP_LOGS.debug("Error while clicking HISTORICAL Tab. \n");
		  }
	  
		  try
		  {
		  WebElement sanborn_maps_subtab_ele = driver.findElement(By.xpath(OR.getProperty("sanborn_map_subtab")));
		  System.out.println("Sub Tab name :"+sanborn_maps_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+sanborn_maps_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,sanborn_maps_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...SANBORN MAP Tab is not present");
			  APP_LOGS.debug("Error...SANBORN MAP Tab is not present. \n");
		  }
		  
		  try
		  {
		  WebElement aerial_photos_subtab_ele = driver.findElement(By.xpath(OR.getProperty("hist_aerial_subtab")));
		  System.out.println("Sub Tab name :"+aerial_photos_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+aerial_photos_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,aerial_photos_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...AERIAL PHOTOS Tab is not present");
			  APP_LOGS.debug("Error...AERIAL PHOTOS Tab is not present. \n");
		  }
		  
		  try
		  {
		  WebElement topographic_map_subtab_ele = driver.findElement(By.xpath(OR.getProperty("hist_topo_subtab")));
		  System.out.println("Sub Tab name :"+topographic_map_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+topographic_map_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,topographic_map_subtab_ele);
		  Thread.sleep(5000);
		//  topographic_map_subtab_ele.click();
		 // driver.findElement(By.xpath("//div[@id='topoYearList']/label/span[Contains(text(),'1996')]")).click();
		  //Thread.sleep(4000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...TOPOGRAPHIC MAPS Tab is not present");
			  APP_LOGS.debug("Error...TOPOGRAPHIC MAPS Tab is not present. \n");
		  }
		  
			  
	  }
	  
	  @Test(priority=3, description = "TC 02: Verify TAX MAP Tab")
	  public void verifyTaxmapTab()
	  {
		  System.out.println("\n Verify whether TAX MAP Tab is displayed");
		  APP_LOGS.debug("Verify whether TAX MAP Tab is displayed\n");
		  System.out.println("Clicking on TAX MAP Tab.");
		  APP_LOGS.debug("Clicking on TAX MAP Tab.\n");
		  try
		  {
		  WebElement taxmap_tab_ele = driver.findElement(By.xpath(OR.getProperty("taxmap_tab")));
		  System.out.println("Sub Tab name :"+taxmap_tab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+taxmap_tab_ele.getText().trim()+"\n");
		  HighlightElement(driver,taxmap_tab_ele);
		  driver.findElement(By.xpath(OR.getProperty("taxmap_tab"))).click();
		  Thread.sleep(3000);
		  }
		  catch(Exception e)
		  {
			  System.out.println("Error while clicking TAX MAP Tab");
			  APP_LOGS.debug("Error while clicking TAX MAP Tab.\n");
		  }
		  
	  }
	  
	  @Test(priority=4, description = "TC 03: Verify TOPO Tab")
	  public void verifyTOPOTab()
	  {
		  System.out.println("\n Verify whether all sub-tabs are displayed for TOPO Tab ");
		  APP_LOGS.debug("Verify whether all sub-tabs are displayed for TOPO Tab\n");
		  System.out.println("Clicking on TOPO Tab.");
		  APP_LOGS.debug("Clicking on TOPO Tab.\n");
		  try
		  {
		  WebElement topo_tab_ele = driver.findElement(By.xpath(OR.getProperty("topo_tab")));
		  System.out.println("Sub Tab name :"+topo_tab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+topo_tab_ele.getText().trim()+"\n");
		  HighlightElement(driver,topo_tab_ele);
		  driver.findElement(By.xpath(OR.getProperty("topo_tab"))).click();
		  Thread.sleep(3000);
		  }
		  catch(Exception e)
		  {
			  System.out.println("Error while clicking TOPO Tab");
			  APP_LOGS.debug("Error while clicking TOPO Tab.\n");
		  }
		  
		  try
		  {
		  WebElement mintopo_subtab_ele = driver.findElement(By.xpath(OR.getProperty("7.5mini_topo_subtab")));
		  System.out.println("Sub Tab name :"+mintopo_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+mintopo_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,mintopo_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...7.5 MIN TOPO Tab is not present");
			  APP_LOGS.debug("Error...7.5 MIN TOPO Tab is not present.\n");
		  }
		  
		  try
		  {
		  WebElement contour_lines_subtab_ele = driver.findElement(By.xpath(OR.getProperty("contour_lines_subtab")));
		  System.out.println("Sub Tab name :"+contour_lines_subtab_ele.getText());
		  APP_LOGS.debug("Tab name :"+contour_lines_subtab_ele.getText()+"\n");
		  HighlightElement(driver,contour_lines_subtab_ele);
		  Thread.sleep(5000);
		  contour_lines_subtab_ele.click();
		  Thread.sleep(5000);
		 
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...CONTOUR LINES Tab is not present");
			  APP_LOGS.debug("Error...CONTOUR LINES Tab is not present.\n");
		  }
		  
	  }
	  
	  @Test(priority=5, description = "TC 04: Verify BASE MAP Tab")
	  public void verifyBASEMAP()
	  {
		  System.out.println("\n Verify whether all sub-tabs are displayed for BASEMAP Tab ");
		  APP_LOGS.debug("Verify whether all sub-tabs are displayed for BASEMAP Tab\n");
		  System.out.println("Clicking on BASEMAP Tab.");
		  APP_LOGS.debug("Clicking on BASEMAP Tab.\n");
		  try
		  {
		  WebElement base_map_tab_ele = driver.findElement(By.xpath(OR.getProperty("basemap_tab")));
		  System.out.println("Sub Tab name :"+base_map_tab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+base_map_tab_ele.getText().trim()+"\n");
		  HighlightElement(driver,base_map_tab_ele);
		  driver.findElement(By.xpath(OR.getProperty("basemap_tab"))).click();
		  Thread.sleep(3000);
		  }
		  catch(Exception e)
		  {
			  System.out.println("Error while clicking BASEMAP Tab");
			  APP_LOGS.debug("Error while clicking BASEMAP Tab.\n");
		  }
		  
		  try
		  {
		  WebElement streetmap_subtab_ele = driver.findElement(By.xpath(OR.getProperty("street_map_subtab")));
		  System.out.println("Sub Tab name :"+streetmap_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+streetmap_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,streetmap_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...STREET MAP Tab is not present");
			  APP_LOGS.debug("Error...STREET MAP Tab is not present.\n");
		  }
		  
		  try
		  {
		  WebElement simple_map_subtab_ele = driver.findElement(By.xpath(OR.getProperty("simple_map_subtab")));
		  System.out.println("Sub Tab name :"+simple_map_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+simple_map_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,simple_map_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...SIMPLE MAP Tab is not present.");
			  APP_LOGS.debug("Error...SIMPLE MAP Tab is not present.\n");
		  }
		  
		  try
		  {
		  WebElement satellite_map_subtab_ele = driver.findElement(By.xpath(OR.getProperty("satelite_map_subtab")));
		  System.out.println("Sub Tab name :"+satellite_map_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+satellite_map_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,satellite_map_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...SATELLITE Tab is not present");
			  APP_LOGS.debug("Error...SATELLITE Tab is not present.\n");
		  }
		  
		  try
		  {
		  WebElement degree_subtab_ele = driver.findElement(By.xpath(OR.getProperty("45degree_map_subtab")));
		  System.out.println("Sub Tab name :"+degree_subtab_ele.getText().trim());
		  APP_LOGS.debug("Sub Tab name :"+degree_subtab_ele.getText().trim()+"\n");
		  HighlightElement(driver,degree_subtab_ele);
		  Thread.sleep(5000);
		  
		  }catch(Exception e)
		  {
			  System.out.println("Error...45 DEGREE Tab is not present");
			  APP_LOGS.debug("Error...45 DEGREE Tab is not present.\n");
			  
		  }
	  }
	  

	/*  @Test(priority = 6, description = "TC: Close lbx url")
		public void CloseWindow()
		{
			driver.close();
		}*/
}
