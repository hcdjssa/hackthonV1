package testCases;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.TopCitiesPage;
import pageObject.homePage;



public class TC002_GetTopCities extends BaseClass{
	
	@Test
	public void getTopCities() throws InterruptedException {
		homePage hp = new homePage(driver);
		
		hp.clickSurgeriesTab();
		hp.clickLabTestsTab();
		
		TopCitiesPage tcp = new TopCitiesPage(driver);
		
		List<String> names = tcp.getNames();
		
		Assert.assertTrue(true);
	}

}
