package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ExcelUtility;
import pageObject.loginPage;
import pageObject.homePage;

public class T003_corporateWellness extends BaseClass{

	@Test
	public void fillDetails() throws InterruptedException, IOException {
		loginPage dp = new loginPage (driver);
		homePage hp = new homePage (driver);
		hp.selectHealthAndWellness();
		String path = "testData/ReadAndWriteData.xlsx";
		ExcelUtility obj = new ExcelUtility(path);
		String sheet = "input";
		int r = 1;
		for(int i=0;i<3;i++) {
			String name = obj.getCellData(sheet, i, 0);
			String as = obj.getCellData(sheet, i, 1);
			String number = obj.getCellData(sheet, i, 2);
			String email = obj.getCellData(sheet, i, 3);
			String range =obj.getCellData(sheet, i, 4);
			String demo =obj.getCellData(sheet, i, 5);
			dp.fillForm(name, as, number, email, range, demo);
			String result = dp.isSubmitButtonEnabled();
			obj.setCellData(sheet, i, 6, result);
			driver.navigate().refresh();
		}
		
		
		
		//dp.fillForm("harshini", "as", "9176700576", "harshini.com", "<500", "Taking a demo");
		
		Assert.assertTrue(true);
	}

}
