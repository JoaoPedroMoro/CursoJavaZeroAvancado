package desafios;

/*
 * O objetivo desse programa é ler 20 números inteiros passados pelo usuário e adicioná-los em
 * 2 vetor, o vetor PAR e o vetor IMPAR, mostrando o vetor total, o vetor par e o vetor impar ao final
 * */

import java.util.InputMismatchException;
import java.util.Scanner;

public class desafio_6 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int[] completo = new int[20];
		
		int numPar = 0;
		int numImpar = 0;
		
		for (int i=0; i<20 ;) {
			
			try {
				
				System.out.println("Digite o " + (i+1) + "º número para o vetor: ");
				
				int numero = entrada.nextInt();
				
				completo[i] = numero;
				
				i++;
				
				if (numero % 2 == 0) numPar++;
				else numImpar++;
				
				
			} catch (InputMismatchException e) {
				
				entrada.nextLine();
				
				System.out.println("Formato inválido, digite um número.");
				
			}
			
		}
		
		int[] par = new int[numPar];
		
		int[] impar = new int[numImpar];
		
		numPar = 0;
		numImpar = 0;
		
		for (int i = 0; i < completo.length ; i++) {
			
			if (completo[i] % 2 == 0) {
				
				par[numPar] = completo[i];
				
				numPar++;
				
			} else {
				
				impar[numImpar] = completo[i];
				
				numImpar++;
			}
			
		}
		
		System.out.print("\nVetor completo: [");
		
		for (int i = 0; i < completo.length ; i++) {
			
			System.out.print(completo[i]);
			
			if (i < completo.length - 1) {
				
				System.out.print(", ");
			} else {
				
				System.out.print("]");
			}
			
		}
		
		System.out.print("\n\nVetor par: [");
		
		for (int i = 0; i < par.length ; i++) {
			
			System.out.print(par[i]);
			
			if (i < par.length - 1) {
				
				System.out.print(", ");
			} else {
				
				System.out.print("]");
			}
			
		}
		
		System.out.print("\n\nVetor impar: [");
		
		for (int i = 0; i < impar.length ; i++) {
			
			System.out.print(impar[i]);
			
			if (i < impar.length - 1) {
				
				System.out.print(", ");
			} else {
				
				System.out.print("]");
			}
			
		}
		
		entrada.close();

	}

}
