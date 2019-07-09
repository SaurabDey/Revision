package report.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrangeHRMLogin {
	WebDriver driver;
	public OrangeHRMLogin(WebDriver driver2) {
		driver= driver2;
	}
	public void loginMethod()
	{
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");
		
		WebDriverWait wai= new WebDriverWait(driver, 15);
		WebElement pass= wai.until(ExpectedConditions.presenceOfElementLocated(By.id("txtPassword")));		
		pass.sendKeys("admin12");

		WebElement login=wai.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
		login.click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		
	}
	
}
