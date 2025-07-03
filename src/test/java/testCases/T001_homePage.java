package testCases;

import java.time.Duration;
import java.util.List;

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
	public void getResult()
	{
		homePage hp = new homePage(driver);
		hp.cityLoc();
		JavascriptExecutor js=(JavascriptExecutor) driver;;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight * 0.75);");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='left']//li[11]")));
		
		resultPage rp = new resultPage(driver);
		List<WebElement> ans = rp.takeList();
		
		System.out.println(ans.size());
	}
}
