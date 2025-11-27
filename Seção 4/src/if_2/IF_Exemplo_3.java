package if_2;

import java.util.Scanner; // Para receber entradas do usuário

public class IF_Exemplo_3 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in); // System.in indica que vem do teclado
		
		System.out.println("Digite a nota do aluno: ");
		
		// É necessário fornecer o número no padrão americano 5,9 e não no padrão brasileiro 5.9.
		double nota =  entrada.nextDouble();
		
		if (nota >= 7) {
		
			System.out.println("Você passou de ano.");
		
		} else if (nota >= 5) {
			
			System.out.println("Você está de recuperação.");
			
		} else {
			
			System.out.println("Você não passou de ano.");
			
		}
		
		entrada.close(); // É uma boa prática fechar o Scanner ao final do programa.
		
	}

}
