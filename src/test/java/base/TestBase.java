package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import Utilities.ExcelReader;


public class TestBase

{
	/*
	 * Initializing WebDriver Logs properties ExtentReports ExcelRead Mail
	 */

	public  static WebDriver driver;
//public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	public  Properties config = new Properties();
	public  Properties OR = new Properties();
	public  FileInputStream fis;
	public  Logger log = Logger.getLogger(TestBase.class);
	public  Assert asrt;
	public  ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TestExecutionDataMyTime.xlsx");
	public  WebDriverWait wait;
	public  WebElement dropdown;
	public Map<String, Object> prefs;

	SoftAssert asf=new SoftAssert();

	public TestBase()
	{

		if (driver == null) {

		try {
			//Getting file from the location
			fis = new FileInputStream(
					System.getProperty("user.dir" )+ "\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			config.load(fis);

		} catch (IOException e) {

			e.printStackTrace();
		}

		log.info("Config properties loaded");

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			OR.load(fis);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("OR properties  loaded");

		if (config.getProperty("browser").equals("chrome")) {

			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("dom.webnotifications.enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
// options.addArguments("--temp-profile");
			options.addArguments("--incognito");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			log.info("Chrome Browser Launching");
		}
		else if (config.getProperty("browser").equals("edge")) {
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("dom.webnotifications.enabled", false);
			EdgeOptions options = new EdgeOptions();
			options.setExperimentalOption("prefs", prefs);
			// options.addArguments("--temp-profile");
			options.addArguments("--incognito");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
			log.info("Edge Browser Launching");

		driver.get(config.getProperty("URL"));
		//log.info("Navigated to URL:"+config.getProperty("URL").toString());
		//log.debug("navigated to " + config.getProperty("URL"));
		driver.manage().window().maximize();
		log.info("Window Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			}}}

	public void click(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_Name")) {
			driver.findElement(By.name(OR.getProperty(locator))).click();
		}
		else if (locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).click();
		}
		log.debug("Clicking Element: " + locator);
	}

	public void type(String locator, String value) {
		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}

		else if (locator.endsWith("_Name")) {
			driver.findElement(By.name(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		else if (locator.endsWith("NAME"))
		{driver.findElement(By.name(OR.getProperty(locator))).sendKeys(value);

		}
		log.debug("Typing in an element: " + locator + "and entered value is: " + value);

	}

	public void select(String locator, String value) {
		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(value)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(value)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(value)));
		} else if (locator.endsWith("_name")) {
			dropdown = driver.findElement(By.name(OR.getProperty(value)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		log.debug("Selecting from an element : " + locator + " value as : " + value);
	}


public static WebDriver getDriver()
{
	
return driver;
}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
@AfterSuite
	public static void quit()
	{
		try {
			try {
				driver.quit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}




	/*public void setup(String browserName) throws FileNotFoundException {

			*//************************************************
			 * Initialization of config.Properties file
			************************************************************//*
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			try {
				log.debug("Config File Loaded");
				config.load(fis);
			} catch (IOException e) {

				e.printStackTrace();
			}

			*//************************************************
			 * Initialization of driver based on Config file
			 ***************************************************//*


		if (browserName.equals("Chrome")) {
			prefs=new HashMap<String, Object>();

			prefs.put("profile.default_content_setting_values.notifications", false);
			prefs.put("profile.password_manager_enabled",false);
			prefs.put("credentials_enable_service", false);
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disabled-infobars");

			log.debug("Chrome Browser launched");
			driver = new ChromeDriver();

		} else if (browserName.equals("Edge")) {

			prefs=new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", false);
			prefs.put("profile.password_manager_enabled",false);
			prefs.put("credentials_enable_service", false);
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disabled-infobars");

			driver = new EdgeDriver();
		}
		driver.get(config.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}


	*//***************************************************************
	 * Ending Session once execution done
	 ***************************************************************//*

	@AfterSuite
	public void teardown() {
		if (driver != null) // If driver/browser is active then only browser will get closed
		{
			driver.quit();
		}
		log.debug("Execution Completed");
	}

}
*/