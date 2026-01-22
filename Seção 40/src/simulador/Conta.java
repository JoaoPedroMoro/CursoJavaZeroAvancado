package simulador;

import java.text.NumberFormat; // Essa biblioteca irá formatar os valores de acordo com as regras monetárias do Brasil
import java.util.ArrayList;
import java.util.List;
import java.util.Locale; // Configurações regionais, formatando os números conforme o padrão brasileiro.

// A classe Conta representa uma conta bancária no simulador, encapsulando dados como nome do titular,
//			saldo e histórico das transações realizadas.
public class Conta {
	
	private static final NumberFormat NF = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
	
	// O bloco estático é executado automaticamente apenas uma vez assim que a classe é carregada pela JVM.
	static {
		
		NF.setMinimumFractionDigits(2);
		
		NF.setMaximumFractionDigits(2);
		
	}
	
	private final String nome;
	private final String senha;
	private double saldo;
	private final List<String> historico;
	
	public Conta(String nome, String senha, double saldo, List<String>historicoExistente) {
		
		this.nome = nome;
		this.senha = senha;
		this.saldo = saldo;
		this.historico = new ArrayList<>();
		
		if (historicoExistente != null) {
			
			this.historico.addAll(historicoExistente);
			
		}
		
	}
	
	public Conta(String nome, String senha, double saldoInicial) {
		
		this(nome, senha, saldoInicial, null);
		
		this.historico.add("Conta criada com saldo inicial de R$ " + NF.format(saldoInicial));
		
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double v) {
		this.saldo = v;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public List<String> getHistorico() {
		return historico;
	}
	
	public void adicionarHistorico(String linha) {
		
		historico.add(linha);
		
	}

}
