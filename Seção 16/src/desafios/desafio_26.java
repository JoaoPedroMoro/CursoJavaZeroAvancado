package desafios;

import java.util.*;

public class desafio_26 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		Random random = new Random();
		
		boolean jogo = true;
		
		System.out.println("===== JOGO DAS TRÊS PORTAS =====");
		
		while (jogo) {
			
			int vitoria = random.nextInt(3) + 1;
			int armadilha;
			int reinicio;
			
			do {
				
				armadilha = random.nextInt(3) + 1;
				
			} while (armadilha == vitoria);
			
			do { 
				
				reinicio = random.nextInt(3) + 1; 
				
			} while (reinicio == vitoria || reinicio == armadilha);
			
			System.out.println("Escolha uma porta (1, 2 ou 3): ");
			
			int porta = entrada.nextInt();
			
			System.out.println("\nPorta da vitória: " + vitoria + "\nPorta da armadilha: " + armadilha +
					"\nPorta do começo do jogo: " + reinicio + "\n");
			
			if (porta == vitoria) {
				
				System.out.println("Você escolheu a porta da vitória! Encerrando o jogo ...");
				
				jogo = true;
				
			} else if (porta == armadilha) {
				
				System.out.println("Ops, você caiu em uma armadilha e morreu. Encerrando o jogo ...");
				
				jogo = true;
				
			} else if (porta == reinicio) {
				
				System.out.println("Você escolheu a porta que volta ao início do jogo, tente novamente.");
			} else {
				
				System.out.println("Você escolheu uma porta inválida, tente novamente.");
				
			}
			
		}
		
		entrada.close();

	}

}
