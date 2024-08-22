package com.example.LearningSel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AppVWOLoginTest {

	WebDriver driver;
	ChromeOptions option;
	
	public static WebElement waitForElementPresent(WebDriver driver, By locator,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElement(locator);
	}
	
	@BeforeTest
	public void setup() {
		option=new ChromeOptions();
		option.addArguments("--start-maximized");
		driver=new ChromeDriver(option);
	}
		
	
	
	@Test(priority=1,groups = {"negative","sanity"})
	@Severity(SeverityLevel.BLOCKER)
	@Description("TC#1 Verify that with valid username and invalid password, Login is not Successful")
	
	public void invalidLogin() throws InterruptedException  {
		driver.get("https://app.vwo.com/#/login");
		driver.findElement(By.id("login-username")).sendKeys("mallikarjuna02v@gmail.com");
		driver.findElement(By.name("password")).sendKeys("M@Vaidya");
		driver.findElement(By.id("js-login-btn")).click();
		waitForElementPresent(driver,By.className("notification-box-description"),5000);

		String errorNotification=driver.findElement(By.className("notification-box-content")).getText();
		//Thread.sleep(2000);
		Assert.assertEquals(errorNotification, "Your email, password, IP address or location did not match");
		
	}
	
	@Test(priority = 2,groups={"positive","sanity"})
	@Severity(SeverityLevel.NORMAL)
	@Description("TC#1 Verify that with valid username and valid password, Login is Successful")
	public void validLogin()  {
		driver.navigate().refresh();
		driver.get("https://app.vwo.com/#/login");
		driver.findElement(By.id("login-username")).sendKeys("mallikarjuna02v@gmail.com");
		driver.findElement(By.name("password")).sendKeys("M@Vaidya");
		driver.findElement(By.id("js-login-btn")).click();
		String title=driver.getCurrentUrl();
		Assert.assertEquals(title, "https://app.vwo.com/#/login");
		
		driver.get("https://app.vwo.com/logout");
		
	}
	
	public void tearDown() {
		driver.quit();
	}
}
