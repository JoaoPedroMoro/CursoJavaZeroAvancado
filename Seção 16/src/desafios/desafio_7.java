package desafios;

import java.util.InputMismatchException;

/*
 * O objetivo desse programa é pedir as 4 notas de 10 alunos e calcular e armazenar a média
 * dessas notas em um vetor, informando quem está acima da média de 7.0
 * */

import java.util.Scanner;

public class desafio_7 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		double[] medias = new double[10];
		
		int contador = 0;
		
		double[] notasAluno = new double[4];
		
		for (int i = 0; i < 40 ;) {
			
			if (i % 4 == 0) notasAluno = new double[4];
			
			try {
				
				System.out.println("Digite a " + ((i%4)+1)+"º nota do " + (contador+1) + "º aluno: ");
				
				double nota = entrada.nextDouble();
				
				notasAluno[i%4] = nota;
				
				i++;
				
			} catch (InputMismatchException e) {
				
				entrada.nextLine();
				
				System.out.println("Número inválido, tente novamente inserir um número.");
				
			}
			
			if (i % 4 == 0) {
				
				medias[contador] = (notasAluno[0] + notasAluno[1] + notasAluno[2] + notasAluno[3])/4;
				
				contador++;
				
			}
		}
		
		for (int i = 0 ; i < 10 ; i++) {
			
			System.out.println("Média do " + (i + 1) + "º aluno: " + medias[i]);
		}
		
		entrada.close();

	}

}
