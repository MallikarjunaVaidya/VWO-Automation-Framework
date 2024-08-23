package in.vtech.swagLabsFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import in.vtech.swagLabsFramework.base.TestBase;

public class CheckoutPage extends TestBase {
	private By firstnameField = By.id("first-name");
	private By lastnameField = By.id("last-name");
	private By zipcodeField = By.id("postal-code");
	private By continueButton = By.id("continue");
	private By cancelButton = By.id("cancel");
	private By headerPageText = By.xpath("//span[contains(text(),'Checkout: Your Information')]");
	private By finishButton = By.id("finish");
	private By backToHomeButton = By.id("back-to-products");

	public void enterfirstnameField(String text) {
		enterField(firstnameField, text);
	}

	public void enterlastnameField(String text) {
		enterField(lastnameField, text);
	}

	public void enterzipcodeField(String text) {
		enterField(zipcodeField, text);
	}

	public void clickContinueButton() {
		clickButton(continueButton);
	}

	public void clickFinishButton() {
		clickButton(finishButton);
	}

	public void clickBackToHomeButton() {
		clickButton(backToHomeButton);
	}

	public void clickCancelButton() {
		clickButton(cancelButton);
	}

	public String getpageHeaderText() {
		WebElement element = getElement(headerPageText);
		String elementText = element.getText();
		return elementText;

	}

}
