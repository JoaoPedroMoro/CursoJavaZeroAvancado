package desafios;

/*
 * Verificação se a letra informada pelo usuário é uma consoante ou uma vogal. Caso não seja uma letra, vai informar.
 * */

import java.util.Scanner;

public class desafio_1 {
	
	public static String verificarLetra(String entrada) {
		
		String[] vogais = {"a", "A", "b", "B", "c", "C", "d", "D", "e", "E"};
		
		if (entrada.length() == 1) {
			
			char letra = entrada.charAt(0);
			
			if (Character.isLetter(letra)) {
				
				for (String v : vogais) {
					
					if (v.charAt(0) == letra) {
						
						return "A letra " + letra + " é uma vogal.";
					
					}
					
				}
				
				return "A letra " + letra + " é uma consoante.";
				
				
			} else {
				
				return "Entrada inválida, você não informou uma letra. Tente novamente.";
			}
			
			
		} else {
			
			return "Você passou uma entrada com mais de 1 caractere, tente novamente!";
		}
		
		
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe a letra: ");
		
		String letra = entrada.nextLine();
		
		String resultado = verificarLetra(letra);
		
		System.out.println(resultado);
		
		resultado = verificarLetra("A");
		
		System.out.println(resultado);
		
		resultado = verificarLetra("c");
		
		System.out.println(resultado);
		
		resultado = verificarLetra("y");
		
		System.out.println(resultado);
		
		resultado = verificarLetra("X");
		
		System.out.println(resultado);
		
		resultado = verificarLetra("Abc");
		
		System.out.println(resultado);
		
		resultado = verificarLetra("7");
		
		System.out.println(resultado);
		
		entrada.close();
		
	}

}
