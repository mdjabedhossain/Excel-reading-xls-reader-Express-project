package com.Express_DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.Express.Utilities.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	
		driver.get("https://www.express.com/register");
		
		
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Java-Maven_project\\Express_SignUp\\Member_SignUP\\src\\test\\java\\com\\Express_TestData\\Book1.xlsx");		
		String email = reader.getCellData("registration", "email", 2);
		System.out.println(email);
		String fname = reader.getCellData("registration", "firstname", 2);
		System.out.println(fname);
		String lname= reader.getCellData("registration", "lastname", 2);
		System.out.println(lname);
		String passwd = reader.getCellData("registration", "passoword", 2);
		System.out.println(passwd);
		String country = reader.getCellData("registration", "country", 2);
		System.out.println(country);
		
		
		reader.addColumn("registration", "Country");
		reader.setCellData("registration", "Country", 2, "Belgium");
		
		
		
		
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/section/section[2]/div/form/div[1]/div/input")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"content\"]/section/section[2]/div/form/div[2]/div/input")).sendKeys(fname);
		driver.findElement(By.xpath("//*[@id=\"content\"]/section/section[2]/div/form/div[3]/div/input")).sendKeys(lname);
		driver.findElement(By.xpath("//*[@id=\"content\"]/section/section[2]/div/form/div[4]/div[1]/div[1]/input")).sendKeys(passwd);
		
		
		
		Select select = new Select (driver.findElement(By.id("//*[@id=\"content\"]/section/section[2]/div/form/div[3]/div/input")));
		select.selectByVisibleText(country);
		
		
		driver.quit();
	}
	

}
