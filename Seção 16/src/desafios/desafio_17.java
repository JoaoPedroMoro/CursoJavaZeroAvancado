package desafios;

/*
 * O programa consiste em receber uma lista de números diferentes, retornar o maior deles, utilizar
 * métodos auxiliares (simulando funções aninhadas), detectar duplicatas e solicitar uma nova entrada, 
 * mostrar todos os números em ordem decrescente e permitir o usuário repetir o processo automaticamente
 * */

import java.util.*;

public class desafio_17 {
	
	public static double comparacao(double num1, double num2) {
		
		if (num1 > num2) return num1;
		else return num2;
		
//		return (num1>num2) ? num1 : num2; // faz a mesma coisa que o anterior
		
	}
	
	public static double maior (List<Double> numeros) {
		
		double maior = numeros.get(0);
		
		for (int i = 1 ; i < numeros.size(); i++) { // Começa em 1 pq o 0 já ta como maior
			
			maior = comparacao(maior, numeros.get(i));
			
		}
		
		return maior;
		
	}
	
	public static List<Double> entradaNumeros(Scanner scanner) {
		
		while (true) {
			
			try {
				
				System.out.print("Digite números diferentes separados por espaço: ");
				
				String entrada = scanner.nextLine();
				
				String[] numerosStr = entrada.trim().split("\\s+");
				
				List<Double> numeros = new ArrayList<>();
				
				for (String num : numerosStr) {
					
					// Converte o numero em double, se a conversão falhar, vai lançar uma exceção
					numeros.add(Double.parseDouble(num));
					
				}
				
				if (numeros.size() < 1) {
					
					System.out.println("Você não digitou nenhum número, digite pelo menos um número.");
					
					continue; // reinicia o laço
					
				}
				
				if (duplicados(numeros)) {
					
					System.out.println("Existem pelo menos dois números iguais. Tente novamente "
							+ "inserindo apenas números diferentes.");
					
					continue;
					
				}
				
				return numeros;
				
			} catch (InputMismatchException e) {
				
				System.out.println("Entrada inválida, digite um número novamente.");
				
			}
			
 		}
		
	}
	
	public static void decrescente (List<Double> numeros) {
		
		List<Double> temp = new ArrayList<>(numeros);
		
		temp.sort(Collections.reverseOrder());
		
		System.out.println("Os números em ordem decrescente: " + temp);
		
		return;
		
	}
	
	public static boolean duplicados(List<Double> numeros) {
		
		Set<Double> set = new HashSet<>(numeros);
		
		return set.size() != numeros.size();
		
		
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		while (true) {
			
			List<Double> numeros = entradaNumeros(entrada);
			
			double maior = maior(numeros);
			
			System.out.println("O maior valor dessa lista de números é: " + maior);
			
			decrescente(numeros);
			
			System.out.println("Deseja rodar o programa de novo? (s/n): ");
			
			String texto = entrada.nextLine().trim().toLowerCase();
			
			if (texto.equals("s")) {
				
				continue;
				
			} else {
				
				System.out.println("Encerrando o programa ...");
				
				break;
				
			}
			
		}
		
		entrada.close();

	}

}
