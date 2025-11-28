package while_4;

/*
 * O objetivo deste exercício é imprimir os números pares de 0 a 50 usando o while.
 * */

public class while_exercicio_2 {

	public static void main(String[] args) {
		
		int contador = 0;
		
		while (contador <= 50) {
			
			if (contador % 2 == 0) {
				
				System.out.println(contador);
				
			}
			
			contador++;
			
		}

	}

}
