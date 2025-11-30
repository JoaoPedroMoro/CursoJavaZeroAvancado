package Vetores_Array_8;

/*
 * O objetivo desse exercício é calcular a média de 5 elementos que foram inseridos pelo usuário, 5 valores reais.
 * */

import java.util.Scanner;

public class array_exercicio_4 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		double[] vetor = new double[5];
		
		double soma = 0;
		
		for (int i = 0 ; i < vetor.length ; i++) {
			
			System.out.println("Digite o valor " + (i+1) + ": ");
			
			vetor[i] = entrada.nextDouble();
			
			soma += vetor[i];
			
		}
		
		System.out.println("A média aritmética dos elementos passados é: " + (soma/vetor.length));
		
		entrada.close();

	}

}
