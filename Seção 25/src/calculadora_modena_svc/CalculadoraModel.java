package calculadora_modena_svc;

public class CalculadoraModel {
	
	private double primeiroNumero;
	
	private double segundoNumero;
	
	private String operadorAtual;
	
	public CalculadoraModel() {
		
		primeiroNumero = 0;
		
		segundoNumero = 0;
		
		operadorAtual = "";
		
	}
	
	public void definirPrimeiroNumero(double valor) {
		
		primeiroNumero = valor;
		
	}
	
	public void definirSegundoNumero (double valor) {
		
		segundoNumero = valor;
		
	}
	
	public void definirOperador(String op) {
		
		operadorAtual = op;
		
	}
	
	public void limpar() {
		
		primeiroNumero = 0;
		
		segundoNumero = 0;
		
		operadorAtual = "";
		
	}
	
	public double calcular() throws ArithmeticException {
		
		double resultado = 0;
		
		switch (operadorAtual) {
		
			case "+":
				resultado = primeiroNumero + segundoNumero;
				
				break;
			
			case "-":
				resultado = primeiroNumero - segundoNumero;
				
				break;
				
			case "×":
				resultado = primeiroNumero * segundoNumero;
				
				break;
				
			case "÷":
				if (segundoNumero == 0) {
					
					throw new ArithmeticException("Divisão por zero");
					
				}
				
				resultado = primeiroNumero / segundoNumero;
				
				break;
				
			default:
				resultado = primeiroNumero;
				
				break;
		}
		
		return resultado;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
