package com.Mytime.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Mytime.HomePage.HomePage;

import base.BasePage;

public class LoginPage extends BasePage
{
		public LoginPage(WebDriver driver) {
		super(driver);
		
	}

		@FindBy(id="username")
		public WebElement usernamefield;

		@FindBy(id="password")
		public WebElement passwordField;

		@FindBy (id="signOnButton")
		public WebElement loginbtn;


		@FindBy(xpath="//*[@id=\"content-wrap\"]/div/h2/p")
		public WebElement Welcome;

		public HomePage DoLogin(String empid, String pwd) throws InterruptedException
		{
			Thread.sleep(1500);

			usernamefield.sendKeys(empid);
			Thread.sleep(500);
			passwordField.sendKeys(pwd);
			Thread.sleep(500);
			loginbtn.click();
			Thread.sleep(13000);

		return new HomePage(driver);
		}

}


