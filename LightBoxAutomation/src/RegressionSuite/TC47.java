package RegressionSuite;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC47 extends CommonFunctions {
	@Test(priority = 80, description = "TC: Load lightbox URL")
	public void beforeTest() throws InterruptedException, IOException {
		initialize();
		// selectBrowser();
		File file = new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();

		driver.get(
				"http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=80bef1ce-2032-4070-91f7-bf7649486811&lsessguid=2360691e-4deb-4b5c-aae4-11ac0ce5b1ee");
		driver.manage().window().maximize();
		Thread.sleep(18000);

	}

	// Verify map markers available in layers dropdown.
	@Test(priority = 81, description = "TC 47: Verify LAYERS dropdown")
	public void verifyMapMarkers() throws InterruptedException {

		/*
		 * System.out.println("Closing right panel list view."); WebElement
		 * hide_show_button =
		 * driver.findElement(By.xpath(OR.getProperty("hide_list_button")));
		 * HighlightElement(driver, hide_show_button); Thread.sleep(4000);
		 * hide_show_button.click(); Thread.sleep(7000);
		 * 
		 */
		System.out.println("Verify map markers available in layers dropdown.");
		APP_LOGS.debug("Verify map markers available in layers dropdown.\n");

		driver.findElement(By.xpath(".//*[@id='map_host']/div/div[8]/div/div[1]/button[2]")).click();
		driver.findElement(By.xpath(".//*[@id='map_host']/div/div[8]/div/div[1]/button[2]")).click();

		System.out.println("Check whether layers dropdown is displayed or not.");
		WebElement layers_dropdown = driver.findElement(By.xpath(".//*[@id='filterButton']"));
		HighlightElement(driver, layers_dropdown);
		Thread.sleep(5000);

		if (layers_dropdown.getText().trim().toLowerCase().contains("layers")) {
			System.out.println("Dropdown title is diplayed correctly.");
			System.out.println("Test case status: Pass\n");
		} else {
			System.out.println("Dropdown title is not diplayed correctly.");
			System.out.println("Test case status: Fail\n");
		}

	}

	// Verify map markers list available in layers dropdown.
	@Test(priority = 82, description = "TC 47: Verify LAYERS dropdown")
	public void verifyMapMarkersList() throws InterruptedException {
		System.out.println("Verify map markers list available in layers dropdown.");
		APP_LOGS.debug("Verify map markers list available in layers dropdown.\n");

		System.out.println("MAP MARKERS in LAYERS dropdown.");
		WebElement layers_dropdown = driver.findElement(By.xpath(".//*[@id='filterButton']"));
		layers_dropdown.click();
		Thread.sleep(5000);

		List<WebElement> list_options = driver.findElements(By.xpath(".//*[@id='Filters']/ul/li/label/span[1]"));
		for (WebElement ele : list_options) {
			HighlightElement(driver, ele);
			Thread.sleep(5000);
			System.out.println("" + ele.getText());

		}

	}

	// Verify map markers list available in layers dropdown.
	@Test(priority = 83, description = "TC 47: Verify TP Map Marker")
	public void verifyMapMarkerTPMarker() throws InterruptedException, IOException {
		System.out.println("Verify map markers functionality for TP Marker.");
		APP_LOGS.debug("Verify map markers functionality for TP Marker.\n");

		Thread.sleep(5000);
		try {
			// uncheck checkbox for TP map marker.
			WebElement tpmarker = driver.findElement(By.xpath(".//*[@id='filterchktpStar']"));
			tpmarker.click();
			Thread.sleep(8000);

			// capture screenshot
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\no_tp_marker.png"));
			System.out.println("Check screenshot no_tp_marker.");

			// checking checkbox again
			tpmarker.click();
			Thread.sleep(8000);
			// capture screenshot
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\tp_marker.png"));

			Thread.sleep(5000);

			System.out.println("Check screenshot tp_marker.\n");
		} catch (Exception e) {
			System.out.println("Error in viewing map marker data.");
			System.out.println("" + e.getMessage());
		}

	}

	// Verify map markers list available in layers dropdown.
	@Test(priority = 84, description = "TC 47: Verify MAP FINDINGS Map Marker")
	public void verifyMapMarkerMAPFINDINGSMarker() throws InterruptedException, IOException {
		System.out.println("Verify map markers functionality for MAP FINDINGS Marker.");
		APP_LOGS.debug("Verify map markers functionality for MAP FINDINGS Marker.\n");

		Thread.sleep(5000);
		try {
			// uncheck checkbox for map findings map marker.
			WebElement mfmarker = driver.findElement(By.xpath(".//*[@id='filterchkMapFinding']"));
			mfmarker.click();
			Thread.sleep(8000);

			// capture screenshot
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\no_mapfindings_marker.png"));
			System.out.println("Check screenshot no_mapfindings_marker.");
			// checking checkbox again
			mfmarker.click();
			Thread.sleep(8000);
			// capture screenshot
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\mapfindings_marker.png"));
			System.out.println("Check screenshot mapfindings_marker.\n");
			Thread.sleep(5000);

			mfmarker.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Error in viewing map marker data.");
			System.out.println("" + e.getMessage());
		}
	}

	// Verify map markers list available in layers dropdown.
	@Test(priority = 85, description = "TC 47: Verify WATER WELLS Map Marker")
	public void verifyMapMarkerWATERWELLSMarker() throws InterruptedException, IOException {
		System.out.println("Verify map markers functionality for WATER WELLS Marker.");
		APP_LOGS.debug("Verify map markers functionality for WATER WELLS Marker.\n");

		try {
			// loading data for water wells
			WebElement physical_settings_tab_ele = driver
					.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
			HighlightElement(driver, physical_settings_tab_ele);
			physical_settings_tab_ele.click();
			Thread.sleep(3000);

			if (driver.findElement(By.xpath(".//*[@id='physical2']")).getAttribute("class").equals("pointer ")) {
				WebElement water_wells_subtab_ele = driver.findElement(By.xpath(OR.getProperty("water_wells_subtab")));
				HighlightElement(driver, water_wells_subtab_ele);
				water_wells_subtab_ele.click();
				Thread.sleep(8000);

				// uncheck checkbox for water wells map marker.
				WebElement waterlwellsmarker = driver.findElement(By.xpath(".//*[@id='filterchkWater']"));
				waterlwellsmarker.click();
				Thread.sleep(8000);

				// capture screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\no_waterwells_marker.png"));
				System.out.println("Check screenshot no_waterwells_marker.");
				// checking checkbox again
				waterlwellsmarker.click();
				Thread.sleep(8000);
				// capture screenshot
				scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\waterwells_marker.png"));
				System.out.println("Check screenshot waterwells_marker.\n");
				Thread.sleep(5000);

				waterlwellsmarker.click();
				Thread.sleep(3000);
			} else {
				System.out.println("Tab is disabled.");
			}
		} catch (Exception e) {
			System.out.println("Error in viewing map marker data.");
			System.out.println("" + e.getMessage());
		}
	}

	// Verify map markers list available in layers dropdown.
	@Test(priority = 86, description = "TC 47: Verify OIL AND GAS WELLS Map Marker")
	public void verifyMapMarkerOILGASMarker() throws InterruptedException, IOException {
		System.out.println("Verify map markers functionality for OIL & GAS Marker.");
		APP_LOGS.debug("Verify map markers functionality for OIL & GAS Marker.\n");

		try {
			// loading data for water wells
			WebElement physical_settings_tab_ele = driver
					.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
			HighlightElement(driver, physical_settings_tab_ele);
			physical_settings_tab_ele.click();
			Thread.sleep(3000);

			if (driver.findElement(By.xpath(".//*[@id='physical3']")).getAttribute("class").equals("pointer ")) {
				WebElement oil_subtab_ele = driver.findElement(By.xpath(OR.getProperty("oilgas_wells_subtab")));
				HighlightElement(driver, oil_subtab_ele);
				oil_subtab_ele.click();
				Thread.sleep(8000);

				// uncheck checkbox for water wells map marker.
				WebElement oilgasmarker = driver.findElement(By.xpath(".//*[@id='filterchkOilGas']"));
				oilgasmarker.click();
				Thread.sleep(8000);

				// capture screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\no_oilgas_marker.png"));
				System.out.println("Check screenshot no_oilgas_marker.");
				// checking checkbox again
				oilgasmarker.click();
				Thread.sleep(8000);
				// capture screenshot
				scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\oilgas_marker.png"));
				System.out.println("Check screenshot oilgas_marker.\n");
				Thread.sleep(5000);

				oilgasmarker.click();
				Thread.sleep(3000);
			} else {
				System.out.println("Tab is disabled.");
			}
		} catch (Exception e) {
			System.out.println("Error in viewing map marker data.");
			System.out.println("" + e.getMessage());
		}
	}

	// Verify map markers list available in layers dropdown.
	@Test(priority = 87, description = "TC 47: Verify SOIL DATA Map Marker")
	public void verifyMapMarkerSOILMarker() throws InterruptedException, IOException {
		System.out.println("Verify map markers functionality for SOIL Marker.");
		APP_LOGS.debug("Verify map markers functionality for SOIL Marker.\n");
		try {

			// loading data for soil
			WebElement physical_settings_tab_ele = driver
					.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
			HighlightElement(driver, physical_settings_tab_ele);
			physical_settings_tab_ele.click();
			Thread.sleep(3000);
			if (driver.findElement(By.xpath(".//*[@id='physical4']")).getAttribute("class").equals("pointer ")) {
				WebElement soil_subtab_ele = driver.findElement(By.xpath(OR.getProperty("soil_data_subtab")));
				HighlightElement(driver, soil_subtab_ele);
				soil_subtab_ele.click();
				Thread.sleep(8000);

				// uncheck checkbox for soil map marker.
				WebElement soilmarker = driver.findElement(By.xpath(".//*[@id='filterchkSoil']"));
				soilmarker.click();
				Thread.sleep(8000);

				// capture screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\no_soil_marker.png"));
				System.out.println("Check screenshot no_soil_marker.");
				// checking checkbox again
				soilmarker.click();
				Thread.sleep(8000);
				// capture screenshot
				scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\soil_marker.png"));
				System.out.println("Check screenshot soil_marker.\n");
				Thread.sleep(6000);

				soilmarker.click();
				Thread.sleep(3000);
			} else {
				System.out.println("Tab is disabled.");
			}
		} catch (Exception e) {
			System.out.println("Error in viewing map marker data.");
			System.out.println("" + e.getMessage());
		}
	}

	// Verify map markers list available in layers dropdown.
	@Test(priority = 88, description = "TC 47: Verify AQUIFLOW Map Marker")
	public void verifyMapMarkerAQUIFLOWMarker() throws InterruptedException, IOException {
		System.out.println("Verify map markers functionality for AQUIFLOW Marker.");
		APP_LOGS.debug("Verify map markers functionality for AQUIFLOW Marker.\n");

		try {

			// loading data for aquiflow
			WebElement physical_settings_tab_ele = driver
					.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
			HighlightElement(driver, physical_settings_tab_ele);
			physical_settings_tab_ele.click();
			Thread.sleep(3000);

			if (driver.findElement(By.xpath(".//*[@id='physical1']")).getAttribute("class").equals("pointer ")) {
				WebElement aquiflow_subtab_ele = driver.findElement(By.xpath(OR.getProperty("aquiflow_subtab")));
				HighlightElement(driver, aquiflow_subtab_ele);
				aquiflow_subtab_ele.click();
				Thread.sleep(8000);

				// uncheck checkbox for soil map marker.
				WebElement aquiflowmarker = driver.findElement(By.xpath(".//*[@id='filterchkAquiflow']"));
				aquiflowmarker.click();
				Thread.sleep(8000);

				// capture screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\no_aquiflow_marker.png"));
				System.out.println("Check screenshot no_aquiflow_marker.");
				// checking checkbox again
				aquiflowmarker.click();
				Thread.sleep(8000);
				// capture screenshot
				scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\aquiflow_marker.png"));
				System.out.println("Check screenshot aquiflow_marker.\n");
				Thread.sleep(5000);

				aquiflowmarker.click();
				Thread.sleep(3000);
			} else {
				System.out.println("Tab is disabled.");
			}
		} catch (Exception e) {
			System.out.println("Error in viewing map marker data.");
			System.out.println("" + e.getMessage());
		}
	}

	// Verify map markers list available in layers dropdown.
	@Test(priority = 89, description = "TC 47: Verify BUILDING PERMITS Map Marker")
	public void verifyMapMarkerBULDPERMITMarker() throws InterruptedException, IOException {
		System.out.println("Verify map markers functionality for BUILDING PERMITS Marker.");
		APP_LOGS.debug("Verify map markers functionality for BUILDING PERMITS Marker.\n");

		try {
			// loading data for buliding permits
			WebElement other_tab_ele = driver.findElement(By.xpath(OR.getProperty("other_tab")));
			HighlightElement(driver, other_tab_ele);
			other_tab_ele.click();
			Thread.sleep(3000);

			WebElement buildpermit_subtab_ele = driver.findElement(By.xpath(OR.getProperty("building_permits_subtab")));
			HighlightElement(driver, buildpermit_subtab_ele);
			buildpermit_subtab_ele.click();
			Thread.sleep(8000);

			if (driver.findElement(By.xpath(".//*[@id='otherOne']")).getAttribute("class").equals("pointer ")) {
				// uncheck checkbox for building permits map marker.
				WebElement buildingpermitmarker = driver.findElement(By.xpath(".//*[@id='filterchkBuilding']"));
				buildingpermitmarker.click();
				Thread.sleep(8000);

				// capture screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(
						"C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\no_buildpermit_marker.png"));
				System.out.println("Check screenshot no_buildpermit_marker.");
				// checking checkbox again
				buildingpermitmarker.click();
				Thread.sleep(8000);
				// capture screenshot
				scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\buildpermit_marker.png"));
				System.out.println("Check screenshot buildpermit_marker.\n");
				Thread.sleep(5000);

				buildingpermitmarker.click();
				Thread.sleep(3000);
			} else {
				System.out.println("Tab is disabled.");
			}
		} catch (Exception e) {
			System.out.println("Error in viewing map marker data.");
			System.out.println("" + e.getMessage());
		}
	}

	// Verify map markers list available in layers dropdown.
	@Test(priority = 90, description = "TC 47: Verify POI Map Marker")
	public void verifyMapMarkerPOIMarker() throws InterruptedException, IOException {
		System.out.println("Verify map markers functionality for POI Marker.");
		APP_LOGS.debug("Verify map markers functionality for POI Marker.\n");

		try {
			// check checkbox for poi map marker.
			WebElement poimarker = driver.findElement(By.xpath(".//*[@id='filterchkmapLabels']"));
			poimarker.click();
			Thread.sleep(8000);

			// capture screenshot
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\poi_marker.png"));
			System.out.println("Check screenshot poi_marker.");
			// un checking checkbox again
			poimarker.click();
			Thread.sleep(8000);
			// capture screenshot
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Admin\\workspace\\LBXAutomation1\\screencasts\\no_poi_marker.png"));
			System.out.println("Check screenshot no_poi_marker.\n");
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println("Error in viewing map marker data.");
			System.out.println("" + e.getMessage());
		}
	}

	@Test(priority = 91, description = "TC : Close lbx url")
	public void CloseWindow() {
		driver.close();
	}
}
