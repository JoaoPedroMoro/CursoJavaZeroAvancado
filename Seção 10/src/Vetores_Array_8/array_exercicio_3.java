package Vetores_Array_8;

/*
 * O objetivo deste exercício é inverter os elementos de um vetor.
 * */

public class array_exercicio_3 {

	public static void main(String[] args) {

		int[] vetor = {1, 2, 3, 4, 5, 6};
		
		int[] vetorInverso = new int[6];
		
		int j = vetor.length-1;
		
		for (int i = 0 ; i < vetor.length ; i++, j--) {
			
			vetorInverso[i] = vetor[j];
			
		}
		
		System.out.println("\nVetor original: ");
		
		for (int i : vetor) {;
		
			System.out.println(i);
			
		}
		
		System.out.println("\nVetor inverso: ");
		
		for (int i : vetorInverso) {
			
			System.out.println(i);
			
		}

	}

}
