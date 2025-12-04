package Encapsulamento;

public class Exemplo {

	private String atributoPrivado = "Sou PRIVATE";
	
	String atributoDefault = "Sou DEFAULT";
	
	protected String atributoProtegido = "Sou PROTECTED";
	
	public String atributoPublico = "Sou PUBLIC";
	
	public void mostrarTudo() {
		
		System.out.println(atributoPrivado);
		
		System.out.println(atributoDefault);
		
		System.out.println(atributoProtegido);
		
		System.out.println(atributoPublico);
		
	}
}
