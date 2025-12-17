package desafios;

/* 
 * Diferentes formas de somar os elementos de uma lista.
 * 
 * Dada a lista x = [5, 10, 15, 20], apresente pelo menos cinco formas diferentes de retornar a 
 * soma dos elementos dessa lista. Utilize diferentes abordagens e estruturas de controle
 * ou funções nativas de Java.
 * 
 * Requisitos:
 * - Apresente cinco maneiras distintas de calcular e exibir a soma dos elementos da lista
 * - As abordagens devem variar entre o uso de funções embutdas, laços de repetição, compreensões
 * de lista e outras ferramentas da linguagem Java.
 * - O resultado final para cada método deve ser o mesmo: a soma dos elementos da lista*/

import java.util.*;

public class desafio_23 {

	public static void main(String[] args) {

		List<Integer> x = Arrays.asList(5, 10, 15, 20);
		
		System.out.println("=== JEITO 1 - USANDO UM FOR TRADICIONAL ===");
		
		int soma1 = 0;
		
		for (int i = 0 ; i < x.size() ; i++) {
			
			soma1 += x.get(i);
			
		}
		
		System.out.println("Soma usando um for tradicional: " + soma1);
		
		System.out.println("\n=== JEITO 2 - USANDO UM FOR EACH ===");
		
		int soma2 = 0;
		
		for (int valor : x) {
			
			soma2 += valor;
			
		}
		
		System.out.println("Soma usando um for each: " + soma2);
		
		System.out.println("\n=== JEITO 3 - USANDO WHILE ===");
		
		int soma3 = 0;
		int temp = 0;
		
		while (temp < x.size()) {
			
			soma3 += x.get(temp);
			temp++;
			
		}
		
		System.out.println("Soma usando while: " + soma3);
		
		System.out.println("\n=== JEITO 4 - USANDO ITERATOR ===");
		
		int soma4 = 0;
		Iterator<Integer> it = x.iterator();
		
		while (it.hasNext()) {
			
			soma4 += it.next();;
			
		}
		
		System.out.println("Soma usando iterator: " + soma4);
		
		System.out.println("\n=== JEITO 5 - USANDO STREAM ===");
		
		int soma5 = x.stream().mapToInt(Integer::intValue).sum();
		
		System.out.println("Soma usando stream: " + soma5);
		
		


	}

}
