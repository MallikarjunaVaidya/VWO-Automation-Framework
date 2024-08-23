package in.vtech.swagLabsFramework.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import in.vtech.swagLabsFramework.base.TestBase;
import in.vtech.swagLabsFramework.utility.ExtentReportsManager;
import in.vtech.swagLabsFramework.utility.ScreenshotUtility;

public class TestNGListener extends TestBase implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		logger.info("TEST_SUITE_START: " + context.getName());
		extentReports = ExtentReportsManager.getInstance();
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("TEST_SUITE_FINISH: " + context.getName());
		extentReports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("TEST_CASE_START: " + result.getName());
		extentTest = extentReports.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("TEST_CASE_PASS: " + result.getName());
		extentTest.log(Status.PASS,
				MarkupHelper.createLabel(result.getName() + " - TEST_CASE_PASS", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error("TEST_CASE_FAILURE: " + result.getName());

		extentTest.log(Status.FAIL,
				MarkupHelper.createLabel(result.getName() + " - TEST_CASE_FAILURE", ExtentColor.RED));
		extentTest.log(Status.FAIL,
				MarkupHelper.createLabel(result.getThrowable() + " - TEST_CASE_FAILURE", ExtentColor.RED));

		try {
			ScreenshotUtility.takeScreenshotAtEndOfTest();
			extentTest.addScreenCaptureFromPath(ScreenshotUtility.destinationDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn("TEST_CASE_SKIP: " + result.getName());

		extentTest.log(Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " - TEST_CASE_SKIP", ExtentColor.ORANGE));
		
		try {
			ScreenshotUtility.takeScreenshotAtEndOfTest();
			extentTest.addScreenCaptureFromPath(ScreenshotUtility.destinationDir);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
