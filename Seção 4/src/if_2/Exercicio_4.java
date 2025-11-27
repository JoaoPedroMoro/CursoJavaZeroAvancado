package if_2;

/*
 * O objetivo desse exercício é verificar se o número inserido pelo usuário está
 * dentro do intervalo fechado de 10 a 100.
 * */

import java.util.Scanner;

public class Exercicio_4 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o número desejado: ");
		
		int numero = entrada.nextInt();
		
		if (numero >= 10 && numero <= 100) {
			
			System.out.println("O número inserido está dentro do intervalo fechado de 10 a 100.");
		} else if (numero >= 10 || numero <= 100) {
			if (numero >= 10) {
				
				System.out.println("O número que você forneceu é maior que 100.");
				
			} else {
				
				System.out.println("O número que você forneceu é menor que 10.");
				
			}
		}
		
		entrada.close();
		

	}

}
