package RegressionSuite;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC45 extends CommonFunctions {
	@Test(priority = 74, description = "TC: Load lightbox URL ")
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

	// Verify filter applied on summary tab is reflecting on map findings tab or
	// not.
	@Test(priority = 75, description = "TC 45: Verify Filter Dependency between SUMMARY and MAP FINDINGS DB filter ")
	public void verifyAddRemoveColumnFilter() throws InterruptedException {
		System.out.println("Verify filter applied on summary tab is reflecting on map findings tab or not.");
		APP_LOGS.debug("Verify filter applied on summary tab is reflecting on map findings tab or not.\n");

		Thread.sleep(6000);
		// click on summary tab
		System.out.println("Click on summary tab.");
		APP_LOGS.debug("Click on summary tab.\n");
		WebElement summary_tab = driver.findElement(By.xpath(".//*[@id='btnSummary']"));
		HighlightElement(driver, summary_tab);
		summary_tab.click();
		Thread.sleep(5000);

		// Initialize Javascript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside web element vertically (e.g. 100 pixel)
		js.executeScript("arguments[0].scrollTop = arguments[1];",
				driver.findElement(By.xpath(".//*[@id='summaryId_wrapper']/div/div[2]")), 100);
		Thread.sleep(8000);

		WebElement summary_tbl_row = driver.findElement(By.xpath(".//*[@id='summaryId']/tbody/tr[19]/td[1]"));
		HighlightElement(driver, summary_tbl_row);
		summary_tbl_row.click();
		Thread.sleep(5000);

		// Verify whether filter link is displayed or not
		try {
			WebElement filter_link = driver
					.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[3]/div[1]/div/div/div[2]/a"));
			HighlightElement(driver, filter_link);
			String link_txt = filter_link.getText();
			System.out.println("Filter applied on Database : " + link_txt);
			String count = driver.findElement(By.xpath(".//*[@id='summaryId']/tbody/tr[19]/td[9]")).getText();

			// navigate to map findings tab
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
			Thread.sleep(6000);

			// verify whether correct filter is displayed on map finding tab
			// check db filter is applied or not
			try {
				System.out.println("Filtered By :"
						+ driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div/span[2]/a[1]"))
								.getText());

				// check correct number of records are displayed
				WebElement record_count_note = driver
						.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div/span[1]"));
				HighlightElement(driver, record_count_note);
				Thread.sleep(5000);
				String note = record_count_note.getText();
				String count1[] = note.split("\\s+");
				System.out.println("List view record count displayed at top of list view :" + count1[0]);
				if (count.contains(count1[0])) {
					System.out.println(
							"Record count displayed on Summary for selected DB matched with displayed records on map findings.");
					System.out.println("Filter is applied successfully.");
					System.out.println("Test case status: Pass");
				} else {
					System.out.println("Incorrect records are displayed.");
					System.out.println("Test case status: Fail");
				}

			} catch (Exception e) {
				System.out.println("Filtered By Database link is not displayed.");
				System.out.println("Test case status: Fail");
			}

		} catch (Exception e) {
			System.out.println("Filter link is not displayed.");
			System.out.println("Test case status: Fail");
		}

	}

	@Test(priority = 76, description = "TC: Close lbx url ")
	public void CloseWindow() {
		driver.close();
	}
}
