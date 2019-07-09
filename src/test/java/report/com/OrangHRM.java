package report.com;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class OrangHRM {
	WebDriver driver;
	ExtentTest test;
	ExtentReports extent;

	@Test
	public void f() throws IOException {

		try {
			test.info("Started login");
			OrangeHRMLogin log = new OrangeHRMLogin(driver);
			log.loginMethod();
			test.pass("Login Successful");
		} catch (Exception | AssertionError  e) {
			CommonClass common= new CommonClass(driver);		
			test.fail("Login was un-Successful : "+ e).addScreenCaptureFromPath(common.screenshotMethod("LoginErrorScreenshot"));

		}

		try {
			test.info("Started Dashboard activities");
			DashboradOrange dash = new DashboradOrange(driver);
			dash.dashboradmethod();
			test.pass("Dashboard Successful");
		} catch (Exception e) {
			CommonClass common= new CommonClass(driver);	
			test.fail("Dashboradmethod was un-Successful : "+ e , MediaEntityBuilder.createScreenCaptureFromPath(common.screenshotMethod("DashboardErrorScreenshot")).build());
		}
		

	}

	@BeforeTest
	public void beforeTest() {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("NewExtentOrange.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.setAppendExisting(true);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("SaurabHRMsite");
		test.info("Started the execution");

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();
		test.info("Started the browser");

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		test.info("Opened the site");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {

		driver.quit();
		test.info("Done withe the execution");
		extent.flush();
	}

}
