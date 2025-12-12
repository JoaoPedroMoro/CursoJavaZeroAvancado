package Listas;

import java.util.ArrayList;
import java.util.Arrays;

public class exemplo_4 {

	public static void main(String[] args) {
		
		System.out.println("===== 1.ADICIONAR ELEMENTOS =====");
		
		ArrayList<String> frutas = new ArrayList<>(Arrays.asList("maca", "banana"));
		
		frutas.add("cereja");
		
		System.out.println("add (append): " + frutas);
		
		frutas = new ArrayList<>(Arrays.asList("maçã", "banana", "cereja"));
		
		frutas.add(1, "abacate");
		
		System.out.println("add (index, valor) (insert): " + frutas);
		
		System.out.println("\n===== 2. REMOVER ELEMENTOS =====");
		
		frutas = new ArrayList<>(Arrays.asList("maçã", "banana", "cereja"));
		
		frutas.remove("banana");
		
		System.out.println("remove (valor): " + frutas);
		
		frutas = new ArrayList<>(Arrays.asList("maçã", "banana", "cereja"));
		
		frutas.remove(1);
		
		System.out.println("remove (index): " + frutas);
		
		frutas.remove(frutas.size() - 1);
		
		System.out.println("remove último: " + frutas);
		
		System.out.println("\n===== 3.CONCATENAR LISTAS =====");
		
		ArrayList<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3));
		
		ArrayList<Integer> lista2 = new ArrayList<>(Arrays.asList(4, 5, 6));
		
		ArrayList<Integer> uniao = new ArrayList<>(lista1);
		
		uniao.addAll(lista2);
		
		System.out.println("União:(+ / extend): " + uniao);
		
		lista1 = new ArrayList<>(Arrays.asList(1, 2, 3));
		
		lista2 = new ArrayList<>(Arrays.asList(4, 5, 6));
		
		lista1.addAll(lista2);
		
		System.out.println("União na mesma: " + lista1);
		
		System.out.println("\n===== 4. REPETIR LISTAS =====");
		
		ArrayList<String> repeticao = new ArrayList<>();
		
		for (int i = 0 ; i < 3 ; i++) {
			
			repeticao.add("a");
			
			repeticao.add("b");
			
		}
		
		System.out.println("Repetição manual (*): " + repeticao);
		
		System.out.println("\n===== 5. VERIFICAR SE UM ITEM ESTÁ NA LISTA =====");
		
		frutas = new ArrayList<>(Arrays.asList("maçã", "banana", "cereja"));
		
		System.out.println("Contém 'banana'? " + frutas.contains("banana"));
		
		System.out.println("Contém 'abacate'? " + frutas.contains("abacate"));
		
		System.out.println("\n===== FIM DAS OPERAÇÕES =====");

	}

}
