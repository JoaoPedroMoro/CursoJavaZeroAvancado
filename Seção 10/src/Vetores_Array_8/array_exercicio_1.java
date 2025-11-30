package Vetores_Array_8;

/*
 * O objetivo desse exercício é criar e imprimir um vetor de inteiros. Crie um vetor de 5 posições contendo números
 * de 1 até 5, depois printe todos os valores.
 * */

public class array_exercicio_1 {

	public static void main(String[] args) {

		int[] vetor = {1, 2, 3, 4, 5};
		
		for (int i =0 ; i < vetor.length ; i++) {
			
			System.out.println("Valor na posição " + i + ": " + vetor[i]);
			
		}
		
	}

}
