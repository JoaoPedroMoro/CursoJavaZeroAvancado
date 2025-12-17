package desafios;

/*
 * O programa consiste em receber uma palavra ou frase digitada pelo usuário e 
 * contar quantas letras maiusculas e minusculas tem nessa frase.
 * */

import java.util.*;

public class desafio_18 {
	
	public static List<Integer> contador(String str) {
		 
		List<Integer> lista = new ArrayList<>();
		
		int qtdeMaius = 0;
		int qtdeMinus = 0;
		
		for (int i = 0;  i < str.length() ; i++) {
			
			char caractere = str.charAt(i);
			
			if (Character.isLetter(caractere)) {
				
				if (Character.isUpperCase(caractere)) {
					
					qtdeMaius++;
					
				} else {
					
					qtdeMinus++;
					
				}
				
			}
			
		}
		
		lista.add(qtdeMaius);
		
		lista.add(qtdeMinus);
		
		return lista;
	}
	

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o texto: ");
		
		String texto = entrada.nextLine();
		
		List<Integer> lista = contador(texto);
		
		System.out.println("A qtde de letras maiusculas é " + lista.get(0) + " e a qtde de minusculas é " + lista.get(1));
		
		entrada.close();
		
	}

}
