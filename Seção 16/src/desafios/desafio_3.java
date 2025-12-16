package desafios;

import java.util.InputMismatchException;

/*
 * O programa solicita um número de 0 a 10 para o usuário, e após a inserção exibir na tela a nota. Caso não esteja
 * dentro desse intervalo ou não for um número, o programa deve solicitar ao usuário até ser válido.
 * */

import java.util.Scanner;

public class desafio_3 {
	
	public static String notaValida(int nota) {
		
		if (nota >= 0 && nota <= 10) {
			
			return "Você inseriu a nota " + nota  + ".";
			
		} else {
			
			return "Você não inseriu uma nota válida, tente novamente";
			
		}
		
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a nota: ");
		
		try {
			
			int numero = entrada.nextInt();
			
			System.out.println(notaValida(numero));
			
		} catch (InputMismatchException e ) {
			
			System.out.println("Você não inseriu um número, tente novamente.");
			
		}
		
		System.out.println(notaValida(7));
		
		System.out.println(notaValida(11));
		
		System.out.println(notaValida(4));
		
		System.out.println(notaValida(-1));
		
		System.out.println(notaValida(0));
		
		entrada.close();

	}

}
