package Set;

import java.util.HashMap;

import java.util.Map;

public class set_com_map {

	public static void main(String[] args) {
		
		Map<Integer, String> produtos = new HashMap<>();
		
		produtos.put(1, "Teclado");
		
		produtos.put(2, "Mouse");
		
		produtos.put(3, "Monitor");
		
		produtos.put(4, "Gabinete");
		
		System.out.println("Produtos: " + produtos);
		
		String produto = produtos.get(2);
		
		System.out.println("Produto com ID 2: " + produto);
		
		if (produtos.containsKey(3)) {
			
			System.out.println("ID 3 existe no map");
			
		} else System.out.println("Não existe ID 3 no map");
	
		
		if (produtos.containsValue("Monitor")) {
			
			System.out.println("O produto 'Monitor' existe no map");
			
		} else System.out.println("O produto 'Monitor' existe no map");
		
		produtos.put(4,  "Impressora a laser");
		
		System.out.println("Após atualização: " + produtos);
		
		produtos.remove(1);
		
		System.out.println("Após remover ID 1: " + produtos);
		
		System.out.println("\nLista de produtos: ");
		
		for (Map.Entry<Integer, String> entry :produtos.entrySet()) {
			
			System.out.println("ID: " + entry.getKey() + " -> Produto: " + entry.getValue());
			
		}
		
		System.out.println("Chaves: " + produtos.keySet());
		
		System.out.println("Valores: " + produtos.values());
		
		produtos.clear();
		
		System.out.println("Após o clear(): " + produtos);

	}

}
