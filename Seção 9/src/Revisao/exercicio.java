package Revisao;

/*
 * Vários exercícios para fortalecer os conhecimentos em estruturas de repetição.
 * */

import java.util.Scanner;

import java.util.Random;

public class exercicio {

	public static void main(String[] args) {
		
		System.out.println("\n 1. Contando de 1 até 100 e interrompendo a contagem quando encontrar múltiplo de 7.\n");
		
		for (int i = 1; i<= 100 ;i++) {
			
			if (i%7==0) {
				
				System.out.println("Opa, multiplo de 7 encontrado, interrompendo a contagem.");
				
				break;
				
			}
			
			System.out.println("Número: " + i);
			
		}
		
		System.out.println("\n 2. Contando de 1 até 20 e pulando os números ímpares.\n");
		
		for (int i = 1; i<= 20 ;i++) {
			
			if (i%2==1) {
				
				System.out.println("Opa, número ímpar encontrado, pulando.");
				
				continue;
				
			}
			
			System.out.println("Número: " + i);
			
		}
		
		System.out.println("\n 3. Ler número até o usuário digitar -1.\n");
		
		Scanner entrada = new Scanner(System.in);
		
		boolean flag = false;
		
		int numero;
		
		while (flag != true) {
			
			System.out.println("Digite um número: ");
			
			numero = entrada.nextInt();
			
			if (numero == -1) {
				
				System.out.println("Opa, foi digitado o -1, interrompendo o laço.");
				
				flag = true;
				
				continue;
				
			}
			
			System.out.println("Número digitado: " + numero);
			
		}

		System.out.println("\n 4. Somar números até o usuário digitar um número negativo.\n");
		
		flag = false;
		
		int soma = 0;
		
		
		while (flag != true) {
			
			System.out.println("Digite um número: ");
			
			numero = entrada.nextInt();
			
			if (numero < 0) {
				
				System.out.println("Opa, foi digitado um número negativo, interrompendo o laço.\nSoma total: " + soma);
				
				flag = true;
				
				continue;
				
			}
			
			soma += numero;
			
		}
		
		System.out.println("\n 5. Ler o número digitado pelo usuário e pular ele na sequência de 1 até 10.\n");
		
		numero = -1;
		
		while (numero < 1 || numero > 10) {
			
			System.out.println("Digite um número entre 1 e 10: ");
			
			numero = entrada.nextInt();
			
		}
		
		
		for (int i=0 ; i<=10 ; i++) {
			
			
			if (i == numero) {
				
				continue;
				
			}
			
			System.out.println("Sequência: " + i);
			
		}
		
		System.out.println("\n 6. Validar a senha com no máximo três tentativas. Senha: 12345.\n");
		
		
		for (int i=1 ; i<=3 ; i++) {
			
			System.out.println("Digite a senha: ");
			
			numero = entrada.nextInt();
			
			if (numero == 12345) {
				
				System.out.println("Acesso liberado, você acertou a senha!");
				
				break;
				
			}
			
			if (i == 3) {
				
				System.out.println("Acesso bloqueado, você digitou três vezes uma senha incorreta!");
				
			}
			
		}
		
		System.out.println("\n 7. Imprimir os 10 primeiros múltiplos de 4.\n");
		
		flag = false;
		
		int iterador = 0;
		int i = 0;
		
		while (flag != true) {
			
			i++;
			
			if (i % 4 == 0) {
				
				System.out.println(i);
				
				iterador ++;
				
			}
			
			if (iterador == 10) {
				
				System.out.println("Já foram impressos os 10 primeiros múltiplos de 4, encerrando o programa...");
				
				flag = true;
				
				break;
				
			}
			
		}
		
		System.out.println("\n 8. Gerando números aleatórios até encontrar o número 10.\n");
		
		Random aleatorio = new Random();
		
		int numeroAleatorio;
		
		while (true) {
			
			numeroAleatorio = aleatorio.nextInt(20);
			
			System.out.println("Número aleatório gerado: " + numeroAleatorio);
			
			if (numeroAleatorio == 10) {
				
				System.out.println("Número 10 encontrado, parando a repetição.");
				
				break;
				
			}
			
		}
		
		entrada.nextLine(); // limpa o Enter pendente
		
		System.out.println("\n 9. Imprimir apenas as vogais de uma palavra digitada pelo usuário.\n");
		
		System.out.println("Digite uma palavra: ");
		
		String palavra = entrada.nextLine().toLowerCase();
		
		for (int letra = 0 ; letra < palavra.length() ; letra++) {
			
			char letraAnalisada = palavra.charAt(letra);
			
			if (letraAnalisada == 'a' || letraAnalisada == 'e' || letraAnalisada == 'i' || letraAnalisada == 'o' || letraAnalisada == 'u') {
				
				System.out.println(palavra.charAt(letra));
				
				continue;
				
			} 
			
		}
		
		entrada.close();
		
	}

}
