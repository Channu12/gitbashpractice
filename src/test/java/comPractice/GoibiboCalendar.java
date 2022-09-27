package comPractice;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboCalendar {

	public static void main(String[] args) throws ParseException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		String reqMonth = "August 2023";
		String reqDate = "30";

		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='sc-kfPuZi dprjVP fswDownArrow']")).click();

		while(true)
		{
			String text = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
			if (text.equalsIgnoreCase(reqMonth)) 
			{
				break;
			} 
			else 
			{
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		driver.findElement(By.xpath("//div[@class='DayPicker-Month']/div[@class='DayPicker-Body']/div/div/p[text()='"+reqDate+"']")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
	}
}
