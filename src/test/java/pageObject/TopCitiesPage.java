package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopCitiesPage extends basePage{

	public TopCitiesPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath = "//div[text() = 'TOP CITIES']/following-sibling::ul/li/div[2]")
List<WebElement> nameWebEleList;

	public List<String> getNames(){
		
		List<String> nameList = new ArrayList<>();
		
		int size = nameWebEleList.size();
		
		for(int i = 0;i < size;i++) {
			String name = nameWebEleList.get(i).getText();
			nameList.add(name.trim());
			System.out.println(name.trim());
		}
		return nameList;
	}
}
