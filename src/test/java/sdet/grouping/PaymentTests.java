package sdet.grouping;

import org.testng.annotations.Test;

public class PaymentTests {

	@Test(priority=1 , groups = {"regression","sanity","functional"})
	void UPIPayment() {
		System.out.println("Payment through UPI");
	}
	
	@Test(priority=2 , groups = {"regression","sanity","functional"})
	void CreditCardPayment() {
		System.out.println("Payment through credit card");
	}
	
}
