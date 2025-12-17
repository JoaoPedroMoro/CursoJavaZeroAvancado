package desafios;

/*
 * O objetivo desse desafio é receber uma lista com os dias da semana na seguinte ordem:
 * ['Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado', 'Domingo', 'Segunda']
 * 
 * Deve reordenar da seguinte forma: Segunda, Terça, Quarta, ...
 * */

import java.util.*;

public class desafio_25 {

	public static void main(String[] args) {

		ArrayList<String> diasDaSemana = new ArrayList<>();
		
		diasDaSemana.add("Terça");
		diasDaSemana.add("Quarta");
		diasDaSemana.add("Quinta");
		diasDaSemana.add("Sexta");
		diasDaSemana.add("Sábado");
		diasDaSemana.add("Domingo");
		diasDaSemana.add("Segunda");
		
		int indiceSegunda = diasDaSemana.indexOf("Segunda");
		
		ArrayList<String> ordenado = new ArrayList<>();
		
		for (int i = indiceSegunda ; i < diasDaSemana.size(); i++) {
			
			ordenado.add(diasDaSemana.get(i));
			
		}
		
		for (int i = 0 ;  i < indiceSegunda ; i++) {
			
			ordenado.add(diasDaSemana.get(i));
			
		}
		
		System.out.println("Antes de reordenar: " + diasDaSemana);
		
		System.out.println("Depois de reordenar: " + ordenado);

	}

}
