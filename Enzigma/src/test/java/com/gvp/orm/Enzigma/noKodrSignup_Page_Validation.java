package com.gvp.orm.Enzigma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class noKodrSignup_Page_Validation {
	public String baseURL = "https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login";
	public WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}
	@Test(priority=3)
	public void Signup_Page_Validation() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign up']")).click();
		WebElement emailInputField = driver.findElement(By.xpath("(//div[@id='messageInputTag'])[3]"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(emailInputField).click().sendKeys("hrushikeshbagal6298@gmail.com").perform();
		 
		 driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		 driver.findElement(By.xpath("//div[normalize-space()='Proceed']//div[@id='staticElement']")).click();
		 
		 
		 // i used all my email address they show error massage email already register 
		
		
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();

	}
	
}
