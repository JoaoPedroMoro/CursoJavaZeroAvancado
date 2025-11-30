package Vetores_Array_8;

/*
 * Objetivo desde exemplo é somar dois vetores.
 * */

public class array_exemplo_5 {

	public static void main(String[] args) {

		int[] vetor1 = {4, 8, 12, 16, 20, 24};
		
		int[] vetor2 = {2, 4, 8, 16, 32, 64};
		
		int[] soma = new int[6];
		
		for (int i = 0 ; i < vetor1.length ; i++) {
			
			soma[i] = vetor1[i] + vetor2[i];
			
		}
		
		for (int valor : soma) {
			
			System.out.println(valor);
			
		}
		

	}

}
