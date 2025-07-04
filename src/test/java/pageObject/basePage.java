package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basePage {
	WebDriver driver;
	WebDriverWait wait;
	
	public basePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(this.driver,Duration.ofSeconds(10));
		
	}
}
