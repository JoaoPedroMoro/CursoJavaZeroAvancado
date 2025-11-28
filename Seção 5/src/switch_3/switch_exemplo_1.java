package switch_3;
/*
 * Código para aprender sobre a função switch, que é de escolha.
 * O objetivo desse exemplo é criar um ssitema que pergunte ao usuário sua cor favorita entre três:
 * 1 - Azul;
 * 2 - Verde;
 * 3 - Vermelho.
 * */
 
import java.util.Scanner;

public class switch_exemplo_1 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Escolha sua cor favorita entre as três a seguir: ");
		
		System.out.println("1 - Azul");
		
		System.out.println("2 - Verde");
		
		System.out.println("3 - Vermelho");
		
		System.out.println("Digite o número da sua cor favorita: ");
		
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			
			case 1:
				
				System.out.println("Você escolheu a cor azul!");
				
				break;
				
			case 2:
				
				System.out.println("Você escolheu a cor verde!");
				
				break;
				
			case 3:
				
				System.out.println("Você escolheu a cor vermelha!");
				
				break;
				
			default:
				
				System.out.println("Você escolheu a opção inválida!");
				 
				break;
			
		}
		
		entrada.close();

	}

}
