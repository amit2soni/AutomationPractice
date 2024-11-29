package sdet.testNGRunningSuite;

import org.testng.annotations.Test;

public class TestCase1 {

	// to run a test case using testng we have to use @test annotation
	// we can provide priority to tests to run them as per our requirement
	// of no priority is provided testng will run test by alphabetical order
	// default priority value is 0 , we can also provide negative priority and least value will run first
	// if we provide same priority it will run on alphabetic order
	
	@Test(priority=-1)
	public void tc_1_fun_1() {
		System.out.println("First test case , first method");
	}
	
	@Test(priority=0)
	public void tc_1_fun_2() {
		System.out.println("First test case , Second method");
	}
	
	@Test(priority=2738)
	public void tc_1_fun_3() {
		System.out.println("First test case , third method");
	}
	
	
	
	
}
