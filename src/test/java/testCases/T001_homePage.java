package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObject.homePage;
import pageObject.resultPage;

public class T001_homePage extends BaseClass {
	
	@Test
	public void getResult() throws IOException
	{
		logger.info("**** starting T001_homePage ****");
		List<WebElement> ans = new ArrayList<>();
		homePage hp = new homePage(driver);
		resultPage rp = new resultPage(driver);
		
		logger.info("**** city and hospitals details are entered ****");
		hp.cityLoc();
		for(int i=1;i<2;i++) {
			rp.scrollD(i);
		}
		
		logger.info("**** hospital details are being fetched ****");
		ans  = rp.takeList();
		List<String> hosName = new ArrayList<>();
		for(WebElement e : ans) {
			hosName.add(e.findElement(By.tagName("h2")).getText());
		}
		
		logger.info("**** hospital details are entered into excel file ****");
		String path = "testData/ReadAndWriteData.xlsx";
		ExcelUtility obj = new ExcelUtility(path);
		int row = 1;
		
		for(int col =0 ;col<hosName.size();col++) {
			obj.setCellData("hospitalName", col, row, hosName.get(col));
		}
		System.out.println(ans.size());
		logger.info("**** ending T001_homePage ****");
	}
}
