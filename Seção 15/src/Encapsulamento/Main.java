package Encapsulamento;

public class Main {

	public static void main(String[] args) {

		Exemplo e = new Exemplo();
		
		System.out.println("===== Testando no MESMO pacote =====");
		
		System.out.println(e.atributoPublico);
		
		System.out.println(e.atributoDefault);
		
		System.out.println(e.atributoProtegido);
		
		System.out.println("\n\n");
		
//		System.out.println(e.atributoPrivado);
		
		e.mostrarTudo();
		
		System.out.println("\n\nExemplos classe Filha");
		
		Filha filha = new Filha();
		
		filha.Testar();

	}

}
