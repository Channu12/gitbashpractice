package comPractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerTest {

	public static void main(String[] args) throws ParseException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();

		String reqMonth = "September 2020";
		String reqDate = "8";

		SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
		Date req = sdf.parse(reqMonth);
		

		while(true)
		{
			WebElement ele = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
			String text = ele.getText();

			Date current = sdf.parse(text);

			if (text.equalsIgnoreCase(reqMonth)) 
			{
				break;
			} 
			else if(req.after(current)) //req date is after current date
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}
		}
		driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='"+reqDate+"']")).click();
	}
}
