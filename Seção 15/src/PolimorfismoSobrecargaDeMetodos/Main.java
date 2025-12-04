package PolimorfismoSobrecargaDeMetodos;

/*
 * Este exemplo aborda sobre sobrecarga de métodos e polimorfismo.
 * */

public class Main {

	public static void main(String[] args) {

		Calculadora calc = new Calculadora();
		
		System.out.println("Soma de 5 + 3 = " + calc.somar(5, 3));
		
		System.out.println("Soma de 5 + 3 + 2 = " + calc.somar(5, 3, 2));
		
		System.out.println("Soma de 1 + 2 + 3 + 4 + 5 = " + calc.somar(1, 2, 3, 4, 5));
		
		System.out.println("Soma de 2.5 + 3.5 = " + calc.somar(2.5, 3.5));
		
		System.out.println("Soma de 1.1 + 2.2 + 3.3 + 4.4 = " + calc.somar(1.1, 2.2, 3.3, 4.4));

	}

}
