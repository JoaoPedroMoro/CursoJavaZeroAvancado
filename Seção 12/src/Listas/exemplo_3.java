package Listas;

import java.util.ArrayList;
import java.util.Arrays;

public class exemplo_3 {

	public static void main(String[] args) {

		System.out.println("===== Criando e acessando Listas em Java =====");
		
		ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
		
		System.out.println("Lista de números: " + numeros);
		
		ArrayList<String> frutas = new ArrayList<>(Arrays.asList("Maçã", "Banana", "Cereja"));
		
		System.out.println("Lista de frutas: " + frutas);
		
		ArrayList<Object> mista = new ArrayList<>();
		
		mista.add(10);
		
		mista.add("Olá");
		
		mista.add(2.5);
		
		mista.add(new ArrayList<>(Arrays.asList("a", "b")));
		
		mista.add(true);
		
		System.out.println("Lista mista: " + mista);
		
		ArrayList<String> frutas2 = new ArrayList<>(Arrays.asList("Maçã", "Banana", "Cereja", "Damasco"));
		
		System.out.println("Lista de frutas2: " + frutas);
		
		System.out.println("\nPrimeira fruta: " + frutas2.get(0));
		
		System.out.println("\nTerceira fruta: " + frutas2.get(2));
		
		int tamanho = frutas2.size();
		
		System.out.println("\nÚltima fruta: " + frutas2.get(tamanho - 1));
		
		System.out.println("\nPenultima fruta: " + frutas2.get(tamanho - 1));
		
		

	}

}
