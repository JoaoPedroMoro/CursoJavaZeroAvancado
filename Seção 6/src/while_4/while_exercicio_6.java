package while_4;

/*
 * O objetivo desse exercício é desenvolver um programa em Java que conta números positivos, até digitar 0.
 * */

import java.util.Scanner;

public class while_exercicio_6 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite um número: ");
		
		int numero = entrada.nextInt();
		
		int numPos = 0;
		
		if (numero > 0) {
			
			numPos++;
			
		}
		
		while (numero != 0) {
			
			System.out.println("Digite outro número: ");
			
			numero = entrada.nextInt();
			
			if (numero > 0) {
				
				numPos++;
				
			}
			
		}
		
		System.out.println("Você digitou 0, que é o critério de parada. Você digitou um total de números positivos igual a " + numPos);
		
		entrada.close();

	}

}
