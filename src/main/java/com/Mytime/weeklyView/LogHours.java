package com.Mytime.weeklyView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LogHours extends BasePage {

	// entering Weekly hourse in Delivery hours input field

	@FindBy(xpath = "//*[@id=\"timecards[1].days[2].hours\"]")
	public WebElement monday;

	@FindBy(xpath = "//*[@id=\"timecards[1].days[3].hours\"]")
	public WebElement tuesday;

	@FindBy(xpath = "//*[@id=\"timecards[1].days[4].hours\"]")
	public WebElement wednesday;

	@FindBy(xpath = "//*[@id=\"timecards[1].days[5].hours\"]")
	public WebElement thursday;

	@FindBy(xpath = "//*[@id=\"timecards[1].days[6].hours\"]")
	public WebElement friday;

	public void DeliveryHours(String mon, String tue, String wed, String thu, String fri) throws InterruptedException {

		
		
		monday.sendKeys(mon);
		
		Thread.sleep(500);
		tuesday.sendKeys(tue);
		Thread.sleep(500);
		wednesday.sendKeys(wed);
		Thread.sleep(500);
		thursday.sendKeys(thu);
		Thread.sleep(500);
		friday.sendKeys(fri);
		Thread.sleep(500);
	}

	/* fOR Entering hours in Business Strategy/ Operations input field */
	@FindBy(xpath = "//*[@id=\"timecards[2].days[2].hours\"]")
	public WebElement mondayS;

	@FindBy(xpath = "//*[@id=\"timecards[2].days[3].hours\"]")
	public WebElement tuesdayS;

	@FindBy(xpath = "//*[@id=\"timecards[2].days[4].hours\"]")
	public WebElement wednesdayS;

	@FindBy(xpath = "//*[@id=\"timecards[2].days[5].hours\"]")
	public WebElement thursdayS;

	@FindBy(xpath = "//*[@id=\"timecards[2].days[6].hours\"]")
	public WebElement fridayS;

	public void StrategyHours(String mon, String tue, String wed, String thu, String fri) throws InterruptedException {

		mondayS.sendKeys(mon);
		Thread.sleep(500);
		tuesdayS.sendKeys(tue);
		Thread.sleep(500);
		wednesdayS.sendKeys(wed);
		Thread.sleep(500);
		thursdayS.sendKeys(thu);
		Thread.sleep(500);
		fridayS.sendKeys(fri);
		Thread.sleep(500);

	}

	public LogHours(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\"timecards[0].days[2].hours\"]")
	public WebElement mondayVac;

	@FindBy(xpath = "//*[@id=\"timecards[0].days[3].hours\"]")
	public WebElement tuesdayVac;

	@FindBy(xpath = "//*[@id=\"timecards[0].days[4].hours\"]")
	public WebElement wednesdayVac;

	@FindBy(xpath = "//*[@id=\"timecards[0].days[5].hours\"]")
	public WebElement thursdayVac;

	@FindBy(xpath = "//*[@id=\"timecards[0].days[6].hours\"]")
	public WebElement fridayVac;

	@FindBy(xpath = "//*[@value=\"Vacation\"][2]")
	public WebElement Vacationsec;

	@FindBy(id = "timcardinfo")
	public WebElement timecard;

	@FindBy(id = "selProject")
	public WebElement selectProj; // For Project Dropdown

	@FindBy(xpath = "//*[@id=\"optionsDiv1\"]/p[2]/a")
	public WebElement ooo;

	@FindBy(id = "selTasks")
	public WebElement selectTask; // For Task Dropdown Eg. Vacation, Sick Time,etc.

	@FindBy(xpath = "//p[@onclick='dont_show_warning=true;']//img[@id='mythomsonlogo']")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"optionsDiv2\"]/p[9]/a")
	public WebElement sickTime;

	public void vacationHours(String mon, String tue, String wed, String thu, String fri) throws InterruptedException {

		String vacationtext = Vacationsec.getText();
		/* Code for Selecting Sick Time from drop down but it is commented */
//		String card = timecard.getText();
//
//		if (!(card.contains("Sick Time"))) {
//
//			selectProj.click();
//			Actions a = new Actions(driver);
//
//			a.doubleClick(ooo).perform();
//			Thread.sleep(3000);
//
//			selectTask.click();
//			a.click(sickTime).perform();
//
//
//	Add.click();
//		}
//
//		else
		if (!(vacationtext == null)) {

			mondayVac.sendKeys(mon);
			Thread.sleep(500);
			tuesdayVac.sendKeys(tue);
			Thread.sleep(500);
			wednesdayVac.sendKeys(wed);
			Thread.sleep(500);
			thursdayVac.sendKeys(thu);
			Thread.sleep(500);
			fridayVac.sendKeys(fri);
			Thread.sleep(500);

		}

	}

	@FindBy(id = "submitProjectChanges")
	public WebElement savetime;

	public void SaveTime() throws InterruptedException {
		savetime.click();
		Thread.sleep(4000);
		}

}