package desafios;
/*
 * O objetivo desse programa é receber uma lista contendo elementos mistos e trocar a posição
 * do primeiro com o ultimo, independente do tipo de dado. Caso a lista esteja vazia ou tenha
 * apenas 1 elemento, nenhuma troca deve ser realizada
 * */

import java.util.*;

public class desafio_20 {
	
	public static void inverter(List<Object> lista) {
		
		Object temp = lista.get(0);
		
		lista.set(0, lista.get(lista.size()-1));
		
		lista.set(lista.size()-1, temp);
		
	}
	

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);

		List<Object> lista = new ArrayList<>();
		
		while (true) {
			
			System.out.println("Digite o próximo elemento da lista (para encerrar digite 'sair'): ");
			
			Object input = entrada.next();
			
			if (input.equals("sair")) {
				
				break;
				
			} else {
				
				lista.add(input);
				
				continue;
				
			}
			
		}
		
		System.out.println("Lista antes de inverter: " + lista);
		
		inverter(lista);
		
		System.out.println("Lista depois de inverter: " + lista);
		
		entrada.close();

	}

}
