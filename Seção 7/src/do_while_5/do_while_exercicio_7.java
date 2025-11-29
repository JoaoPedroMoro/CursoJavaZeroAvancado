package do_while_5;

/*
 * O objetivo deste exercício é solicitar uma senha do usuário e só sair do do-while quando a ser for correta (1234).
 * */

import java.util.Scanner;

public class do_while_exercicio_7 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		int senha;
		
		do {
			
			System.out.println("Digite a senha: ");
			
			senha = entrada.nextInt();
			
		} while (senha != 1234);
		
		System.out.println("Parabéns, você digitou a senha corretamente. Saindo do programa ...");
		
		entrada.close();

	}

}
