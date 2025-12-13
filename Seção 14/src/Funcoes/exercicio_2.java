package Funcoes;

public class exercicio_2 {
	
	public static int fatorial (int numero) {
		
		int total = 1;
		
		for (int i = numero ; i > 0 ; i--) {
			
			total *= i;
			
		}
		
		return total;
	}

	public static void main(String[] args) {

		System.out.println("1! = " + fatorial(1));
		
		System.out.println("2! = " + fatorial(2));
		
		System.out.println("3! = " + fatorial(3));
		
		System.out.println("4! = " + fatorial(4));
		
		System.out.println("5! = " + fatorial(5));
		
		System.out.println("6! = " + fatorial(6));
		
		System.out.println("7! = " + fatorial(7));
		
		System.out.println("8! = " + fatorial(8));
		
		System.out.println("9! = " + fatorial(9));
		
		System.out.println("10! = " + fatorial(10));
		

	}

}
