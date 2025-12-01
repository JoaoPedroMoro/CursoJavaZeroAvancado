package Matrizes_9;

/*
 * O objetivo desse exercício é calcular a média dos valores de uma matriz e contar quantos elementos de uma matriz são pares
 * */

public class matriz_exercicio_2 {

	public static void main(String[] args) {

		int[][] matriz = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		int soma = 0;
		
		for (int l = 0 ; l < 3 ; l++) {
			
			for (int c = 0 ; c < 3 ; c++) {
				
				soma += matriz[l][c];
				
			}
			
		}
		
		System.out.println("A média dos elementos dessa matriz é: " + soma/(matriz[0].length * matriz[1].length));
		
		int pares = 0;
		
		for (int l = 0 ; l < 3 ; l++) {
			
			for (int c = 0 ; c < 3 ; c++) {
				
				if (matriz[l][c] % 2 == 0) {
					
					pares++;
					
				}
				
			}
			
		}
		
		System.out.println("\nA quantidade de elementos pares dessa matriz é: " + pares);
		
	}

}
