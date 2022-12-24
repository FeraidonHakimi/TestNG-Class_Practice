package testNG4Day;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataTableHardCode {

	
	WebDriver driver;
	
	@BeforeMethod(groups="smoke")
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
	}
	
	@AfterMethod(groups="smoke")
	public void close() {
		driver.close();
	}
	
	@Test(groups="smoke",dataProvider="HardCode")

	public void testOne(String name, String lastName, String email, String password,
			String monthValue,String dayValue, String yearValue) {
	
		
		driver.findElement(By.xpath("//*[text()='Create new account']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(email);
		driver.findElement(By.id("password_step_input")).sendKeys(lastName);
		
		WebElement month = driver.findElement(By.id("month"));
		Select select = new Select(month);
		select.selectByValue(monthValue);
		
		List<WebElement> day = driver.findElements(By.xpath("//select[@id='day']//child::option"));
		for(WebElement i: day) {
			if(i.getText().equals(dayValue)) {
				i.click();
			}
		}
		
		List<WebElement> year = driver.findElements(By.xpath("//select[@id='year']//child::option"));
		
		for(int i=0; i<year.size(); i++) {
			if(year.get(i).getText().equals(yearValue)) {
				year.get(i).click();
			}
			
		}
		
		WebElement sex = driver.findElement(By.xpath("//label[text()='Male']"));
		if(sex.isEnabled()&&sex.isDisplayed()&&!sex.isSelected()) {
			sex.click();
		} else {
			System.out.println("Noooooooooooooo, take care please");
		}
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@DataProvider(name="HardCode")
	public Object [][]obj(){
		
		
		return new Object [][] {{"feraidon","hakimi","feraiodn@gmail.com","fafadafeQ234","3","29","1999"}
		,	{"feraiddon","hakdddimi","feraioddn@gmail.com","fafadafeQ234","3","29","1999"}
		
		};
	}
	
	
	
	
	
//	String [][] str = new String [][] {};
//	ArrayList<Integer> in = new ArrayList<>();	
//	int [] obj = {231,13};
//	
	
	
	
	
	
	
	
	
}
