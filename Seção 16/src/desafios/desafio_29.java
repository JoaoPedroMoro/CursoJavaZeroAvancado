package desafios;

/*
29. Exercício: "Criptografia de Substituição"

Descrição: Neste exercício, o jogador deve decifrar uma mensagem criptografada 
        usando uma substituição de letras. O programa gera uma mensagem oculta, 
        onde cada letra foi substituída por outra letra. 
        
O jogador deve tentar adivinhar qual é a substituição correta, letra por letra, 
        para revelar a mensagem original. A cada tentativa, o programa revela as 
        letras corretas ou informa se o jogador errou.

Regras:

- O jogador recebe uma mensagem criptografada com substituição de 
        letras (exemplo: 'A' foi substituído por 'X', 'B' por 'Y', etc.).
- O jogador deve tentar adivinhar a correspondência entre as letras.
- O programa verifica a resposta e atualiza a mensagem com as 
        letras corretas a cada tentativa.
- O jogo termina quando a mensagem inteira for decifrada.
*/

import java.util.*;

public class desafio_29 {

	public static Map<Character, Character> gerarCriptografia() {
	    
	    List<Character> letras = new ArrayList<>();

	    for (char c = 'a'; c <= 'z'; c++) {
	        letras.add(c); 
	    }

	    Collections.shuffle(letras);

	    Map<Character, Character> substituicao = new HashMap<>();

	    int i = 0;

	    for (char c = 'a'; c <= 'z'; c++) {

	    	substituicao.put(c, letras.get(i));  
	       
	        i++; 
	        
	    }

	    return substituicao;
	    
	}

	public static String criptografarMensagem(String mensagem, Map<Character, Character> substituicao) {

	    StringBuilder mensagemCriptografada = new StringBuilder();

	    for (char c : mensagem.toCharArray()) {

	        if (Character.isLetter(c)) {

	        	char letraMinuscula = Character.toLowerCase(c);

	            char substituto = substituicao.getOrDefault(letraMinuscula, letraMinuscula);

	            mensagemCriptografada.append(substituto);

	        } else {
	        	
	            mensagemCriptografada.append(c);
	            
	        }
	    }

	    return mensagemCriptografada.toString();
	    
	}

	public static String decifrarMensagem(String mensagemCriptografada, Map<Character, Character> mapaUsuario) {
	    
	    StringBuilder decifrada = new StringBuilder();

	    for (char c : mensagemCriptografada.toCharArray()) {
	        
	        if (Character.isLetter(c)) {
	            
	            char letraMinuscula = Character.toLowerCase(c);

	            char substituto = mapaUsuario.getOrDefault(letraMinuscula, '*');

	            if (Character.isUpperCase(c) && substituto != '*') {
	                substituto = Character.toUpperCase(substituto);
	            }

	            decifrada.append(substituto);

	        } else {
	        	
	            decifrada.append(c);
	            
	        }
	    }

	    return decifrada.toString();
	    
	}

	public static void jogoCriptografia() {

	    Scanner entrada = new Scanner(System.in);

	    String mensagemOriginal = "este e um teste";

	    Map<Character, Character> substituicao = gerarCriptografia();

	    String mensagemCriptografada = criptografarMensagem(mensagemOriginal, substituicao);

	    System.out.println("Mensagem criptografada: " + mensagemCriptografada);

	    Map<Character, Character> mapaUsuario = new HashMap<>();

	    String mensagemDecifrada = decifrarMensagem(mensagemCriptografada, mapaUsuario);

	    System.out.println("Mensagem decifrada até agora: " + mensagemDecifrada + "\n");

	    while (true) {
		     
			System.out.print("Digite a letra criptografada que você quer decifrar: ");

			String entradaCripto = entrada.nextLine().toLowerCase();

			if (entradaCripto.length() != 1 || !Character.isLetter(entradaCripto.charAt(0))) {
			    
			    System.out.println("Entrada inválida! Digite apenas uma letra.\n");
			    
			    continue;
			    
			}

			char letraCripto = entradaCripto.charAt(0);

			System.out.print("Qual é a letra original correspondente a '" + letraCripto + "'?: ");

			String entradaOriginal = entrada.nextLine().toLowerCase();


			if (entradaOriginal.length() != 1 || !Character.isLetter(entradaOriginal.charAt(0))) {
			    
			    System.out.println("Entrada inválida! Digite apenas uma letra.\n");
			    
			    continue;
			    
			}

			char letraOriginal = entradaOriginal.charAt(0);

			boolean palpiteCorreto = false;

			if (substituicao.containsKey(letraOriginal) && substituicao.get(letraOriginal) == letraCripto) {

				palpiteCorreto = true;
			    
			}


			if (palpiteCorreto) {
			    
			    mapaUsuario.put(letraCripto, letraOriginal);
			    
			    System.out.println("Boa! Você acertou a letra.\n");
			    
			} else {
			    
			    System.out.println("Palpite errado! Tente novamente.\n");
			    
			    continue;
			    
			}

			mensagemDecifrada = decifrarMensagem(mensagemCriptografada, mapaUsuario);

			System.out.println("Mensagem decifrada até agora: " + mensagemDecifrada + "\n");

			if (!mensagemDecifrada.contains("*")) {
			    
			    System.out.println("Parabéns! Você decifrou a mensagem completa!");
			    
			    break;
			    
			}

		}

	    entrada.close();
	    
	}

    public static void main(String[] args) {
    	
        jogoCriptografia();
        
    }
    
}