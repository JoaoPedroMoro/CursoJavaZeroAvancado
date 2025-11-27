package logica;

public class Operadores_aritmeticos_relacionais_e_logico {

	public static void main(String[] args) {
		
		mostrarOperadoresAritmeticos();
		System.out.println("-------------------------");
		mostrarOperadoresRelacionais();
		System.out.println("-------------------------");
		mostrarOperadoresLogicos();

	}
	
	public static void mostrarOperadoresAritmeticos() {
		
		int a = 10;
		
		int b = 3;
		
		System.out.println("Soma: " + (a + b));
		
		System.out.println("Diferença: " + (a - b));
		
		System.out.println("Multiplicação: " + (a * b));
		
		System.out.println("Divisão: " + (a / b));
		
		System.out.println("Resto da divisão: " + (a % b));
		
	}
	
	public static void mostrarOperadoresRelacionais() {
		int x = 10;
		
		int y = 20;
		
		System.out.println("x é igual a y? " + (x == y));
		
		System.out.println("x é diferente a y? " + (x != y));
		
		System.out.println("x é maior que a y? " + (x > y));
		
		System.out.println("x é menor que a y? " + (x < y));
		
		System.out.println("x é maior ou igual a y? " + (x >= y));
		
		System.out.println("x é menor ou igual a y? " + (x <= y));
	}

	public static void mostrarOperadoresLogicos() {
		int idade = 18;
		
		boolean temCarteira = true;
		
		boolean podeDirigir = (idade >=18) && temCarteira; // Condição E
		
		boolean podeViajarSozinho = (idade >= 18) || temCarteira; // Condição OU
		
		boolean naoTemCarteira = !temCarteira; // Condição NÃO
		
		System.out.println("Pode dirigir? " + podeDirigir);
		
		System.out.println("Pode viajar sozinho? " + podeViajarSozinho);
		
		System.out.println("Não tem carteira? " + naoTemCarteira);
	}
}
