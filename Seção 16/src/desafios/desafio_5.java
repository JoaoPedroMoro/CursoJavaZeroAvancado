package desafios;

/*
 * O objetivo desse desafio é criar um programa que leia um vetor de 10 números informados pelo
 * usuário e depois mostre esse vetor na ordem inversa.
 * 
 * */

import java.util.Scanner;
import java.util.InputMismatchException;

public class desafio_5 {
	
	public static void vetorInverso(double[] vetor) {
		
		double[] inverso = new double[10];
		
		int temp = 0;
		
		for (int i = vetor.length - 1 ; i>= 0 ; i--) {
			
			inverso[temp] = vetor[i];
			
			temp++;
			
		}
		
		System.out.println("\nVetor original: ");
			
		for (int i = 0; i < vetor.length ; i++) {
			
			System.out.println(vetor[i]);
			
		}
		
		System.out.println("\nVetor inverso: ");
		
		for (int i = 0; i < inverso.length ; i++) {
			
			System.out.println(inverso[i]);
			
		}
		
		
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		double[] vetor = new double[10];
		
		
		for (int i=0; i<10 ;) {
			
			try {
				
				System.out.println("Digite o " + (i+1) + "º número para o vetor: ");
				
				double numero = entrada.nextDouble();
				
				vetor[i] = numero;
				
				i++;
				
				
			} catch (InputMismatchException e) {
				
				entrada.nextLine();
				
				System.out.println("Formato inválido, digite um número.");
				
			}
			
		}
		
		vetorInverso(vetor);
		
		entrada.close();

	}

}
