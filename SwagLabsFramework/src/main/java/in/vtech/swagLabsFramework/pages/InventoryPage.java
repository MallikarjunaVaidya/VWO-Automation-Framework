package in.vtech.swagLabsFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import in.vtech.swagLabsFramework.base.TestBase;

public class InventoryPage extends TestBase {

	private By pageHeaderText = By.xpath("//span[@contains(text(),'Products')]");
	private By productImage = By.xpath("//img[@src='/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg']");
	private By hamburgerMenuButton = By.id("react-burger-menu-btn");
	private By logoutLink = By.id("logout_sidebar_link");
	

	public void clickhamburgerMenuButton() {
		clickButton(hamburgerMenuButton);
	}

	public void clicklogoutLink() {
		clickButton(logoutLink);
	}

	public String getInventoryPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public void clickproductImage() {
		clickButton(productImage);
	}

	public boolean isPageHeaderTextIsDisplayed() {
		WebElement element = getElement(pageHeaderText);
		boolean flag = element.isDisplayed();
		return flag;
	}

}
