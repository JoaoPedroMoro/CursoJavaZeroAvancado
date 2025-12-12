package Set;

import java.util.HashMap;

import java.util.Map;

public class exercicio_3_map {

	public static void main(String[] args) {

		Map<String, String> traducao = new HashMap<>();
		
		traducao.put("Cenoura", "Carrot");
		traducao.put("Maçã", "Apple");
		traducao.put("Torta de maçã", "Apple Pie");
		traducao.put("Fogo", "Fire");
		traducao.put("Água", "Water");
		
		for (Map.Entry<String, String> entry :traducao.entrySet()) {
			
			System.out.println("Português: " + entry.getKey() + " -> Inglês: " + entry.getValue());
			
		}
		
		traducao.remove("Cenoura");
		
		System.out.println("\n Após a remoção de 'cenoura': ");
		
		for (Map.Entry<String, String> entry :traducao.entrySet()) {
			
			System.out.println("Português: " + entry.getKey() + " -> Inglês: " + entry.getValue());
			
		}
	}

}
