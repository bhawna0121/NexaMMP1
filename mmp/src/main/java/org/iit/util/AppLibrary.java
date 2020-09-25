package org.iit.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class AppLibrary {
	
	
	public static WebElement waitforElementClickable(WebDriver driver,long timeinSecs,By e)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeinSecs);
		WebElement continueWE = wait.until(ExpectedConditions.elementToBeClickable(e));
		System.out.println("Webelement " +continueWE);
		return continueWE;
		
	}

	public static String[][] readXls(String filePath, String sheetName) throws BiffException, IOException {

		File srcFile = new File(filePath);
		Workbook wb = Workbook.getWorkbook(srcFile);
		// Sheet sheet = wb.getSheet("MMPLogin");
		Sheet sheet = wb.getSheet(sheetName);
		int row = sheet.getRows();
		int col = sheet.getColumns();

		String[][] str = new String[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				Cell cell = sheet.getCell(j, i);
				str[i][j] = cell.getContents().toString();
			}
		}

		return str;
	}


}
