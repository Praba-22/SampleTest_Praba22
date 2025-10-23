package com.Project.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.*;
import org.apache.commons.io.FileUtils;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	// ----------------- Browser Launch -----------------
	public static void launchBrowser(String browser, String Url) {
		if (driver == null) {
			switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Browser not supported, launching Chrome by default.");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.get(Url);
		}
	}

	// ----------------- Waits -----------------
	public static void waitForElementVisible(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementClickable(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// ----------------- Screenshots -----------------
	public static void takeScreenshot(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ----------------- ExtentReports -----------------
	public static void setupExtentReports(String reportName) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/" + reportName + ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	public static void createTest(String testName) {
		test = extent.createTest(testName);
	}

	public static void flushReports() {
		extent.flush();
	}

	// ----------------- Excel Data-Driven -----------------
	public static String getExcelData(String filePath, String sheetName, int rowNum, int cellNum) {
		String value = "";
		try {
			FileInputStream file = new FileInputStream(filePath);
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			value = cell.toString();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	// ----------------- Close Browser -----------------
	public static void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
