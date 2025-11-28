package while_4;

/*
 * O exercício desse programa consiste em calcular o fatorial do número passado pelo usuário usando o while.
 * */

import java.util.Scanner;

public class while_exercicio_9 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o número do qual você quer calcular o fatorial: ");
		
		int fatorial = 1;
		
		int numero = entrada.nextInt();
		
		int i = numero;
		
		while (i >= 1) {
			
			fatorial = fatorial * i;
			
			i--;
			
		}
		
		System.out.println("O fatorial do número " + numero + " é " + fatorial);
		
		entrada.close();

	}

}
