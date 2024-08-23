package in.vtech.swagLabsFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.vtech.swagLabsFramework.base.TestBase;
import in.vtech.swagLabsFramework.pages.CartPage;
import in.vtech.swagLabsFramework.pages.CheckoutPage;
import in.vtech.swagLabsFramework.pages.HomePage;
import in.vtech.swagLabsFramework.pages.InventoryPage;
import in.vtech.swagLabsFramework.pages.ProductDetailPage;

public class CheckoutTest extends TestBase {
	public HomePage homePage;
	public InventoryPage inventoryPage;
	public ProductDetailPage productdetailPage;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();

	}

	@Test(priority = 1)
	public void validateHomePageTitle() {

		String LoginUsername = "standard_user";
		String LoginPawword = "secret_sauce";
		homePage.enteruserName(LoginUsername);
		homePage.enterpassword(LoginPawword);
		homePage.clickloginButton();
		inventoryPage = new InventoryPage();

		inventoryPage.clickproductImage();
		productdetailPage = new ProductDetailPage();
		productdetailPage.clickAddToCartButton();
		productdetailPage.getProductNameText();
		productdetailPage.clickShoppingCartLink();

		cartPage = new CartPage();
		cartPage.clickCheckoutButton();

	}

	@Test(priority = 2)
	public void validateInventoryPageHeaderTextIsDisplayed() {

		String LoginUsername = "standard_user";
		String LoginPawword = "secret_sauce";
		homePage.enteruserName(LoginUsername);
		homePage.enterpassword(LoginPawword);
		homePage.clickloginButton();

		inventoryPage = new InventoryPage();
		inventoryPage.clickproductImage();

		productdetailPage = new ProductDetailPage();
		productdetailPage.clickAddToCartButton();
		productdetailPage.getProductNameText();
		productdetailPage.clickShoppingCartLink();

		cartPage = new CartPage();
		cartPage.clickCheckoutButton();

		checkoutPage = new CheckoutPage();
		checkoutPage.enterfirstnameField("Liki");
		checkoutPage.enterlastnameField(" h h");
		checkoutPage.enterzipcodeField("560007");
		checkoutPage.clickContinueButton();
		checkoutPage.clickFinishButton();
		checkoutPage.clickBackToHomeButton();

	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
