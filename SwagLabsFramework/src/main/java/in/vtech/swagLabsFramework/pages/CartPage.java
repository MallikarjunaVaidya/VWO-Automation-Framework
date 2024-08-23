package in.vtech.swagLabsFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import in.vtech.swagLabsFramework.base.TestBase;

public class CartPage extends TestBase {

	private By pageHeaderText = By.xpath("//span[contains(text(),'Your Cart')]");
	private By productName = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
	private By removeButton = By.xpath("//button[contains(text(),'Remove')]");
	private By checkoutButton = By.id("checkout");

	public String getpageHeaderText() {
		WebElement element = getElement(pageHeaderText);
		String elementText = element.getText();
		return elementText;

	}

	public String getproductName() {
		WebElement element = getElement(productName);
		String elementText = element.getText();
		return elementText;

	}

	public void clickRemoveButton() {
		clickButton(removeButton);
	}

	public void clickCheckoutButton() {
		clickButton(checkoutButton);
	}

}
