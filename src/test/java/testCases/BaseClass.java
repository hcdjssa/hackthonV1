package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public WebDriver driver;
	public static List<String> names;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
