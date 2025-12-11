package Exercicio_3;

import java.util.Scanner;
/*
 * O objetivo desse exercício é desenvolver um sistem de reservas, com menu interativo
 * */

public class Main {

	private static void mostrarMenu() {
		
		System.out.println("\n========== MENU ==========");
		
		System.out.println("Lista de opções disponíveis: ");
		
		System.out.println("1. Reservar um lugar");
		
		System.out.println("2. Cancelar uma reserva");
		
		System.out.println("3. Mostrar status de reservas");
		
		System.out.println("0. Sair do menu");
		
		System.out.println("Escolha uma das opções: ");
	}
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe a capacidade do evento (caso pressionar Enter, será determinado como 10: ");
		
		String linhaCapacidade = entrada.nextLine().trim(); // trim() remove espaços em branco no inicio e fim da entrada
		
		Evento evento;
		
		if (linhaCapacidade.isEmpty()) {
			
			evento = new Evento();
			
		} else {
			
			try {
				
				int capacidade = Integer.parseInt(linhaCapacidade);
				
				evento = new Evento(capacidade);
				
			} catch (NumberFormatException e) {
				
				System.out.println("Valor inválido. Será utilizado a capacidade padrão de 10");
				
				evento = new Evento();
				
			}
			
		}
		
		while (true) {
			
			mostrarMenu();
			
			String opcao = entrada.nextLine().trim();
			
			switch (opcao) {
			
				case "1" -> evento.reservar();
				
				case "2" -> evento.cancelar();
				
				case "3" -> evento.exibirStatus();
				
				case "0" -> {
					
					System.out.println("Encerrando o sistema. Até mais!");
					
					entrada.close();
					
					return;
					
				}
				
				default -> System.out.println("Opção inválida. Tente novamente.");
				
			}
			
		}
		
	}

}
