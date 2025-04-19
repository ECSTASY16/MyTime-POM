package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mytime.HomePage.HomePage;

import base.TestBase;

public class HomePageTest extends TestBase

{
	@Test(priority = 1, alwaysRun = false)
	public void homePageTest() {

		HomePage hp = new HomePage(driver);
		hp.verifyUsername("Welcome PRANAY RAHATE!");

		Assert.assertEquals("", true);
		
//		SoftAssert s = new SoftAssert();
//
//		String verifyName = hp.verifyName.getText();
//		s.assertEquals(verifyName, true);
//
	}

}
