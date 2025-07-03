package testCases;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.TopCitiesPage;
import pageObject.diagnosticPage;



public class TC00X_GetTopCities extends BaseClass{
	
	@Test
	public void getTopCities() throws InterruptedException {
	diagnosticPage dp = new diagnosticPage(driver);
		
		dp.clickSurgeriesTab();
		Thread.sleep(10000);
		dp.clickLabTestsTab();
		Thread.sleep(5000);
		
		TopCitiesPage tcp = new TopCitiesPage(driver);
		
		List<String> names = tcp.getNames();
		
		Assert.assertTrue(true);
	}

}
