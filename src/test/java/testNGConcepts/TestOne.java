package testNGConcepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestOne {

	@Test
	public void testPrint() {
		System.out.println("*************second**************");
	}
	
	@BeforeClass
	public void test2() {
		System.out.println("Befrore class from second");
	}
	@AfterClass
	public void test3() {
		System.out.println("After class from second");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("<<<<<<Before Suite from second >>>>>>");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("<<<<<<After Suite from second>>>>>>");
	}
	
	
	@Test(groups = "smoke")
	public void cocmon() {
		System.out.println("<<<<<<this is from second class>>>>>>");
	}
	
	@Test(groups = "smoke")
	public void cocmdf() {
		System.out.println("<<<<<<this is from second class>>>>>>");
	}
	@BeforeTest() 
	public void testThree() {
		System.out.println("Before Test");
	}
	@AfterTest() 
	public void testlast() {
		System.out.println("after Test");
	}
	
	@BeforeGroups() 
	public void before() {
		System.out.println("Before groups");
	}
	@AfterGroups() 
	public void afterMe() {
		System.out.println("after groups");
	}
	
	

}
