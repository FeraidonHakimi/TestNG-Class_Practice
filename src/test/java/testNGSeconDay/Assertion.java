package testNGSeconDay;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Assertion {
	
/*
  A = 
Assertion:
we have two types of assert in TestNG
1 = Hard assert =  it will stop the execution if the assert failed or
	actual does not match the expected on.

2 = Soft Assert = it will not stop the execution even if the assert failed.
	Soft assert is available only in testNG. jUnit does not have soft assert.
	in order to use soft assert, we have to ceate the object of soft assert.
*/
	
	@Test
	public void hardAssert() {
		int a = 10;
		int b = 15;
		int c = a+b;
		Assert.assertEquals(c, 25);
		System.out.println("they are equal");
	}
	
	
/*
 B =  dependent on method(dependent on another test cases)
 	: the first test passed, second test also should pass. other wise n
*/
	@Test(dependsOnMethods = "hardAssert")
	public void softAssert() {
		SoftAssert softAssert = new SoftAssert();
		int x = 20;
		int y = 20;
		softAssert.assertEquals(x,y);
		softAssert.assertAll();
		System.out.println( "they are equal");
	}
	
	
	
	
	/*
	 * How we ReRun when a test case failed? we should reRun only the failed test cases.
	 * 
	 * OneWay
	 * Answer: when a test cases failed, TestNG give us a failed file under the output folder
	 * which basicly dedicate which test cases failed. then when we fixed the issue,
	 * the can run from failed file.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	

}
