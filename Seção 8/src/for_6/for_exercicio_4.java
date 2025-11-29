package for_6;

/*
 * Calcula a média de 10 números fornecidos pelo usuário.
 * */

import java.util.Scanner;

public class for_exercicio_4 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		double total = 0;
		int numero;
		
		for (int i = 1 ; i<= 10 ; i++) {
			
			System.out.println(i + ". Digite um número: ");
			
			numero = entrada.nextInt();
			
			total += numero;
			
		}
		
		System.out.println("A média aritmética dos 10 números que você digitou é " + (total/10));
		
		entrada.close();

	}

}
