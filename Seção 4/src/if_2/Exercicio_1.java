package if_2;
/*
 * O objetivo do exercício é criar um programa que receba um número INTEIRO
 * do usuário e verifique se ele é positivo ou não.
 * 
 * Se o número > 0: imprimir que ele é positivo.
 * Caso contrário: imprimir que ele não é positivo.
 * 
 * */

import java.util.Scanner;

public class Exercicio_1 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite um número inteiro: ");
		
		int numero = entrada.nextInt();
		
		if (numero > 0) {
			
			System.out.println("O número que você digitou é inteiro!");
			
		} else {
			
			System.out.println("O número que você digitou não é inteiro!");
			
		}
		
		entrada.close(); // Boa prática

	}

}
