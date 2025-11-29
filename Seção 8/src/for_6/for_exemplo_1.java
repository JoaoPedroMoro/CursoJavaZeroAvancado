package for_6;

/*
 * No exemplo deste programa iremos fazer 4 exemplos, contar de 1 até 10, contar de 10 até 1, mostrar todos os números pares de 0 até 20 e
 * somar todos os números de 1 até 100.
 * */

public class for_exemplo_1 {

	public static void main(String[] args) {

		System.out.println("\n1. Contagem de 1 até 10.\n");
		
		
		for (int i=1; i <= 10; i++) {
			
			System.out.println("Contagem: " + i);
			
			
		}
		
		System.out.println("\n2. Contagem decrescente de 10 até 1.\n");
		
		for (int i=10; i > 0; i--) {
			
			System.out.println("Contagem decrescente: " + i);
			
			
		}
		
		System.out.println("\n3. Números pares de 0 até 20.\n");
		
		for (int i=0; i <= 20; i++) {
			
			if (i % 2 == 0) {
				
				System.out.println("Número par: " + i);
				
			}
			
		}
		
		System.out.println("\n4. Soma de todos os números de 1 até 100.\n");
		
		int soma = 0;
		
		for (int i=1; i <= 100; i++) {
			
			soma += i;
			
		}
		
		System.out.println("A soma dos números é: " + soma);
		
	}

}
