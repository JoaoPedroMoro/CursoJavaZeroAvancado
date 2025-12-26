package desafios;

/*
 * Exercício: Calculadora de Tabuada Interativa
 *
 * O jogador escolhe um número e responde perguntas de multiplicação
 * de 1 a 10. No final, recebe uma pontuação baseada nos acertos.
 */

import java.util.Scanner;

public class desafio_30 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int numero;
        int respostaUsuario;
        int pontuacao = 0;

        System.out.println("=== CALCULADORA DE TABUADA INTERATIVA ===");

        System.out.print("Escolha um número para gerar a tabuada: ");
        numero = entrada.nextInt();

        System.out.println("\nResponda às multiplicações:");

        for (int i = 1; i <= 10; i++) {

            System.out.print(numero + " x " + i + " = ");
            respostaUsuario = entrada.nextInt();

            if (respostaUsuario == numero * i) {
                System.out.println("Correto!");
                pontuacao++;
            } else {
                System.out.println("Errado! Resposta correta: " + (numero * i));
            }
        }

        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Você acertou " + pontuacao + " de 10 perguntas.");

        entrada.close();
    }
}
