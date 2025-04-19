package rough;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.asserts.SoftAssert;

public class excel
{
	public int sum(int a , int b)
	{
		return a+b;
	}



	public static void main(String[] args) throws InvalidFormatException, IOException {
//File file=new File(System.getProperty("user.dir"+"\\src\\test\\resources\\excel\\TestExecutionData.xlsx"));
//	File file=new File("C:\\TestExecutionData.xlsx");
//	FileInputStream fis=new FileInputStream(file);
//	XSSFWorkbook workbook=new XSSFWorkbook(fis);
//	XSSFSheet sheet=workbook.getSheet("FindNewCarTest");
//
SoftAssert as=new SoftAssert();
	excel excel = new excel();
	System.out.println(excel.sum(32, 21));

	}

}
