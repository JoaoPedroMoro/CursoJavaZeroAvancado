package Listas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exemplo_6 {

	public static void main(String[] args) {

		System.out.println("===== Slicing de listas em Java (Simulando) =====");
		
		ArrayList<Integer> minhaLista = new ArrayList<>(Arrays.asList(
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		));
		
		System.out.println("Lista original: " + minhaLista);
		
		List <Integer> subconjunto = minhaLista.subList(1,  4);
		
		System.out.println("\nSubconjunto [1:4]: " + subconjunto);
		
		List<Integer> primeirosElementos = minhaLista.subList(0,  2);
		
		System.out.println("\nPrimeiros elementos [:2]: " + primeirosElementos);
		
		List<Integer> elementosDepoisDo2 = minhaLista.subList(2, minhaLista.size());
		
		System.out.println("\nElementos a partir do índice 2 [2:]: " + elementosDepoisDo2);
		
		ArrayList<Integer> elementosAlternados = new ArrayList<>();
		
		for (int i = 0 ; i < minhaLista.size(); i+=2) {
			
			elementosAlternados.add(minhaLista.get(i));
			
		}
		
		System.out.println("\nElementos alternados [::2]: " + elementosAlternados);
		
		ArrayList<Integer> subconjuntoAlternado = new ArrayList<>();
		
		for (int i = 2; i < 8; i+=2) {
			
			subconjuntoAlternado.add(minhaLista.get(i));
			
		}
		
		System.out.println("\nSubconjunto alternado [2:8:2]: " + subconjuntoAlternado);
		
		System.out.println("\nminhaLista[2]: " + minhaLista.get(2));
		
		System.out.println("\nminhaLista[4]: " + minhaLista.get(4));
		
		System.out.println("\nminhaLista[6]: " + minhaLista.get(6));

	}

}
