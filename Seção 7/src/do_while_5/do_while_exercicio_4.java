package do_while_5;

/*
 * O objetivo deste exercício é desenvolver um programa que leia números inteiros do usuário até ele digitar um número negativo.
 * */

import java.util.Scanner;

public class do_while_exercicio_4 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		int numero;
		
		do {
			
			System.out.println("Digite um número inteiro: ");
			
			numero = entrada.nextInt();
			
		} while (numero >= 0);
		
		System.out.println("Você digitou um número negativo, fim do programa ...");
		
		entrada.close();

	}

}
