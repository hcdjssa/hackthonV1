package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class resultPage extends basePage{
	List<WebElement> ans= new ArrayList<>();
	public resultPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@class='left']//li")
	List<WebElement> ls;
	@FindBy(xpath="//span[text()='Read more info']")
	WebElement rm;
	@FindBy(xpath="//*[text()='Amenities']//following::div[@class='p-entity__item']/span")
	List<WebElement> park;
	public boolean checkParking(WebElement w) {
		w.findElement(By.xpath(".//a")).click();
		Object[] wh = driver.getWindowHandles().toArray();
		driver.switchTo().window((String)wh[1]);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",rm);
		rm.click();
		for(WebElement i:park) {
			String j = i.getText();
			if(j.equals("Parking")) {
				driver.close();
				driver.switchTo().window((String)wh[0]);
				return true;
			}
		}
		driver.close();
		driver.switchTo().window((String)wh[0]);
		return false;
		
	}
	public List<WebElement> takeList() {
		for(WebElement e:ls) {
			//System.out.print(e.findElement(By.tagName("h2")).getText()+" ");
			String timing = e.findElement(By.xpath(".//div[@class='line-4']/span[2]/span")).getText();
			Double rating = Double.parseDouble(e.findElement(By.xpath(".//div[@class='text-1']//span[@class='u-bold']")).getText());
			if(timing.equals("Open 24x7") && rating>3.5 && checkParking(e)){
				ans.add(e);
				System.out.print(e.findElement(By.tagName("h2")).getText()+" ");
				System.out.print(timing+" ");
				System.out.println(rating+" ");
				
			}
		}
		System.out.println(ls.size());
		return ans;
	}
	
}
