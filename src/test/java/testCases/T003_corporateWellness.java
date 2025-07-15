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
		logger.info("**** starting T003_corporateWellness ****");
		loginPage dp = new loginPage (driver);
		homePage hp = new homePage (driver);
		logger.info("**** health and wellness is clicked ****");
		hp.selectHealthAndWellness();
		String path = "testData/ReadAndWriteData.xlsx";
		ExcelUtility obj = new ExcelUtility(path);
		String sheet = "input";
		logger.info("**** details are entered and valid/invalid msg is filled ****");
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
		logger.info("**** ending T003_corporateWellness ****");
	
	}

}
