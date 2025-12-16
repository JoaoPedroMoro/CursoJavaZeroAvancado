package desafios;

/*
 * O objetivo desse programa é receber uma sequencia de nomes digitados pelo usuário, em apenas
 * uma linha. Vai separar esses nomes usando o espaço como delimitador, ordenar os nomes em ordem
 * alfabética e exibir esses nomes em uma unica linha, separados por espaços
 * */

import java.util.Scanner;
import java.util.Arrays;

public class desafio_14 {
	
	public static void separadorNomes (String nomes) {
		
		String[] listaNomes = nomes.split(" ");
		
		Arrays.sort(listaNomes);
		
		System.out.println("\nA lista de homes em ordem alfabética é: ");
		
		for (int i = 0 ; i < listaNomes.length ; i++) {
			
			System.out.print(listaNomes[i]);
			
			if ( i < listaNomes.length - 1) {
				
				System.out.print(" ");
				
			}
			
		}
		
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		try {
			
			System.out.println("Digite a string de nomes em uma linha única: ");
			
			String nomes = entrada.nextLine();
			
			separadorNomes(nomes);
			
		} catch (Exception e) {
			
			System.out.println("Algo deu errado, tente novamente.");
			
		}
		
		entrada.close();

	}

}
