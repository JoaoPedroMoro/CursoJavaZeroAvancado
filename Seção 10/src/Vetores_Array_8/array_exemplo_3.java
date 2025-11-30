package Vetores_Array_8;

/*
 * Neste exercício é desenvolvido um programa que conta a quantidade de números pares digitados pelo usuário, dentre 10 entradas.
 * */

import java.util.Scanner;

public class array_exemplo_3 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		int[] numeros = new int[10];
		
		int pares = 0;
		
		for (int i=0 ; i < 10 ; i++) {
			
			System.out.println("Digite o " + (i+1) + "º números: ");
			
			numeros[i] = entrada.nextInt();
			
			if(numeros[i]%2==0) {
				
				pares++;
				
			}
			
		}
		
		System.out.println("Quantidadede números pares digitados: " + pares);
		
		entrada.close();

	}

}
