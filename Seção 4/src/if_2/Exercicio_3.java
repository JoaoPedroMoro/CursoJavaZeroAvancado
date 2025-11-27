package if_2;

/*
 * O objetivo desse exercício é receber 2 números do usuário e determinar qual desses números 
 * é o maior e indicar na tela qual é.
 * */

import java.util.Scanner;

public class Exercicio_3 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o seu primeiro número: ");
		
		double primNum = entrada.nextDouble();
		
		System.out.println("Digite o seu segundo número: ");
		
		double segNum = entrada.nextDouble();
		
		if (primNum > segNum) {
			
			System.out.println("O primeiro número " + primNum + " é maior que o segundo número " + segNum + ".");
			
		} else if (segNum > primNum) {
			
			System.out.println("O segundo número " + segNum + " é maior que o primeiro número " + primNum + ".");
			
		} else {
			
			System.out.println("Os dois números que você digitou, " + primNum + " e " + segNum + ", são iguais.");
			
		}
		
		entrada.close();
		
	}

}
