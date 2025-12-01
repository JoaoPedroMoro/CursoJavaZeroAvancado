package Matrizes_9;

/*
 * O objetivo desse exemplo é conhecer sobre a matriz em Java.
 * */

public class matriz_exemplo_1 {

	public static void main(String[] args) {

		System.out.println("\nExemplo 1 - Imprimindo uma matriz 3x3: ");
		
		int[][] matriz = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8,9}
		};
		
		for (int linha = 0; linha < 3 ;linha++) {
			
			for (int coluna = 0; coluna < 3 ;coluna++) {
				
				System.out.print(matriz[linha][coluna] + " "); // Só o print pra não pular
				
			}
			
			System.out.println();
			
		}
		
		System.out.println("\nExemplo 2 - Preenchendo uma matriz manualmente: ");
		
		for (int linha = 0; linha < 3 ;linha++) {
			
			for (int coluna = 0; coluna < 3 ;coluna++) {
				
				if (linha == 0) {
					
					matriz[linha][coluna] = linha+coluna+2;
					
				} else if (linha == 1) {
					
					matriz[linha][coluna] = linha+coluna+6;
					
				} else {
					
					matriz[linha][coluna] = linha+coluna+10;
					
				}
				
			}

		}
		
		for (int linha = 0; linha < 3 ;linha++) {
			
			for (int coluna = 0; coluna < 3 ;coluna++) {
				
				System.out.print(matriz[linha][coluna] + " "); // Só o print pra não pular
				
			}
			
			System.out.println();
			
		}
		
		System.out.println("\nExemplo 3 - Soma de todos os elementos da matriz: ");
		
		int soma = 0;
		
		int[][] matriz2 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8,9}
		};
		
		for (int linha = 0; linha < 3 ;linha++) {
			
			for (int coluna = 0; coluna < 3 ;coluna++) {
				
				soma += matriz2[linha][coluna];
				
			}
			
			
		}
		
		System.out.println(soma);
		
		System.out.println("\nExemplo 4 - Maior número da matriz: ");
		
		int maior = 0;
		
		int[][] matriz3 = {
				{102, 22, 39},
				{41234, 5123, 601},
				{71, 8,912}
		};
		
		for (int linha = 0; linha < 3 ;linha++) {
			
			for (int coluna = 0; coluna < 3 ;coluna++) {
				
				if (maior < matriz3[linha][coluna]) {
					
					maior = matriz3[linha][coluna];
					
				}
				
			}
			
		}
		
		System.out.println(maior);

		System.out.println("\nExemplo 1 - Diagonal principal da matriz: ");
		
		int[][] matriz4 = {
				{10, 1, 2},
				{3, 10, 4},
				{5, 6,10}
		};
		
		for (int linha = 0; linha < 3 ;linha++) {
			
			for (int coluna = 0; coluna < 3 ;coluna++) {
				
				if (linha == coluna) {
					
					System.out.print(matriz4[linha][coluna] + " ");
					
				} else {
					
					System.out.print(" " + " ");
					
				}

			}
			
			System.out.println();
			
		}

	}

}
