package Classes_e_objetos;

/*
 * Este exemplo é para introduzir a Orientação À Objetos. Criamos uma classe e um objeto dessa classe, além de utilizar métodos dela.
 * */

import java.util.Scanner;

public class exemplo_classes_e_objetos {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite o nome do carro: ");
		
		String nome = teclado.nextLine();
		
		System.out.println("Digite o modelo do carro: ");
		
		String modelo = teclado.nextLine();
		
		System.out.println("Digite o ano do carro: ");
		int ano = teclado.nextInt();
		
		Carro meuCarro = new Carro(nome, modelo, ano);
		
		meuCarro.exibirInformacoes();
		
		teclado.close();
		
	}

}

class Carro {
	
	String nome;
	String modelo;
	int ano;
	
	Carro(String nome, String modelo, int ano) {
		
		this.nome = nome;
		this.modelo = modelo;
		this.ano = ano;
		
	}
	
	void exibirInformacoes() {
		System.out.println("\n========== INFORMAÇÕES DO CARRO ==========");
		System.out.println("Nome: " + nome);
		System.out.println("Modelo: " + modelo);
		System.out.println("Ano: " + ano);
		System.out.println("============================================");
	}
}
