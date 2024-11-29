package sdet.grouping;

import org.testng.annotations.Test;

public class SignUpTests {

	@Test(priority=1 , groups = {"regression"})
	void SignUpByEmail() {
		System.out.println("This is SignUp by email");
	}
	
	@Test(priority=2 , groups = {"regression"})
	void SignUpByFacebook() {
		System.out.println("This is SignUp by facebook");
	}
	
	@Test(priority=3 , groups = {"regression"})
	void SignUpByTwitter() {
		System.out.println("This is SignUp by twitter");
	}
	
}
