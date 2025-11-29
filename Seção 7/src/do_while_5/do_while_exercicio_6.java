package do_while_5;

/*
 * O objetivo desse exercício é contar quantos números inteiros positivos foram digitados até o usuário digitar 0.
 * */

import java.util.Scanner;

public class do_while_exercicio_6 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int numero;
		
		int qtde = 0;
		
		do {
			
			System.out.println("Digite um número: ");
			
			numero = entrada.nextInt();
			
			if (numero > 0) {
				
				qtde++;
				
			}
			
		} while (numero != 0);
		
		System.out.println("Você digitou 0, encerrando o programa. Você digitou um total de " + qtde + " números positivos.");
		
		entrada.close();

	}

}
