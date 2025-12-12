package Set;

/*
 * O objetivo desse exercicio é criar um programa que simula um controle de números da loteria.
 * O jogador vai inserir 6 números de 1 a 60*/

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.TreeSet;


public class exercicio_2 {

	public static void main(String[] args) {

		Set<Integer> numerosUsuario = new HashSet<>();
		
		Scanner entrada = new Scanner(System.in);
		
		int contador = 0;
		
		while (numerosUsuario.size() < 6) {
			
			System.out.println("Digite o " + (numerosUsuario.size() + 1) + "º número: ");
			
			int numero = entrada.nextInt();
			
			if (numero < 1 || numero > 60) {
				
				System.out.println("Número inválido, você deve inserir um número entre 1 e 60, tente novamente.");
				
			} else {
				
				contador++;
				
				if (numerosUsuario.add(numero)) {
					
					System.out.println("O número " + numero + " foi escolhido com sucesso.");
					
				} else {
					
					System.out.println("O número " + numero + " já está na lista, escolha outro.");
				}
			}
		}
		
		System.out.println("\nVocê escolheu os 6 números. Lista de números escolhidos: ");
		
		Set<Integer> ordenado = new TreeSet<>(numerosUsuario);
		
		System.out.println(ordenado);
		
		System.out.println("O usuário digitou um total de " + contador + " números entre 1 e 60.");
 		
		entrada.close();

	}

}
