package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopCitiesPage extends basePage{

	public TopCitiesPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath = "//div[text() = 'TOP CITIES']")
WebElement topCitiesText;	
	
@FindBy(xpath = "//div[text() = 'TOP CITIES']/following-sibling::ul/li/div[2]")
List<WebElement> nameWebEleList;

public List<String> getNames(){
		
		List<String> nameList = new ArrayList<>();
		
		wait.until(ExpectedConditions.visibilityOf(topCitiesText));
		
		for(WebElement nameOfCity : nameWebEleList) {
			String name = nameOfCity.getText();
			nameList.add(name.trim());
		}
		return nameList;
	}
}
