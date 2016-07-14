package RegressionSuite;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC41ToTC44 extends CommonFunctions {
	@Test(priority = 67, description = "TC: Load lightbox URL ")
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

	// Verify AQUIFLOW tab is displayed on top bar in right panel and when
	// clicked, AQUIFLOW records are displayed in table
	@Test(priority = 68, description = "TC 41: Verify AQUIFLOW Tab ")
	public void verifyTitle() throws InterruptedException {
		System.out.println(
				"Verify AQUIFLOW tab is displayed on top bar in right panel and when clicked, AQUIFLOW records are displayed in table");
		APP_LOGS.debug(
				"Verify AQUIFLOW tab is displayed on top bar in right panel and when clicked, AQUIFLOW records are displayed in table\n");

		// Clicking on AQUIFLOW SubTab
		System.out.println("Clicking on PHYSICAL SETTINGS Tab.");
		APP_LOGS.debug("Clicking on PHYSICAL SETTINGS Tab.\n");
		WebElement physettings_tab_ele = driver.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
		HighlightElement(driver, physettings_tab_ele);
		physettings_tab_ele.click();
		Thread.sleep(8000);

		System.out.println("Clicking on AQUIFLOW Tab.");
		APP_LOGS.debug("Clicking on AQUIFLOW Tab.\n");
		WebElement aquiflow_subtab_ele = driver.findElement(By.xpath(OR.getProperty("aquiflow_subtab")));
		HighlightElement(driver, aquiflow_subtab_ele);
		Thread.sleep(8000);
		aquiflow_subtab_ele.click();
		Thread.sleep(6000);

		// Check whether tab title is displayed correctly or not.
		WebElement aquiflow_title = driver.findElement(By.xpath(OR.getProperty("aquiflow_title")));
		HighlightElement(driver, aquiflow_title);
		Thread.sleep(5000);

		String aquiflow_title_text = aquiflow_title.getText();

		if (aquiflow_title_text.trim().contains("AQUIFLOW")) {
			System.out.println("Title is displayed correctly.");
			System.out.println("Title text: " + aquiflow_title_text);
			System.out.println("Test case status: Pass \n");
		} else {
			System.out.println("Title is not displayed correctly.");
			System.out.println("Test case status: Fail \n");
			driver.quit();
		}

	}

	// Verify AQUIFLOW records count in list view and on map
	@Test(priority = 69, description = "TC 42: Verify Record Count for AQUIFLOW ")
	public void verifyAQUIFLOWRecordCount() throws InterruptedException {
		System.out.println("Verify AQUIFLOW records count in list view and on map ");
		APP_LOGS.debug("Verify AQUIFLOW records count in list view and on map\n");

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

	// Verify column adjustment feature for table list view for AQUIFLOW.
	@Test(priority = 70, description = "TC 43: Verify Add/Remove Column Feature ")
	public void verifyColumnAdjustmentFeature() throws InterruptedException {

		// Verify columns displayed in table
		System.out.println("\n Verify columns displayed in table");
		APP_LOGS.debug("\n Verify columns displayed in table \n");

		System.out.println("Displayed columns are as following: ");
		List<WebElement> AQUIFLOW_column_list = driver.findElements(By.xpath(OR.getProperty("aquiflow_column_list")));
		for (WebElement ele : AQUIFLOW_column_list) {
			if (ele.getAttribute("style").contains("width: 0px;")) {
				// System.out.println(""+ele.getText()+" column is not
				// displayed.");

			} else {
				System.out.println("" + ele.getText() + " column is displayed.");
			}
		}

		System.out.println("\n Check whether DISTANCE column is displayed or not.");

		WebElement distance_column = driver.findElement(By.xpath(OR.getProperty("aqui_distance_column")));
		if (distance_column.getAttribute("style").contains("width: 0px;")) {
			System.out.println("DISTANCE Column is not displayed.");
			System.out.println("Checking checkbox for DISTANCE Column");

			// clicking on columns drop down
			WebElement column_dropdown_ele = driver.findElement(By.xpath(OR.getProperty("aqui_column_dropdown")));
			HighlightElement(driver, column_dropdown_ele);
			Thread.sleep(5000);
			column_dropdown_ele.click();
			Thread.sleep(6000);

			WebElement distance_column_chckbx = driver.findElement(By.xpath(OR.getProperty("distft_column_chckbx")));
			HighlightElement(driver, distance_column_chckbx);
			Thread.sleep(5000);
			distance_column_chckbx.click();
			Thread.sleep(6000);

			// clicking outside of window
			driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
			Thread.sleep(5000);

			// verify whether Site Name column is displayed now or not
			if (distance_column.getAttribute("style").contains("width: 0px;")) {
				System.out.println("DISTANCE Column is not displayed.");
				System.out.println("Test case status: Fail \n");
			} else {
				System.out.println("DISTANCE Column is now displayed.");
				System.out.println("Width : " + distance_column.getAttribute("style"));
				System.out.println("Test case status: Pass\n");

				System.out
						.println("Unchecking checknbox again to verify whether DISTANCE column gets removed or not. ");

				// clicking on columns dropdown

				HighlightElement(driver, column_dropdown_ele);
				Thread.sleep(5000);
				column_dropdown_ele.click();
				Thread.sleep(6000);

				HighlightElement(driver, distance_column_chckbx);
				Thread.sleep(5000);
				distance_column_chckbx.click();
				Thread.sleep(6000);

				// clicking outside of window
				driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
				Thread.sleep(5000);

				// verify whether DISTANCE column is removed now or not
				if (distance_column.getAttribute("style").contains("width: 0px;")) {
					System.out.println("DISTANCE Column is not displayed");
					System.out.println("Test case status: Pass \n");
				} else {
					System.out.println("DISTANCE Column is displayed");
					System.out.println("Width : " + distance_column.getAttribute("style"));
					System.out.println("Test case status: Fail\n");
				}
			}
		} else {
			System.out.println("DISTANCE Column is displayed.");
			System.out.println("Checking checkbox for DISTANCE Column to uncheck DISTANCE column checkbox.");

			Thread.sleep(6000);

			// clicking on columns drop down
			WebElement column_dropdown_ele = driver.findElement(By.xpath(OR.getProperty("aqui_column_dropdown")));
			HighlightElement(driver, column_dropdown_ele);
			Thread.sleep(5000);
			column_dropdown_ele.click();
			Thread.sleep(6000);

			WebElement distance_column_chckbx = driver.findElement(By.xpath(OR.getProperty("distft_column_chckbx")));
			HighlightElement(driver, distance_column_chckbx);
			Thread.sleep(5000);
			distance_column_chckbx.click();
			Thread.sleep(6000);

			// clicking outside of window
			driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
			Thread.sleep(5000);

			// verify whether DISTANCE column is removed or not
			if (distance_column.getAttribute("style").contains("width: 0px;")) {
				System.out.println("DISTANCE Column is not displayed");
				System.out.println("Test case status: Pass\n");

				System.out.println("Checking checknbox again to verify whether DISTANCE column gets added or not. ");

				// clicking on columns dropdown

				HighlightElement(driver, column_dropdown_ele);
				Thread.sleep(5000);
				column_dropdown_ele.click();
				Thread.sleep(6000);

				HighlightElement(driver, distance_column_chckbx);
				Thread.sleep(5000);
				distance_column_chckbx.click();
				Thread.sleep(6000);

				// clicking outside of window
				driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
				Thread.sleep(5000);

				// verify whether DISTANCE column is displayed now or not
				if (distance_column.getAttribute("style").contains("width: 0px;")) {
					System.out.println("DISTANCE Column is not displayed");
					System.out.println("Test case status: Fail \n");
				} else {
					System.out.println("DISTANCE Column is displayed");
					System.out.println("Width : " + distance_column.getAttribute("style"));
					System.out.println("Test case status: Pass\n");
				}
			} else {
				System.out.println("DISTANCE Column is still displayed");
				System.out.println("Width : " + distance_column.getAttribute("style"));
				System.out.println("Test case status: Fail\n");

			}
		}

	}

	@Test(priority = 71, description = "TC 44: Verify Hightlight Filter on AQUIFLOW ")
	public void verifyHighLightFlagFilter() throws InterruptedException {
		System.out.println("Verify Highlight Flag Filter on List view records.");
		APP_LOGS.debug("Verify Highlight Flag Filter on List view records.\n");

		// Clicking on AQUIFLOW SubTab
		System.out.println("Clicking on PHYSICAL SETTINGS Tab.");
		APP_LOGS.debug("Clicking on PHYSICAL SETTINGS Tab.\n");
		WebElement physettings_tab_ele = driver.findElement(By.xpath(OR.getProperty("physical_settings_tab")));
		HighlightElement(driver, physettings_tab_ele);
		physettings_tab_ele.click();
		Thread.sleep(8000);

		System.out.println("Clicking on AQUIFLOW Tab.");
		APP_LOGS.debug("Clicking on AQUIFLOW Tab.\n");
		WebElement aquiflow_subtab_ele = driver.findElement(By.xpath(OR.getProperty("aquiflow_subtab")));
		HighlightElement(driver, aquiflow_subtab_ele);
		Thread.sleep(8000);
		aquiflow_subtab_ele.click();
		Thread.sleep(6000);

		// verify any filter is been applied, if yes remove it
		System.out.println("Verify any filter is been applied, if yes remove it.");
		try {
			WebElement db_filter = driver.findElement(By.xpath(OR.getProperty("db_filterby_link")));
			HighlightElement(driver, db_filter);
			db_filter.click();
			System.out.println("DB Filter removed.");
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
			System.out.println("No DB Filter is applied.");
		}
		try {
			WebElement address_filter = driver.findElement(By.xpath(OR.getProperty("address_filterby_link")));
			HighlightElement(driver, address_filter);
			address_filter.click();
			System.out.println("Address Filter removed.");
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
			System.out.println("No Address Filter is applied.");
		}
		try {
			WebElement relElevation_filter = driver.findElement(By.xpath(OR.getProperty("relelev_filterby_link")));
			HighlightElement(driver, relElevation_filter);
			relElevation_filter.click();
			System.out.println("Relative Elevation Filter removed.");
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
			System.out.println("No Relative Filter is applied.");
		}
		try {
			WebElement dist_filter = driver.findElement(By.xpath(OR.getProperty("dist_filterby_link")));
			HighlightElement(driver, dist_filter);
			dist_filter.click();
			System.out.println("Distance(ft) Filter removed.");
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
			System.out.println("No Distance(ft) Filter is applied.");
		}
		try {
			WebElement dist_mile_filter = driver.findElement(By.xpath(OR.getProperty("dist_mile_filterby_link")));
			HighlightElement(driver, dist_mile_filter);
			dist_mile_filter.click();
			System.out.println("Distance(ml) Filter applied.");
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
			System.out.println("No Distance(ml) Filter is removed.");
		}
		try {
			WebElement flag_filter = driver.findElement(By.xpath(OR.getProperty("flag_filterby_link")));
			HighlightElement(driver, flag_filter);
			flag_filter.click();
			System.out.println("Flag Filter applied.");
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
			System.out.println("No Flag Filter is removed.");
		}

		// Check record count displayed at the top of table
		WebElement record_count_note = driver.findElement(By.xpath(OR.getProperty("records_count_at_top")));
		HighlightElement(driver, record_count_note);
		Thread.sleep(5000);
		String note = record_count_note.getText();
		String count[] = note.split("\\s+");
		System.out.println("List view record count displayed at top of list view before any filter :" + count[0]);

		// Marking two record with flag green
		System.out.println("Marking two record with flag green");
		WebElement ele = driver
				.findElement(By.xpath(".//*[@id='toggleIconAquiflowFilter03d4fc36-cf93-4fcf-bdf2-b96cebc58fea']"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		ele = driver.findElement(
				By.xpath(".//*[@id='toggleFilterAquiflowDiv03d4fc36-cf93-4fcf-bdf2-b96cebc58fea']/div[4]/span[1]"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		ele = driver.findElement(By.xpath(".//*[@id='toggleIconAquiflowFilterfa47548f-b954-45e0-9722-a60f4c3a2826']"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		ele = driver.findElement(
				By.xpath(".//*[@id='toggleFilterAquiflowDivfa47548f-b954-45e0-9722-a60f4c3a2826']/div[4]/span[1]"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		// Applying filter on Highlight flag filter
		System.out.println("Applying filter on Highlight flag filter");
		WebElement highlight_flagfilter_dropdown = driver.findElement(By.xpath(".//*[@id='flagAquiflow']/div/span/i"));
		HighlightElement(driver, highlight_flagfilter_dropdown);
		// Thread.sleep(5000);
		highlight_flagfilter_dropdown.click();
		Thread.sleep(6000);

		// selecting green flag
		WebElement flag_green = driver.findElement(By.xpath(".//*[@id='AquiflowFlagFilter2']"));
		HighlightElement(driver, flag_green);
		Thread.sleep(5000);
		flag_green.click();
		Thread.sleep(6000);

		// Check record count displayed at the top of table
		System.out.println("Check record count displayed at the top of table when filter is applied.");
		record_count_note = driver.findElement(By.xpath(OR.getProperty("records_count_at_top")));
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
			System.out.println("Test case status: Pass");
		} else {
			System.out.println("Count is wrong.");
			System.out.println("Test case status: Fail");
		}

	}

	@Test(priority = 72, description = "TC 45: Verify Slideout panel for AQUIFLOW ")
	public void verifySlideout() {

	}

	@Test(priority = 73, description = "TC : Close lbx url")
	public void CloseWindow() {
		driver.close();
	}
}
