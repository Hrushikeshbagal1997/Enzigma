package com.gvp.orm.Enzigma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class noKodr_LogIn_Function {

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
	// Correct username and password.
	public void loginTest_ValidCredential() {
		// Enter Valid User Name
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.clear();
		username.sendKeys("hrushikeshbagal@gmail.com");
		
		// Enter Valid Password
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("Rushikesh@4564");
		
		// Click LogIn Buttton
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']//div[@id='staticElement']"))
				.click();
		// verify LogIn Sucessfull
		
		String pageTitle=driver.getTitle();
		if(pageTitle.equals("noKodr")) {
			System.out.println("login Sucessfull ");
		}
		else {
			System.out.println("Login Failed!");
		}
		Assert.assertEquals("noKodr", pageTitle);
		// Log Out Account
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//img[@title='Hrushikesh Bagal']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
	}
	@Test(priority=2)
	// Incorrect username or password.
	public void loginTest_InvalidCredential() {
		// Enter InValid User Name
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.clear();
		username.sendKeys("hrushikeshbagalgmail.com");
		
		// Enter InValid Password
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("ushikesh@454");
		
		// Click LogIn Button
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']//div[@id='staticElement']"))
				.click();
		// Print Error Massage 
		
		WebElement  ErrorMassage = driver.findElement(By.xpath("//h1[normalize-space()='Error']"));
		System.out.println(ErrorMassage.getText());
		/*WebElement passwordErrorMassage = driver.findElement(By.xpath("//h2[normalize-space()='Please enter password']"));
		System.out.println(passwordErrorMassage.getText());
		*/
		
		if(ErrorMassage.getText().equals("Error")) {
			System.out.println("Error Please enter a valid email");
			
		}/*
		if(passwordErrorMassage.getText().equals("Error")) {
			System.out.println("Please enter password");
			
		}*/
		
		
		
		
	}
	
	
	@Test(priority=3)
	// Blank fields
	public void loginTest_Blankfields() {
		// Enter InValid User Name
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.clear();
		username.sendKeys("");
		
		// Enter InValid Password
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("");
		
		// Click LogIn Buttton
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']//div[@id='staticElement']"))
				.click();
		// Print Error Massage 
		
		WebElement  ErrorMassage = driver.findElement(By.xpath("//h1[normalize-space()='Error']"));
		System.out.println(ErrorMassage.getText());
		/*WebElement passwordErrorMassage = driver.findElement(By.xpath("//h2[normalize-space()='Please enter password']"));
		System.out.println(passwordErrorMassage.getText());
		*/
		
		
		if(ErrorMassage.getText().equals("Error")) {
			System.out.println("Error Please enter a valid email");
			
		}
		/*
		if(passwordErrorMassage.getText().equals("Error")) {
			System.out.println("Please enter password");
			}*/
		
	}
	
	
	// Special characters
	@Test(priority=4)
	// Blank fields
	public void loginTest_Specialcharacters() {
		// Enter InValid User Name
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.clear();
		username.sendKeys("hrushikesh#gmail.com");
		
		// Enter InValid Password
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("Rushikesh_9787");
		
		// Click LogIn Buttton
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']//div[@id='staticElement']"))
				.click();
		// Print Error Massage 
		
		WebElement  ErrorMassage = driver.findElement(By.xpath("//h1[normalize-space()='Error']"));
		System.out.println(ErrorMassage.getText());
		WebElement passwordErrorMassage = driver.findElement(By.xpath("//div[@class='slds-form-element__help']"));
		System.out.println(passwordErrorMassage.getText());
		
		
		
		if(ErrorMassage.getText().equals("Error")) {
			System.out.println("Error Please enter a valid email");
			
		}
		
		if(passwordErrorMassage.getText().equals("Error")) {
			System.out.println("Error Please enter a valid email");
		}
		
	}
	
	
	

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();

	}

}
