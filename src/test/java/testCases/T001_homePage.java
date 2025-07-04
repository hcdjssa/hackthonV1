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
		homePage hp = new homePage(driver);
		hp.cityLoc();
		JavascriptExecutor js=(JavascriptExecutor) driver;;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight * 0.75);");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='left']//li[11]")));
		
		resultPage rp = new resultPage(driver);
		List<WebElement> ans = rp.takeList();
		List<String> s = new ArrayList<>();
		for(WebElement e : ans) {
			s.add(e.findElement(By.tagName("h2")).getText());
		}
		String path = "testData/ReadAndWriteData.xlsx";
		ExcelUtility obj = new ExcelUtility(path);
		int r = 1;
		
		for(int j =0 ;j<s.size();j++) {
			obj.setCellData("hospitalName", j, r, s.get(j));
		}
		System.out.println(ans.size());
	}
}
