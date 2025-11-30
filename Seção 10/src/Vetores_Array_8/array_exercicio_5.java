package Vetores_Array_8;

/*
 * O objetivo desse exercício é solicitar 5 números inteiros para o usuário e armazenar em um vetor, depois multiplicar
 * todos esses números pelo número que o usuário desejar.
 * */

import java.util.Scanner;

public class array_exercicio_5 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		int[] vetor = new int[5];
		
		for (int i = 0 ; i < vetor.length ; i++) {
			
			System.out.println("Digite um número para acrescentar ao vetor: ");
			
			vetor[i] = entrada.nextInt();
			
		}
		
		int numero = 0;
		
		System.out.println("Digite o número pelo qual você deseja multiplicar todos os valores do vetor: ");
		
		numero = entrada.nextInt();
		
		for (int i = 0 ; i < vetor.length ; i++) {
			
			vetor[i] *= numero;
			
		}
		
		System.out.println("\nVetor final: ");
		
		for (int i : vetor) {
			
			System.out.println(i);
			
		}
		
		entrada.close();

	}

}
