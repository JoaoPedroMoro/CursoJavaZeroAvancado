package Listas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class exemplo_8 {

	public static void main(String[] args) {

		ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(6, 3, 8, 12, 2,9, 17));
		
		System.out.println("Lista de números: " + numeros);
		
		int tamanho = numeros.size();
		
		System.out.println("O número de elementos na lista é: " + tamanho);
		
		int maiorValor = Collections.max(numeros);
		
		System.out.println("O maior valor na lsita é: " + maiorValor);
		
		int menorValor = Collections.min(numeros);
		
		System.out.println("O menor valor na lista é: " + menorValor);
		
		int somaTotal = 0;
		
		for (int num : numeros) {
			
			somaTotal += num;
			
		}
		
		System.out.println("A soma dos elementos na lista é: " + somaTotal);

	}

}
