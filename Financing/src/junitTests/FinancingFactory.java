package junitTests;

import services.Financing;

public class FinancingFactory {

	public static Financing generateFinancing(Double totalAmount, Double income, Integer months) {
		return new Financing(totalAmount, income, months);
	}
}
