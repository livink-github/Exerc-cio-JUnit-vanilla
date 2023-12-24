package application;

import java.util.Scanner;

import services.Financing;

public class Program {
	public static void main(String[] args) {
		Long count = 1L;
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Valor do produto : "); double amount = sc.nextDouble();
			System.out.print("Renda Simulada   : "); double salary = sc.nextDouble();
			System.out.print("N° Parcelas      : "); int month = sc.nextInt();
			System.out.println();
			try {
				Financing financing = new Financing(amount, salary, month);
				System.out.println("Financiamento "+count+"\n" + financing);
			} catch (IllegalArgumentException e) {
				System.out.println("Dados invalidos para financiamento #"+count+"\n"
						+ "Valor Financiado = " + String.format("%.3f%n", amount)
						+ "Renda Simulada   = " + String.format("%.3f%n", salary)
						+ "N° de Parcelas   = " + month
						+ "\nValor da parcela = " + String.format("%.3f%n", amount * 0.8 / month));
				System.out.println(e.getMessage()+"\n");
			}
			count++; sc.close();
		}
	}
}
