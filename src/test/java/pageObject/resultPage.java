package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class resultPage extends basePage{
	
	List<WebElement> ans= new ArrayList<>();
	
	public resultPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@class='left']//li")
	List<WebElement> resultList;
	
	@FindBy(xpath="//span[text()='Read more info']")
	WebElement readMoreInfo;
	
	@FindBy(xpath="//*[text()='Amenities']//following::div[@class='p-entity__item']/span")
	List<WebElement> park;
	
	public boolean checkParking(WebElement w) {
		w.findElement(By.xpath(".//a")).click();
		Object[] wh = driver.getWindowHandles().toArray();
		driver.switchTo().window((String)wh[1]);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView();",readMoreInfo);
			readMoreInfo.click();
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
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	public List<WebElement> takeList() {
		for(WebElement e:resultList) {
			try {
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
			catch(Exception er) {
				System.out.println(er.getMessage());
			}
		}
		System.out.println(resultList.size());
		return ans;
	}
	public void scrollD(int i) {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight * 0.75);");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='left']//li["+((10*i)+1)+"]")));
	}
}
