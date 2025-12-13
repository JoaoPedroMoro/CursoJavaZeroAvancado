package Funcoes;

public class exemplo_2 {
	
	public static void mensagem (String mensagem, int qtde) {
		
		for (int i = 0 ; i < qtde ; i++) {
			
			System.out.println(mensagem);
			
		}
		
	}
	
	public static int absoluto (int num) {
		
		return -num;
		
	}
	
	public static boolean multiplo(int multiplicador, int multiplo) {
		
		return multiplicador % multiplo == 0;
		
	}
	
	public static char primeiraLetra(String nome) {
		
		return nome.charAt(0);
	}
	
	

	public static void main(String[] args) {


		mensagem("Estudando funções em Java" , 5);
		
		mensagem("13/12/2025" , 3);
		
		System.out.println("--------------------------");
		
		System.out.println("O valor absoluto de 3 é " + absoluto(3));
		
		System.out.println("O valor absoluto de -3 é " + absoluto(-3));
		
		System.out.println("O valor absoluto de 0 é " + absoluto(0));
		
		System.out.println("--------------------------");
		
		System.out.println("16 é multiplo de 4? " + multiplo(16, 4));
		
		System.out.println("10 é multiplo de 3? " + multiplo(10, 3));
		
		System.out.println("--------------------------");
		
		System.out.println("A primeira letra do nome 'João' é " + primeiraLetra("João"));
		
		System.out.println("A primeira letra do nome 'Luiza' é " + primeiraLetra("Luiza"));

	}

}
