package sdet.dependencyMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {

	
	// if a test fails or skips all its dependent test will also get skip
	
	@Test(priority=1)
	public void openUrl() {
		Assert.assertTrue(true);
	}
	
	@Test(priority=2,dependsOnMethods = {"openUrl"})
	public void login() {
		Assert.assertTrue(true);
	}
	
	@Test(priority=3,dependsOnMethods = {"login"})
	public void search() {
		Assert.fail();;
	}
	
	@Test(priority=4,dependsOnMethods = {"openUrl","search"})
	public void advanceSearch() {
		Assert.assertTrue(true);
	}
	
	@Test(priority=5,dependsOnMethods = {"login"})
	public void logout() {
		Assert.assertTrue(true);
	}
	
	
}
