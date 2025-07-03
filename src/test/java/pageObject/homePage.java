package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class homePage extends basePage {
	
	public homePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@placeholder='Search location']")
	WebElement locSearch;
	
	@FindBy(xpath="//div[text()= 'Bangalore']")
	WebElement locCity;
	
	@FindBy(xpath="//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
	WebElement hosType;
	
	@FindBy(xpath="//div[text()= 'Hospital']")
	WebElement locHos;
	
	@FindBy(xpath="//*[text()='For Corporates']")
	WebElement corpBut;
	
	@FindBy(xpath="//*[text()='Health & Wellness Plans']")
	WebElement healthbut;
	
	@FindBy(linkText = "Surgeries")
	WebElement surgeriesTab;

	@FindBy(linkText = "Lab Tests")
	WebElement labtestsTab;
	
	@FindBy(xpath="//a[text() = 'Health & Wellness Plans']")
	WebElement dropDownHealthAndWellness;
	
	@FindBy(xpath="//span[text()='For Corporates']")
	WebElement downArrow;

	public void clickSurgeriesTab() {
		surgeriesTab.click();
	}

	public void clickLabTestsTab() {
		labtestsTab.click();
	}

	public void cityLoc() {
		locSearch.clear();
		locSearch.sendKeys("Banglore");
		wait.until(ExpectedConditions.elementToBeClickable(locCity)).click();
		hosType.sendKeys("Hospital");
		wait.until(ExpectedConditions.elementToBeClickable(locHos)).click();
	}
	
	public void selectHealthAndWellness() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(downArrow)).click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownHealthAndWellness)).click();
	}
	
}
