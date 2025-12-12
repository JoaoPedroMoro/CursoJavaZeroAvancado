package Listas;

/*
 * O objetivo desse exerc´cio é criar uma lista de valores inteiros e depois verificar qual é o maior valor
 * dessa lista e mostrar na tela.
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class exercicio_4 {

	public static void main(String[] args) {
			
		ArrayList<Integer> listaNumeros = new ArrayList<>(Arrays.asList(7, 19, 1, 29, 65, 21, 37, 45, 54, 67, 9, 60));
		
		int maiorNumero = Collections.max(listaNumeros);
		
		System.out.println("O maior número da lista " + listaNumeros + " é: " + maiorNumero);

	}

}
