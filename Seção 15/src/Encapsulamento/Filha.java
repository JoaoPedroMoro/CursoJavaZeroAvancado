package Encapsulamento;

import Encapsulamento.Exemplo;

public class Filha extends Exemplo{

	public void Testar() {
		
		System.out.println("===== Testando em SUBCLASSE de outro pacote =====");
		
//		System.out.println(atributoPrivado);
		
		System.out.println(atributoDefault);
		
		System.out.println(atributoProtegido);
		
		System.out.println(atributoPublico);
	}
	
}
