package desafios;

/*
 * O programa consiste em ser um microcomputador para um pescador controlar seu rendimento diário.
 * Sempre que o pescador traz mais de 50 kg, ele deve pagar 8 reais por quilo adicional.
 * Deve mostrar ao término do programa quantos quilos deu, quantos quilo de excesso e o valor da multa*/

public class desafio_10 {
	
	public static void pesca(double peso) {
		
		if (peso <= 0) {
			
			System.out.println("Insira um valor positivo.");
			
			return;
			
		}
		
		if (peso > 50) {
			
			double excedente = peso - 50;
			 
			int valor = (int)excedente*8;
			
			if  (excedente % 1 != 0) valor+= 8;
			
			System.out.println("Você trouxe um total de " + peso + " quilos de peixe, terá de pagar pelos " + 
			excedente + " quilos a mais que você trouxe, pagando uma multa de R$ " + valor + ".");
			
		} else {
			
			System.out.println("Você trouxe um total de " + peso + " quilos de peixe, e não "
					+ "precisará pagar a multa.");
		
		}
		
	}

	public static void main(String[] args) {


		pesca(48.7);
		
		pesca(13.9);
		
		pesca(56.7);
		
		pesca(89.5);
		
		pesca(-1);

	}

}
