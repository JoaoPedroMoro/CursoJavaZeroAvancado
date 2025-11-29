package do_while_5;

/*
 * Este exemplo é para aprender sobre o do-while. O objetivo deste programa aprender sobre o bloco do-while realizando vários exemplos.
 * */

import java.util.Scanner;

public class do_while_exemplo_1 {

	public static void main(String[] args) {

		System.out.println("\n1. Exemplo 1: Contar de 1 até 5 com do-while\n");
		
		int contador = 1;
		
		do {
			
			System.out.println("Contando: " + contador);
			
			contador++;
			
		} while (contador <= 5);
		
		System.out.println("\n2. Exemplo 2: Menu simples que repete até o usuário digitar 0\n");
		
		int opcao;
		
		Scanner entrada =  new Scanner(System.in);
		
		do {
			
			System.out.println("\n========== MENU ==========\n");
			System.out.println("1 - Opção 1");
			System.out.println("2 - Opção 2");
			System.out.println("0 - Sair");
			
			System.out.println("Escolha uma opção: ");
			
			opcao = entrada.nextInt();
			
			if (opcao == 1) {
				
				System.out.println("Você escolheu a opção 1.");
				
			} else if (opcao == 2) {
				
				System.out.println("Você escolheu a opção 2.");
				
			} else if (opcao != 0) {
				
				System.out.println("Você escolheu uma opção inválida, tente novamente ...");
				
			}
			
			
		} while (opcao != 0);
		
		System.out.println("Você escolheu a opção 0. Saindo do menu ...");
		
		System.out.println("\nExemplo 3: Validar entrada até o usuário digitar um número positivo\n");
		
		int numero;
		
		do {
			
			System.out.println("Digite um número positivo: ");
			
			numero = entrada.nextInt();
			
			if (numero < 0) {
				
				System.out.println("Número inválido, tente novamente.");
				
			}
			
		} while (numero <= 0);
		
		System.out.println("Você digitou um número válido. Número digitado: " + numero);
		
		entrada.close();

	}

}
