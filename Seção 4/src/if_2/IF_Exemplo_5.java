package if_2;

import java.util.Scanner;


public class IF_Exemplo_5 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite sua idade: ");
		
		int idade = entrada.nextInt();
		
		entrada.nextLine();
		
		System.out.println("Você é estudante? (sim/não)");
		
		String estudante = entrada.nextLine().toLowerCase();
		
		if (idade < 18 || estudante.equals("sim")) {
			
			System.out.println("Você tem direito à meia-entrada no cinema.");
			
		} else {
			
			System.out.println("Você não tem direito à meia-entrada no cinema.");
			
		}
		
		entrada.close();

	}

}
