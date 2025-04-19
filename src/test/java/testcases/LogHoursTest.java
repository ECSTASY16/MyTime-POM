package testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Mytime.weeklyView.LogHours;

import Utilities.Datautil;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import listeners.AllureListeners;

@Listeners({AllureListeners.class})
public class LogHoursTest extends TestBase{

	LogHours lp=new LogHours(driver);
	
	@Description ("Verify Log hour Test")
	@Test (dataProviderClass = Datautil.class,dataProvider = "dp", priority = 3,alwaysRun = true)

	@Epic("Ep-001")
	@Feature("Feature 2: Log hours Functionality")
	@Story("Story: Log user hours")
	@Severity(SeverityLevel.BLOCKER)

	public void AddloginHours(String m, String t,String w, String th, String f ) throws InterruptedException
	{
//		Conversion from double to int
//Commented code as if user enters 7.5 then code may change it to 75
//		double m1=Double.parseDouble(m);
//		int mi1= (int) m1;
//		String mis1=String.valueOf(mi1);
//		
//		double t1=Double.parseDouble(t);
//		int ti1= (int) t1;
//		String tis1=String.valueOf(ti1);
//		
//		double w1=Double.parseDouble(w);
//		int wi1= (int) w1;
//		String wis1=String.valueOf(wi1);
//		
//		double th1=Double.parseDouble(th);
//		int thi1= (int) th1;
//		String this1=String.valueOf(thi1);
//		
//		double f1=Double.parseDouble(f);
//		int fi1= (int) f1;
//		String fis1=String.valueOf(fi1);
//		
	
		
		
		lp=new LogHours(driver);
		lp.DeliveryHours(m, t,w,th,f);
		log.info("Entering Delivery hours");
		
	}
	@Description ("Verify Adding business strategy hours Test")
	@Step ("S")
	@Epic("Ep-001")
	@Feature("Feature 3: Log Strategy hours Functionality")
	@Story("Story: Log strategy hours")
	@Severity(SeverityLevel.BLOCKER)

	@Test(dataProviderClass = Datautil.class,dataProvider = "dp", priority = 4,alwaysRun = true)
	public void AddStrategyHours(String m, String t,String w, String th, String f) throws InterruptedException
	{
		
	 lp=new LogHours(driver);
	 lp.StrategyHours(m, t, w, th, f);
	 
	 log.info("Entering Strategy/Business Operation hours");
	 
	}

	@Test(dataProviderClass = Datautil.class,dataProvider = "dp", priority = 5,alwaysRun = true)
	@Epic("Ep-001")
	@Feature("Feature 4: Log vacation hours Functionality")
	@Story("Story: Log vacation hours")
	@Severity(SeverityLevel.BLOCKER)

	public void AddVacationHours(String m, String t,String w, String th, String f) throws InterruptedException
	{

		lp.vacationHours(m, t, w, th, f);
		 log.info("Entering Vacation hours");
		
	}
	
	@Test(priority = 6,alwaysRun = true)
	public void Savetime() throws InterruptedException
	{
		lp.SaveTime();
		log.info("User added hours");
	}
}
