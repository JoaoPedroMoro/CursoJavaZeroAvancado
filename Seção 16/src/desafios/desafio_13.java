package desafios;

import java.util.InputMismatchException;

/*
 * O programa solicita um tamanho de senha para o usuário. Após o usuário escolher, o programa
 * vai gerar uma senha aleatório com a quantidade de digitos informada pelo usuário
 * */

import java.util.Scanner;
import java.util.Random;

public class desafio_13 {
	
	public static String geradorSenha (int tamanho) {
		
		Random aleatorio = new Random();
		
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
				+ "1234567890!@#$%¨&*()-_=+[]<>{}?";
		
		StringBuilder senha = new StringBuilder(tamanho);
		
		for (int i = 0 ; i < tamanho ; i++) {
			
			int indice = aleatorio.nextInt(caracteres.length());
			
			senha.append(caracteres.charAt(indice));
			
		}
		
		String senhaStr = senha.toString();
		
		return senhaStr;
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int tamanho = 0;
		
		while (true) {
			
			try {
				
				System.out.println("Informe o tamanho da senha que deseja: ");
				
				tamanho = entrada.nextInt();
				
				break;
				
				
			} catch (InputMismatchException e) {
				
				entrada.nextLine();
				
				System.out.println("Entrada inválida, escolha um número novamente.");
				
			}
			
		}
		
		String senha = geradorSenha(tamanho);
		
		System.out.println("A senha gerada foi: " + senha);
		
		entrada.close();

	}

}
