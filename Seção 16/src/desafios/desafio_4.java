package desafios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class desafio_4 {
	
	public static String contaIntervalo () {
		
		Scanner entrada = new Scanner(System.in);
		
		int contador025 = 0;
		int contador2650 = 0;
		int contador5175 = 0;
		int contador76100 = 0;
		
		while (true) {
			
			try {
				
				System.out.println("Insira um número: ");
				
				int numero = entrada.nextInt();
				
				if (numero < 0) {
					
					System.out.println("Opa, número negativo, interrompendo o programa ...");
					
					break;
				}
				
				if (numero >= 0 && numero <= 25) {
					
					contador025++;
					
				} else if (numero >= 26 && numero <= 50) {
					
					contador2650++;
					
				} else if (numero >= 51 && numero <= 75) {
					
					contador5175++;
					
				} else if (numero >= 76 && numero <= 100) {
					
					contador76100++;
					
				}
				
				System.out.println();
				
				
			} catch (InputMismatchException e) {
				
				System.out.println("Entrada inválida, informe um número.");
			}
				
		}
		
		entrada.close();
		
		return "\nLista de número: \n[0-25] - " + contador025 + " números" + "\n[26-50] - " + contador2650 +  " números" 
		+ "\n[51-75] - " + contador5175 + " numeros" + "\n[76-100] - " + contador76100 + " números";
		
	}

	public static void main(String[] args) {

		System.out.println(contaIntervalo());

	}

}
