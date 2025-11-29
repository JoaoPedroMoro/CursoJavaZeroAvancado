package do_while_5;

/*
 * O objetivo desse exercício é exibir a tabuada do número passado pelo usuário utilizando o do-while.
 * */

import java.util.Scanner;

public class do_while_exercicio_8 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe qual numero você deseja ver a tabuada de 1 a 10: ");
		
		int numero = entrada.nextInt();
		
		int i =1;
		
		do {
			
			System.out.println("Tabuada do " + numero + " * "+ i + " : " + (numero * i));
			
			i++;
			
		} while (i <= 10);
		
		entrada.close();

	}

}
