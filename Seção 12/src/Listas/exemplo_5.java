package Listas;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.Collections;

public class exemplo_5 {

	public static void main(String[] args) {

		ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(23, 1, 44, 7, 13));
		
		ArrayList<String>frutas = new ArrayList<>(Arrays.asList(
				"banana",
				"maçã",
				"cereja",
				"banana",
				"maçã",
				"damasco"
		));
		
		System.out.println("===== Lista original de números =====");
		
		System.out.println(numeros);
		
		Collections.sort(numeros);
		
		System.out.println("\nNúmeros ordenados (crescente): " + numeros);
		
		System.out.println("===== Lista original de frutas =====");
		
		System.out.println(frutas);
		
		Collections.sort(frutas);
		
		System.out.println("\nFrutas ordenadas (ordem alfabética): " + frutas);
		
		Collections.sort(numeros, Collections.reverseOrder());
		
		System.out.println("\nNúmeros ordenados (decrescente): " + numeros);
		
		System.out.println("\n===== Invertendo a ordem =====");
		
		Collections.reverse(numeros);
		
		System.out.println("Números após o reverse(): " + numeros);
		
		Collections.reverse(frutas);
		
		System.out.println("Frutas após o reverse(): " + frutas);
		
		System.out.println("\n===== Contando ocorrências =====");
		
		int ocorrenciasBanana = 0;
		
		for (String fruta : frutas) {
			
			if (fruta.equals("banana")) {
				
				ocorrenciasBanana++;
				
			}
			
		}
		
		System.out.println("Ocorrências de 'banana': " + ocorrenciasBanana);
		
		int ocorrenciasNumero6 = 0;
		
		for (int num : numeros) {
			
			if (num == 6) {
				
				ocorrenciasNumero6++;
				
			}
			
		}
		
		System.out.println("Ocorrências do número 5: " + ocorrenciasNumero6);
		
		System.out.println("\n===== Buscando índices =====");
		
		int indiceBanana = frutas.indexOf("banana");
		
		if (indiceBanana != -1) {
			
			System.out.println("Índice da primeira 'banana': " + indiceBanana);
			
		} else {
			
			System.out.println("'banana' não está na lista");
			
		}
		
		int indice23 = numeros.indexOf(23);
		
		if (indice23 != -1) {
			
			System.out.println("Índice do primeiro 23': " + indice23);
			
		} else {
			
			System.out.println("23 não está na lista");
			
		}
		
		System.out.println("\n===== Fim da demonstração dos métodos de lista =====");

	}

}
