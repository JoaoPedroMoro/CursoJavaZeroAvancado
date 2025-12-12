package Listas;

/*
 * O objetivo desse exercício é criar um programa que tem uma lista fixa de números e mostrar a soma
 * de todos esses números
 * */

import java.util.ArrayList;
import java.util.Arrays;

public class exercicio_2 {

	public static void main(String[] args) {
		
		ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40, 45, 50));
		
		int somaTotal = 0;
		
		for (int num : numeros) {
			
			somaTotal += num;
			
		}
		
		System.out.println("A soma total da lista " + numeros + " é: " + somaTotal);
		
	}

}
