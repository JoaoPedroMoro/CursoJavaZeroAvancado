package switch_3;

/*
 * O objetivo deste exercício é criar um programa que solicita ao usuário uma letra do alfabeto e deve
 * identificar se a letra é uma vogal ou uma consoante.
 * */

import java.util.Scanner;

public class switch_exercicio_3 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite uma letra do alfabeto: ");
		
		char letra = entrada.next().toLowerCase().charAt(0);
		
		switch (letra) {
		
			case 'a':
				
				System.out.println("Você escolheu uma vogal, a letra a.");
				
				break;
				
			case 'e':
				
				System.out.println("Você escolheu uma vogal, a letra e.");
				
				break;
				
			case 'i':
				
				System.out.println("Você escolheu uma vogal, a letra i.");
				
				break;
				
			case 'o':
				
				System.out.println("Você escolheu uma vogal, a letra o.");
				
				break;
				
			case 'u':
				
				System.out.println("Você escolheu uma vogal, a letra u.");
				
				break;
				
			default:
				
				if (!Character.isLetter(letra)) {
					
					System.out.println("Você não digitou uma letra e sim um outro caractere, tente novamente.");
					
					break;
					
				}
				
				System.out.println("Você escolheu uma consoante, a letra " + letra + ".");
				
				break;
				
		}
		
		entrada.close();

	}

}
