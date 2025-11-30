package Vetores_Array_8;

/*
 * O objetivo desse exercício é preencher um vetor de 5 posições com a entrada do usuário. O vetor é numérico.
 * */

import java.util.Scanner;

public class array_exercicio_2 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		int[] vetor = new int[5];
		
		for (int i =0 ; i < vetor.length ; i++) {
			
			System.out.println("Insira o valor desejado para a posição " + i + ": " );
			
			vetor[i] = entrada.nextInt();
			
		}
		
		
		System.out.println("\nVetor digitado: ");
		
		for (int i : vetor) {
			
			System.out.println(i); 
			
		}
		
		entrada.close();
		
	}
	
}
