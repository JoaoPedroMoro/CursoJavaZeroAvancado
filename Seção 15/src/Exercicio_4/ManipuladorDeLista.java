package Exercicio_4;

import java.util.ArrayList;

import java.util.List;

public class ManipuladorDeLista {

	private List<Integer> lista;
	
	public ManipuladorDeLista() {
		
		this.lista = new ArrayList<>();
		
	}
	
	public void adicionarElemento(int elemento) {
		
		lista.add(elemento);
		
		System.out.println("Elemento " + elemento + " adicionado com sucesso!");
		
	}
	
	public void removerElemento(int elemento) {
		
		if (lista.contains(elemento)) {
			
			// Fazendo o cast Integer para que seja removido o elemento e não o index
			lista.remove((Integer) elemento);
			
			System.out.println("Elemento " + elemento + " removido da lista com sucesso!");
			
		} else {
			
			System.out.println("Elemento " + elemento + " não foi encontrado na lista!");
			
		}
		
	}
	
	public String encontrarMaior() {
		
		if (lista.isEmpty()) {
			
			return "A lista está vazia.";
			
		}
		
		int maior = lista.get(0);
		
		for (int num : lista) {
			
			if (num > maior) {
				
				maior = num;
				
			}
			
		}
		
		return String.valueOf(maior); // Convertendo o número em String
		
	}
	
	public String encontrarMenor() {
		
		if (lista.isEmpty()) {
			
			return "A lista está vazia.";
			
		}
		
		int menor = lista.get(0);
		
		for (int num : lista) {
			
			if (num < menor) {
				
				menor = num;
				
			}
			
		}
		
		return String.valueOf(menor); // Convertendo o número em String
		
	}
	
	public String calcularMedia() {
		
		if (lista.isEmpty()) {
			
			return "A lista está vazia.";
			
		}

		double soma = 0;
		
		for (int num : lista) {
			
			soma += num;
			
		}
		
		double media = soma/lista.size();
		
		return String.format("%.2f", media);
		
	}
	
	public String mostrarLista() {
		
		return lista.toString();
		
	}
	
}
