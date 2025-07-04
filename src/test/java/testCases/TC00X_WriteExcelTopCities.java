package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import utilities.ExcelUtility;

public class TC00X_WriteExcelTopCities extends BaseClass{
	
	@Test
	public void writeExcelData() throws IOException {
		
		String path = "testData/ReadAndWriteData.xlsx";

		ExcelUtility xlUtil = new ExcelUtility(path);
		int arrCount = 0;
		
		for(int i = 3;i < (3 + names.size());i++) {
			xlUtil.setCellData("TopCities",i, 1, names.get(arrCount));
			arrCount++;
		}
		System.out.println();
		System.out.println("***** Data Written in Excel File *****");
		System.out.println();
	}
}
