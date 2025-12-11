package Exercicio_2;

/* Exercício: Formatador de Frases em Java
*
* Objetivo:
* 
* Neste exercício, você será desafiado a criar uma aplicação Java 
* 			que ajuda os usuários a formatar frases de diversas maneiras. 
* A aplicação deve oferecer opções para converter toda a 
* 			frase para maiúsculas ou minúsculas, capitalizar a 
* 			primeira letra, transformá-la em um título, contar 
* 			vogais e consoantes, e mais.
* 
* Requisitos:
* 
*   Crie uma classe chamada FormatadorDeFrase que será responsável por 
*     		todas as operações de formatação.
* 
*     1. A classe deve possuir os seguintes métodos:
*     
*         para_maiusculas(): converte toda a frase para maiúsculas.
*         para_minusculas(): converte toda a frase para minúsculas.
*         capitalizar(): capitaliza a primeira letra da frase.
*         formato_titulo(): converte a primeira letra de cada 
*         			palavra da frase para maiúscula.
*         contar_vogais(): conta e retorna o número de vogais na frase.
*         contar_consoantes(): conta e retorna o número de consoantes na frase.
*         contar_letra_a(): conta e retorna o número de ocorrências da letra 'a' na frase.
*         procurar_palavra(palavra): conta e retorna o número de 
*         			ocorrências de uma palavra específica na frase.
*         obter_frase(): retorna a frase atual.
* 
*     2. Implemente uma função menu que serve como interface do usuário. Essa 
*     			função deve mostrar um menu com as opções de 
*     			formatação e realizar a operação escolhida pelo usuário.
* 
*     3. O programa deve continuar rodando e mostrando o 
*     		menu até que o usuário escolha sair.
* 
* Detalhes:
* 
*     O programa deve ser case-insensitive para contagem e 
*     		pesquisa de palavras.
*     Você pode assumir que o usuário entrará apenas com 
*     		caracteres alfabéticos e espaços. 
* */

import java.util.Scanner;

public class Main {
	
	private static void mostrarMenu() {
		
	     System.out.println("\nEscolha uma opção:");

	     System.out.println("1. Converter para MAIÚSCULAS");
	     System.out.println("2. Converter para minúsculas");
	     System.out.println("3. Capitalizar a primeira letra da frase");
	     System.out.println("4. Formato Título (primeira letra de cada palavra maiúscula)");
	     System.out.println("5. Contar vogais");
	     System.out.println("6. Contar consoantes");
	     System.out.println("7. Contar letra 'a'");
	     System.out.println("8. Pesquisar palavra (contar ocorrências)");
	     System.out.println("9. Mostrar frase atual");
	     System.out.println("10. Sair");

	     System.out.print("Digite sua opção: ");
	     
	}

	public static void main(String[] args) {
		
	    Scanner sc = new Scanner(System.in);


	    System.out.println("\nBem-vindo ao Formatador de Frases (Java)!");

	    System.out.print("Por favor, digite uma frase: ");
	    
	    String fraseInicial = sc.nextLine();

	    FormatadorFrases formatador = new FormatadorFrases(fraseInicial);

	    while (true) {

	        mostrarMenu();

	        // O trim() remove espaços à esquerda e à direita,
	        String escolha = sc.nextLine().trim();

	        switch (escolha) {

			    case "1" -> {
		
			         formatador.upperCase();
		
			         System.out.println("Frase atual: " + formatador.obterFrase());
			         
			    }

			    case "2" -> {

			         formatador.lowerCase();
			         System.out.println("Frase atual: " + formatador.obterFrase());
			         
			    }


				case "3" -> {
	
				     formatador.capitalizar();
				     System.out.println("Frase atual: " + formatador.obterFrase());
				
				}

				case "4" -> {
	
				     formatador.formatoTitulo();
				     System.out.println("Frase atual: " + formatador.obterFrase());
				
				}

				case "5" -> {

				    int total = formatador.contarVogais();
				    System.out.println("Total de vogais: " + total);
				    
				}

				case "6" -> {
				    int total = formatador.contarConsoantes();
				    System.out.println("Total de consoantes: " + total);
				    
				}

				case "7" -> {

				    int total = formatador.contarLetraA();
				    System.out.println("Total de ocorrências da letra 'a': " + total);
				    
				}

				case "8" -> {

				    System.out.print("Digite a palavra a pesquisar: ");

				    String palavra = sc.nextLine();

				    int total = formatador.procurarPalavra(palavra);

				    if (total > 0) {
				    	
				        System.out.println("A palavra \"" + palavra + "\" aparece " + total + " vez(es).");

				    } else {
				    	
				        System.out.println("A palavra \"" + palavra + "\" não foi encontrada.");
				        
				    }
				    
				}

	            case "9" -> {
	            	
	                System.out.println("Frase atual: " + formatador.obterFrase());
	                
	            }

	            case "10" -> {
	  
	                System.out.println("Saindo... Até mais!");

	                sc.close();
	                
	                return;
	                
	            }

	            default -> 
	            
	                System.out.println("Opção inválida. Tente novamente.");
	                
	        }
	    }

	}

}
