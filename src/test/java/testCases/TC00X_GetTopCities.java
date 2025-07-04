package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.TopCitiesPage;
import pageObject.homePage;

public class TC00X_GetTopCities extends BaseClass{
	
	@Test
	public void getTopCities() throws InterruptedException {
		homePage hp = new homePage(driver);
		
		hp.clickSurgeriesTab();
		hp.clickLabTestsTab();
		
		TopCitiesPage tcp = new TopCitiesPage(driver);
		
		names = tcp.getNames();
		
		System.out.println("The top cities from the \"Diagnostics\" page are :");
		
		for(String name : names) {
			System.out.println("-> " + name.trim());
		}
		
		Assert.assertTrue(true);
	}
}
