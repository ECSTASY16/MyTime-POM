package Utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import base.TestBase;

/*
 FROM ENTERMYTIME -POM PROJECT
*/
public class Datautil extends TestBase {
	public static String screenshotpath;
	public static String screenshotName;

	@DataProvider(name="dp")
	public Object[][] getData(Method m) throws InvalidFormatException, IOException // Method gets the name of the method
																				// kept same as Method Name
	{
		String sheetName = m.getName(); // This gonna get method name. recommend to hace same name for excelsheet as
										// method name
		int rowCount = excel.getRowCount(sheetName);
		int colCount = excel.getColumnCount(sheetName);

//if 0 values present then uncomment following code
//	if (rowCount <= 1) {
//        return new Object[0][0]; // Return an empty array
//    }
		Object[][] data = new Object[rowCount - 1][colCount];

		for (int rows = 2; rows <= rowCount; rows++) {

			for (int cols = 0; cols < colCount; cols++) {

				data[rows - 2][cols] = excel.getCellData(sheetName, cols, rows);
			}
		}
		return data;

	}

}
