package testCases;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObject.homePage;
import pageObject.resultPage;

public class T001_homePage {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		homePage hp = new homePage(driver);
		hp.cityLoc();
		JavascriptExecutor js=(JavascriptExecutor) driver;;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight * 0.75);");
		
		resultPage rp = new resultPage(driver);
		List<WebElement> ans = rp.takeList();
		
		System.out.println(ans.size());
	}
}
