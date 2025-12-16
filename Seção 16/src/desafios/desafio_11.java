package desafios;

import java.util.InputMismatchException;

/*
 * O programa é de uma loja de tintas, ele deve solicitar ao usuário o tamanho da área em m² que ele
 * deseja pintar. Deve considerar que o litro da tinta pinta 5 m². As tintas são vendidas em latas de 
 * 18 litros e cada lata custa R$ 100.
 * O programa deve informar ao usuário quantos litros de tinta é necessário para pintar, quantas 
 * latas de tinta serão necessárias e o valor que ele deve gastar para isso.
 * */

import java.util.Scanner;

public class desafio_11 {
	
	public static void calculaPintura (double metros) {
		
		int totalLitros = (int)metros/5;
		
		if (metros % 5 != 0) totalLitros++;
		
		int totalLatas = totalLitros/18;
		
		if (totalLitros < 18) totalLatas = 1;
		else if (totalLitros % 18 != 0) totalLatas++;
		
		int valor = totalLatas * 100;
		
		System.out.println("Para pintar " + metros + "m², é necessário " + totalLitros + " litros de tinta,"
				+ " que da um total de " + totalLatas + " latas de tinta, que custa R$ " + valor);
		
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		while (true) {
			
			try {
				
				System.out.println("Informe quantos m² você deseja pintar: ");
				
				double metros = entrada.nextDouble();
				
				calculaPintura(metros);
				
				break;
				
			} catch (InputMismatchException e) {
				
				entrada.nextLine();
				
				System.out.println("Você não inseriu um número, tente novamente.");
				
			}
			
		}
		
		entrada.close();

	}

}
