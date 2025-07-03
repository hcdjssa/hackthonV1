package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends basePage{
	
	public loginPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "organizationName")
    WebElement orgField;

    @FindBy(id = "contactNumber")
    WebElement contactField;

    @FindBy(id = "officialEmailId")
    WebElement emailField;

    @FindBy(id = "organizationSize")
    WebElement orgSizeDropdown;

    @FindBy(id = "interestedIn")
    WebElement interestDropdown;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitButton;

    public void fillForm(String name, String orgName, String contact, String email, String size, String interest) {
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(orgField)).sendKeys(orgName);
        wait.until(ExpectedConditions.elementToBeClickable(contactField)).sendKeys(contact);
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(orgSizeDropdown));
        new Select(orgSizeDropdown).selectByVisibleText(size);

        wait.until(ExpectedConditions.elementToBeClickable(interestDropdown));
        new Select(interestDropdown).selectByVisibleText(interest);
    }

  
    public void isSubmitButtonEnabled() {
         if (wait.until(ExpectedConditions.visibilityOf(submitButton)).isEnabled())
    {
    	System.out.println("Entered information is valid");
    }
         
    else
    {
    	System.out.println("Validation is triggered on entering an invalid input");
    }
         
    }
}
