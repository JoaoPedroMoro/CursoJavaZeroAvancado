package desafios;

/*
 * Esse desafio é o exercício construa a palavra. O computador começa com uma letra válida que
 * pertence à uma das palavras no dicionario e o jogador deve ir construindo a palavra que ele acredita
 * ser informando as letrar ao programa. O jogo termina quando a palavra é finalizada ou o 
 * jogador comete um erro. Será avisado ao jogador cada passo que for acontecendo e ele pode
 * decidir se a palavra é válida ou não, sem a necessidade do programa decidir.
 * */

import java.util.*;

public class desafio_28 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        String[] dicionario = {
            "gato", "cachorro", "leao", "tigre", "elefante",
            "vermelho", "azul", "amarelo", "verde", "roxo",
            "pizza", "hamburguer", "chocolate", "arroz", "banana"
        };

        String palavra = dicionario[random.nextInt(dicionario.length)];

        StringBuilder resposta = new StringBuilder();

        resposta.append(palavra.charAt(0));

        System.out.println("===== JOGO DE CONSTRUIR A PALAVRA =====");
        System.out.println("O tema é: animais, cores ou comidas");
        System.out.println("Letra inicial: " + resposta);
        System.out.println("Digite '!' a qualquer momento para entregar a palavra.");

        boolean jogoAtivo = true;

        while (jogoAtivo) {

            System.out.println("\nPalavra atual: " + resposta);
            System.out.print("Digite a próxima letra ou '!': ");
            String entradaLetra = entrada.nextLine().toLowerCase();
            
            if (entradaLetra.equals("!")) {
                System.out.println("Você desistiu.");
                System.out.println("A palavra correta era: " + palavra);
                break;
            }

            if (entradaLetra.length() != 1) {
                System.out.println("Digite apenas uma letra.");
                continue;
            }

            resposta.append(entradaLetra);

            if (!palavra.startsWith(resposta.toString())) {
                System.out.println("Você errou! A palavra não é válida.");
                System.out.println("Palavra correta era: " + palavra);
                break;
            }

            if (resposta.toString().equals(palavra)) {
                System.out.println("Parabéns! Você completou a palavra: " + palavra);
                break;
            }

            System.out.println("Palavra sendo formada, continue...");
        }

        entrada.close();
        System.out.println("\nJogo encerrado.");
    }
}
