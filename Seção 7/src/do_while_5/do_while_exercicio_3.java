package do_while_5;

/*
 * O objetivo desse exercício é ler números inteiros até o usuário digitar 0.
 * */

import java.util.Scanner;

public class do_while_exercicio_3 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		int numero;
		
		do {
			
			System.out.println("Digite um número: ");
			
			numero= entrada.nextInt();
			
		} while (numero != 0);
		
		System.out.println("Número 0 digitado, fim do programa ...");
		
		entrada.close();

	}

}
