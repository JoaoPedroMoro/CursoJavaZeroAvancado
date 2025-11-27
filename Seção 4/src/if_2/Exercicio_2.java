package if_2;
/*
 * O objetivo desse exercício é verificar se o número inteiro é par ou ímpar e imprimir na tela o resultado
 * */

import java.util.Scanner;

public class Exercicio_2 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite um número inteiro: ");
		
		int numero = entrada.nextInt();
		
		if (numero % 2 == 0) {
			
			System.out.println("O número que você digitou é par!");
			
		} else {
			
			System.out.println("O número que você digitou é ímpar!");
			
		}
		
		entrada.close(); // Boa prática

	}

}
