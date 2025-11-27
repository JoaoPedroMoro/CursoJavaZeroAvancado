package if_2;
/*
 * O objetivo do exercício é verificar se o número digitado pelo usuário é múltiplo de 3 e 5.
 * */

import java.util.Scanner;

public class Exercicio_5 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o número desejado: ");
		
		int numero = entrada.nextInt();
		
		if (numero % 3 == 0 && numero % 5 == 0) {
			
			System.out.println("O número digitado é múltiplo de 3 e 5.");
			
		} else if (numero % 3 == 0 || numero % 5 == 0) {
			
			if (numero % 3 == 0) {
				
				System.out.println("O número digitado é múltiplo apenas de 3.");
				
			} else {
				
				System.out.println("O número digitado é múltiplo apenas de 5.");
				
			}
			
		} else {
			
			System.out.println("O número digitado não é múltiplo nem de 3 e nem de 5");
		}
		
		entrada.close();

	}

}
