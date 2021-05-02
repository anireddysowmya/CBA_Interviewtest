package Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CBA.Main.base;

public class SearchTest extends base {


public WebDriver driver;
	
	
	
	@BeforeTest
	public void test_driver() throws IOException {
		driver= test_browserDriver("chrome");
		}


	@Test(priority=1)
	public void test_case1() {
		driver.get(prop.getProperty("url"));
		WebElement search= driver.findElement(By.id("search-input"));
		if(search.isDisplayed()) {
			System.out.println("Search query is displayed");
		}
		
		else {
			System.out.println("Search query is not displayed");
		}
		
		WebElement searchbtn= driver.findElement(By.id("search-button"));
		if(searchbtn.isDisplayed()) {
			System.out.println("Search button is displayed");
		}
		
		else {
			System.out.println("Search button is not displayed");
		}
		
	}
	
	@Test(priority=2)
	public void test_case2() {
		driver.findElement(By.id("search-button")).click();
		WebElement empty=driver.findElement(By.xpath("//div[@id='error-empty-query']"));
		String empytext=empty.getText();
		System.out.println(empytext);
	}
	@Test(priority=3)
	public void test_case3() {
		driver.findElement(By.id("search-input")).sendKeys("isla");
		driver.findElement(By.id("search-button")).click();
		List<WebElement> listresults=driver.findElements(By.id("search-results"));
		 WebElement Isla=driver.findElement(By.xpath("//li[contains(text(),'Isla de Muerta')]"));
		 if(Isla.isDisplayed()) {
			 System.out.println("Island is displayed");
		 }
		 driver.findElement(By.id("search-input")).clear();
	}
	
	@Test(priority=4)
	public void test_case4() {
		driver.findElement(By.id("search-input")).sendKeys("castle");
		driver.findElement(By.id("search-button")).click();
		WebElement noresult= driver.findElement(By.xpath("//div[@id='error-no-results']"));
		String noresulttext= noresult.getText();
		if(noresult.isDisplayed())
		{
			System.out.println("no results displayed");
		}
		 driver.findElement(By.id("search-input")).clear();
	}
	
	@Test(priority=5)
	public void test_case5() {
		driver.findElement(By.id("search-input")).sendKeys("port");
		driver.findElement(By.id("search-button")).click();
		List<WebElement> portresult= driver.findElements(By.xpath("//ul[@id='search-results']//li"));
		int count= portresult.size();
		if(count==1) {
			System.out.println("Only 1 Port royal result found");
		}
	}
	
	
	
	
}
