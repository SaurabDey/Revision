package com.git.start.RevisionProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboradClass {
	WebDriver driver;
	public DashboradClass(WebDriver driver2) {
		driver=driver2;
	}
	public void dashboradmethod()
	{
		WebElement clickPost=  driver.findElement(By.xpath("//div[text()='Posts']"));
	      clickPost.click();
	      WebElement clickAddnew=  driver.findElement(By.xpath("//a[text()='Add New'][@href='post-new.php']"));
	      System.out.println("Hello");
	      clickAddnew.click();
	      

	      WebElement enter =  driver.findElement(By.xpath("//input[@name='post_title']"));
	         enter.sendKeys("abcd");

	      System.out.println("Succesfully Loaded Project on local System");
	      System.out.println("Amol");
	}
	public void test() {
		System.out.println("Testt");
	}
}
