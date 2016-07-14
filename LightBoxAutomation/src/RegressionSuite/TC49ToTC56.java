package RegressionSuite;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC49ToTC56 extends CommonFunctions{
	@Test(priority = 92, description = "TC : Close lbx url")
	
	public void beforeTest() throws InterruptedException, IOException {
		initialize();
		// selectBrowser();
		File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();

		driver.get(
				"http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=80bef1ce-2032-4070-91f7-bf7649486811&lsessguid=2360691e-4deb-4b5c-aae4-11ac0ce5b1ee");
		driver.manage().window().maximize();
		Thread.sleep(18000);

	}

	// Verify imagery displayed for BASEMAP tab in left panel.
	@Test(priority = 93, description = "TC 49: Verify BASEMAP Tab Function")
	public void verifyImagery1() throws InterruptedException {
		System.out.println("Verify imagery displayed for BASEMAP tab in left panel.");
		APP_LOGS.debug("Verify imagery displayed for BASEMAP tab in left panel.\n");

		System.out.println("Closing right panel list view.");
		WebElement hide_show_button = driver.findElement(By.xpath(OR.getProperty("hide_list_button")));
		HighlightElement(driver, hide_show_button);
		Thread.sleep(4000);
		hide_show_button.click();
		Thread.sleep(7000);

		try {
			System.out.println("Clicking on STREET MAP Sub tab");
			WebElement base_map_tab_ele = driver.findElement(By.xpath(OR.getProperty("basemap_tab")));
			HighlightElement(driver, base_map_tab_ele);
			Thread.sleep(4000);
			base_map_tab_ele.click();

			WebElement street_map_subtab = driver.findElement(By.xpath(".//*[@id='streetMap']"));
			HighlightElement(driver, street_map_subtab);
			Thread.sleep(4000);
			street_map_subtab.click();
			Thread.sleep(7000);
			System.out.println("Capturing screenshot for the STREET MAP.");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\street_map_view.png"));
			System.out.println("Test case status : Pass \n");
		} catch (Exception e) {
			System.out.println("Error in clicking on tab.");
			System.out.println("Test case status : Fail\n");
		}

		try {
			System.out.println("Clicking on SIMPLE MAP Sub tab");
			WebElement base_map_tab_ele = driver.findElement(By.xpath(OR.getProperty("basemap_tab")));
			HighlightElement(driver, base_map_tab_ele);
			Thread.sleep(4000);
			base_map_tab_ele.click();

			WebElement simple_map_subtab = driver.findElement(By.xpath(".//*[@id='simpleMap']"));
			HighlightElement(driver, simple_map_subtab);
			Thread.sleep(4000);
			simple_map_subtab.click();
			Thread.sleep(7000);

			System.out.println("Capturing screenshot for the SIMPLE MAP.");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\simple_map_view.png"));
			System.out.println("Test case status : Pass\n");
		} catch (Exception e) {
			System.out.println("Error in clicking on tab.");
			System.out.println("Test case status : Fail\n");
		}

		try {
			System.out.println("Clicking on SATELLITE MAP Sub tab");
			WebElement base_map_tab_ele = driver.findElement(By.xpath(OR.getProperty("basemap_tab")));
			HighlightElement(driver, base_map_tab_ele);
			Thread.sleep(4000);
			base_map_tab_ele.click();

			WebElement satellite_map_subtab = driver.findElement(By.xpath(".//*[@id='satelliteMap']"));
			HighlightElement(driver, satellite_map_subtab);
			Thread.sleep(4000);
			satellite_map_subtab.click();
			Thread.sleep(7000);

			System.out.println("Capturing screenshot for the SATELLITE MAP.");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\satellite_map_view.png"));
			System.out.println("Test case status : Pass\n");
		} catch (Exception e) {
			System.out.println("Error in clicking on tab.");
			System.out.println("Test case status : Fail\n");
		}

		try {
			System.out.println("Clicking on 45 DEGREE MAP Sub tab");
			WebElement base_map_tab_ele = driver.findElement(By.xpath(OR.getProperty("basemap_tab")));
			HighlightElement(driver, base_map_tab_ele);
			Thread.sleep(4000);
			base_map_tab_ele.click();

			WebElement degree45_map_subtab = driver.findElement(By.xpath(".//*[@id='rotateMap']"));
			HighlightElement(driver, degree45_map_subtab);
			Thread.sleep(4000);
			degree45_map_subtab.click();
			Thread.sleep(7000);

			System.out.println("Capturing screenshot for the 45DEGREE MAP.");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\degree45_map_view.png"));
			System.out.println("Test case status : Pass\n");
		} catch (Exception e) {
			System.out.println("Error in clicking on tab.");
			System.out.println("Test case status : Fail\n");
		}
	}

	// Verify imagery displayed for TOPO tab in left panel.
	@Test(priority = 94, description = "TC 50: Verify TOPO Tab Function")
	public void verifyImagery2() throws InterruptedException {
		System.out.println("Verify imagery displayed for TOPO tab in left panel.");
		APP_LOGS.debug("Verify imagery displayed for TOPO tab in left panel.\n");

		Thread.sleep(6000);

		try {
			System.out.println("Clicking on 7.5 MIN TOPO Sub tab");
			WebElement topo_tab_ele = driver.findElement(By.xpath(OR.getProperty("topo_tab")));
			HighlightElement(driver, topo_tab_ele);
			topo_tab_ele.click();

			WebElement mintopo_subtab_ele = driver.findElement(By.xpath(OR.getProperty("7.5mini_topo_subtab")));

			HighlightElement(driver, mintopo_subtab_ele);
			Thread.sleep(5000);
			mintopo_subtab_ele.click();
			Thread.sleep(7000);

			System.out.println("Capturing screenshot for the 7.5 MIN TOPO MAP.");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\min_topo_map_view.png"));
			System.out.println("Test case status : Pass\n");
		} catch (Exception e) {
			System.out.println("Error in clicking on tab.");
			System.out.println("Test case status : Fail\n");
		}

		try {
			System.out.println("Clicking on CONTOUR LINES sub tab");
			WebElement topo_tab_ele = driver.findElement(By.xpath(OR.getProperty("topo_tab")));
			HighlightElement(driver, topo_tab_ele);
			topo_tab_ele.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='main']/div[4]/div[1]/div/div/div[2]/button[2]")).click();

			WebElement contour_lines_subtab_ele = driver.findElement(By.xpath(OR.getProperty("contour_lines_subtab")));
			Thread.sleep(5000);
			contour_lines_subtab_ele.click();
			Thread.sleep(8000);

			System.out.println("Capturing screenshot for the CONTOUR LINES MAP.");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\contour_lines_map_view.png"));
			System.out.println("Test case status : Pass\n");
		} catch (Exception e) {
			System.out.println("Error in clicking on tab.");
			System.out.println("Test case status : Fail\n");
		}

	}

	// Verify imagery displayed for TAX MAP tab in left panel.
	@Test(priority = 95, description = "TC 51: Verify TAX MAP Tab Function")
	public void verifyImagery3() throws InterruptedException {
		System.out.println("Verify imagery displayed for TAX MAP tab in left panel.");
		APP_LOGS.debug("Verify imagery displayed for TAX MAP tab in left panel.\n");

		Thread.sleep(7000);
		try {
			System.out.println("Clicking on TAX MAP tab");
			WebElement taxmap_tab_ele = driver.findElement(By.xpath(OR.getProperty("taxmap_tab")));

			HighlightElement(driver, taxmap_tab_ele);
			Thread.sleep(5000);
			taxmap_tab_ele.click();
			Thread.sleep(8000);

			System.out.println("Capturing screenshot for the 7.5 MIN TOPO MAP.");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\taxmap_map_view.png"));
			System.out.println("Test case status : Pass \n");
		} catch (Exception e) {
			System.out.println("Error in clicking on tab.");
			System.out.println("Test case status : Fail\n ");
		}

	}

	// Verify imagery displayed for HISTORICAL tab in left panel.
	@Test(priority = 96, description = "TC 52: Verify HISTORICAL Tab Function")
	public void verifyImagery4() throws InterruptedException {
		System.out.println("Verify imagery displayed for HISTORICAL tab in left panel.");
		APP_LOGS.debug("Verify imagery displayed for HISTORICAL tab in left panel.\n");

		Thread.sleep(6000);

		try {
			System.out.println("Clicking on CERTIFIED SANBORN tab");
			WebElement historical_tab_ele = driver.findElement(By.xpath(OR.getProperty("historical_tab")));
			HighlightElement(driver, historical_tab_ele);
			Thread.sleep(4000);
			driver.findElement(By.xpath(OR.getProperty("historical_tab"))).click();
			Thread.sleep(6000);

			WebElement sanborn_maps_subtab_ele = driver.findElement(By.xpath(OR.getProperty("sanborn_map_subtab")));
			HighlightElement(driver, sanborn_maps_subtab_ele);
			Thread.sleep(5000);
			sanborn_maps_subtab_ele.click();
			Thread.sleep(7000);

			System.out.println("Capturing screenshot for the CERTIFIED SANBORN MAPS.");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\sanborn_map.png"));
			System.out.println("Test case status : Pass \n");
		} catch (Exception e) {
			System.out.println("Error in clicking on tab.");
			System.out.println("Test case status : Fail \n");
		}

		try {
			System.out.println("Clicking on HISTORICAL AERIAL sub tab");
			WebElement historical_tab_ele = driver.findElement(By.xpath(".//*[@id='mapHeaderBtns']/button[2]"));
			HighlightElement(driver, historical_tab_ele);
			Thread.sleep(4000);
			historical_tab_ele.click();
			Thread.sleep(7000);

			WebElement aerial_photos_subtab_ele = driver.findElement(By.xpath(".//*[@id='historicalAerial']/a"));
			HighlightElement(driver, aerial_photos_subtab_ele);
			Thread.sleep(5000);
			aerial_photos_subtab_ele.click();
			Thread.sleep(7000);

			System.out.println("Capturing screenshot for the HISTORICAL AERIAL");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\aerial.png"));
			System.out.println("Test case status : Pass \n");
		} catch (Exception e) {
			System.out.println(""+e.getMessage());
			System.out.println("Error in clicking on tab.");
			System.out.println("Test case status : Fail \n");
		}

		try {
			System.out.println("Clicking on HISTORICAL TOPOGRAPHIC sub tab");
			WebElement historical_tab_ele = driver.findElement(By.xpath(".//*[@id='mapHeaderBtns']/button[2]"));
			HighlightElement(driver, historical_tab_ele);
			Thread.sleep(7000);
			historical_tab_ele.click();
			Thread.sleep(13000);

			WebElement topographic_map_subtab_ele = driver.findElement(By.xpath(".//*[@id='topoMap']/a"));
			HighlightElement(driver, topographic_map_subtab_ele);
			Thread.sleep(8000);
			topographic_map_subtab_ele.click();
			Thread.sleep(13000);

			System.out.println("Capturing screenshot for the HISTORICAL TOPOGRAPHIC.");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\topographic.png"));
			System.out.println("Test case status : Pass\n");
		} catch (Exception e) {
			System.out.println(""+e.getMessage());
			System.out.println("Error in clicking on tab.");
			System.out.println("Test case status : Fail \n");
		}

	}
	
	@Test(priority = 97, description = "TC : Close lbx url")
	public void CloseWindow() {
		driver.close();
	}
}
