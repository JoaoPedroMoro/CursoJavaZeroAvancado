package Funcoes;

public class exemplo_1 {
	
	public static void mensagemBoasVindas() {
		
		System.out.println("Boas vindas ao mundo das funções em Java.");
	
	}
	
	public static void saudar (String nome) {
		
		System.out.println("Olá, " + nome + ", é um prazer te ver aqui.");
		
	}
	
	public static int somar (int num1, int num2) {
		
		return num1+num2;
		
	}
	
	public static boolean ePar(int num) {
		
		return num % 2 == 0;
		
	} 
	
	public static int quadrado (int num) {
		
		return num*num;
		
	}

	public static void main(String[] args) {
		
		mensagemBoasVindas();
		
		System.out.println("-------------------");
		
		saudar("João");
		
		System.out.println("-------------------");
		
		int soma = somar(10,5);
		
		System.out.println("A soma de 10 + 5 = " + soma);
		
		System.out.println("-------------------");
		
		System.out.println("2 é par? " + ePar(2));
		
		System.out.println("7 é par? " + ePar(7));
		
		System.out.println("16 é par? " + ePar(16));
		
		System.out.println("25 é par? " + ePar(25));
		
		System.out.println("-------------------");
		
		System.out.println("O quadrado de 2 é " + quadrado(2));
		
		System.out.println("O quadrado de 7 é " + quadrado(7));
		
		System.out.println("O quadrado de 12 é " + quadrado(12));
		
		System.out.println("O quadrado de 20 é " + quadrado(20));
		
	}

}
