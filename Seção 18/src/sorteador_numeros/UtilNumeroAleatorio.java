package sorteador_numeros;

import java.util.Random;

public final class UtilNumeroAleatorio {
	
	private static final Random GERADOR = new Random();
	
	public static int sortear(int minimo, int maximo) {
		
		// Gera um número inteiro [minimo, maximo]
		return GERADOR.nextInt((maximo - minimo) + 1) + minimo;
		
	}
	
	// Impede que a classe seja instanciada. Como ela é utilitária, não faz sentido criar objetos com ela. Fazendo isso, impedimos essa criação.
	private UtilNumeroAleatorio() {}

}
