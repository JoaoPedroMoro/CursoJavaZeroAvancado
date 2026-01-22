package GeradorCPFInterface;

import java.util.Random;

public class CpfUtil {
	
	private CpfUtil() {}
	
	public static String gerarCpf() {
		
		Random r = new Random();
		
		int[] cpf = new int[11];
		
		for (int i = 0; i < 9; i++) {
			
			cpf[i] = r.nextInt(10);
			
		}
		
		int soma1 = 0;
		
		for (int i = 0; i < 9; i++) {
			
			soma1 += cpf[i] * (10 - i);
			
		}
		
		int digito1 = soma1 % 11;
		
		cpf[9] = (digito1 < 2) ? 0 : 11 - digito1;
		
		int soma2 = 0;
		
		for (int i = 0; i < 10 ;i++) {
			
			soma2 += cpf[i] * (11 - i);
			
		}
		
		int digito2 = soma2 % 11;
		
		cpf[10] = (digito2 < 2) ? 0 : 11 - digito2;
		
		return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", cpf[0], cpf[1], cpf[2], cpf[2], cpf[3], cpf[4], cpf[5],
														cpf[6], cpf[7], cpf[8], cpf[9], cpf[10]);
		
	}
	
	public static boolean validarCpf(String cpfDigitos) {
		
		if (cpfDigitos == null || cpfDigitos.length() != 11 || cpfDigitos.matches("(\\d)\\1{10}")) {
			
			return false;
			
		}
		
		int[] num = new int[11];
		
		for (int i = 0; i < 11; i++) {
			
			num[i] = Integer.parseInt(cpfDigitos.substring(i, i + 1));
			
		}
		
		int soma1 = 0;
		
		for (int i = 0; i < 9; i++) {
			
			soma1 += num[i] * (10 - i);
			
		}
		
		int digito1 = (soma1 % 11 < 2) ? 0 : 11 - (soma1 % 11);
		
		if (num[9] != digito1) return false;
		
		int soma2 = 0;
		
		for (int i = 0; i < 10; i++) {
			
			soma2 += num[i] * (11 - i);
			
		}
		
		int digito2 = (soma2 % 11 < 2) ? 0 : 11 - (soma2 % 11);
		
		return num[10] == digito2;
		
	}

}
