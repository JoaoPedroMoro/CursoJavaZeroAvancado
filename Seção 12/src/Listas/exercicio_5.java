package Listas;
/*
 * O objetivo desse exercício é solicitar que o usuário digite 5 nomes e depois
 * gerar uma nova lista sem repetições, contendo apenas nomes únicos, após isso deve mostrar
 * no console os nomes da nova lista sem repetições.
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class exercicio_5 {

	public static void main(String[] args) {
			
		Scanner entrada = new Scanner(System.in);
		
		ArrayList<String> nomes = new ArrayList<>();
		
		String nome;
		
		for (int i=0; i<5; i++) {
			
			System.out.println("Digite o " + (i+1) + "º nome da lista: ");
			
			nome = entrada.nextLine();
			
			nomes.add(nome);
			
		}
		
		ArrayList<String> nomesUnicos = new ArrayList<>();
		
		for (String n : nomes) {
			
			if (!nomesUnicos.contains(n)) {
				
				nomesUnicos.add(n);
				
			} 
			
		}
		
		System.out.println("\nLista original: " + nomes);
		
		System.out.println("\nLista com nomes únicos: " + nomesUnicos);
		
		entrada.close();
		
	}

}
