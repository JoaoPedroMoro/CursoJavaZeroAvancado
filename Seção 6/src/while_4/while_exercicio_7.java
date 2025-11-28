package while_4;

/*
 * O objetivo desse exercício é desenvolver um programa em Java que leia a senha que o usuário digitar e permita apenas a senha correta,
 * que é 1234.
 * */

import java.util.Scanner;

public class while_exercicio_7 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a senha: ");
		
		int numero = entrada.nextInt();
		
		while (numero != 1234) {
			
			System.out.println("Senha incorreta, digite novamente: ");
			
			numero = entrada.nextInt();

			
		}
		
		System.out.println("Você digitou a senha corretamente, parabéns!");
		
		entrada.close();

	}

}
