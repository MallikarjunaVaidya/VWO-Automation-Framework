package in.vtech.swagLabsFramework.listeners;


	import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import in.vtech.swagLabsFramework.base.TestBase;
import in.vtech.swagLabsFramework.utility.ScreenshotUtility;



	public class DriverListener extends TestBase implements WebDriverEventListener {

		@Override
		public void beforeAlertAccept(WebDriver driver) {
			// TODO Auto-generated method stub
		}

		@Override
		public void afterAlertAccept(WebDriver driver) {
			// TODO Auto-generated method stub
		}

		@Override
		public void afterAlertDismiss(WebDriver driver) {
			// TODO Auto-generated method stub
		}

		@Override
		public void beforeAlertDismiss(WebDriver driver) {
			// TODO Auto-generated method stub
		}

		@Override
		public void beforeNavigateTo(String url, WebDriver driver) {
			logger.info("BEFORE_NAVIGATING_TO_URL: '" + url + "'");
		}

		@Override
		public void afterNavigateTo(String url, WebDriver driver) {
			logger.info("AFTER_NAVIGATING_TO_URL: '" + url + "'");
		}

		@Override
		public void beforeNavigateBack(WebDriver driver) {
			logger.info("BEFORE_NAVIGATING_TO_PREVIOUS_PAGE");
		}

		@Override
		public void afterNavigateBack(WebDriver driver) {
			logger.info("AFTER_NAVIGATING_TO_PREVIOUS_PAGE");
		}

		@Override
		public void beforeNavigateForward(WebDriver driver) {
			logger.info("BEFORE_NAVIGATING_TO_NEXT_PAGE");
		}

		@Override
		public void afterNavigateForward(WebDriver driver) {
			logger.info("AFTER_NAVIGATING_TO_NEXT_PAGE");
		}

		@Override
		public void beforeNavigateRefresh(WebDriver driver) {
			logger.info("BEFORE_NAVIGATING_TO_REFRESH_PAGE");
		}

		@Override
		public void afterNavigateRefresh(WebDriver driver) {
			logger.info("AFTER_NAVIGATING_TO_REFRESH_PAGE");
		}

		@Override
		public void beforeFindBy(By by, WebElement element, WebDriver driver) {
			logger.info("TRYING_TO_FIND_ELEMENT_BY: '" + by.toString() + "'");
		}

		@Override
		public void afterFindBy(By by, WebElement element, WebDriver driver) {
			logger.info("FOUND_ELEMENT_BY: '" + by.toString() + "'");
		}

		@Override
		public void beforeClickOn(WebElement element, WebDriver driver) {
			logger.info("TRYING_TO_CLICK_ON_ELEMENT : '" + element.toString() + "'");
		}

		@Override
		public void afterClickOn(WebElement element, WebDriver driver) {
			logger.info("CLICKED_ON_ELEMENT : '" + element.toString() + "'");
		}

		@Override
		public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			logger.info("VALUE_OF_THE_ELEMENT : '" + element.toString() + "'" + " BEFORE_ANY_CHANGES_MADE");
		}

		@Override
		public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			logger.info("ELEMENT_VALUE_CHANGED_TO : '" + element.toString() + "'");
		}

		@Override
		public void beforeScript(String script, WebDriver driver) {
			// TODO Auto-generated method stub
		}

		@Override
		public void afterScript(String script, WebDriver driver) {
			// TODO Auto-generated method stub
		}

		@Override
		public void beforeSwitchToWindow(String windowName, WebDriver driver) {
			logger.info("BEFORE_SWITCH_TO_WINDOW : '" + windowName + "'");
		}

		@Override
		public void afterSwitchToWindow(String windowName, WebDriver driver) {
			logger.info("AFTER_SWITCH_TO_WINDOW : '" + windowName + "'");
		}

		@Override
		public void onException(Throwable error, WebDriver driver) {
			logger.info("EXCEPTION_OCCURED: " + error);
			try {
				ScreenshotUtility.takeScreenshotAtEndOfTest();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public <X> void beforeGetScreenshotAs(OutputType<X> target) {
			// TODO Auto-generated method stub
		}

		@Override
		public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
			// TODO Auto-generated method stub
		}

		@Override
		public void beforeGetText(WebElement element, WebDriver driver) {
			// TODO Auto-generated method stub
		}

		@Override
		public void afterGetText(WebElement element, WebDriver driver, String text) {
			// TODO Auto-generated method stub
		}

	} // end class{}


