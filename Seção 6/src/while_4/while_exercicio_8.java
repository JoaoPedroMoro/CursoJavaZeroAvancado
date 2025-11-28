package while_4;

/*
 * O exercício deste programa consiste em solicitar um número para o usuário e mostrar a tabuada desse número de 1 a 10.
 * */

import java.util.Scanner;

public class while_exercicio_8 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o número que você quer ver a tabuada: ");
		
		int numero = entrada.nextInt();
		
		int i = 1;
		
		while (i <= 10) {
			
			System.out.println(numero + " * " + i + " = " + (numero * i));
			
			i++;

			
		}
		
		System.out.println("Fim da tabuada.");
		
		entrada.close();

	}

}
