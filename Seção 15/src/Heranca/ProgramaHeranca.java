package Heranca;

/*
 * O intuito desse exemplo é conhecer sobre a herança dentro de POO.
 * */

import Heranca.AlunoEscolaFilho;

import Heranca.AlunoEscolaNeto;

public class ProgramaHeranca {

	public static void main(String[] args) {
		
		AlunoEscolaFilho dadosEscolaFilho = new AlunoEscolaFilho();
		
		dadosEscolaFilho.imprimirNaTela();
		
		AlunoEscolaNeto dadosEscolaNeto = new AlunoEscolaNeto();
		
		dadosEscolaNeto.imprimirNaTela();
		
		dadosEscolaNeto.nome = "Alfredo Alves";
		
		dadosEscolaNeto.idade = 38;
		
		dadosEscolaNeto.imprimirNaTela();
		
	}

}
