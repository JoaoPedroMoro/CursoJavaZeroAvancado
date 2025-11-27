package if_2;
/*
 * O objetivo desse exercício é verificar se o aluno foi aprovado com base na média de duas notas.
 * */

import java.util.Scanner;

public class Exercicio_8 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a primeira nota do aluno: ");
		
		double nota1 = entrada.nextDouble();
		
		System.out.println("Digite a segunda nota do aluno: ");
		
		double nota2 = entrada.nextDouble();
		
		if ((nota1 + nota2)/2 >= 7) {
			
			System.out.println("O aluno foi aprovado!");
			
		} else if ((nota1 + nota2)/2 >=5) {
			
			System.out.println("O aluno está de recuperação!");
			
		} else {
			
			System.out.println("O aluno foi reprovado!");
			
		}
		
		entrada.close();

	}

}
