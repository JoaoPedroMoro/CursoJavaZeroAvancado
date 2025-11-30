package Vetores_Array_8;

/*
 * O objetivo deste exemplo é aprender como criar um vetor e criar uma cópia dele.
 * */

public class array_exemplo_2 {

	public static void main(String[] args) {

		int[] vetorOriginal = {10, 20, 30, 40, 50};
		
		int[] vetorCopia = new int[5];
		
		for(int i=0 ; i < vetorOriginal.length ; i++) {
			
			vetorCopia[i] = vetorOriginal[i]; // Cópia de elemento por elemento, índice a índice.
			
		}
		
		for(int valor : vetorCopia) {
			
			System.out.println("Número: " + valor);
			
		}

	}

}
