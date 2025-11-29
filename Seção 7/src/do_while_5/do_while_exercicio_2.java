package do_while_5;

/*
 * O objetivo do exercício é imprimir os números pares de 0 a 50 com o do-while.
 * */

public class do_while_exercicio_2 {

	public static void main(String[] args) {

		int numero = 0;
		
		do {
			
			if (numero % 2 == 0) {
				
				System.out.println(numero);
				
			}
			
			numero++;
			
		} while (numero <= 50);

	}

}
