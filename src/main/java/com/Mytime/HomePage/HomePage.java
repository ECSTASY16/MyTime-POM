package com.Mytime.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Mytime.weeklyView.LogHours;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//*[@id=\"content-wrap\"]/div/h2/p")
	public WebElement verifyName;
	
	public String verifyUsername(String usrname)

	{ 
		
		String expusrname=verifyName.getText();
		String actusername=expusrname.toString();

		return actusername;
		
	}

	@FindBy(xpath = "//span[contains(text(),\"Weekly View\")]")
	public WebElement weeklyview;

	public LogHours gotoWeeklyView() throws InterruptedException {

		weeklyview.click();
		Thread.sleep(4000);
		return new LogHours(driver);

	}

}
