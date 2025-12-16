package desafios;

/*
 * O programa lê um número digitado pelo usuário e exibe o número correspondente da semana, caso não esteja entre os números,
 * vai informar o usuário.
 * 1 - Domingo
 * 2 - Segunda-feira
 * 3 - Terça-feira
 * 4 - Quarta-feira
 * 5 - Quinta-feira
 * 6 - Sexta-feira
 * 7 - Sábado
 * */

import java.util.Map;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class desafio_2 {
	
	public static String checaDia(int numero) {
		
		Map<Integer, String> diasDaSemana = new HashMap<>();
		
		diasDaSemana.put(1,  "Domingo");
		
		diasDaSemana.put(2,  "Segunda-feira");
		
		diasDaSemana.put(3,  "Terça-feira");
		
		diasDaSemana.put(4,  "Quarta-feira");
		
		diasDaSemana.put(5,  "Quinta-feira");
		
		diasDaSemana.put(6,  "Sexta-feira");
		
		diasDaSemana.put(7,  "Sábado");
			
		if (numero < 1 || numero > 7) {
			
			return "Você informou um número inválido, tente novamente.";
			
		} else if (numero >= 1 && numero <= 7) {
			
			for (Integer indice : diasDaSemana.keySet()) {
				
				if (indice == numero) {
					
					String dia = diasDaSemana.get(indice);
					
					return "Você digitou o número " + numero + " - " + dia + ".";
					
				}
				
			}
			
			return "Você digitou um número inválido, tente novamente.";
			
		} else {
			
			return "Você não informou um número, tente novamente.";
		}

		
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe um número: ");
		
		try {
			
			int numero = entrada.nextInt();
			
			System.out.println(checaDia(numero));
			
		} catch (InputMismatchException e) {
			
			System.out.println("Você precisa digitar um tipo numérico, tente novamente.");
		}
		

		System.out.println(checaDia(1));
		
		System.out.println(checaDia(2));
		
		System.out.println(checaDia(3));
		
		System.out.println(checaDia(4));
		
		System.out.println(checaDia(5));
		
		System.out.println(checaDia(6));
		
		System.out.println(checaDia(7));
		
		System.out.println(checaDia(8));
		
		System.out.println(checaDia(0));
		
//		System.out.println(checaDia("Segunda"));

		entrada.close();

	}
	

}
