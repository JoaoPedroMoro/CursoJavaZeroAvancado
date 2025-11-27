package if_2;

/*
 * O objetivo desse exercício é classificar um número como positivo, negativo ou 0.
 * */

import java.util.Scanner;

public class Exercicio_6 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o número inteiro desejado: ");
		
		int numero = entrada.nextInt();
		
		if (numero > 0) {
			
			System.out.println("O número informado é maior que 0.");
			
		} else if (numero < 0) {
			
			System.out.println("O número informado é menor que 0.");
			
		} else {
			
			System.out.println("O número informado é 0.");
		}
		
		entrada.close();

	}

}
