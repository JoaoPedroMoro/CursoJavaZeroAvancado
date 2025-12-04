package Encapsulamento;

/*
 * Neste exemplo conhecemos sobre o encapsulamento e exploramos bastante sobre ele.
 * */

import java.util.Scanner;

public class exemplo_2_encapsulamento {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o nome do titular: ");
		
		String nome = entrada.nextLine();
		
		System.out.println("Digite o CPF do titular (somente números): ");
		
		String cpf = entrada.nextLine();
		
		System.out.println("Digite o saldo inicial: ");
		
		double saldoInicial = entrada.nextDouble();
		
		ContaBancaria conta = new ContaBancaria(nome, cpf, saldoInicial);
		
		conta.exibirResumo();
		
		conta.depositar(100.0);
		
		System.out.println("\nApós o depósito de R$100: ");
		
		conta.exibirResumo();
		
		boolean saque1 = conta.sacar(50.0);
		
		if(saque1) {
			
			System.out.println("\nSaque de R$ 50 realizado com sucesso!");
			
		} else {
			
			System.out.println("\nFalha ao tentar sacar R$ 50.");
		}
		
		conta.exibirResumo();
		
		boolean saque2 = conta.sacar(10000.0);
		
		if(saque2) {
			
			System.out.println("\nSaque de R$ 10.000 realizado com sucesso!");
			
		} else {
			
			System.out.println("\nFalha ao tentar sacar R$ 10.000.");
		}
		
		conta.exibirResumo();
		
		conta.depositar(500.0);
		
		System.out.println("\nApós o depósito de R$500: ");
		
		conta.exibirResumo();
		
		conta.setNomeTitular("Novo Titular");
		
		System.out.println("\nApós alterar o nome do titular: ");
		
		conta.exibirResumo();
		
		entrada.close();

	}

}
