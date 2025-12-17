package desafios;

/*
 * O objetivo desse desafio é fazer a contagem de segundas-feiras no dia 1º em um intervalo
 * de dados. Deve solicitar ao usuário um intervalo de datas, com uma data início e uma data fim, e
 * contar quantas segundas-feiras caem no dia 1º de cada mÊs dentro desse intervalo. O programa deve
 * garantir que a data início seja anterior ou igual a data fim. Deve solicitar as datas ao usuário
 * no formato AAAA-MM-DD.*/

import java.util.*;
import java.time.*;
import java.time.format.DateTimeParseException;

public class desafio_21 {
	
	public static int contadorSegundas (LocalDate inicio, LocalDate fim) {
		
		int contador = 0;
		
		LocalDate dataAtual = inicio.withDayOfMonth(1);
		
		while (!dataAtual.isAfter(fim)) {
			
			if (!dataAtual.isBefore(inicio) && dataAtual.getDayOfWeek() == DayOfWeek.MONDAY) {
				
				contador++;
				
			}
			
			dataAtual = dataAtual.plusMonths(1);
			
		}
		
		return contador;
		
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		LocalDate inicio = null;
		
		LocalDate fim = null;
		
		while (true) {
			
			try {
				
				System.out.println("Digite a data inicial (AAAA-MM-DD): ");
				
				inicio = LocalDate.parse(entrada.nextLine());
				
				System.out.println("Digite a data final (AAAA-MM-DD): ");
				
				fim = LocalDate.parse(entrada.nextLine());
				
				if (inicio.isAfter(fim)) {
					
					System.out.println("A data inicial deve ser menor ou igual a data final.");
					
					continue;
					
				}
				
				break;
				
			} catch (DateTimeParseException e) {
				
				System.out.println("Formato de data inválido, tente novamente (Insira no formato AAAA-MM-DD).\n");
				
			}
			
		}
		
		int numDias = contadorSegundas(inicio, fim);
		
		System.out.println("\nA quantidade de segundas-feiras como dia 1º é " + numDias + " dias.");
		
		entrada.close();

	}

}
