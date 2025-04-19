package testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Mytime.loginPage.LoginPage;

import Utilities.Datautil;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import listeners.AllureListeners;

@Listeners({AllureListeners.class})
public class LoginTest extends TestBase {

	@Test(dataProviderClass = Datautil.class, dataProvider = "dp", priority = 1)
	@Description("Verify Login Functionality")
	@Epic("Ep-001")
	@Feature("Feature 1: Login Functionality")
	@Story("Story: Verify Login")
	@Severity(SeverityLevel.BLOCKER)

	public void loginTest(String empnumber, String pw) throws FileNotFoundException, InterruptedException {

		// Code for converting double to integer since emp id is getting read as
		// 6123456.0 so user is converting decimal to integer.

		double empDouble = Double.parseDouble(empnumber);

		int empidnum = (int) empDouble;

		String empidstring = String.valueOf(empidnum);

		LoginPage lp = new LoginPage(driver);

		log.info("Entering UserName and Password provided in Excel");
		lp.DoLogin(empidstring, pw).gotoWeeklyView();

	}

}
