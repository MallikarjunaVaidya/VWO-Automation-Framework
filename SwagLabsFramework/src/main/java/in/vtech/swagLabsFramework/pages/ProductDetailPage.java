package in.vtech.swagLabsFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import in.vtech.swagLabsFramework.base.TestBase;

public class ProductDetailPage extends TestBase {

	private By productName = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
	private By addToCartButton = By.id("add-to-cart");
	private By shoppingCartLink = By.xpath("//a[@class='shopping_cart_link']");

	public String getProductNameText() {
		WebElement element = getElement(productName);
		String elementText = element.getText();
		return elementText;

	}

	public void clickAddToCartButton() {
		clickButton(addToCartButton);
	}

	public void clickShoppingCartLink() {
		clickButton(shoppingCartLink);
	}

}
