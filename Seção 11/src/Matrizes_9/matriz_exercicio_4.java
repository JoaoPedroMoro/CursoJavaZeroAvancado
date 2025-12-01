package Matrizes_9;

/*
 * O objetivo desse exercício é calcular a soma de duas matrizes e encontrar a posição de um número específico
 * */

public class matriz_exercicio_4 {

	public static void main(String[] args) {
		int[][] matriz = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		int[][] matriz2 = {
				{10, 20, 30},
				{40, 50, 60},
				{70, 80, 90}
		};
		
		int[][] matrizSoma = new int[matriz.length][matriz[0].length];
		
		for (int linha = 0; linha < matriz.length ; linha++) {
			
			for (int coluna = 0 ; coluna < matriz[0].length ; coluna++) {
		    	
		        matrizSoma[linha][coluna] = matriz[linha][coluna] + matriz2[linha][coluna];
		        
		    }
		    
		}
		
		System.out.println("\nA matriz soma é: ");
		
		for (int linha = 0; linha < matriz.length ; linha++) {
			
			for (int coluna = 0 ; coluna < matriz[0].length ; coluna++) {
		    	
		        System.out.print(matrizSoma[linha][coluna] + " ");
		        
		    }
			
			System.out.println();
		    
		}
		
		int numero = 4;
		
		boolean flag = false;
		
		for (int linha = 0; linha < matriz.length ; linha++) {
			
			for (int coluna = 0 ; coluna < matriz[0].length ; coluna++) {
				
				if (matriz[linha][coluna] == 4) {
					
					System.out.println("O número 4 foi encontrado na posição " + linha + " " + coluna);
					
					flag = true;
					
				}
		        
		    }
		    
		}
		
		if (flag == false) {
			
			System.out.println("Não foi possível encontrar o número 4 na matriz");
		}

	}

}
