package desafios;

import java.util.Scanner;

/*
 * O objetivo desse programa é criar uma classe com um atributo privado interno que armazena uma string
 * e fornece tres metodos: receber a string do usuario, converter essa string para uppercase e
 *  exibir a string convertida
 *  */

public class desafio_15 {
	
	private String texto;
	
	public desafio_15() {
		
		this.texto = "";
		
	}
	
	public void receberString() {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite uma string: ");
		
		this.texto = entrada.nextLine();
		
		entrada.close();
		
	}
	
	public String converteMaiuscula() {
		
		return this.texto.toUpperCase();
		
	}
	
	public void exibirResultado () {
		
		System.out.println(converteMaiuscula());
	}

	public static void main(String[] args) {

		desafio_15 manipulador = new desafio_15();
		
		manipulador.receberString();
		
		manipulador.exibirResultado();
		
	}

}
