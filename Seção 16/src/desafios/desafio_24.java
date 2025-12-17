package desafios;

/*
 * O objetivo desse programa é implementar um carrinho de compras simples. O sistema deve permitir
 * que o usuário adicione ou remova itens do carrinho, visualize o conteúdo do carrinho. A 
 * interação é feita via comandos de texto por um menu, que deve permanecer ativo até
 * o usuário digitar a opção correspondente ao término do programa.
 * 
 * Menu: 
 * 1 - Adicionar item: solicita o nome de um item e adiciona ao carrinho.
 * 2 - Remover item: solicita o nome de um item e remove do carrinho, caso esteja nele.
 * 3 - Ver conteúdo: mostra todo o conteúdo do carrinho.
 * 0 - Sair: encerra o programa.
 * 
 * Regras:
 * - Caso o usuário tente remover um item que não esta no carrinho, deve informar a ele isso.
 * - Caso o usuário tente remover um item quando o carrinho estiver vazio, deve informar isso.
 * - O sistema funciona até o usuário querer sair.
 * 
 * Restrições:
 * - Não deve ser utilizado list compreehension e nem funções que retorne listas vazias.
 * - Apenas estruturas condicionais simples (if, else, else if) deve, ser usadas.
 * */

import java.util.*;

public class desafio_24 {

	public static void main(String[] args) {
			
		Scanner entrada = new Scanner(System.in);
		
		List<String> carrinho = new ArrayList<>();
		
		int opcao = -1;
		
		while (opcao != 0) {
			
			System.out.println("\n ===== MENU =====");
            System.out.println("1 - Adicionar item");
            System.out.println("2 - Remover item");
            System.out.println("3 - Ver conteúdo do carrinho");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = entrada.nextInt();
            
            entrada.nextLine();
            
            if (opcao == 1) {
            	
            	System.out.println("Digite o nome do produto que deseja adicionar: ");
            	
            	String item = entrada.nextLine();
            	
            	carrinho.add(item);
            	System.out.println(item + " foi adicionado no carrinho com sucesso.");
            	
            } else if (opcao == 2) {
            	
            	System.out.println("Digite o nome do produto que deseja remover: ");
            	
            	String item = entrada.nextLine();
            	
            	if (carrinho.isEmpty()) {
            		
            		System.out.println("O carrinho está vazio.");
            		
            	} else if (carrinho.remove(item)) {
            		
                	System.out.println(item + " foi removido no carrinho com sucesso.");
            		
            	} else {
            		
            		System.out.println("O item não existe no carrinho.");
            		
            	}
            	
            } else if (opcao == 3) {
            	
            	if(carrinho.isEmpty()) {
            		
            		System.out.println("O carrinho está vazio.");
            		
            	} else {
            		
            		System.out.println("Itens no carrinho: ");
            		
            		for (String item : carrinho) {
            			
            			System.out.println("- " + item);
            			
            		}
            		
            	}
            } else if (opcao == 0) {
            	
            	System.out.println("Finalizando o programa ...");
            	
            	break;
            	
            } else {
            	
            	System.out.println("Opção inválida, tente novamente.");
            	
            }
            
		}
		
		entrada.close();

	}

}
