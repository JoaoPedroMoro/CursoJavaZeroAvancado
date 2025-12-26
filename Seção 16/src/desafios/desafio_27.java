package desafios;

/*
 * O objetivo desse programa é criar um quiz de matemática com desafios, fazendo perguntas
 * para o usuário sobre matemática. O programa trará uma série de perguntas aleatórias e o jogador 
 * terá que responder corretamente para continuar, aumentando a dificuldade e ganhando pontos gradativamente.
 * O jogo terminar quando o usuário erra uma pergunta ou decide parar.
 * */

import java.util.*;

public class desafio_27 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		Random aleatorio = new Random();
		
		int pontos = 0;
		
		int nivel = 1;
		
		boolean flag = true;
		
		System.out.println("Seja bem-vindo ao jogo matemático!");
		
		while (flag) {
			
			int n1, n2, resultado=0;
			
			String operacao;
			
			if (nivel == 1) {
				
				n1 = aleatorio.nextInt(10) + 1;
				
				n2 = aleatorio.nextInt(10) + 1;
				
				operacao = aleatorio.nextBoolean() ? "+" : "-";
				
				if (operacao.equals("+")) {
					
					resultado = n1 + n2;
					
				} else {
					
					resultado = n1 - n2;
					
				}
				
				System.out.printf("\nQual o resultado da operação %d %s %d :", n1, operacao, n2);
				
				int resposta = entrada.nextInt();
				
				if (resposta == resultado) {
					
					System.out.println("\nParabéns, você acertou. Avançando para o próximo nível ...");
					
					pontos += 1;
					
					if (pontos >= 5) {
						
						System.out.println("\nVocê já fez 5 pontos, indo para um nível mais avançado ... ");
						
						nivel += 1;
					}
					
				} else {
					
					System.out.println("\nOps, você errou, o resultado correto é " + resultado + ". Encerrando o jogo ...");
					
					flag = false;
					
					break;
				
				}
				
				System.out.println("\nVocê deseja continuar no jogo (s/n): ");
				
				entrada.nextLine();
				
				String escolha = entrada.nextLine();
				
				if (escolha.equals("n")) {
					
					System.out.println("\nVocê optou por sair do jogo, encerrando ...");
					
					flag = false;
					
					break;
					
				} else {
					
					System.out.println("\nVocê optou por continuar ...");
					
				}
				
			} else {
				
				n1 = aleatorio.nextInt(20) + 1;
				
				n2 = aleatorio.nextInt(10) + 1;
				
				operacao = aleatorio.nextBoolean() ? "*" : "/";
				
				if (operacao.equals("*")) {
					
					resultado = n1 * n2;
					
				} else {
					
					n1 = n1 * n2; // Para deixar uma divisão inteira
					
					resultado = n1 / n2;
				}
				
				System.out.printf("\nQual o resultado da operação %d %s %d :", n1, operacao, n2);
				
				int resposta = entrada.nextInt();
				
				if (resposta == resultado) {
					
					System.out.println("\nParabéns, você acertou. Avançando para o próximo nível ...");
					
					pontos += 1;
					
					nivel += 1;
					
				} else {
					
					System.out.println("\nOps, você errou, o resultado correto é " + resultado + ". Encerrando o jogo ...");
					
					flag = false;
					
					break;
					
				}
				
				System.out.println("\nVocê deseja continuar no jogo (s/n): ");
				
				entrada.nextLine();
				
				String escolha = entrada.nextLine();
				
				if (escolha.equals("n")) {
					
					System.out.println("\nVocê optou por sair do jogo, encerrando ...");
					
					flag = false;
					
					break;
					
				} else {
					
					System.out.println("\nVocê optou por continuar ...");
					
				}
				
			}
		}
		
		System.out.printf("\nFim de jogo! Você fez um total de %d pontos e chegou até o nível %d.", pontos, nivel);
		
		entrada.close();
		
	}

}
