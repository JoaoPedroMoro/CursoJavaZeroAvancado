package PolimorfismoSobrecargaDeMetodos;

/*
 * Neste programa conhecemos o polimorfismo override.
 * */

public class Main2 {

	public static void main(String[] args) {

		Animal a1 = new Animal();
		
		Animal a2 = new Cachorro();
		
		Animal a3 = new Gato();
		
		System.out.println("==== Testando polimorfismo com @Override ====");
		
		a1.emitirSom();
		
		a2.emitirSom();
		
		a3.emitirSom();

	}

}
