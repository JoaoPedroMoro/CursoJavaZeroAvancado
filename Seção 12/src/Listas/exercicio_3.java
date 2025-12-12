package Listas;

/*
 * O objetivo desse programa é criar uma lista de 5 nomes já definidos e depois solicitar que o
 * usuário digite um nome e verificar se esse nome está na lista, informando o sucesso ou não.
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class exercicio_3 {

	public static void main(String[] args) {
			
		Scanner entrada =  new Scanner(System.in);
		
		ArrayList<String> listaNomes = new ArrayList<>(Arrays.asList("João", "Luiza", "Ricardo", "Beatriz", "Gabriel"));
		
		System.out.println("Digite o nome que você deseja buscar na lista: ");
		
		String nome = entrada.nextLine().trim();
		
		if (listaNomes.contains(nome)) {
			
			System.out.println("O nome " + nome + " foi encontrado na lista.");
			
			System.out.println("Lista de nomes: " + listaNomes);
			
		} else {
			
			System.out.println("O nome " + nome + " não foi encontrado na lista.");
			
			System.out.println("Lista de nomes: " + listaNomes);
			
		}
		
		entrada.close();

	}

}
