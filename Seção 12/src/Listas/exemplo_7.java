package Listas;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class exemplo_7 {

	public static void main(String[] args) {

		ArrayList<Integer> dobrosTradicional = new ArrayList<>();
		
		for (int numero = 0; numero < 5 ;numero++) {
			
			int dobro = numero * 2;
			
			dobrosTradicional.add(dobro);
			
		}
		
		System.out.println("Dobros com for tradidional: " + dobrosTradicional);
		
		ArrayList<Integer> dobrosComStream = IntStream.range(0, 5).map(x -> x*2).boxed().collect(Collectors.toCollection(ArrayList::new));
		
		System.out.println("Dobros com list comprehension (Stream): " + dobrosComStream);
		
		System.out.println(
				"Dobros com list comprehension (enxuto): " + 
						IntStream.range(0, 5)
								 .map(x -> x * 2)
								 .boxed()
								 .toList()
		);

	}

}
