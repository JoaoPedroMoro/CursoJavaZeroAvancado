package PolimorfismoSobrecargaDeMetodos;

public class Calculadora {

	// Esse ... indica que a quantidade de números é variável, o programa vai saber exatamente quantos são e calcular corretamente.
	public int somar(int... numeros) {
		
		int soma = 0;
		
		for (int n : numeros) {
			
			soma += n;
			
		}
		
		return soma;
		
	}
	
	public double somar(double... numeros) {
		
		double soma = 0;
		
		for (double n : numeros) {
			
			soma += n;
			
		}
		
		return soma;
		
	}

}
