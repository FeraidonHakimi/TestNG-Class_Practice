package testNGSeconDay;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v102.css.model.StyleSheetOrigin;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameter {
	
	
	/*
	 *  In order to parameterize our test cases, we have two options
	 *  1 = through Parameter
	 *  2 = with DataTable
	 * 
	 *  Why we call data driven FrameWork?
	 *  becuase we can do paramterazition through DataTable, it means can execute same testCases
	 *  with different set of data
	 * 
	 */
	
	
	
	//1 = through Parameter
	
	@Test
	@Parameters({"email", "password"})
	
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
	
	
	

}
