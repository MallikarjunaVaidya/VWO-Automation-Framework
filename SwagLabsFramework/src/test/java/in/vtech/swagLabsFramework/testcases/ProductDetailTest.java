package in.vtech.swagLabsFramework.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.vtech.swagLabsFramework.base.TestBase;
import in.vtech.swagLabsFramework.pages.HomePage;
import in.vtech.swagLabsFramework.pages.InventoryPage;
import in.vtech.swagLabsFramework.pages.ProductDetailPage;

public class ProductDetailTest extends TestBase {
	public HomePage homePage;
	public InventoryPage inventoryPage;
	public ProductDetailPage productdetailPage;

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();

	}

	@Test(priority = 1)
	public void ProductImage() {

		String LoginUsername = "standard_user";
		String LoginPassword = "secret_sauce";
		homePage.enteruserName(LoginUsername);
		homePage.enterpassword(LoginPassword);
		homePage.clickloginButton();

		inventoryPage = new InventoryPage();

		inventoryPage.clickproductImage();
	}

	@Test(priority = 2)
	public void productDetail() {
		
		String LoginUsername = "standard_user";
		String LoginPassword = "secret_sauce";
		homePage.enteruserName(LoginUsername);
		homePage.enterpassword(LoginPassword);
		homePage.clickloginButton();

		inventoryPage = new InventoryPage();

		inventoryPage.clickproductImage();
		productdetailPage = new ProductDetailPage();

		productdetailPage.clickAddToCartButton();

		productdetailPage.clickShoppingCartLink();
	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
