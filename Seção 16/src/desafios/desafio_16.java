package desafios;

/*
 * O objetivo desse programa é implementar uma estrutura orientada a objetos para o cadastro de veiculos.
 * Cada veiculo deve ser descrito com marca, modelo, ano, cort e valor. A estrutura deve permitir o 
 * cadastrp de multiplos veiculos e o sistema deve exibir as informaççoes completas de cada veiculo,
 * além do identificador de memoria do objeto correspondente.
 * */

public class desafio_16 {
	
	private String marca;
	private String modelo;
	private int ano;
	private String cor;
	private double valor;
	
	public desafio_16(String marca, String modelo, int ano, String cor, double valor) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.valor = valor;
		
	}
	
	public void exibeInformacoes() {
		
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Ano: " + ano);
		System.out.println("Cor: " + cor);
		System.out.printf("Valor: R$.2f\n ", valor);
		System.out.println("ID do objeto na memória: " + System.identityHashCode(this));
		System.out.println("x---x---x---x---x---x---x---x---x---x---x---x---x");
	}

	public static void main(String[] args) {

		desafio_16 carro1 = new desafio_16("Toyota", "Corolla", 2019, "Branco", 76.900);
		
		desafio_16 carro2 = new desafio_16("Fiat", "Pulse", 2023, "Vermelho", 106.900);
		
		desafio_16 carro3 = new desafio_16("Chevrolet", "Camaro", 2022, "Azul", 299.900);
		
		carro1.exibeInformacoes();
		
		carro2.exibeInformacoes();
		
		carro3.exibeInformacoes();

	}

}
