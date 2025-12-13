package Funcoes;

public class exercicio_5 {
	
	public static int maior (int n1, int n2) {
		
		if (n1 > n2) {
			
			return n1;
			
		} else {
			
			return n2;
			
		}
		
	}
	
	public static int tamanhoTexto(String texto) {
		
		return texto.length();
		
	}
	
	public static String inverteString (String texto) {
		
		String inverso = "";
		
		for (int i = texto.length() - 1 ; i >= 0 ; i--) {
			
			inverso += texto.charAt(i);
			
		}
		
		return inverso;
		
	}
	
	public static void imprimeLista (int num) {
		
		if (num < 1) {
			
			System.out.println("Informe um número maior ou igual a 1.");
			
			return;
			
		} else {
			
			System.out.println("Lista de números de 1 até " + num + ": ");
			
		}
		
		for (int i = 1 ;  i <= num ; i++) {
			
			System.out.println(i);
			
		}
		
		System.out.println();
		
		return;
	}
	
	public static int contaVogais (String texto) {
		
		int contador = 0;
		
		texto = texto.toLowerCase();
		
		for (int i = 0 ; i < texto.length() ; i++) {
			
			if (texto.charAt(i) == 'a' || texto.charAt(i) == 'e' ||  texto.charAt(i) == 'i' ||  texto.charAt(i) == 'o' ||  texto.charAt(i) == 'u') {
				
				contador++;
				
			}
			
		}
		
		return contador;
	}

	public static void main(String[] args) {

		System.out.println("Quem é maior entre 30 e 27? " + maior(30, 27));
		
		System.out.println("Quem é maior entre 3 e 7? " + maior(3, 7));
		
		System.out.println("Quem é maior entre 19 e 2? " + maior(19, 2));
		
		System.out.println("=======================");
		
		System.out.println("O tamanho do texto 'Dexter é uma série legal' é " + tamanhoTexto("Dexter é uma série legal"));
		
		System.out.println("=======================");
		
		System.out.println("O inverso de 'Abacaxi é ácido' é " + inverteString("Abacaxi é ácido"));
		
		System.out.println("=======================");
		
		System.out.println("Quantas vogais tem a frase 'O Lucas quer comer' ? " + contaVogais("O Lucas quer comer"));
		
		System.out.println("Quantas vogais tem a frase 'O bebê chora todos os dias de manhã' ? " + contaVogais("O bebê chora todos os dias de manhã"));
		
		System.out.println("=======================");
		
		imprimeLista(10);
		
		imprimeLista(19);
		
		imprimeLista(-6);
		
	}

}
