package desafios;

/*
 * O objetivo desse programa é receber uma data no formato DD/MM/AAAA e retornar no seguinte formato
 * DD de mês de AAAA. Deve retornar null se o mês ou o dia não existirem.
 * */

import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class desafio_8 {
	
	private static final String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
										   "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
	
	public static String ajustaData(String data) {
		
		try {
			
			// Cria um objeto SimpleDateFormat para definir o formato da data
			// "dd/MM/yyyy" significa: dia/mês/ano (ex: 25/12/2025)
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

			// Define que o formato NÃO será flexível
			// Ou seja, datas inválidas como 32/01/2025 ou 31/02/2024 vão gerar erro
			formato.setLenient(false);

			// Converte a String 'data' (ex: "15/08/2023") para um objeto Date
			Date data1 = formato.parse(data);

			// Cria uma instância da classe Calendar usando a data e hora atuais
			Calendar calendario = Calendar.getInstance();

			// Define a data do calendário com a data convertida (data1)
			calendario.setTime(data1);

			// Obtém o dia do mês (1 a 31)
			int dia = calendario.get(Calendar.DAY_OF_MONTH);

			// Obtém o mês (IMPORTANTE: o mês começa em 0 → Janeiro = 0, Fevereiro = 1, etc.)
			int mes = calendario.get(Calendar.MONTH);

			// Obtém o ano (ex: 2025)
			int ano = calendario.get(Calendar.YEAR);

			// Retorna a data no formato por extenso
			// Exemplo de saída: "15 de Agosto de 2023"
			// O array 'meses' deve conter os nomes dos meses
			return dia + " de " + meses[mes] + " de " + ano;

		} catch (ParseException e) {
			
			return "NULL";
		}
		
	}

	public static void main(String[] args) {

		System.out.println(ajustaData("10/01/2025"));
		
		System.out.println(ajustaData("31/01/2025"));
		
		System.out.println(ajustaData("30/02/2025"));
		
		System.out.println(ajustaData("10/21/2025"));
		
		System.out.println(ajustaData("31/04/2025"));

	}

}
