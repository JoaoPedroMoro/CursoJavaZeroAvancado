package Set;

/*
 * O objetivo desse exercicio é criar um programa que leia palavaras digitadas pelo usuário
 * até ele digitar "fim", armazenando essas palavras sem repetição usando um set.
 * Após o fim do programa, deve ser mostrado no terminal todas as palavras que foram digitadas,
 * sem duplicatas, quantas palavras unicas foram digitas, mostrar as palavras em ordem alfabética,
 * usando um TreeSet, e perguntar ao usuario uma palavra para buscar no conjunto.
 * 
 * Regras:
 * - Não pode usar List.
 * - O armazenamento deve ser com Set.
 * - Palavras repetidas não contam mais de uma vez.
 * - Ignorar diferenças de maiusculas e minusculas*/

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.TreeSet;

public class exercicio_1 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		Set<String> palavras = new HashSet<>();
		
		String palavra;
		
		int contador = 0;
		
		do {
			
			System.out.println("Digite a " + (contador+1) + "º palavra que você quer adicionar('fim' para sair): ");
			
			contador++;
			
			palavra = entrada.nextLine();
			
			if (palavra.equals("fim")) {
				
				System.out.println("Você digitou 'fim', saindo do programa ...");
				
			} else {
				
				if (palavras.add(palavra)) {
					
					System.out.println("Adicionando " + palavra + " ao conjunto.");
					
				} else {
					
					System.out.println("A palavra " + palavra + " já foi digitada antes.");
					
				}
				
			}
			
			
		} while (!palavra.equals("fim"));
		
		System.out.println("\n===== RESULTADO =====");
		
		System.out.println("Total de palavras digitadas: " + (contador-1));
		
		System.out.println("Palavras digitadas (sem duplicatas): " + palavras);
		
		System.out.println("Total de palavras únicas: " + palavras.size());
		
		Set<String> ordenadas = new TreeSet<>(palavras);
		
		System.out.println("Palavras em ordem alfabética: " + ordenadas);
		
		System.out.println("\nDigite uma palavra para pesquisar no conjunto: ");
		
		String busca = entrada.nextLine();
		
		if (palavras.contains(busca)) {
			
			System.out.println("A palavra '" + busca + "' está no conjunto.");
			
		} else {
			
			System.out.println("A palavra '" + busca + "' não está no conjunto.");
			
		}
		
		entrada.close();

	}

}
