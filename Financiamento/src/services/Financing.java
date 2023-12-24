package services;

import internalDataBase.Fees_And_Limits;

public class Financing {
	
	private double totalAmount;
	private double income;
	private int months;
	
	public Financing() {
	}
	public Financing(Double totalAmount, Double income, Integer months) {
		dataValidation(totalAmount, income, months);
		this.totalAmount = totalAmount;
		this.income = income;
		this.months = months;
	}
	
	public double entry() {
		return totalAmount * Fees_And_Limits.financingMinEntryPercentageTax;
	}
	
	public double quota() {
		return (totalAmount - entry()) / months;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		dataValidation(totalAmount, income, months);
		this.totalAmount = totalAmount;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		dataValidation(totalAmount, income, months);
		this.income = income;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		dataValidation(totalAmount, income, months);
		this.months = months;
	}
	
	private void dataValidation(Double totalAmount, Double income, Integer months) {
		double quota = (totalAmount - totalAmount*Fees_And_Limits.financingMinEntryPercentageTax);
		if (quota / months > income/2) throw new IllegalArgumentException("Valor da parcela Excede metade do salario do contratante"); 
	}
	@Override
	public String toString() {
		return "----------------------------------"
		+ "\nValor do produto = " + String.format("%.3f%n", totalAmount) 
		+ "Valor de entrada = " + String.format("%.3f%n", entry())
		+ "Valor Financiado = " + String.format("%.3f%n", totalAmount - entry()) 
		+ "Renda Simulada   = " + String.format("%.3f%n", income )
		+ "N° de Parcelas   = " + months 
		+ "\nValor da parcela = " + String.format("%.3f%n", quota())
		+ "\n----------------------------------\n\n";
	}
	
}
