package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.loginPage;
import pageObject.homePage;

public class T003_corporateWellness extends BaseClass{

	@Test
	public void fillDetails() throws InterruptedException {
		loginPage dp = new loginPage (driver);
		homePage hp = new homePage (driver);
		hp.selectHealthAndWellness();
		dp.fillForm("harshini", "as", "9176700576", "harshini.com", "<500", "Taking a demo");
		dp.isSubmitButtonEnabled();
		Assert.assertTrue(true);
	}

}
