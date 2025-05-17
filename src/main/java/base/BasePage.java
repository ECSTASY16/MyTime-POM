package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public WebDriver driver;

//Chnages Done in the pagefactory initElements..
public BasePage(WebDriver driver) {
		this.driver = driver;
	PageFactory.initElements(driver, this);

	}

}
