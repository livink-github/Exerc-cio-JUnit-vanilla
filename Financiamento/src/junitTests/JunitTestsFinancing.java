package junitTests;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import services.Financing;

public class JunitTestsFinancing {
	private Financing financing = FinancingFactory.generateFinancing(10.0, 1.0, 20);
	private Object expectedValue;
	
	@Test
	public void CONSTRUCTORtestShouldIllegalArgumentExceptionWhenNotPassInValidationMethod() {
		assertThrows(IllegalArgumentException.class, ()-> {
			financing = FinancingFactory.generateFinancing(10.0, 1.0, 10);
		}); 
	}
	@Test
	public void CONSTRUCTORtestShouldNotErrorOrExceptionWhenPassInValidationMethod() {
		assertNotNull(FinancingFactory.generateFinancing(10.00, 1.000, 20));
	}
	
	@Test
	public void ENTRYtestShouldReturnTwentyPercentOfAmount() {
		expectedValue = 2.0;
		assertTrue(financing.entry() == (Double)expectedValue);
	}
	
	@Test
	public void QUOTAtestShouldReturnInstallmentValue() {
		expectedValue = 0.4;
		assertTrue(financing.quota() == (Double)expectedValue);
	}
	
	@Test
	public void SETAMOUNTtestShouldNotErrorOrExceptionWhenPassInValidationMethod() {
		expectedValue = 8.0;
		financing.setTotalAmount((Double)expectedValue);
		assertEquals(financing.getTotalAmount(), (Double)expectedValue);
	}
	
	@Test
	public void SETAMOUNTtestShouldIllegalArgumentExceptionWhenIvalidData() {
		expectedValue = 15.00;
		assertThrows(IllegalArgumentException.class,  ()-> {
			financing.setTotalAmount((Double)expectedValue);
		});
	}
	
	@Test
	public void SETINCOMEtestShouldNotErrorOrExceptionWhenPassInValidationMethod() {
		expectedValue = 8.0;
		financing.setIncome((Double)expectedValue);
		assertEquals(financing.getIncome(), (Double)expectedValue);
	}
	
	@Test
	public void SETINCOMEtestShouldIllegalArgumentExceptionWhenIvalidData() {
		expectedValue = 0.7;
		assertThrows(IllegalArgumentException.class,  ()-> {
			financing.setIncome((Double)expectedValue);
		});
	}
	
	@Test
	public void SETMONTHStestShouldNotErrorOrExceptionWhenPassInValidationMethod() {
		expectedValue = 30;
		financing.setMonths((Integer)expectedValue);
		assertEquals(financing.getMonths(), (Integer)expectedValue);
	}
	
	@Test
	public void SETMONTHStestShouldIllegalArgumentExceptionWhenIvalidData() {
		expectedValue = 10;
		assertThrows(IllegalArgumentException.class,  ()-> {
			financing.setMonths((Integer)expectedValue);
		});
	}
	
}
