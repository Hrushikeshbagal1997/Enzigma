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

public class noKodr_Forgot_Password_Validation {
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
	@Test(priority=1)
	//Check for mandatory email field
	public void Check_for_mandatory_email_field() {
		driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
		 WebElement emailInputField = driver.findElement(By.xpath("(//div[@id='messageInputTag'])[3]"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(emailInputField).click().sendKeys("hrushikeshbagal@gmail.com").perform();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.xpath("//abx-button[@name='proceed']//div[@id='staticElement']")).click();
		 
		WebElement errormassage= driver.findElement(By.xpath("//h1[normalize-space()='Error']"));
		System.out.println(errormassage.getText());
		String pageTitle=errormassage.getText();
		
		
		if(pageTitle.equals("Error")) {
			System.out.println("Please Enter Email");
		}
		else {
			System.out.println("Enter Valid Email ");
		}

	
		
	}
	@Test(priority=2)
	//Validate email format
	public void Validate_Email_Format() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
		 WebElement emailInputField = driver.findElement(By.xpath("(//div[@id='messageInputTag'])[3]"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(emailInputField).click().sendKeys("hrushikeshbagalgmail.com").perform();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.xpath("//abx-button[@name='proceed']//div[@id='staticElement']")).click();
	 
	}
	

	
	
	@Test(priority=3)
	//Valid inputs
	public void Valid_inputs() {
		driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
		 WebElement emailInputField = driver.findElement(By.xpath("(//div[@id='messageInputTag'])[3]"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(emailInputField).click().sendKeys("hrushikeshbagal@gmail.com").perform();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.xpath("//abx-button[@name='proceed']//div[@id='staticElement']")).click();
		
	
		
		
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();

	}

}
