package testNG4Day;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tek.sdet.testng.utilities.ExcelReader;

public class ReadFromExcel {
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
	}
	
//	@AfterMethod
//	public void close() {
//		driver.close();
//	}
	
	@Test(dataProvider="fromExel")
	//@Parameters({"name","lastName","email","password","monthValue","dayValue","yearValue"})
	public void testOne(String name, String lastName, String email, String password,
			String monthValue,String dayValue, String yearValue) {
	System.out.println("*********`"+monthValue);
	System.out.println(dayValue);
	System.out.println(yearValue);
		
		driver.findElement(By.xpath("//*[text()='Create new account']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(email);
		driver.findElement(By.id("password_step_input")).sendKeys(lastName);
		
		WebElement month = driver.findElement(By.id("month"));
		Select select = new Select(month);
		select.selectByVisibleText(monthValue);
		
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
	
	@DataProvider(name="fromExel")
	public Object [][] obj () throws IOException{
		String path =".\\src\\test\\resources\\testData\\facebookCreate (6).xlsx";
		List<Map<String, String>> map = 
				ExcelReader.readSheetWithFirstRowAsHeader(ExcelReader.getExcelSheet(path, 0));
		Object [][] obj = new Object[map.size()][map.get(0).size()];
		for(int i =0; i<obj.length;i++) {
		obj[i][0] = map.get(i).get("name");
		obj[i][1] = map.get(i).get("lastName");
		obj[i][2] = map.get(i).get("email");
		obj[i][3] = map.get(i).get("pawssword");
		obj[i][4] = map.get(i).get("monthValue");
		obj[i][5] = map.get(i).get("dayValue");
		obj[i][6] = map.get(i).get("yearValue");
		}
		
		return obj;
	}
	
	
	
	
	
	
	
	
	String path1 = "fadfasfa";
	public Object [] [] temp () throws IOException{
		List<Map<String, String>> list = ExcelReader.readSheetWithFirstRowAsHeader(ExcelReader.getExcelSheet(path1, 0));
		Object [][] obj = new Object [list.size()][list.get(0).size()];
		
		for(int i=0; i<obj.length;i++) {
			
			obj[i][0] = list.get(i).get("afdafds");
		}
		
		
		
		
		
		
		
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Object [] [] ooo () throws IOException{
		String paht6 = "fadaf";
	List<Map<String, String>> ob = ExcelReader.readSheetWithFirstRowAsHeader(ExcelReader.getExcelSheet(paht6, 0));	
		Object [][] kk = new Object[ob.size()][ob.get(0).size()];
		for(int o=0; o<ob.size();o++) {
			
			
			kk [o][0] = ob.get(o).get("jh");
		}
		return kk;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
