package if_2;

/*
 * O objetivo desse exercício é verificar se um ano é bissexto.
 * */

import java.util.Scanner;

public class Exercicio_7 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o ano: ");
		
		int ano = entrada.nextInt();
		
		if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
			
			System.out.println("O ano informado de " + ano + " é um ano bissexto.");
			
		} else {
			
			System.out.println("O ano informado de " + ano + " não é um ano bissexto.");
			
		}
		
		entrada.close();

	}

}
