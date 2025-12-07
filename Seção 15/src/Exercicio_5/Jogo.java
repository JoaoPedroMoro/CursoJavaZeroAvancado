package Exercicio_5;

import java.util.Random;
import java.util.Scanner;

public class Jogo {

    public enum Escolha {
        PEDRA(1, "Pedra"),
        PAPEL(2, "Papel"),
        TESOURA(3, "Tesoura");

        private final int codigo;
        private final String rotulo;

        Escolha(int codigo, String rotulo) {
        	
            this.codigo = codigo;
            
            this.rotulo = rotulo;
            
        }

        public String getRotulo() {
        	
            return rotulo;
            
        }

        public static Escolha fromCodigo(int codigo) {
        	
            for (Escolha e : values()) {
            	
                if (e.codigo == codigo) {
                	
                    return e;
                    
                }
                
            }
            
            return null;
            
        }
    } 
    
    private int pontuacaoJogador = 0;
    
    private int pontuacaoComputador = 0;
    
    private final Random random = new Random();
    
    private final Scanner scanner;

    public Jogo(Scanner scanner) {
    	
        this.scanner = scanner;
        
    }

    private Escolha obterEscolhaJogador() {
    	
        while (true) {
        	
            System.out.println("\nEscolha sua opção: ");
            
            System.out.println("1. Pedra");
            
            System.out.println("2. Papel");
            
            System.out.println("3. Tesoura");
            
            System.out.print("Digite (1 a 3): ");

            String linha = scanner.nextLine().trim();

            try {
            	
                int codigo = Integer.parseInt(linha);
                
                Escolha escolha = Escolha.fromCodigo(codigo);
                
                if (escolha != null) {
                	
                    return escolha;
                    
                }
                
                System.out.println("Opção inválida. Tente novamente.");
                
            } catch (NumberFormatException e) {
            	
                System.out.println("Entrada inválida. Digite um número entre 1 e 3.");
                
            }
            
        }
        
    }

    private Escolha obterEscolhaComputador() {
    	
        int codigo = 1 + random.nextInt(3);
        
        return Escolha.fromCodigo(codigo);
        
    }

    private void determinarVencedor(Escolha jogador, Escolha computador) {
    	
        System.out.println("Você escolheu: " + jogador.getRotulo());
        
        System.out.println("Computador escolheu: " + computador.getRotulo());

        if (jogador == computador) {
        	
            System.out.println("Resultado: Empate!");
            
            System.out.println("--------------------------------------");
            
            return; 
        }

        if (vence(jogador, computador)) {
        	
            String motivo = motivoVitoria(jogador, computador);
            
            System.out.println("Você venceu esta rodada porque "
                    + jogador.getRotulo() + " " + motivo + " " + computador.getRotulo() + "!");
            
            pontuacaoJogador++;
            
        } else {
        	
            String motivo = motivoVitoria(computador, jogador);
            
            System.out.println("Você perdeu esta rodada porque "
                    + computador.getRotulo() + " " + motivo + " " + jogador.getRotulo() + "!");
            
            pontuacaoComputador++;
            
        }

        System.out.println("Placar após esta rodada: Você " + pontuacaoJogador + " vs " + pontuacaoComputador + " Computador");
        
        System.out.println("--------------------------------------");
        
    }

    private boolean vence(Escolha a, Escolha b) {
    	
        switch (a) {
        
            case PEDRA:
            	
                return (b == Escolha.TESOURA);
                
            case PAPEL:
            	
                return (b == Escolha.PEDRA);
                
            case TESOURA:
            	
                return (b == Escolha.PAPEL);
                
            default:
            	
                return false;
                
        }
        
    }

    private String motivoVitoria(Escolha vencedor, Escolha perdedor) {
       
        if (vencedor == Escolha.PEDRA && perdedor == Escolha.TESOURA) {
        	
            return "vence";
            
        }
        
        if (vencedor == Escolha.PAPEL && perdedor == Escolha.PEDRA) {
        	
            return "vence";
        }
        
        if (vencedor == Escolha.TESOURA && perdedor == Escolha.PAPEL) {
        	
            return "vence";
            
        }
        
        return "vence"; 
        
    }

    private int lerQuantidadeRodadas() {
    	
        while (true) {
        	
            System.out.print("\nQuantas rodadas você quer jogar? ");
            
            String linha = scanner.nextLine().trim();
            
            try {
            	
                int n = Integer.parseInt(linha);
                
                if (n > 0) return n;
                
                System.out.println("Informe um número inteiro positivo");
                
            } catch (NumberFormatException e) {
            	
                System.out.println("Entrada inválida. Digite um número inteiro.");
                
            }
        }
    }

    public void jogar() {
    	
        System.out.println("Bem-vindo ao jogo Pedra, Papel e Tesoura!");
        
        int rodadas = lerQuantidadeRodadas();

        for (int i = 1; i <= rodadas; i++) {
        	
            System.out.println("\n=== RODADA " + i + " de " + rodadas + " ===");
            
            Escolha escolhaJogador = obterEscolhaJogador();
            
            Escolha escolhaComputador = obterEscolhaComputador();
            
            determinarVencedor(escolhaJogador, escolhaComputador);
            
        }

        System.out.println("\nFim de jogo!");

        if (pontuacaoJogador > pontuacaoComputador) {
        	
            System.out.println("Você venceu o placar final! Você " + pontuacaoJogador + " vs " + pontuacaoComputador + " Computador");
            
        } else if (pontuacaoJogador < pontuacaoComputador) {
        	
            System.out.println("O computador venceu o placar final! Você " + pontuacaoJogador + " vs " + pontuacaoComputador + " Computador");
            
        } else {
        	
            System.out.println("Houve um empate no placar final! Você " + pontuacaoJogador + " vs " + pontuacaoComputador + " Computador");
            
        }
        
    }
    
}
