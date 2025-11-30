package Revisao;

/*
 * Aprofundando as funções de repetição com break e continue.
 * */

public class exemplo_1 {

	public static void main(String[] args) {

		System.out.println("\n1. Laço for com break e continue\n");

		
		for (int i = 1 ; i <= 10 ; i++) {
			
			if (i == 5) {
				
				System.out.println("Pulando o número 5 com continue.");
				
				continue;
				
			}
			
			if (i == 8) {
				
				System.out.println("Número 8 encontrado, parando a repetição com break.");
				
				break;
				
			}
			
			System.out.println("Número: " + i);
			
		}
		
		
		System.out.println("\n2. Laço while com break e continue");
		
		int contador = 0;
		
		while (contador < 10) {
			
			contador++;
			
			if (contador % 2 == 0) {
				
				System.out.println("Pulando número par continue.");
				
				continue;
				
			}
			
			if (contador == 7) {
				
				System.out.println("Número 7 encontrado, parando a repetição com break.");
				
				break;
				
			}
			
			System.out.println("Número ímpar: " + contador);
			
		}
		
		System.out.println("\n3. Laço do-while com break e continue");
		
		int numero = 0;
		
		do {
			
			numero++;
			
			if (numero == 3) {
				
				System.out.println("Pulando número 3 com continue.");
				
				continue;
				
			}
			
			if (numero == 6) {
				
				System.out.println("Número 6 encontrado, parando a repetição com break.");
				
				break;
				
			}
			
			System.out.println("Número: " + numero);
			
		} while (numero < 10);

	}

}
