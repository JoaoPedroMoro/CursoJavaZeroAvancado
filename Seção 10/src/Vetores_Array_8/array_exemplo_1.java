package Vetores_Array_8;

/*
 * O objetivo deste exemplo é aprender sobre Arrays, por meios de 5 exemplos.
 * */

public class array_exemplo_1 {

	public static void main(String[] args) {
		
		int[] numeros = {10, 20, 30, 40, 50};
		
		//System.out.println(numeros); // Isso aqui mostra o ponteiro do array;
		
		System.out.println("Exemplo 1 - Exibindo os valores de um vetor: ");
		
		
		for (int i=0; i < numeros.length ;i++) {
			
			System.out.println("Posição " + i + ": " + numeros[i]);
			
		}
		
		System.out.println("\n-----------------------------\n");
		
		int [] idades = new int[3];
		
		idades[0] = 18;
		
		idades[1] = 25;
		
		idades[2] = 30;
		
		System.out.println("Exemplo 2 - Preenchendo vetor manualmente: ");
		
		for (int i=0; i < idades.length ;i++) {
			
			System.out.println("Posição " + i + ": " + idades[i]);
			
		}
		
		System.out.println("\n-----------------------------\n");
		
		int [] valores = {5, 10, 15, 20};
		
		int soma = 0;
		
		System.out.println("Exemplo 3 - Somando valores de um vetor: ");
		
		for (int i=0; i < valores.length ;i++) {
			
			soma += valores[i];
			
		}
		
		System.out.println("A soma dos valores do vetor é: " + soma);
		
		System.out.println("\n-----------------------------\n");
		
		int [] dados = {22, 13, 35, 2, 87};
		
		int maior = dados[0];
		
		System.out.println("Exemplo 4 - Descobrindo o maior valor de um vetor: ");
		
		for (int i=0; i < dados.length ;i++) {
			
			if(dados[i] > maior) {
				
				maior = dados[i];
				
			}
			
		}
		
		System.out.println("O maior elemento deste vetor é: " + maior);
		
		System.out.println("\n-----------------------------\n");
		
		int [] numeros2 = {22, 13, 3, 2, 87, 10};
		
		int contador = 0;
		
		System.out.println("Exemplo 5 - Descobrindo quantos valores de um vetor são maiores que 10: ");
		
		for (int i=0; i < numeros2.length ;i++) {
			
			if(numeros2[i] > 10) {
				
				contador++;
				
			}
			
		}
		
		System.out.println("O número de elementos desse vetor que são maiores que 10 é: " + contador);

	}

}
