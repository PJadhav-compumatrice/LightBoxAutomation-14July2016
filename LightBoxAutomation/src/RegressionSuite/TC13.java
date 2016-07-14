package RegressionSuite;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC13 extends CommonFunctions {
	@Test(priority = 25, description = "TC: Load lightbox URL ")
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

	// Verify Filters on List view record columns.-
	@Test(priority = 26, description = "TC 13: Verify Filter on Dist Column")
	public void verifyFilters() throws InterruptedException {
		System.out.println("Verify Dist Filter on List view records. ");
		APP_LOGS.debug("Verify Dist Filter on List view records.\n");

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
		Thread.sleep(8000);
		map_findings_subtab_ele.click();
		Thread.sleep(8000);

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
			;
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
		System.out.println(" ");
		// Verify Dist(ft) filter
		System.out.println("Verifying Distance(ft) Filter.");
		System.out.println("Clicking on Distance filter.");

		WebElement dist_filter_dropdown = driver.findElement(By.xpath(OR.getProperty("dist_filter_dropdown")));
		HighlightElement(driver, dist_filter_dropdown);
		Thread.sleep(5000);
		dist_filter_dropdown.click();
		Thread.sleep(5000);

		// entering manual ft distance
		System.out.println("Entering ft value manually.");
		driver.findElement(By.xpath(".//*[@id='distFindings']/div/ul/li[6]/div/label/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='ftdist']")).clear();

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='ftdist']")).sendKeys("1", Keys.ENTER);
		Thread.sleep(5000);

		// clcking outside of window
		driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
		Thread.sleep(5000);

		// Verify whether distance filter is applied or not
		System.out.println("Verify whether distance filter is applied or not.");
		System.out.println("Verify whether Filtered By link is displayed or not.");
		try {

			WebElement dist_filter = driver.findElement(By.xpath(OR.getProperty("dist_filterby_link")));
			HighlightElement(driver, dist_filter);
			System.out.println("Distance(ft) Filter By link is displayed.");
			System.out.println("Test case status: Pass");
			Thread.sleep(5000);

			// Verify filter is applied on table or not.
			System.out.println("Verify filter is applied on table or not.");
			// Check record count displayed at the top of table
			record_count_note = driver
					.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div/span[1]"));
			HighlightElement(driver, record_count_note);
			Thread.sleep(5000);
			note = record_count_note.getText();
			String count1[] = note.split("\\s+");
			System.out.println("List view record count displayed at top of list view after filter on Distance filter :"
					+ count1[0]);

			// Verify whether no record is displayed with distance value greater
			// that 1 ft.
			System.out.println("Verify whether no record is displayed with distance value greater that 1 ft.");

			List<WebElement> allRowData = driver
					.findElements(By.xpath("//div[@id='findingTblBody']/table/tbody/tr/td[10]"));
			String a;
			int flag = 1;

			for (WebElement we : allRowData) {
				a = we.getText();
				float f = Float.parseFloat(a);
				System.out.println("Data in row dist(ft) column :" + f);
				if (f <= 1) {

				} else {
					flag = 0;
				}

			}
			if (flag == 1) {
				System.out.println("No record with dist value greater that 1 is displayed.");
				System.out.println("Test case status: Pass");

			} else {
				System.out.println("Records with value greater than 1 are displayed.");
				System.out.println("Test case status: Fail");
			}
		} catch (Exception e) {
			// as no filter is applied, do nothing
			System.out.println("No Distance(ft) Filter By link is displayed.");
			System.out.println("Test case status: Fail");
		}
		try {
			;
			WebElement dist_filter = driver.findElement(By.xpath(OR.getProperty("dist_filterby_link")));
			HighlightElement(driver, dist_filter);
			dist_filter.click();
			// System.out.println("Distance(ft) Filter removed.");
			Thread.sleep(5000);
		} catch (Exception e) {
			// as no filter is applied, do nothing
			// System.out.println("No Distance(ft) Filter is applied.");
		}

	}

	@Test(priority = 27, description = "TC :Close lbx url")
	public void CloseWindow() {
		driver.close();
	}
}
