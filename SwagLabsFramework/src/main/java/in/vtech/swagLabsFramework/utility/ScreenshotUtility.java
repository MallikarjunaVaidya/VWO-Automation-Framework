package in.vtech.swagLabsFramework.utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import in.vtech.swagLabsFramework.base.TestBase;

public class ScreenshotUtility extends TestBase {
	public static String destinationDir;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

destinationDir = currentDir + "/screenshots/" + LocalDate.now() + "-" + System.currentTimeMillis()
				+ ".png";
		FileUtils.copyFile(scrFile, new File(destinationDir));
		logger.error("SCREENSHOT_CAPTURED_AT: " + destinationDir);
	}
}
