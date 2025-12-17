package desafios;

/*
 * O objetivo desse desafio é solicitar um endereço de um site para o usuario e verificar
 * se o endereço digitado é valido, começando com www., terminando com .com.br. Deve solicitar
 * ao usuário o endereço correto até que seja digitado um endereço válido.
 * */

import java.util.*;

public class desafio_19 {
	
	public static boolean enderecoValido(String endereco) {
		
		String primeiraCondicao = endereco.substring(0,4);
		
		String segundaCondicao = endereco.substring(endereco.length() - 7);
		
		if (primeiraCondicao.equals("www.")) {
			
			if (segundaCondicao.equals(".com.br") ) {
				
				return true;
				
			} else {
				
				return false;
				
			}
			
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		 
		Scanner entrada = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("Digite o endereço de um site: ");
			
			String endereco = entrada.nextLine();
			
			if (enderecoValido(endereco)) {
				
				System.out.println("O endereço '" + endereco + "' é um endereço válido. Encerrado o programa...");
				
				break;
				
			} else {
				
				System.out.println("O endereço digitado não é válido, tente novamente.");
				
				continue;
				
			}
			
		}
		
		entrada.close();
	}

}
