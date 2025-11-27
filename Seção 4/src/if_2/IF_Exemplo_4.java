package if_2;

import java.util.Scanner;

public class IF_Exemplo_4 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a sua idade: ");
		
		int idade = entrada.nextInt();
		
		entrada.nextLine();
		
		System.out.println("Você é brasileiro ou naturalizado? (sim/não: ");
		
		// Lê a linha completa digitada pelo usuário
		// O método toLowerCase() transforma o texto digitado para letras minúsculas
		String nacionalidade = entrada.nextLine().toLowerCase();
		
		// Usa-se .equals() para comparar a string
		// && nesse caso é E
		if (idade >= 16 && nacionalidade.equals("sim")) {
			
			System.out.println("Você pode votar!");
		} else {
			
			System.out.println("Você não pode votar!");
			
		}
		
		entrada.close();
		
	}

}
