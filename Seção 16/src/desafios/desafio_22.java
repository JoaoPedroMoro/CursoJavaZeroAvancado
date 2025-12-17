package desafios;

/*
 * O objetivo desse programa é receber uma lista de dicionarios, onde cada dicionario
 * descreve um carro e contem as informações de modelo do carro e ano de fabricacao. O objetivo
 * é ordenar o dicionario em ordem crescente de ano de fabricacao
 * */

import java.util.*;

public class desafio_22 {
	
	public static List<Map<String, Object>> ordenaCarros (List<Map<String, Object>> dicionario) {
		
		List<Map<String, Object>> resultado = new ArrayList<>(dicionario);
		
		// Utiliza uma função de comparação para ordenar a lista, retornando em ordem crescente
		resultado.sort((c1, c2) ->{
			int ano1 = (int) c1.get("Ano");
			int ano2 = (int) c2.get("Ano");
			return Integer.compare(ano1, ano2);
			
		});
		
		return resultado;
		
	}

	public static void main(String[] args) {

		List<Map<String, Object>> carros = new ArrayList<>();
		
		Map<String, Object> carro1 = new HashMap<>();
		
		carro1.put("Modelo", "Cruze");
		carro1.put("Ano", 2021);
		
		Map<String, Object> carro2 = new HashMap<>();
		
		carro2.put("Modelo", "Pulse");
		carro2.put("Ano", 2024);
		
		Map<String, Object> carro3 = new HashMap<>();
		
		carro3.put("Modelo", "Amarok");
		carro3.put("Ano", 2017);
		
		carros.add(carro1);
		
		carros.add(carro2);
		
		carros.add(carro3);
		
		List<Map<String, Object>> ordenado = ordenaCarros(carros);
		
		System.out.println("Dicionário ordenado por ano: ");
		
		for (Map<String, Object> carro : ordenado) {
			
			System.out.println(carro.get("Modelo") + " - " + carro.get("Ano"));
			
		}

	}

}
