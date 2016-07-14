package RegressionSuite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC48 extends CommonFunctions {
	@Test(priority = 92, description = "TC : Loading lbx url")
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

	// Verify Reports Tab.
	@Test(priority = 93, description = "TC 48: Verify About Tab")
	public void verifyMapMarkers() throws InterruptedException {
		System.out.println("Verify About Tab.");
		APP_LOGS.debug("Verify About Tab.\n");

		try {
			System.out.println("Clicking on About Tab.");
			WebElement about_tab = driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[1]/li[3]/a"));
			HighlightElement(driver, about_tab);
			Thread.sleep(5000);
			about_tab.click();
			Thread.sleep(3000);

			System.out.println("Clicking on DATABASE DESCRIPTIONS Sub-tab");
			WebElement db_description_tab = driver
					.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[1]/li[3]/ul/li[1]/a"));
			HighlightElement(driver, db_description_tab);
			Thread.sleep(5000);

			db_description_tab.click();
			Thread.sleep(3000);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));

			// verify whether database description page is opened or not.
			System.out.println("Verify whether database description page is opened or not.");
			if (driver.getCurrentUrl().contains("database_descriptions")) {
				System.out.println("Database description page is displayed.");
				System.out.println("Test case status: Pass \n");
			} else {
				System.out.println("Database description page is not displayed.");
				System.out.println("Test case status: Fail \n");
			}

			Thread.sleep(5000);
			driver.close();

			driver.switchTo().window(tabs2.get(0));
		} catch (Exception e) {
			System.out.println("Error in viewing Database description page.");
		}

		try {
			System.out.println("Clicking on About Tab.");
			WebElement about_tab = driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[1]/li[3]/a"));
			HighlightElement(driver, about_tab);
			Thread.sleep(5000);
			about_tab.click();
			Thread.sleep(3000);

			System.out.println("Clicking on DISCLAIMER Sub-tab");
			WebElement disclaimer_tab = driver
					.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[1]/li[3]/ul/li[2]/a"));
			HighlightElement(driver, disclaimer_tab);
			Thread.sleep(5000);

			disclaimer_tab.click();
			Thread.sleep(3000);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));

			// verify whether database description page is opened or not.
			System.out.println("Verify whether disclaimer page is opened or not.");
			if (driver.getCurrentUrl().contains("disclaimer")) {
				System.out.println("Disclaimer page is displayed.");
				System.out.println("Test case status: Pass \n");
			} else {
				System.out.println("Disclaimer page is not displayed.");
				System.out.println("Test case status: Fail \n");
			}

			Thread.sleep(7000);
			driver.close();

			driver.switchTo().window(tabs2.get(0));
		} catch (Exception e) {
			System.out.println("Error in viewing Disclaimer page.");
		}

		try {
			System.out.println("Clicking on About Tab.");
			WebElement about_tab = driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[1]/li[3]/a"));
			HighlightElement(driver, about_tab);
			Thread.sleep(5000);
			about_tab.click();
			Thread.sleep(3000);

			System.out.println("Clicking on MAP LEGEND Sub-tab");
			WebElement maplegend_tab = driver
					.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[1]/li[3]/ul/li[3]/a"));
			HighlightElement(driver, maplegend_tab);
			Thread.sleep(5000);

			maplegend_tab.click();
			Thread.sleep(3000);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));

			// verify whether Map Legend page is opened or not.
			System.out.println("Verify whether Map Legend page is opened or not.");
			if (driver.getCurrentUrl().contains("maplegend")) {
				System.out.println("Map Legend page is displayed.");
				System.out.println("Test case status: Pass\n");
			} else {
				System.out.println("Map Legend page is not displayed.");
				System.out.println("Test case status: Fail\n");
			}

			Thread.sleep(7000);
			driver.close();

			driver.switchTo().window(tabs2.get(0));
		} catch (Exception e) {
			System.out.println("Error in viewing Map Legend page.");
		}

		try {
			System.out.println("Clicking on About Tab.");
			WebElement about_tab = driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[1]/li[3]/a"));
			HighlightElement(driver, about_tab);
			Thread.sleep(5000);
			about_tab.click();
			Thread.sleep(3000);

			System.out.println("Clicking on SANBORN MAP LEGEND Sub-tab");
			WebElement san_maplegend_tab = driver
					.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[1]/li[3]/ul/li[4]/a"));
			HighlightElement(driver, san_maplegend_tab);
			Thread.sleep(5000);

			san_maplegend_tab.click();
			Thread.sleep(3000);

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));

			// verify whether Sanborn Map Legend page is opened or not.
			System.out.println("Verify whether Sanborn Map Legend page is opened or not.");
			if (driver.getCurrentUrl().contains("sanbornkey")) {
				System.out.println("Sanborn Map Legend page is displayed.");
				System.out.println("Test case status: Pass\n");
			} else {
				System.out.println("Sanborn Map Legend page is not displayed.");
				System.out.println("Test case status: Fail\n");
			}

			Thread.sleep(7000);
			driver.close();

			driver.switchTo().window(tabs2.get(0));
		} catch (Exception e) {
			System.out.println("Error in viewing Sanborn Map Legend page.");
		}

	}

	@Test(priority = 94, description = "TC : Close lbx url")
	public void CloseWindow() {
		driver.close();
	}
}
