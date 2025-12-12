package Listas;

import java.util.ArrayList;
import java.util.Scanner;

public class exemplo_9_menu_interativo {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		ArrayList<String> lista = new ArrayList<>();
		
		int opcao;
		
		do {
			
			System.out.println("\n===== MENU DA LISTA =====");
			System.out.println("1. Adicionar item");
			System.out.println("2. Remover item");
			System.out.println("3. Alterar item");
			System.out.println("4. Listar itens");
			System.out.println("5. Limpar lista");
			System.out.println("6. Sair");
			System.out.println("Escolha uma opção: ");
			
			opcao = entrada.nextInt();
			entrada.nextLine(); // Para ignorar o enter
			
			switch (opcao) {
			
				case 1:
					
					System.out.println("Digite o item que quer adicionar: ");
					
					String novoItem = entrada.nextLine();
					
					lista.add(novoItem);
					
					System.out.println("Item " + novoItem + " adicionado com sucesso."); 
					
					break;
					
				case 2:
					
					if (lista.isEmpty()) {
						
						System.out.println("A lista está vazia.");
						
						
					} else {
						
						System.out.println("Digite o item que quer remover: ");
						
						String itemRemover = entrada.nextLine();
						
						if (lista.remove(itemRemover)) {
							
							System.out.println("Item " + itemRemover + " removido com sucesso.");
							
						} else {
							
							System.out.println("Item " + itemRemover + " não encontrado na lista.");
							
						}
	
					}
					
					break;	
					
				case 3:
					
					if (lista.isEmpty()) {
						
						System.out.println("A lista está vazia.");
						
					} else {
						
						System.out.println("Digite o item que deseja alterar: ");
						
						String itemAlterar = entrada.nextLine();
						
						if (lista.contains(itemAlterar)) {
							
							System.out.println("Digite o item que quer adicionar no lugar: ");
							
							String itemNovo = entrada.nextLine();
							
							int indice = lista.indexOf(itemAlterar);
							
							lista.set(indice, itemNovo); // Ele sobrescreve em cima do item antigo, dessa forma não necessitando do remove
							
//							lista.remove(itemAlterar);
							
							System.out.println("O item " + itemAlterar + " foi substituido por " + itemNovo + " com sucesso.");
							
						} else {
							
							System.out.println("O item " + itemAlterar + " não está na lista.");
							
						}
						
					}
					
					break;
					
				case 4:
					
					if (lista.isEmpty()) {
						
						System.out.println("A lista está vazia.");
						
					} else {
						
						System.out.println("\nItens da lista: ");
						
						for (String i : lista) {
							
							System.out.println(i);
							
						}
						
						System.out.println("\nVisualização da lista com índices: ");
						
						for(int i=0;i<lista.size();i++) {
							
							System.out.println((i+1) + ". " + lista.get(i));
							
						}
					}
					
					break;
					
				case 5: 
					
					if (lista.isEmpty()) {
						
						System.out.println("A lista já está limpa.");
						
					} else {
						
						lista.clear();
						
						System.out.println("Lista limpa com sucesso.");
					}
					
					
					break;
					
				case 6:
					
					System.out.println("Saindo do programa ...");
					
					break;
					
				default:
					
					System.out.println("Opção inválida, tente novamente.");
					
					break;
					
			}
			
		} while (opcao != 6);
		
		entrada.close();

	}

}
