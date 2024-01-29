package application;

import java.util.Scanner;

import models.entities.ContaBancaria;
import models.exceptions.SaqueException;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Dados da conta");
		System.out.print("Número da conta: ");
		int numeroConta = leitor.nextInt();
		leitor.nextLine();
		System.out.print("Titular: ");
		String titularConta = leitor.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = leitor.nextDouble();
		System.out.print("Limite de saque: ");
		double limite = leitor.nextDouble();
		ContaBancaria cc1 = new ContaBancaria(numeroConta, titularConta, saldo, limite);
		try {
			System.out.print("\nValor do saque: ");
			double valor = leitor.nextDouble();
			cc1.saque(valor);
			System.out.print(cc1.toString());
		} catch (SaqueException e) {
			if (e != null) {
				System.out.print(e.getMessage());
			}
		}
	}

}
