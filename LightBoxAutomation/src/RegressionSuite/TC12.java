package RegressionSuite;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC12 extends CommonFunctions {

	@Test(priority = 22, description = "TC: Load lightbox URL ")
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

	// Verify column adjustment feature for table list view.
	@Test(priority = 23, description = "TC 12: Verify Add/Remove List Columns")
	public void verifyAddRemoveColumnFilter() throws InterruptedException {
		System.out.println("Verify column adjustment feature for table list view. ");
		APP_LOGS.debug("Verify column adjustment feature for table list view.\n");

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

		/*
		 * //clicking on columns dropdown WebElement column_dropdown_ele =
		 * driver.findElement(By.xpath(OR.getProperty("column_dropdown")));
		 * HighlightElement(driver,column_dropdown_ele); Thread.sleep(5000);
		 * column_dropdown_ele.click(); Thread.sleep(6000);
		 */
		System.out.println("Check whether DB column is displayed or not.");
		try {
			WebElement db_column = driver.findElement(By.xpath(OR.getProperty("db_column")));
			if (db_column.getAttribute("style").contains("width: 0px;")) {
				System.out.println("DB Column is not displayed.");
				System.out.println("Checking checkbox for DB Column to check checkbox for DB column");
				// clicking on columns dropdown
				WebElement column_dropdown_ele = driver.findElement(By.xpath(OR.getProperty("column_dropdown")));
				HighlightElement(driver, column_dropdown_ele);
				Thread.sleep(5000);
				column_dropdown_ele.click();
				Thread.sleep(6000);

				WebElement db_column_chckbx = driver.findElement(By.xpath(OR.getProperty("database_column_chckbx")));
				HighlightElement(driver, db_column_chckbx);
				Thread.sleep(5000);
				db_column_chckbx.click();
				Thread.sleep(6000);

				// clicking outside of window
				driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
				Thread.sleep(5000);
				// verify whether DB column is displayed now or not
				if (db_column.getAttribute("style").contains("width: 0px;")) {
					System.out.println("DB Column is not displayed");
					System.out.println("Test case status: Fail \n");
				} else {
					System.out.println("DB Column is now displayed");
					System.out.println("Width : " + db_column.getAttribute("style"));
					System.out.println("Test case status: Pass\n");

					System.out.println("Unchecking checknbox again to verify whether DB column gets removed or not. ");
					// clicking on columns dropdown
					column_dropdown_ele = driver.findElement(By.xpath(OR.getProperty("column_dropdown")));
					HighlightElement(driver, column_dropdown_ele);
					Thread.sleep(5000);
					column_dropdown_ele.click();
					Thread.sleep(6000);

					db_column_chckbx = driver.findElement(By.xpath(OR.getProperty("database_column_chckbx")));
					HighlightElement(driver, db_column_chckbx);
					Thread.sleep(5000);
					db_column_chckbx.click();
					Thread.sleep(6000);

					// clcking outside of window
					driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
					Thread.sleep(5000);

					// verify whether DB column is removed now or not
					if (db_column.getAttribute("style").contains("width: 0px;")) {
						System.out.println("DB Column is not displayed");
						System.out.println("Test case status: Pass \n");
					} else {
						System.out.println("DB Column is displayed");
						System.out.println("Width : " + db_column.getAttribute("style"));
						System.out.println("Test case status: Fail\n");
					}
				}
			} else {
				System.out.println("DB Column is displayed.");
				System.out.println("Checking checkbox for DB Column to uncheck DB column checkbox.");
				Thread.sleep(6000);
				// clicking on columns dropdown
				// System.out.println("1");
				WebElement column_dropdown_ele = driver.findElement(By.xpath(OR.getProperty("column_dropdown")));
				HighlightElement(driver, column_dropdown_ele);
				Thread.sleep(5000);
				// System.out.println("2");
				column_dropdown_ele.click();
				Thread.sleep(6000);
				// System.out.println("3");

				WebElement db_column_chckbx = driver.findElement(By.xpath(OR.getProperty("database_column_chckbx")));
				HighlightElement(driver, db_column_chckbx);
				Thread.sleep(5000);
				db_column_chckbx.click();
				Thread.sleep(6000);

				// clcking outside of window
				driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
				Thread.sleep(5000);
				// verify whether DB column is removed or not
				if (db_column.getAttribute("style").contains("width: 0px;")) {
					System.out.println("DB Column is not displayed");
					System.out.println("Test case status: Pass\n");

					System.out.println("Checking checknbox again to verify whether DB column gets added or not. ");
					// clicking on columns dropdown
					column_dropdown_ele = driver.findElement(By.xpath(OR.getProperty("column_dropdown")));
					HighlightElement(driver, column_dropdown_ele);
					Thread.sleep(5000);
					column_dropdown_ele.click();
					Thread.sleep(6000);

					db_column_chckbx = driver.findElement(By.xpath(OR.getProperty("database_column_chckbx")));
					HighlightElement(driver, db_column_chckbx);
					Thread.sleep(5000);
					db_column_chckbx.click();
					Thread.sleep(6000);

					// clcking outside of window
					driver.findElement(By.xpath(".//*[@id='sidebar']/div[1]/div[4]/div[1]/div/div")).click();
					Thread.sleep(5000);

					// verify whether DB column is displayed now or not
					if (db_column.getAttribute("style").contains("width: 0px;")) {
						System.out.println("DB Column is not displayed");
						System.out.println("Test case status: Fail \n");
					} else {
						System.out.println("DB Column is displayed");
						System.out.println("Width : " + db_column.getAttribute("style"));
						System.out.println("Test case status: Pass\n");
					}
				} else {
					System.out.println("DB Column is still displayed");
					System.out.println("Width : " + db_column.getAttribute("style"));
					System.out.println("Test case status: Fail\n");

				}
			}

		} catch (Exception e) {
			System.out.println("" + e.getMessage());
		}

	}

	@Test(priority = 24, description = "TC: Close lbx url")
	public void CloseWindow() {
		driver.close();
	}
}
