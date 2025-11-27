package if_2;
/*
 * O objetivo desse exercício é verificar se uma letra é vogal ou consoante.
 * */

import java.util.Scanner;

public class Exercicio_9 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a letra escolhida: ");
		
		char letra = entrada.next().toLowerCase().charAt(0);
		
		if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
			
			System.out.println("A letra digitada foi uma vogal!");
			
		} else {
			
			System.out.println("A letra digitada foi uma consoante!");
			
		}
		
		entrada.close();

	}

}
