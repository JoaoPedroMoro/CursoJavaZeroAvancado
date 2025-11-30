package Vetores_Array_8;

/*
 * Criando um vetor e contando quantas vezes o número 7 aparece.
 * */

public class array_exemplo_4 {

	public static void main(String[] args) {
		
		int[] vetor = {7, 1, 7, 2, 7, 3, 7, 4, 7, 5, 7, 6, 7, 7};
		
		int contador = 0;
		
		for(int i=0 ; i < vetor.length ; i++) {
			
			if(vetor[i] == 7) {
				
				contador++;
				
			}
			
		}
		
		System.out.println("A quantidade de números 7 nesse vetor é: " + contador);

	}

}
