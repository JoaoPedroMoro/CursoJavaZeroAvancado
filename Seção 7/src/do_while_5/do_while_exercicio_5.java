package do_while_5;

/*
 * O objetivo desse exercício é calcular a média dos números passados pelo usuário até ele digitar -1
 * */

import java.util.Scanner;

public class do_while_exercicio_5 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		double total = 0;
		
		int qtde = 0;
		
		double numero;
		
		do {
			
			System.out.println("Digite um número: ");
			
			numero = entrada.nextDouble();
			
			if (numero != -1) {
				
				total = total + numero;
						
				qtde++;
				
			}
			
		} while (numero != -1);
		
		System.out.println("Você digitou -1, encerrando o programa.");
		
		System.out.println("Resultado: " + (total/qtde));
		
		entrada.close();

	}

}
