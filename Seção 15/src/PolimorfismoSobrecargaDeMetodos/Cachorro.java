package PolimorfismoSobrecargaDeMetodos;

class Cachorro extends Animal {

	@Override
	public void emitirSom() {
		
		System.out.println("O cachorro late: au au!");
		
	}
	
}

class Gato extends Animal {
	
	@Override
	public void emitirSom() {
		
		System.out.println("O gato mia: miau!");
		
	}
	
}