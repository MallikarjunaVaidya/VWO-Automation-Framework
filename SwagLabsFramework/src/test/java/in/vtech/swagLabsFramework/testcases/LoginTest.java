package in.vtech.swagLabsFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.vtech.swagLabsFramework.base.TestBase;
import in.vtech.swagLabsFramework.pages.HomePage;
import in.vtech.swagLabsFramework.pages.InventoryPage;

public class LoginTest extends TestBase {

	public HomePage homePage;
	public InventoryPage inventoryPage;

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();

	}

	@Test
	public void UserLoginPage() {

		String LoginUsername = "standard_user";
		String LoginPawword = "secret_sauce";
		homePage.enteruserName(LoginUsername);
		homePage.enterpassword(LoginPawword);
		homePage.clickloginButton();
		inventoryPage = new InventoryPage();

	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}
}
