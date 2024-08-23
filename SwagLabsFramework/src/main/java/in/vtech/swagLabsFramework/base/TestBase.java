
package in.vtech.swagLabsFramework.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import in.vtech.swagLabsFramework.listeners.DriverListener;
import in.vtech.swagLabsFramework.listeners.TestNGListener;

public class TestBase {

	public static WebDriver driver;
	public static WebDriverWait explicitWait;// to wait until the element is visible
	public static Logger logger=LogManager.getLogger(TestNGListener.class);//
	public static EventFiringWebDriver eventFiringDriver; // its covert the normal driver 
	public static DriverListener driverListener; // used for action
	public static ExtentSparkReporter sparkReporter;//spark reporter means some advance re
	public static ExtentReports extentReports;  //declqaring
	public static ExtentTest extentTest;//used to start the test
	
	

	public static void initialization() {
		String chromeDriver = "D:\\Selenium-files\\chromedriver\\chromedriver-win64\\126\\chromedriver.exe";

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", chromeDriver);

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		eventFiringDriver = new EventFiringWebDriver(driver);
		// Now create object of EventListenerHandler to register it with
		// EventFiringWebDriver
		driverListener = new DriverListener();
		eventFiringDriver.register(driverListener);
		driver = eventFiringDriver;

		String baseUrl = "https://www.saucedemo.com/";
		driver.get(baseUrl);

		explicitWait = new WebDriverWait(driver, 30);// initialize the webdriver
		
		
				
	}

	public static void clickButton(By locator) {
		WebElement element = explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public static void enterField(By locator, String text) {
		WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}
	public static WebElement getElement(By locator) {
		WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	
	}
}
