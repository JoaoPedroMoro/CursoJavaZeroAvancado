package while_4;

/*
 * O objetivo desse exercício é ler entradas do usuário até ele digitar um número negativo.
 * */

import java.util.Scanner;

public class while_exercicio_4 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite um número: ");
		
		int numero = entrada.nextInt();
		
		while (numero >= 0) {
			
			System.out.println("O número escolhido foi: " + numero);
			
			System.out.println("Digite outro número: ");
			
			numero = entrada.nextInt();
			
		}
		
		System.out.println("Você escolheu um número negativo. Fim do programa.");
		
		entrada.close();

	}

}
