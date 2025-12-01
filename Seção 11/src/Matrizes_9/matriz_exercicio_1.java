package Matrizes_9;

/*
 * O objetivo desse programa é criar uma matriz 3x3 e ler uma matriz 2x2 do usuário.
 * */

import java.util.Scanner;

public class matriz_exercicio_1 {

	public static void main(String[] args) {
		
		int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		for (int l = 0 ; l < 3 ; l++) {
			
			for (int c = 0 ; c < 3 ; c++) {
				
				System.out.print(matriz[l][c] + " ");
				
			}
			
			System.out.println();
			
		}
		
		Scanner entrada = new Scanner(System.in);
		
		int[][] matriz2 = new int[3][3];
		
		for (int l = 0 ; l < 3 ; l++) {
			
			for (int c = 0 ; c < 3 ; c++) {
				
				System.out.println("Digite o elemento [" + l + "][" + c + "] da matriz: ");
				matriz2[l][c] = entrada.nextInt();
				
			}
			
			
		}
		
		System.out.println("A matriz final é: ");
		
		for (int l = 0 ; l < 3 ; l++) {
			
			for (int c = 0 ; c < 3 ; c++) {
				
				System.out.print(matriz2[l][c] + " ");
				
			}
			
			System.out.println();
			
		}
		
		entrada.close();

	}

}
