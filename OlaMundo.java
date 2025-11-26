// Declara o pacote onde esta classe está localizada.
// Pacotes são usados para organizar classes relacionadas em grupos lógicos.
// Aqui, estamos dizendo que esta classe pertence ao pacote chamado "logica".
package logica;

//Declaração da classe pública chamada "OlaMundo".
// Em Java, todo programa é construído em torno de classes.
// A palavra-chave "public" significa que esta classe pode ser acessada por qualquer outra classe.
// O nome da classe deve ser o mesmo nome do arquivo (OlaMundo.java) com a primeira maiúscula por convenção
public class OlaMundo {

	// Este é o método principal do programa, o ponto de entrada da aplicação Java.
	// Quando você executa um programa Java, o método main é o primeiro a ser chamado.
	// "public" significa que esse método pode ser chamado por qualquer parte do programa.
	// "static" significa que ele pode ser chamado sem criar um objeto da classe.
	// "void" significa que este método não retorna nenhum valor.
	// "main" é o nome especial reconhecido pela JVM como ponto de partida do programa.
	// "String [] args" é um parâmetro que representa uma lista (vetor) de Strings, que pode ser usado para 
	//		receber argumentos da linha de comando, se desejado.
	public static void main(String[] args) {
		
		// Comando que imprime uma linha de texto no console (terminal).
		// "System" é uma classe da biblioteca padrão do Java.
		System.out.println("Olá, Mundo!");

	}

}
