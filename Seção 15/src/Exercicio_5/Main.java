package Exercicio_5;

import java.util.Scanner;

/*
 * O objetivo deste código é implementar um jogo de pedra, papel e tesoura aplicando conceitos de Programação Orientada
 * a Objetos (POO), uso de enum, estruturas de decisão e interação com o usuário.
 * 
 * Descrição do jogo:
 * O jogo pedra, papel ou tesoura é um jogo muito conhecido no mundo, onde consiste fazer uma decisão e existe regras de vit´ria:
 * - Pedra ganha de tesoura;
 * - Tesoura ganha de papel;
 * - Papel ganha de pedra;
 * - Duas escolhas iguais é empate e jogam-se novamente.
 * 
 * */

public class Main {

	public static void main(String[] args) {


		try (Scanner entrada = new Scanner(System.in)) {
			
			Jogo jogo = new Jogo(entrada);
			
			jogo.jogar();
		}

	}

}
