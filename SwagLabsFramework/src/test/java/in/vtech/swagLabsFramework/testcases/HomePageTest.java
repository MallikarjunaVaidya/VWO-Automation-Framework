package in.vtech.swagLabsFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.vtech.swagLabsFramework.base.TestBase;
import in.vtech.swagLabsFramework.pages.HomePage;

public class HomePageTest extends TestBase {

	public HomePage homepage;

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
	}

	@Test(priority = 1)
	public void validateHomePageTitle() {

		String expectedPageTitle = "Swag Labs";
		String actualPageTitle = homepage.getHomePageTitle();
		System.out.println("HOME_PAGE_TITLE:" + actualPageTitle);
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "HOME_PAGE_IS NOT_MATCHED");

	}

	@Test(priority = 2)
	public void validateHomePageHeaderTextIsDisplayed() {
		boolean flag = homepage.isPageHeaderTextDisplayed();
		Assert.assertTrue(flag, "PAGE_HEADER_TEXT_IS_NOT_DISPLAYED ");
		
	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
