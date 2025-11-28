package switch_3;

/*
 * O objetivo deste exercício é desenvolver uma calculadora onde o usuário informa 2 números
 * e a operação que quer realizar (+, -, *, /) e aparece na tela o resultado desta operação.
 * */

import java.util.Scanner;

public class switch_exercicio_2 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o primeiro número: ");
		
		double num1 = entrada.nextDouble();
		
		System.out.println("Digite o segundo número: ");
		
		double num2 = entrada.nextDouble();
		
		System.out.println("Digite a operação que você deseja realizar (+, -, * ou /): ");
		
		char operacao = entrada.next().charAt(0);
		
		switch (operacao) {
		
			case '+':
				
				System.out.println("O resultado da operação " + num1 + " " + operacao + " " + num2 + " é " + (num1+num2));
				
				break;
				
			case '-':
				
				System.out.println("O resultado da operação " + num1 + " " + operacao + " " + num2 + " é " + (num1-num2));
				
				break;
				
			case '*':
				
				System.out.println("O resultado da operação " + num1 + " " + operacao + " " + num2 + " é " + (num1*num2));
				
				break;
				
			case '/':
				
				if (num2 == 0) {
					
					System.out.println("Você forneceu 0 como número 2, não existe divisão por 0, tente novamente com outro número.");
					
					break;
					
				}
				System.out.println("O resultado da operação " + num1 + " " + operacao + " " + num2 + " é " + (num1/num2));
				
				break;
				
			default:
				
				System.out.println("Você não inseriu uma operação válida. Tente novamente ...");
				
				break;
				
		}
		
		entrada.close();

	}

}
