package Exercicio_1;

/*
 * O objetivo desse exercício é simular a rotina de uma pessoa. 
 * 
 * Terá uma classe Pesoa, que vai simular atividades da rotina, como acordar, comer, dirigir e dormir.
 * O programa tem que impedir combinações que não fazer sentido, como:
 * - Não dirigir enquanto come
 * - Não dormir enquanto dirige
 * - Não comer enquanto dorme
 * As ações serão escolhidas via terminal pelo usuário.
 * 
 *  Requisitos da classe Pessoa
 *  - Atributor privados que representam o estado da pessoa:
 *  	- nome (String)
 *  	- acordado (boolean)
 *  	- comendo (boolean)
 *  	- dirigindo (boolean)
 *  - Contrutor: recebe apenas o nome da pessoa e seta todo o restante como "false"
 *  - Métodos: acordar, comer, pararComer, dirigir, pararDirigir, dormir
 *  
 *  Deve ter mensagens indicando o status das ações.
 * */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o nome da pessoa: ");
		
		String nome = entrada.nextLine();
		
		Pessoa pessoa = new Pessoa(nome);
		
		Opcoes op = new Opcoes();
		
		int opcao;
		
		
		do {
			
			op.opcoes(nome);
			
			System.out.println("Digite uma das opções que deseja realizar: ");
			
			opcao = entrada.nextInt();
			
			switch (opcao) {
			
				case 1:
					pessoa.acordar();
					break;
				// posso substituir por case 1 -> pessoa.acordar();
				
				case 2:
					pessoa.comer();
					break;
					
				case 3:
					pessoa.pararComer();
					break;
					
				case 4:
					pessoa.dirigir();
					break;
					
				case 5:
					pessoa.pararDirigir();
					break;
					
				case 6:
					pessoa.dormir();
					break;
					
				case 0:
					System.out.println("Você saiu do menu. Encerrando o programa ...");
					break;
					
				default:
					System.out.println("Você inseriu uma opção inválida, tente novamente");
					break;
					
			}
			
			
		}   while (opcao != 0);
		
		entrada.close();

	}

}
