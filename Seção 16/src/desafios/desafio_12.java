package desafios;

/*
 * O objetivo desse programa é formatar nomes no formato americano Sobrenome, Nome
 * */

public class desafio_12 {
	
	public static String sobrenomeAmericano (String nome, String sobrenome) {
		
		return sobrenome + ", " + nome;
		
	}

	public static void main(String[] args) {

		System.out.println(sobrenomeAmericano("João Pedro" , "Moro Bolognini"));
		
		System.out.println(sobrenomeAmericano("João" , "da Costa"));
		
		System.out.println(sobrenomeAmericano("Albert" , "Eistein"));

	}

}
