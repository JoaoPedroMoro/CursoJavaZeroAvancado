package Exercicio_4;

import java.util.Scanner;

public class Main {
	
	private static void mostrarMenu() {
		
	     System.out.println("\n=========== MENU ===========");
	     System.out.println("1 - Adicionar elemento");
	     System.out.println("2 - Remover elemento");
	     System.out.println("3 - Encontrar maior elemento");
	     System.out.println("4 - Encontrar menor elemento");
	     System.out.println("5 - Calcular média");
	     System.out.println("6 - Mostrar lista");
	     System.out.println("7 - Sair");
	     System.out.print("Escolha uma opção: ");
	
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		ManipuladorDeLista manipulador = new ManipuladorDeLista();
		while (true) {
			
			mostrarMenu();
			
			String escolha = entrada.nextLine();
			
			switch (escolha ) {
			
			case "1" -> {
                try {
                    System.out.print("Digite um número inteiro para adicionar: ");
                    int elemento = Integer.parseInt(entrada.nextLine());
                    manipulador.adicionarElemento(elemento);
                } catch (NumberFormatException e) {
                    System.out.println("❌ Entrada inválida. Digite um número inteiro.");
                }
            }

	        case "2" -> {
	            try {
	                 System.out.print("Digite um número inteiro para remover: ");
	                 int elemento = Integer.parseInt(entrada.nextLine());
	                 manipulador.removerElemento(elemento);
	             } catch (NumberFormatException e) {
	                 System.out.println("❌ Entrada inválida. Digite um número inteiro.");
	            }
	        }

		    case "3" -> 
		         System.out.println("Maior elemento: " + manipulador.encontrarMaior());

		    case "4" -> 
		         System.out.println("Menor elemento: " + manipulador.encontrarMenor());

		    case "5" -> 
		         System.out.println("Média dos elementos: " + manipulador.calcularMedia());

		    case "6" -> 
		         System.out.println("Lista atual: " + manipulador.mostrarLista());

		    case "7" -> {
		         System.out.println("👋 Saindo do programa. Até mais!");
		         entrada.close();
		         return;
		    }

		     default -> 
		         System.out.println("⚠️ Opção inválida. Tente novamente.");
			}
		}

	}

}
