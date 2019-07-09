package report.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboradOrange {
	WebDriver driver;
	public DashboradOrange(WebDriver driver2) {
		driver=driver2;
	}
	public void dashboradmethod()
	{
		WebDriverWait wai= new WebDriverWait(driver, 15);
		List<WebElement> tablecontent=wai.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table/tbody/tr")));		 
		System.out.println(tablecontent.size());
		
		for (int i = 1; i <= tablecontent.size(); i++) {
			
			WebElement empname=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]"));
			System.out.println(empname.getText());
			
			if ("Admin".equals(empname.getText())) {
				driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]/input")).click();
			}
		}
	}
	public void test() {
		System.out.println("Testt");
	}
}
