package RegressionSuite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC14To17 extends CommonFunctions {
	@Test(priority = 28, description = "TC: Load lightbox URL ")
	public void beforeTest() throws InterruptedException, IOException {
		initialize();
		File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get(
				"http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=80bef1ce-2032-4070-91f7-bf7649486811&lsessguid=2360691e-4deb-4b5c-aae4-11ac0ce5b1ee");
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}

	// Verify Slideout panel for table list view records.
	@Test(priority = 29, description = "TC 14: Verify Slideout Panel for MAP FINDINGS")
	public void verifySlideOut() throws InterruptedException, IOException {
		System.out.println("Verify Slideout panel for table list view records. ");
		APP_LOGS.debug("Verify Slideout panel for table list view records. \n");

		WebElement width_dropdown = driver.findElement(By.xpath(OR.getProperty("width_dropdown")));
		HighlightElement(driver, width_dropdown);
		width_dropdown.click();
		Thread.sleep(5000);
		WebElement fiftyfive_percent = driver.findElement(By.xpath(OR.getProperty("55pct")));
		HighlightElement(driver, driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[2]/ul/li[7]")));
		fiftyfive_percent.click();
		Thread.sleep(5000);

		// Clicking on MAP FINDINGS SubTab
		System.out.println("Clicking on FINDINGS Tab.");
		APP_LOGS.debug("Clicking on FINDINGS Tab.\n");
		WebElement findings_tab_ele = driver.findElement(By.xpath(OR.getProperty("findings_tab")));
		HighlightElement(driver, findings_tab_ele);
		driver.findElement(By.xpath(OR.getProperty("findings_tab"))).click();
		Thread.sleep(3000);
		System.out.println("Clicking on MAP FINDINGS Tab.");
		APP_LOGS.debug("Clicking on MAP FINDINGS Tab.\n");
		WebElement map_findings_subtab_ele = driver.findElement(By.xpath(OR.getProperty("map_finding_subtab")));
		HighlightElement(driver, map_findings_subtab_ele);
		Thread.sleep(5000);
		map_findings_subtab_ele.click();
		Thread.sleep(8000);

		// Remove any filters if are.
		removeSavedFilters();

		Thread.sleep(5000);
		// Clicking on first record to view slideout panel for that record.
		System.out.println("Clicking on first record to view slideout panel for that record.");
		APP_LOGS.debug("Clicking on first record to view slideout panel for that record.");

		WebElement first_record_listview_ele = driver.findElement(By.xpath(OR.getProperty("first_row_listview")));
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
			System.out.println(
					"Verify slideout panel has correct site information as on list view record i.e. SITE NAME and ADDRESS information.");
			APP_LOGS.debug(
					"Verify slideout panel has correct site information as on list view record i.e. SITE NAME and ADDRESS information.\n");

			WebElement site_name_data = driver.findElement(By.xpath(OR.getProperty("first_row_site_name_column")));
			HighlightElement(driver, site_name_data);
			Thread.sleep(5000);
			WebElement address_data = driver.findElement(By.xpath(OR.getProperty("first_row_address_column")));
			HighlightElement(driver, address_data);
			Thread.sleep(5000);
			System.out.println("Site Name :" + site_name_data.getText());
			APP_LOGS.debug("Site Name :" + site_name_data.getText() + "\n");
			System.out.println("Address :" + address_data.getText());
			APP_LOGS.debug("Address :" + address_data.getText() + "\n");
			System.out.println("\n");

			System.out.println("Information on Slideout Panel :");
			APP_LOGS.debug("Information on Slideout Panel : \n");
			WebElement slideout_panel_info = driver
					.findElement(By.xpath(OR.getProperty("slideout_panel_top_header_info")));
			HighlightElement(driver, slideout_panel_info);
			Thread.sleep(5000);

			System.out.println("" + slideout_panel_info.getText().trim());
			APP_LOGS.debug("" + slideout_panel_info.getText().trim() + "\n");
			Thread.sleep(5000);
			System.out.println("\n");
			int flag = 0;
			String info[] = slideout_panel_info.getText().split("\\s+");
			if (site_name_data.getText().trim().equals(info[0].trim())) {
				System.out.println("SITE NAME matched correctly.");
				APP_LOGS.debug("SITE NAME matched correctly.");
			} else {
				flag = 1;
				System.out.println("Site name do not match!");
				APP_LOGS.debug("Site name do not match!");
			}
			String address = driver.findElement(By.xpath(".//*[@id='headerPanel']/div[1]/div/div/div[1]/b[1]/span[1]"))
					.getText();

			if (address_data.getText().trim().contains(address)) {
				System.out.println("ADDRESS matched correctly.");
				APP_LOGS.debug("ADDRESS matched correctly.");
			} else {

				System.out.println("ADDRESS do not match!");
				APP_LOGS.debug("ADDRESS do not match!");
				flag = 1;
			}

			if (flag == 0) {
				System.out.println("Both site name and address are displayed correct.");
				APP_LOGS.debug("Both site name and address are displayed correct.");
				System.out.println("Test case status: Pass \n");
				APP_LOGS.debug("Test case status: Pass \n");
			} else {
				System.out.println("Error...site name and address do not match.");
				APP_LOGS.debug("Error...site name and address do not match.");
				System.out.println("Test case status: Fail\n");
				APP_LOGS.debug("Test case status: Fail\n");
			}
		} else {
			System.out.println("Slideout panel is not displayed.");
			APP_LOGS.debug("Slideout panel is not displayed.");
			System.out.println("Test case status: Fail \n");
			APP_LOGS.debug("Test case status: Fail \n");
		}

	}

	// Verify DB links are displayed and names are matching.
	@Test(priority = 30, description = "TC15: Verify DB link on Slideout panel.")
	public void verifyDBLinks() throws InterruptedException {
		System.out.println("Verify DB links are displayed and names are matching.");
		APP_LOGS.debug("Verify DB links are displayed and names are matching.\n");

		// Clicking on list record with multiple DB listing.
		System.out.println("Clicking on list record with multiple DB listing.");
		APP_LOGS.debug("Clicking on list record with multiple DB listing.\n");

		WebElement third_row = driver.findElement(By.xpath(OR.getProperty("third_row_listview")));
		HighlightElement(driver, third_row);
		Thread.sleep(5000);
		third_row.click();
		Thread.sleep(10000);
		// expanding db list
		driver.findElement(By.xpath(".//*[@id='headerPanel']/div[1]/div/div/div[2]/div/div[3]/a/span[2]")).click();
		Thread.sleep(6000);

		List<WebElement> db_in_list_view = driver.findElements(By.xpath(OR.getProperty("third_row_db_list")));
		List<WebElement> db_in_slideout = driver.findElements(By.xpath(OR.getProperty("slideout_panel_db_list")));

		// verify count of DB's matches.
		System.out.println("Verify count of DB's matches.");
		APP_LOGS.debug("verify count of DB's matches.\n");
		String a, b;
		int flag = 0;
		if (db_in_list_view.size() == db_in_slideout.size()) {
			System.out.println("DB count matched.\n" + db_in_slideout.size());
			System.out.println("Verify DB Names on list view and on slideout panel.");

			for (WebElement db_slide : db_in_list_view) {
				a = db_slide.getText();

				for (WebElement we : db_in_slideout) {
					b = we.getText();
					// System.out.println(""+b);
					if (b.contains(a)) {
						System.out.println("DB Name Matched :");
						System.out.println("DB Name on Slide Out :" + b);
						System.out.println("DB Name on List View :" + a);
						System.out.println("");
						flag = flag + 1;
						break;
					}

				}

			}
			// System.out.println(""+flag);
			// System.out.println(""+db_in_slideout.size());
			if (flag == db_in_slideout.size() && flag == db_in_list_view.size()) {
				System.out.println("All DB Names matched.");
				System.out.println("Test case status: Pass \n");
			} else {
				System.out.println("DB names do not matched.");
				System.out.println("Test case status: Fail \n");
			}

		} else {
			System.out.println("DB count do not matched.");
			System.out.println("Test case status: Fail \n");
		}
	}

	// Verify Slideout panel for DIST/Dir.link.
	@Test(priority = 31, description = "TC 16: Verify DIST/DIR Link on Slideout panel")
	public void verifyFilters() throws InterruptedException, IOException {
		System.out.println("Verify Slideout panel for DIST/Dir.link. ");
		APP_LOGS.debug("Verify Slideout panel for DIST/Dir.link. \n");

		/*
		 * //Clicking on MAP FINDINGS SubTab System.out.println(
		 * "Clicking on FINDINGS Tab."); APP_LOGS.debug(
		 * "Clicking on FINDINGS Tab.\n"); WebElement findings_tab_ele =
		 * driver.findElement(By.xpath(OR.getProperty("findings_tab")));
		 * HighlightElement(driver,findings_tab_ele);
		 * driver.findElement(By.xpath(OR.getProperty("findings_tab"))).click();
		 * Thread.sleep(3000); System.out.println(
		 * "Clicking on MAP FINDINGS Tab."); APP_LOGS.debug(
		 * "Clicking on MAP FINDINGS Tab.\n"); WebElement
		 * map_findings_subtab_ele =
		 * driver.findElement(By.xpath(OR.getProperty("map_finding_subtab")));
		 * HighlightElement(driver,map_findings_subtab_ele); Thread.sleep(5000);
		 * map_findings_subtab_ele.click(); Thread.sleep(8000);
		 * 
		 * //Remove any filters if are. removeSavedFilters();
		 * 
		 * Thread.sleep(5000); //Clicking on first record to view slideout panel
		 * for that record. System.out.println(
		 * "Clicking on first record to view slideout panel for that record.");
		 * APP_LOGS.debug(
		 * "Clicking on first record to view slideout panel for that record.");
		 * 
		 * WebElement first_record_listview_ele =
		 * driver.findElement(By.xpath(OR.getProperty("first_row_listview")));
		 * HighlightElement(driver,first_record_listview_ele);
		 * Thread.sleep(5000); first_record_listview_ele.click();
		 * Thread.sleep(16000);
		 * 
		 * //Verify whether slideout panel is displayed or not.
		 * System.out.println(
		 * "Verify whether slideout panel is displayed or not.");
		 * APP_LOGS.debug("Verify whether slideout panel is displayed or not.\n"
		 * );
		 * 
		 * System.out.println(""+driver.findElement(By.xpath(OR.getProperty(
		 * "slideout_panel"))).getAttribute("style"));
		 * if(driver.findElement(By.xpath(OR.getProperty("slideout_panel"))).
		 * getAttribute("style").contains("display: block;")) {
		 * System.out.println("Slideout panel is displayed."); APP_LOGS.debug(
		 * "Slideout panel is displayed.\n");
		 * 
		 * 
		 */
		System.out.println("Checking status of DIR/DIST link.");

		if (driver.findElement(By.xpath(".//*[@id='expandDetails']")).getAttribute("class")
				.contains("bg-detail-blue ng-hide")) {
			System.out.println("DIST/DIR information is not displayed on screen.");
			System.out.println("Clicking on DIST/DIR link to view the details.");

			WebElement dist_dir_link = driver.findElement(By.xpath(OR.getProperty("dist_dir_link")));
			HighlightElement(driver, dist_dir_link);
			Thread.sleep(5000);
			dist_dir_link.click();
			Thread.sleep(16000);

			System.out.println("Check DIST/DIR info is displayed or not.");
			if (driver.findElement(By.xpath(".//*[@id='expandDetails']")).getAttribute("class")
					.contains("bg-detail-blue")) {
				System.out.println("Link text changed to : " + dist_dir_link.getText());
				System.out.println("DIST/DIR information is displayed on screen.");
				System.out.println("Test case status: Pass \n");
			} else {
				System.out.println("DIST/DIR information is not displayed on screen.");
				System.out.println("Test case status: Fail\n");
			}
		} else {
			System.out.println("DIST/DIR information is displayed on screen.");
			System.out.println("Clicking on DIST/DIR link to hide the details.");

			WebElement dist_dir_link = driver.findElement(By.xpath(OR.getProperty("dist_dir_link")));
			HighlightElement(driver, dist_dir_link);
			Thread.sleep(5000);
			dist_dir_link.click();
			Thread.sleep(16000);

			System.out.println("Check DIST/DIR info is displayed or not.");
			if (driver.findElement(By.xpath(".//*[@id='expandDetails']")).getAttribute("class")
					.contains("bg-detail-blue ng-hide")) {
				System.out.println("Link text changed to : " + dist_dir_link.getText());
				System.out.println("DIST/DIR information is hidden on screen.");
				System.out.println("Test case status: Pass \n");
			} else {
				System.out.println("DIST/DIR information is still displayed on screen.");
				System.out.println("Test case status: Fail \n");
			}
		}
		/*
		 * }else { System.out.println("Slideout panel is not displayed.");
		 * APP_LOGS.debug("Slideout panel is not displayed.");
		 * System.out.println("Test case status: Fail \n"); APP_LOGS.debug(
		 * "Test case status: Fail \n"); }
		 */
	}

	// Verify popout link on slideout panel.
	@Test(priority = 32, description = "TC 17: Verify Popout page for Map Findings")
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
			System.out.println("Property details page is not displayed.");
			System.out.println("Test case status: Fail \n");
		}

		Thread.sleep(5000);
		driver.close();

		driver.switchTo().window(tabs2.get(0));

	}

	@Test(priority = 33, description = "TC :Close lbx url")
	public void CloseWindow() {
		driver.close();
	}
}
