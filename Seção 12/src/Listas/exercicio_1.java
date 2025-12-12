package Listas;

/*
 * O objetivo desse exercício é cadastrar nomes informados pelo usuário até o usuário digitar "sair", e após
 * isso, mostrar todos os nomes digitados
 * */

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;

public class exercicio_1 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		ArrayList<String> listaNomes = new ArrayList<>();
		
		System.out.println("=== PROGRAMA DE INSERÇÃO DE NOMES ===");
		
		String nome;
		
		do {
			
			System.out.println("Digite o nome que deseja adicionar (para encerrar digite 'sair'): ");
			
			nome = entrada.nextLine();
			
			if (!nome.equals("sair")) {
				
				listaNomes.add(nome);
				
				System.out.println("O nome " + nome + " foi adicionado com sucesso na lista.");
				
			} else {
				
				System.out.println("Saindo da inserção de nomes ...");
				
			}
			
		} while (!nome.equals("sair"));
		
		if (!listaNomes.isEmpty()) {
		
			System.out.println("\nNomes adicionados pelo usuário: ");
			
			for (int i = 0; i < listaNomes.size() ;i++) {
				
				System.out.println((i + 1) + ". " + listaNomes.get(i));
			}
		
		} else {
			
			System.out.println("Não foram adicionados nenhum nome na lista, ela está vazia.");
			
		}
		
		entrada.close();

	}

}
