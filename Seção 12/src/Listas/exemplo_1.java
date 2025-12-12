package Listas;

import java.util.ArrayList;

public class exemplo_1 {

	public static void main(String[] args) {
		
		ArrayList<String> nomes = new ArrayList<>();
		
		nomes.add("Ana");
		
		nomes.add("Carlos");
		
		nomes.add("João");
		
		System.out.println("Lista completa (Formato padrão): ");
		
		System.out.println(nomes);
		
		System.out.println("\nLista formatada com numeração: ");
		
		for (int n = 0; n<nomes.size();n++) {
			
			System.out.println((n+1) + ". " + nomes.get(n));
			
		}
		
		System.out.println("\nTotal de nomes na lista: " + nomes.size());
	}

}
