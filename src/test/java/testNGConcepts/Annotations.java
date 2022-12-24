package testNGConcepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

// in TestNG the flow of execution is based of Atherate@

/*
 
	Then we can priorities by using priority keyword
	Otherwise it will run based of Alpabet
	@Test(priority = 2)
	public void btestOne() {
	System.out.println("this is second test cases 2");
	}
*/



// the testCases which does not have priority, will run first
// even we can use minous numbers




/* how to ignore the test cases = @ignore 
   and @test(enabled=false) same as ignore
   
   	@BeforeClass
   	@Ignore
	public void beforeClass() {
	System.out.println("before class <<<<<<<<<<<<<<<<<<");
	}
*/


// how we can one testCases multiple time?
//@test(priority = 1, invocationCount = 10)


// how we can one grouped some test?
//@test(priority = 1, groups = {"Smoke"})





public class Annotations {

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("after <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("<<<<<<Before Suite>>>>>>");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("<<<<<<after Suite>>>>>>");
	}
	
		
//	@BeforeMethod
//	public void beforeEachTestCase() {
//		System.out.println("this is before each test cases");
//	}
//	@AfterMethod
//	public void afterEachTestCases() {
//		System.out.println("this is after each test cases");
//	}
	
	@Test(priority = 1, invocationCount = 3)
	public void test() {
		System.out.println("Is the first test cases 1");
	}
	
	@Test(priority = 2)
	public void btestOne() {
		System.out.println("this is second test cases 2");
	}
	@Test(priority = 2)
	public void atestTwo() {
		System.out.println("this is third test cases 2");
	}
	@BeforeTest() 
	public void testThree() {
		System.out.println("Before Test");
	}
	@AfterTest() 
	public void testlast() {
		System.out.println("after Test");
	}
	@Test(enabled = false)
	public void testFour() {
		System.out.println("this is fifth 7");
	}
	
	@Test(priority = -1, groups = {"smoke"})
	
	public void alpahTest() {
		System.out.println("This is alpah test 4");
	}
	
	
	
}
