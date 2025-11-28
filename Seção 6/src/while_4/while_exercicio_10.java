package while_4;

/*
 * O exercício desse programa consiste em solicitar dois números inteiros ao usuário e verificar se são iguais ou diferente.
 * Mostrar essa comparação e caso for diferentes, mostrar todos os números que estão entre eles.
 * */

import java.util.Scanner;

public class while_exercicio_10 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o primeiro número: ");
		
		int numero1 = entrada.nextInt();
		
		System.out.println("Digite o segundo número: ");
		
		int numero2 = entrada.nextInt();
		
		
		boolean condicao = false;
		
		while (condicao != true) {
			
			if (numero1 == numero2) {
				
				System.out.println("Você inseriu dois números iguais!");
				
				condicao = true;
				
				break; 
				
			} else {
			
				System.out.println("Você inseriu dois números diferentes. A seguir está a lista dos números entre esses dois números: ");
				
				int maior = Math.max(numero1, numero2);
				
				int menor = Math.min(numero1, numero2);
				
				while (menor < maior - 1) {
					
					menor++;
					
					System.out.println(menor);
					
				}
				
				condicao = true;
				
				break;
				
			}

			
		}
		
		entrada.close();

	}

}
