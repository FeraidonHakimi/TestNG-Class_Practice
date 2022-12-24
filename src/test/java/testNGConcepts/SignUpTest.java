package testNGConcepts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tek.sdet.testng.utilities.ExcelReader;

public class SignUpTest {
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/auth/sign-up");
		
		
	}
	
	
	
	@Test(dataProvider="testInput")
	public void testSignUp(String name, String email, String password, String conFPass) {
		
		driver.findElement(By.id("nameInput")).sendKeys(name);
		driver.findElement(By.id("emailInput")).sendKeys(email);
		driver.findElement(By.id("passwordInput")).sendKeys(password);
		driver.findElement(By.id("confirmPasswordInput")).sendKeys(conFPass);
		
		
	}
	
	@DataProvider(name="testInput")
	public Object[][]signUpData() throws IOException{
		String path=".\\src\\test\\resources\\testData\\testInputData.xlsx";
		List<Map<String, String>> data = ExcelReader.readSheetWithFirstRowAsHeader
				(ExcelReader.getExcelSheet(path, 0));
		Object [][] obj = new Object [data.size()][data.get(0).size()];
		for(int i = 0;i<obj.length; i++) {
			obj[i][0]=data.get(i).get("name");
			obj[i][1]=data.get(i).get("email");
			obj[i][2]=data.get(i).get("password");
			obj[i][3]=data.get(i).get("confirmPassword");
		}
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
