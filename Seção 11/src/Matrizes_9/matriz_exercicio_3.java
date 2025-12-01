package Matrizes_9;

/*
 * O objetivo desse exercicio é transpor uma matriz 3x2 para uma matriz 2x3 e trocar as linhas de uma matriz, trocando a primeira linha com a ultima.
 * 
 * */

public class matriz_exercicio_3 {

	public static void main(String[] args) {
		int[][] matriz = {
			    {1, 3},
			    {4, 5},
			    {8, 9}
			};

			int[][] matrizT = new int[matriz[0].length][matriz.length];
			
			// matriz.length = número de linhas
			// matriz.length[0] = número de colunas na linha 0

			for (int coluna = 0 ; coluna < matriz[0].length ; coluna++) {
				
			    for (int linha = 0; linha < matriz.length ; linha++) {
			    	
			        matrizT[coluna][linha] = matriz[linha][coluna];
			        
			    }
			    
			}

			System.out.println("A matriz original é: ");

			for (int l = 0 ; l < matriz.length ; l++) {
				
			    for (int c = 0 ; c < matriz[0].length ; c++) {
			    	
			        System.out.print(matriz[l][c] + " ");
			        
			    }
			    
			    System.out.println();
			    
			}

			System.out.println("\nA matriz transposta é: ");

			for (int l = 0 ; l < matrizT.length ; l++) {
				
			    for (int c = 0 ; c < matrizT[0].length ; c++) {
			    	
			        System.out.print(matrizT[l][c] + " ");
			        
			    }
			    
			    System.out.println();
			    
			}
			
			int [] temp = matriz[0];
			
			matriz[0] = matriz[2];
			
			matriz[2] = temp;
			
			System.out.println("\nA matriz após a troca de linhas é: ");

			for (int l = 0 ; l < matriz.length ; l++) {
				
			    for (int c = 0 ; c < matriz[0].length ; c++) {
			    	
			        System.out.print(matriz[l][c] + " ");
			        
			    }
			    
			    System.out.println();
			    
			}

	}

}
