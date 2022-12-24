package testNGSeconDay;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataTable {

	
	
	@Test(dataProvider = "test-data")
//	@Parameters({"email", "password"})
	public void test(String email, String password) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.findElement(By.id("signinLink")).click();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("loginBtn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	@DataProvider(name = "test-data")
	public Object [][] input(){
		return new Object[][] {{"Hakimi@gmail.com","Hakimi1111111@"},
			{"Hakimi@gmail.com","Hakimi1111111@"}
		
		
		
		
		};
	}
	
	
}
