package Listas;

import java.util.ArrayList;

import java.util.Arrays;

public class exemplo_2 {

	public static void main(String[] args) {

		System.out.println("========== Lista de notas de um aluno ==========");
		
		ArrayList<Integer> notasAluno = new ArrayList<>(Arrays.asList(86, 100, 56, 47, 95));
		
		System.out.println("Notas do aluno: " + notasAluno);
		
		String mensagem = "Olá";
		
		System.out.println("Mensagem: " + mensagem);
		
		System.out.println("Tipo: String");
		
		ArrayList<String> listaStrings = new ArrayList<>(Arrays.asList("Olá, mundo"));
		
		System.out.println("Lista de Strings: " + listaStrings);
		
		ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3));
		
		System.out.println("Lista padrão: " + lista);
		
		lista.set(0,  100);
		
		lista.set(1, 50);
		
		System.out.println("Lista alterada: " + lista);

	}

}
