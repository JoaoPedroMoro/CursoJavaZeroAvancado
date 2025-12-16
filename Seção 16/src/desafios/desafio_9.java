package desafios;

/*
 * O objetivo desse programa é ler 2 strings e informar o conteúdio de cada uma e seu comprimento,
 * se ambas possuem o mesmo conteúdo e se ambas possuem o mesmo tamanho
 * */


public class desafio_9 {
	
	public static void comparaString (String str1, String str2) {
		
		System.out.println("String 1 tem o conteúdo '" + str1 + "' e o tamanho " + str1.length());
		
		System.out.println("String 2 tem o conteúdo '" + str2 + "' e o tamanho " + str2.length());
		
		System.out.println("Elas possuem o mesmo conteúdo? " + (str1==str2));
		
		System.out.println("Elas possuem o mesmo tamanho? " + (str1.length()==str2.length()));
		
		System.out.println();
		
	}

	public static void main(String[] args) {

		String string1 = "Olá, pessoal, tudo bem?";
		
		String string2 = "Esse é um código em Java";
		
		String string3 = "Abcedário";
		
		String string4 = "Abcedário";
		
		String string5 = "Boa tarde";
		
		
		comparaString(string1, string2);
		comparaString(string1, string3);
		comparaString(string1, string5);
		comparaString(string2, string3);
		comparaString(string2, string5);
		comparaString(string3, string4);
		comparaString(string3, string5);

	}

}
