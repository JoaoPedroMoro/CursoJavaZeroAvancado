package for_6;

import java.util.Arrays;

import java.util.List;

import java.util.Scanner;

/*
 * Solicite ao usuário uma lista de palavras, separadas por vírgula e após ele terminar de inserir, mostrar apenas as palavras
 * que tem mais de 4 letras.
 * */

import java.util.Scanner;

public class for_exercicio_5 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite uma lista de palavras, cada uma separada por vírgula: ");
		
		String linhaDigitada = entrada.nextLine();
		
		List<String> palavras = Arrays.asList(linhaDigitada.split(","));
		
		for (String palavra : palavras) {
			
			palavra = palavra.trim(); // Remove possiveis espaços em branco
			
			if (palavra.length() > 4) {
				
				System.out.println(palavra);
				
			}
			
		}
		
		entrada.close();
		
	}

}
