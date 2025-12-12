package Set;

import java.util.HashSet;

import java.util.Set;

public class exemplos_1 {

	public static void main(String[] args) {
		
		Set<String> frutas = new HashSet<>();
		
		frutas.add("Maçã");
		
		frutas.add("Banana");
		
		frutas.add("Laranja");
		
		frutas.add("Abacaxi");
		
		frutas.add("Abacate");
		
		frutas.add("Maçã");
		
		System.out.println("Frutas: " + frutas);
		
		if (frutas.contains("Banana")) {
			
			System.out.println("Banana está presente.");
			
		}
		
		frutas.remove("Laranja");
		
		System.out.println("Frutas após remoção de laranja: " + frutas);
		
		if (frutas.contains("Abacate")) {
			
			frutas.remove("Abacate");
			
			frutas.add("Melancia");
			
		}
		
		System.out.println("Frutas após editar Abacate para Melancia: " + frutas);
		
		Set<String> filtradas = new HashSet<>();
		
		for (String fruta : frutas) {
			
			if (fruta.startsWith("M")) filtradas.add(fruta);
			
		}
		
		System.out.println("Frutas filtradas (Començando com M): " + filtradas);
		
		Set<String> frutas2 = new HashSet<>();
		
		frutas2.add("Pera");
		
		frutas2.add("Uva");
		
		frutas2.add("Abacaxi");
		
		frutas.addAll(frutas2);
		
		System.out.println("Após juntar os conjuntos: " + frutas);
		
		Set<String> intersecao = new HashSet<>(frutas);
		
		intersecao.retainAll(frutas2);
		
		System.out.println("Interseção: " + intersecao);
		
		Set<String> diferenca = new HashSet<>(frutas);
		
		diferenca.removeAll(frutas2);
		
		System.out.println("Diferença: " + diferenca);
		
		frutas.clear();
		
		System.out.println("Frutas após clear(): " + frutas);

	}

}
