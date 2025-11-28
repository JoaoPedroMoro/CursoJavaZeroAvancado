package while_4;

/*
 * O objetivo desse exercício é ler números do usuário até que ele digitar 0.
 * Este padrão de repetição é conhecido como leitura com sentinela.
 * */

import java.util.Scanner;

public class while_exercicio_3 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite um número: ");
		
		int numero = entrada.nextInt();
		
		while (numero != 0) {
			
			System.out.println("O número escolhido foi: " + numero);
			
			System.out.println("Digite outro número: ");
			
			numero = entrada.nextInt();
			
		}
		
		System.out.println("Você escolheu 0. Fim do programa.");
		
		entrada.close();

	}

}
