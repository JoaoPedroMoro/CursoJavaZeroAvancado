package Set;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class exemplo_menu_interativo {

	public static void main(String[] args) {
		
		Set <String> conjunto = new HashSet<>();
		
		Scanner entrada = new Scanner(System.in);
		
		int opcao;
		
		do {
			
			System.out.println("\n===== MENU SET =====");
			
			System.out.println("1. Adicionar elemento");
			
			System.out.println("2. Remover elemento");
			
			System.out.println("3. Editar elemento");
			
			System.out.println("4. Listar todos os elementos");
			
			System.out.println("5. Limpar o conjunto");
			
			System.out.println("0. Sair");
			
			System.out.println("Escolha uma opcao: ");
			
			opcao = entrada.nextInt();
			
			entrada.nextLine();
			
			switch (opcao) {
			
				case 1:
					
					System.out.println("Digite o elemento que deseja adicionar: ");
					
					String novo = entrada.nextLine();
					
					if (conjunto.add(novo)) {
						
						System.out.println("Elemento " + novo + " adicionado com sucesso.");
						
					} else {
						
						System.out.println("Elemento " + novo + " já existe no conjunto.");
						
					}
					
					break;
					
				case 2:
					
					System.out.println("Digite o elemento que deseja remover: ");
					
					String remover = entrada.nextLine();
					
					if (conjunto.remove(remover)) {
						
						System.out.println("Elemento " + remover + " removido com sucesso.");
						
					} else {
						
						System.out.println("Elemento " + remover + " não existe no conjunto.");
						
					}
				
					break;
					
				case 3:
					
					if (conjunto.isEmpty()) {
						
						System.out.println("O conjunto está vazio.");
						
					} else {
						
						System.out.println("Digite o elemento que você deseja alterar: ");
						
						String alterar = entrada.nextLine();
						
						if (conjunto.remove(alterar)) {
							
							System.out.println("Digite o elemento que você deseja adicionar: ");
							
							String novo1 = entrada.nextLine();
							
							conjunto.add(novo1);
							
							System.out.println("Foi alterado o elemento " + alterar + " por " + novo1);
							
						} else {
							
							System.out.println("O elemento " + alterar + " não está no conjunto");
							
						}
					}
					
					break;
					
				case 4:
					
					if (!conjunto.isEmpty()) {
						
						System.out.println("\nElementos do conjunto: " + conjunto);
	
						
					} else {
						
						System.out.println("O conjunto está vazio.");
						
					}
					
					break;
					
				case 5:
					
					if (conjunto.isEmpty()) {
						
						System.out.println("O conjunto já está limpo");
						
					} else {
						
						conjunto.clear();
						
						System.out.println("O conjunto foi limpo com sucesso");
					}
					
					break;
					
				case 0:
					
					System.out.println("Saindo do programa ...");
					
					break;
					
				default:
					
					System.out.println("Opção inválida, tente novamente.");
					
					break;
			}
			
		} while(opcao != 0);
		
		entrada.close();

	}

}
