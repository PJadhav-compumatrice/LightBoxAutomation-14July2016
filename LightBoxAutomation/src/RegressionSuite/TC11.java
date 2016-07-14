package RegressionSuite;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC11 extends CommonFunctions {
	@Test(priority = 19, description = "TC: Load lightbox URL ")
	public void beforeTest() throws InterruptedException, IOException {
		initialize();
		// selectBrowser();
		File file = new File("C:\\Users\\Admin\\workspace\\LightBoxAutomation\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();

		driver.get(
				"http://www.web.edrnet.com/ordering/lightboxv3/index.html#/?pguid=80bef1ce-2032-4070-91f7-bf7649486811&lsessguid=2360691e-4deb-4b5c-aae4-11ac0ce5b1ee");
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}

	// Verify Highlight Flag Filter on List view records.
	@Test(priority = 20, description = "TC 11: Verify Highlight flag filter for MAP  FINDINGS")
	public void verifyHighLightFlagFilter() throws InterruptedException {
		System.out.println("Verify Highlight Flag Filter on List view records. ");
		APP_LOGS.debug("Verify Highlight Flag Filter on List view records.\n");

		//// Clicking on MAP FINDINGS SubTab
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
		Thread.sleep(6000);

		// Calculating number of records displayed in list view from table rows

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
		WebElement record_count_note = driver
				.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div/span[1]"));
		HighlightElement(driver, record_count_note);
		Thread.sleep(5000);
		String note = record_count_note.getText();
		String count[] = note.split("\\s+");
		System.out.println("List view record count displayed at top of list view before any filter :" + count[0]);

		// Marking two record with flag green
		System.out.println("Marking two record with flag green");
		WebElement ele = driver
				.findElement(By.xpath(".//*[@id='toggleIconFilterc1714098-ac41-4305-bd60-7219ee54f857']"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		ele = driver.findElement(
				By.xpath(".//*[@id='toggleFilterDivc1714098-ac41-4305-bd60-7219ee54f857']/div[4]/span[1]"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		ele = driver.findElement(By.xpath(".//*[@id='toggleIconFilter6e2f07fa-0026-4f51-8c51-84d656f5a72e']"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		ele = driver.findElement(
				By.xpath(".//*[@id='toggleFilterDiv6e2f07fa-0026-4f51-8c51-84d656f5a72e']/div[4]/span[1]"));
		HighlightElement(driver, ele);
		ele.click();
		Thread.sleep(4000);

		// Applying filter on Highlight flag filter
		System.out.println("Applying filter on Highlight flag filter");
		WebElement highlight_flagfilter_dropdown = driver
				.findElement(By.xpath(OR.getProperty("flag_filter_dropdown_link")));
		HighlightElement(driver, highlight_flagfilter_dropdown);
		// Thread.sleep(5000);
		highlight_flagfilter_dropdown.click();
		Thread.sleep(6000);

		// selecting green flag
		WebElement flag_green = driver.findElement(By.xpath(OR.getProperty("flag_green")));
		HighlightElement(driver, flag_green);
		Thread.sleep(5000);
		flag_green.click();
		Thread.sleep(6000);

		// Check record count displayed at the top of table
		System.out.println("Check record count displayed at the top of table when filter is applied.");
		record_count_note = driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div/span[1]"));
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
		try {
			WebElement flag_filter = driver.findElement(By.xpath(OR.getProperty("flag_filterby_link")));
			HighlightElement(driver, flag_filter);
			flag_filter.click();
			// System.out.println("\n Flag Filter applied.");
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
			// System.out.println(" \n No Flag Filter is removed.");
		}

	}

	@Test(priority = 21, description = "TC: Close lbx url")
	public void CloseWindow() {
		driver.close();
	}

}
