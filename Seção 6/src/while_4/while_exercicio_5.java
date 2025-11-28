package while_4;

/*
 * O objetivo do exercício é calcular a média de números até digitar -1.
 * */

import java.util.Scanner;

public class while_exercicio_5 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite um número: ");
		
		int numero = entrada.nextInt();
		
		int soma = 0;
		
		int numeroEntradas = 0;
		
		while (numero != -1) {
			
			soma += numero;
			
			numeroEntradas++;
			
			System.out.println("Digite outro número: ");
			
			numero = entrada.nextInt();
			
			
		}
		
		System.out.println("Você escolheu um número negativo. Fim do programa.");
		
		System.out.println("Você digitou " + numeroEntradas + " número(s) e a média desse(s) número(s) foi " + (soma/numeroEntradas));
		
		entrada.close();

	}

}
