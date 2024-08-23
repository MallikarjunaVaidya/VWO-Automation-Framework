package in.vtech.swagLabsFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import in.vtech.swagLabsFramework.base.TestBase;

public class HomePage extends TestBase {

	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	private By pageHeaderText=By.xpath("//div[@class='login_logo']");

	public void enteruserName(String text) {
		enterField(userName, text);
	}

	public void enterpassword(String text) {
		enterField(password, text);
	}

	public void clickloginButton() {
		clickButton(loginButton);
	}

	public String getHomePageTitle() {

		String pageTitle = driver.getTitle();
		return pageTitle;
	}
public boolean isPageHeaderTextDisplayed() {
	WebElement element= getElement(pageHeaderText);
	boolean flag=element.isDisplayed();
	return flag;
}
}
