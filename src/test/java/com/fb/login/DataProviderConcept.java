package com.fb.login;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderConcept {

	@Test(dataProvider = "provider")
	public void login(String un , String pwd)
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://122.166.192.191:9003");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("email")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("loginBtn")).click();
		driver.close();
		WebElement ele = driver.findElement(By.xpath("path"));
		Assert.assertTrue(ele.isDisplayed());
	}
	@DataProvider()
	public Object[][] provider() throws Throwable
	{
		Object[][] obj = new Object[5][2];
		obj[0][0] = getExcelData("Sheet1", 0, 0);
		obj[0][1] = getExcelData("Sheet1", 0, 1);
		
		obj[1][0] = getExcelData("Sheet1", 1, 0);
		obj[1][1] = getExcelData("Sheet1", 1, 1);
		
		obj[2][0] = getExcelData("Sheet1", 2, 0);
		obj[2][1] = getExcelData("Sheet1", 2, 1);
		
		obj[3][0] = getExcelData("Sheet1", 3, 0);
		obj[3][1] = getExcelData("Sheet1", 3, 1);
		
		obj[4][0] = getExcelData("Sheet1", 4, 0);
		obj[4][1] = getExcelData("Sheet1", 4, 1);
		return obj;
	}
	
	public String getExcelData(String sheetName , int rowNum , int celNum) throws Throwable  {
		FileInputStream fis = new FileInputStream(".\\data\\dp.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).toString();
		return data;	
	}
}
