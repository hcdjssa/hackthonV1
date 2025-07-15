package testCases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.TopCitiesPage;
import pageObject.homePage;
import utilities.ExcelUtility;

public class T002_GetTopCities extends BaseClass{
	
	@Test
	public void getTopCities() throws InterruptedException, IOException {
		logger.info("**** starting T002_GetTopCities ****");
		homePage hp = new homePage(driver);
		logger.info("**** surgeries tab is clicked ****");
		hp.clickSurgeriesTab();
		logger.info("**** lab test is clicked ****");
		hp.clickLabTestsTab();
		logger.info("**** top cities names are being fetched ****");
		TopCitiesPage tcp = new TopCitiesPage(driver);
		List<String> names = tcp.getNames();
		
		System.out.println("The top cities from the \"Diagnostics\" page are :");
		
		for(String name : names) {
			System.out.println("-> " + name.trim());
		}
		String path = "testData/ReadAndWriteData.xlsx";
		
		logger.info("**** fetched details are entered into excel sheet ****");
		ExcelUtility xlUtil = new ExcelUtility(path);
		int arrCount = 0;
		
		for(int i = 3;i < (3 + names.size());i++) {
			xlUtil.setCellData("TopCities",i, 1, names.get(arrCount));
			arrCount++;
		}
		System.out.println();
		System.out.println("***** Data Written in Excel File *****");
		logger.info("**** ending T002_GetTopCities ****");
		
	}
}
