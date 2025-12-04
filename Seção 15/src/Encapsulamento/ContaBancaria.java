package Encapsulamento;

public class ContaBancaria {

	

	private String nomeTitular;
	
	private String cpfTitular;
	
	private double saldo;
	
	String tipoConta = "Conta Corrente";
	
	protected String agencia = "0001";
	
	public ContaBancaria(String nomeTitular, String cpfTitular, double saldoInicial) {
		
		setNomeTitular(nomeTitular);
		
		setCpfTitular(cpfTitular);
		
		setSaldo(saldoInicial);
		
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public String getCpfTitular() {
		return mascaraCpf(cpfTitular);
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setNomeTitular(String novoNome) {
		
		if (novoNome != null && !novoNome.isBlank()) {
			
			this.nomeTitular = novoNome.trim();
			
		} else {
			
			this.nomeTitular = "Titular não informado";
		}
		
	}

	public void setCpfTitular(String novoCpf) {
		
		if(novoCpf == null) {
			
			this.cpfTitular = "";
			
		} else {
			
			this.cpfTitular = novoCpf.replaceAll("\\D", "");
			
		}
			
	}

	public void setSaldo(double novoSaldo) {
		
		this.saldo = Math.max(0.0,  novoSaldo);
		
	}
	
	public void depositar(double valor) {
		
		if (valor > 0) {
			
			this.saldo  += valor;
			
		}
		
	}
	
	public boolean sacar(double valor) {
		
		if (valor > 0 && valor <= saldo) {
			
			this.saldo -= valor;
			
			return true;
			
		}
		
		return false;
		
	}
	
	private String mascaraCpf (String cpfApenasDigitos) {
		
		if (cpfApenasDigitos == null || cpfApenasDigitos.length() < 3) {
			
			return "**cpf inválido*";
			
		}
		
		if (cpfApenasDigitos.length() == 11) {
			
			return cpfApenasDigitos.substring(0, 3) + ".***.***-**";
			
		}
		
		return "***.***.***-**";
		
	}
	
	public void exibirResumo() {
		
		System.out.println("\n========== RESUMO DA CONTA ==========");
		
		System.out.println("Nome do titular: " + getNomeTitular());
		
		System.out.println("CPF do titular : " + getCpfTitular());
		
		System.out.printf("Saldo Atual: R$ %.2f%n", getSaldo());
		
		System.out.println("Agência: " + agencia);
		
		System.out.println("Tipo da conta: " +  tipoConta);
		
		System.out.println("=======================================");
		
	}
	


}
