package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class diagnosticPage extends basePage{
	
	public diagnosticPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Surgeries")
	WebElement surgeriesTab;

	@FindBy(linkText = "Lab Tests")
	WebElement labtestsTab;

	public void clickSurgeriesTab() {
		surgeriesTab.click();
	}

	public void clickLabTestsTab() {
		labtestsTab.click();
	}
}
