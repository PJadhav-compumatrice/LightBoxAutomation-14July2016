package RegressionSuite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC27ToTC31 extends CommonFunctions{
	@Test(priority = 47,description = "TC: Load lightbox URL ")
	public void beforeTest() throws InterruptedException, IOException {
		initialize();
		// selectBrowser();
		File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();

		driver.get(
				"http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=ccc9b265-ec91-4c09-baed-6a00367fae39&lsessguid=f2a67e05-9af2-4a2d-9409-686ef35529b8");
		driver.manage().window().maximize();
		Thread.sleep(18000);
	}

	@Test(priority = 48, description="TC 27: Verify OIL & GAS WELLS Tab")
	public void verifyTitle() throws InterruptedException, IOException {
		System.out.println(
				"Verify OIL & GAS WELLS Tab is displayed on top bar in right panel and when clicked, OIL & GAS WELLS records are displayed in table");
		APP_LOGS.debug(
				"Verify OIL & GAS WELLS tab is displayed on top bar in right panel and when clicked, OIL & GAS WELLS records are displayed in table \n");

		//// Clicking on PHYSICAL SETTINGS SubTab
		System.out.println("Clicking on PHYSICAL SETTINGS Tab.");
		APP_LOGS.debug("Clicking on PHYSICAL SETTINGS Tab.\n");
		Thread.sleep(8000);
		WebElement physical_settings_tab_ele = driver.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
		HighlightElement(driver, physical_settings_tab_ele);
		physical_settings_tab_ele.click();
		Thread.sleep(3000);
		System.out.println("Clicking on OIL & GAS WELLS Tab.");
		APP_LOGS.debug("Clicking on OIL & GAS WELLS Tab.\n");
		WebElement oilgas_data_subtab_ele = driver.findElement(By.xpath(".//*[@id='physical3']/a"));
		HighlightElement(driver, oilgas_data_subtab_ele);
		Thread.sleep(5000);
		oilgas_data_subtab_ele.click();
		Thread.sleep(6000);

		// check whether tab title is displayed correctly or not.
		WebElement oil_data_title = driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/h4"));
		HighlightElement(driver, oil_data_title);
		Thread.sleep(5000);

		String oildata_title_text = oil_data_title.getText();

		if (oildata_title_text.trim().contains("Oil & Gas Wells")) {
			System.out.println("Title is displayed correctly.");
			System.out.println("Title text: " + oildata_title_text);
			System.out.println("Test case status: Pass \n");
		} else {
			System.out.println("Title is not displayed correctly.");
			System.out.println("Test case status: Fail \n");
		}

	}

	// Verify Highlight Flag Filter on List view records.
	@Test(priority = 49, description = "TC 28: Verify Highlight filter on OIL & GAS WELLS")
	public void verifyHighLightFlagFilter() throws InterruptedException {
		System.out.println("Verify Highlight Flag Filter on List view records. ");
		APP_LOGS.debug("Verify Highlight Flag Filter on List view records.\n");

		//// Clicking on PHYSICAL SETTINGS SubTab
		System.out.println("Clicking on PHYSICAL SETTINGS Tab.");
		APP_LOGS.debug("Clicking on PHYSICAL SETTINGS Tab.\n");
		Thread.sleep(8000);
		WebElement physical_settings_tab_ele = driver.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
		HighlightElement(driver, physical_settings_tab_ele);
		physical_settings_tab_ele.click();
		Thread.sleep(3000);
		System.out.println("Clicking on OIL & GAS WELLS Tab.");
		APP_LOGS.debug("Clicking on OIL & GAS WELLS Tab.\n");
		WebElement oil_gas_wells_subtab_ele = driver.findElement(By.xpath(".//*[@id='physical3']/a"));
		HighlightElement(driver, oil_gas_wells_subtab_ele);
		Thread.sleep(5000);
		oil_gas_wells_subtab_ele.click();
		Thread.sleep(6000);

		// Calculating number of records displayed in list view from table rows

		// verify any filter is been applied, if yes remove it
		System.out.println("Verify any filter is been applied, if yes remove it.");

		try {
			WebElement flag_filter = driver
					.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[5]/a"));
			HighlightElement(driver, flag_filter);
			flag_filter.click();
			System.out.println("Flag Filter applied.");
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
			System.out.println("No Flag Filter is removed.");
		}

		// Check record count displayed at the top of table
		WebElement record_count_note = driver
				.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[1]"));
		HighlightElement(driver, record_count_note);
		Thread.sleep(5000);
		String note = record_count_note.getText();
		String count[] = note.split("\\s+");
		System.out.println("List view record count displayed at top of list view before any filter :" + count[0]);

		// Marking two record with flag green
		System.out.println("Marking two record with flag green");
		WebElement ele = driver
				.findElement(By.xpath(".//*[@id='toggleIconOilFilterd14bb0dd-280d-4f44-bef5-4f3f2ca02dd9']"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		ele = driver.findElement(
				By.xpath(".//*[@id='toggleFilterOilDivd14bb0dd-280d-4f44-bef5-4f3f2ca02dd9']/div[4]/span[1]"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		ele = driver.findElement(By.xpath(".//*[@id='toggleIconOilFilter7530eca3-db8b-4bc9-9c01-b0e3c0f1c1db']"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		ele = driver.findElement(
				By.xpath(".//*[@id='toggleFilterOilDiv7530eca3-db8b-4bc9-9c01-b0e3c0f1c1db']/div[4]/span[1]"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		// Applying filter on Highlight flag filter
		System.out.println("Applying filter on Highlight flag filter");
		WebElement highlight_flagfilter_dropdown = driver.findElement(By.xpath(".//*[@id='flagOil']/div/span/i"));
		HighlightElement(driver, highlight_flagfilter_dropdown);
		// Thread.sleep(5000);
		highlight_flagfilter_dropdown.click();
		Thread.sleep(6000);

		// selecting green flag
		WebElement flag_green = driver.findElement(By.xpath(".//*[@id='OilGasFlagFilter2']"));
		HighlightElement(driver, flag_green);
		Thread.sleep(5000);
		flag_green.click();
		Thread.sleep(6000);

		// Check record count displayed at the top of table
		System.out.println("Check record count displayed at the top of table when filter is applied.");
		record_count_note = driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[1]"));
		HighlightElement(driver, record_count_note);
		Thread.sleep(5000);
		note = record_count_note.getText();
		String count1[] = note.split("\\s+");
		System.out.println(
				"List view record count displayed at top of list view when flag filter is applied:" + count1[0]);
		int c1 = Integer.parseInt(count[0]);
		int c2 = Integer.parseInt(count1[0]);

		if ((c1 - c2) == 2) {
			System.out.println("Count displayed at top is correct.");
			System.out.println("Test case status: Pass \n");
		} else {
			System.out.println("Count is wrong.");
			System.out.println("Test case status: Fail \n");
		}

		driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/span[5]/a")).click();
		Thread.sleep(5000);
	}

	/*@Test(priority = 50, description = "TC 29: Verify Add/Remove Column feature")
	public void verifyColumnAdjustmentFeature() {

		System.out.println("Verify column adjustment feature for table list view. ");
		APP_LOGS.debug("Verify column adjustment feature for table list view.\n");

		System.out.println("Check whether Dist(ft) column is displayed or not.");
		try {
			WebElement dist_column = driver.findElement(By.xpath(OR.getProperty("db_column")));
			if (dist_column.getAttribute("style").contains("width: 0px;")) {
				System.out.println("Dist(ft) Column is not displayed.");
				System.out.println("Checking checkbox for Dist Column to check checkbox for Dist column");
				// clicking on columns dropdown
				WebElement column_dropdown_ele = driver
						.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/div/a"));
				HighlightElement(driver, column_dropdown_ele);
				Thread.sleep(5000);
				column_dropdown_ele.click();
				Thread.sleep(6000);

				WebElement dist_column_chckbx = driver.findElement(
						By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/div/ul[4]/li[2]/div/label/input"));
				HighlightElement(driver, dist_column_chckbx);
				Thread.sleep(5000);
				dist_column_chckbx.click();
				Thread.sleep(6000);

				// clicking outside of window
				driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
				Thread.sleep(5000);
				// verify whether Dist column is displayed now or not
				if (dist_column.getAttribute("style").contains("width: 0px;")) {
					System.out.println("Dist Column is not displayed");
					System.out.println("Test case status: Fail \n");
				} else {
					System.out.println("Dist Column is now displayed");
					System.out.println("Width : " + dist_column.getAttribute("style"));
					System.out.println("Test case status: Pass\n");

					System.out
							.println("Unchecking checknbox again to verify whether Dist column gets removed or not. ");
					// clicking on columns dropdown
					column_dropdown_ele = driver
							.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/div/a"));
					HighlightElement(driver, column_dropdown_ele);
					Thread.sleep(5000);
					column_dropdown_ele.click();
					Thread.sleep(6000);

					dist_column_chckbx = driver.findElement(
							By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/div/ul[4]/li[2]/div/label/input"));
					HighlightElement(driver, dist_column_chckbx);
					Thread.sleep(5000);
					dist_column_chckbx.click();
					Thread.sleep(6000);

					// clcking outside of window
					driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
					Thread.sleep(5000);

					// verify whether Dist column is removed now or not
					if (dist_column.getAttribute("style").contains("width: 0px;")) {
						System.out.println("Dist Column is not displayed");
						System.out.println("Test case status: Pass \n");
					} else {
						System.out.println("Dist Column is displayed");
						System.out.println("Width : " + dist_column.getAttribute("style"));
						System.out.println("Test case status: Fail\n");
					}
				}
			} else {
				System.out.println("Dist(ft) Column is displayed.");
				System.out.println("Checking checkbox for Dist(ft) Column to uncheck Dist(ft) column checkbox.");
				Thread.sleep(6000);
				// clicking on columns dropdown
				// clicking on columns dropdown
				WebElement column_dropdown_ele = driver
						.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/div/a"));
				HighlightElement(driver, column_dropdown_ele);
				Thread.sleep(5000);
				column_dropdown_ele.click();
				Thread.sleep(6000);

				WebElement dist_column_chckbx = driver.findElement(
						By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/div/ul[4]/li[2]/div/label/input"));
				HighlightElement(driver, dist_column_chckbx);
				Thread.sleep(5000);
				dist_column_chckbx.click();
				Thread.sleep(6000);

				// clcking outside of window
				driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
				Thread.sleep(5000);
				// verify whether Dist column is removed or not
				if (dist_column.getAttribute("style").contains("width: 0px;")) {
					System.out.println("Dist(ft) Column is not displayed");
					System.out.println("Test case status: Pass\n");

					System.out.println("Checking checknbox again to verify whether Dist column gets added or not. ");
					// clicking on columns dropdown
					// clicking on columns dropdown
					column_dropdown_ele = driver
							.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/div/a"));
					HighlightElement(driver, column_dropdown_ele);
					Thread.sleep(5000);
					column_dropdown_ele.click();
					Thread.sleep(6000);

					dist_column_chckbx = driver.findElement(
							By.xpath(".//*[@id='sidebar']/div[2]/div[1]/div/div/div/ul[4]/li[2]/div/label/input"));
					HighlightElement(driver, dist_column_chckbx);
					Thread.sleep(5000);
					dist_column_chckbx.click();
					Thread.sleep(6000);

					// clcking outside of window
					driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
					Thread.sleep(5000);

					// verify whether Dist column is displayed now or not
					if (dist_column.getAttribute("style").contains("width: 0px;")) {
						System.out.println("Dist Column is not displayed");
						System.out.println("Test case status: Fail \n");
					} else {
						System.out.println("Dist Column is displayed");
						System.out.println("Width : " + dist_column.getAttribute("style"));
						System.out.println("Test case status: Pass\n");
					}
				} else {
					System.out.println("Dist Column is still displayed");
					System.out.println("Width : " + dist_column.getAttribute("style"));
					System.out.println("Test case status: Fail\n");

				}
			}

		} catch (Exception e) {
			System.out.println("" + e.getMessage());
		}

	}
*/
	// Verify Slideout panel for table list view records.
	@Test(priority = 51, description = "TC 30: Verify Slideout panel for OIL & GAS WELLS")
	public void verifySlideOut() throws InterruptedException, IOException {
		System.out.println("Verify Slideout panel for table list view records. ");
		APP_LOGS.debug("Verify Slideout panel for table list view records. \n");

		// Remove any filters if are.
		removeSavedFilters();

		Thread.sleep(5000);
		// Clicking on first record to view slideout panel for that record.
		System.out.println("Clicking on first record to view slideout panel for that record.");
		APP_LOGS.debug("Clicking on first record to view slideout panel for that record.");

		WebElement first_record_listview_ele = driver
				.findElement(By.xpath(".//*[@id='oilGasRecordd14bb0dd-280d-4f44-bef5-4f3f2ca02dd9']/td[2]"));
		HighlightElement(driver, first_record_listview_ele);
		Thread.sleep(5000);
		first_record_listview_ele.click();
		Thread.sleep(16000);

		// Verify whether slideout panel is displayed or not.
		System.out.println("Verify whether slideout panel is displayed or not.");
		APP_LOGS.debug("Verify whether slideout panel is displayed or not.\n");

		System.out.println("" + driver.findElement(By.xpath(OR.getProperty("slideout_panel"))).getAttribute("style"));
		if (driver.findElement(By.xpath(OR.getProperty("slideout_panel"))).getAttribute("style")
				.contains("display: block;")) {
			System.out.println("Slideout panel is displayed.");
			APP_LOGS.debug("Slideout panel is displayed.\n");
			// verify
			System.out.println("Verify correct slideout panel is opened or not.");
			APP_LOGS.debug("Verify correct slideout panel is opened or not.\n");

			// verify title of slideout panel
			WebElement soil_slideout_title = driver
					.findElement(By.xpath(".//*[@id='headerPanel']/div[1]/div/div/div[1]/b[2]"));
			String title_text = soil_slideout_title.getText();
			if (title_text.trim().contains("Oil & Gas Well"))

			{
				System.out.println("Correct slideout panel is displayed.");
				System.out.println("Title for Slideout Panel : " + title_text);
				System.out.println("Test case status: Pass \n");
			} else {
				System.out.println("Incorrect slideout panel is displayed.");
				System.out.println("Test case status: Fail \n");
			}

		} else {
			System.out.println("Slideout panel is not displayed.");
			APP_LOGS.debug("Slideout panel is not displayed.\n");
		}

	}

	// Verify popout link on slideout panel.
	@Test(priority = 52, description = "TC 31: Verify POPOUT link")
	public void verifyPopoutLink() throws InterruptedException {
		System.out.println("Verify popout link on slideout panel.");
		APP_LOGS.debug("Verify popout link on slideout panel. \n");

		System.out.println("Verify whether Popout link is displayed on slideout panel or not.");
		APP_LOGS.debug("Verify whether Popout link is displayed on slideout panel or not. \n");

		WebElement popout_link = driver.findElement(By.xpath(OR.getProperty("popout_link")));
		HighlightElement(driver, popout_link);
		Thread.sleep(5000);

		System.out.println("Link Text : " + driver.findElement(By.xpath(OR.getProperty("popout_link"))).getText());

		// clicking on link
		System.out.println("Clicking on popout link.");
		popout_link.click();
		Thread.sleep(15000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// verify whether popout link is displayed or not.
		System.out.println("Verify whether popout link is displayed or not.");
		if (driver.getCurrentUrl().contains("propertydetails")) {
			System.out.println("Property details page is displayed.");
			System.out.println("Test case status: Pass \n");
		} else {
			System.out.println("Proprty details page is not displayed.");
			System.out.println("Test case status: Fail \n");
		}

		Thread.sleep(5000);
		driver.close();

		driver.switchTo().window(tabs2.get(0));

	}

	@Test(priority = 53, description = "TC :Close lbx url")
	public void CloseWindow() {
		driver.close();
	}
}
