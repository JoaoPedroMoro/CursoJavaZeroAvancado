package switch_3;
/*
 * O exercício a seguir pede uma entrada do usuário de 1 a 7 e exibe o dia da semana correspondente,
 * onde 1 é domingo e 7 é sábado.*/

import java.util.Scanner;

public class switch_exercicio_1 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite um número de 1 a 7 que representa um dia da semana, onde 1 representa domingo, 2 representa segunda, ...");
		
		int num = entrada.nextInt();
		
		switch (num) {
		
			case 1:
				
				System.out.println("Você escolheu 1, que representa domingo.");
				
				break;
				
			case 2:
				
				System.out.println("Você escolheu 2, que representa segunda.");
				
				break;
				
			case 3:
				
				System.out.println("Você escolheu 3, que representa terça.");
				
				break;
				
			case 4:
				
				System.out.println("Você escolheu 4, que representa quarta.");
				
				break;
				
			case 5:
				
				System.out.println("Você escolheu 5, que representa quinta.");
				
				break;
				
			case 6:
				
				System.out.println("Você escolheu 6, que representa sexta.");
				
				break;
				
			case 7:
				
				System.out.println("Você escolheu 7, que representa sábado.");
				
				break;
			
			default:
			
				System.out.println("Você não escolheu uma opção válida.");
				
				break;
				
				
		}
		
		entrada.close();

	}

}
