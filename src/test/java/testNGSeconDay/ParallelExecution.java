package testNGSeconDay;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecution {

	
	/*
	 * ParalleExecution:
	 * it does mean executing two test cases at the same time
	 * for that we need multiple threat
	 * and the code or test cases that we write should support multiple threat
	 * 
	 * the main concept of parralleEcetion come from selenium grid and grid is the main
	 * component of selenuim which will support parralleEcetion with multiple machine
	 * and multiple browser.
	 * 
	 * in companies we had selenuim grid and sauce Lab tools for doing ParralleExecution.
	 * in Hub: configure operation machine, which browser and which test cases need to execute
	 * define the node: how many threat or PC or machine
	 * 
	 * 
	 * TestNG offer the same ParalleExecution but in the same machine with multiple browser. not suggest
	 * in order to have parrallelExecution, we have to setUp the suite level and from there.
	 * 
	 * 
	 * note: we can do parallel execution with BDD framework only if we integrated that with TestNG
	 * */
	
	
	@Test
	public void testOne() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/profile");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.close();
	}
	@Test
	public void testTwo() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/profile");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.close();
		
	}
	@Test
	public void testThree() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver  = new EdgeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/profile");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
