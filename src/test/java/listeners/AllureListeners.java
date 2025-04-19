package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.TestBase;
import io.qameta.allure.Attachment;

public class AllureListeners implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}


	@Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
	
	@Attachment(value = "data", type = "text/plain", fileExtension = ".txt")
	public static String saveTextLog(String message) {

		return message;
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("I am in onStart method " + result.getName());
		result.setAttribute("WebDriver", TestBase.driver);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		System.out.println("I am in onTestSuccess method " + getTestMethodName(result) + " succeed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		saveScreenshotPNG(TestBase.getDriver());
		saveTextLog(result.getMethod().getConstructorOrMethod().getName()+" Testcase failed and Screenshot is captured");
		
	}
}


