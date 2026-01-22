package simulador;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class TelaPrincipal extends JPanel {
	
	public interface OuvintePrincipal {
		
		void aoSolicitarHistorico(Conta conta);
		
		void aoLogout();
		
	}
	
	private final NumberFormat NF = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
	
	{
		
		NF.setMinimumIntegerDigits(2);
		
		NF.setMaximumFractionDigits(2);
		
	}
	
	private final RepositorioContas repositorio;
	
	private final OuvintePrincipal ouvinte;
	
	private JLabel lblUsuario = new JLabel();
	
	private JLabel lblSaldo = new JLabel();
	
	private JTextField campoValor = new JTextField();
	
	private Conta contaAtual;
	
	public TelaPrincipal(RepositorioContas repo, OuvintePrincipal ouv) {
		
		super(new GridBagLayout());
		
		this.repositorio = repo;
		
		this.ouvinte = ouv;
		
		construirInterface();
		
	}
	
	private void construirInterface() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(15, 15, 15, 15);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel titulo = new JLabel("Bem-vindo(a)!", SwingConstants.CENTER);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 24));
		
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.gridwidth = 3;
		add(titulo, gbc);
		
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		
		gbc.gridy = 1;
		add(lblUsuario, gbc);
		
		lblSaldo.setFont(new Font("Arial", Font.PLAIN, 20));
		
		gbc.gridy = 2;
		add(lblSaldo, gbc);
		
		JLabel lblValor = new JLabel("Valor:", SwingConstants.CENTER);
		
		lblValor.setFont(new Font("Arial", Font.PLAIN, 18));
		
		gbc.gridwidth = 1;
		gbc.gridy = 3;
		gbc.gridx = 0;
		add(lblValor, gbc);
		
		campoValor.setFont(new Font("Arial", Font.PLAIN, 18));
		
		gbc.gridx = 1;
		add(campoValor, gbc);
		
		JButton btnSacar = new JButton("Sacar");
		
		JButton btnDepositar = new JButton("Depositar");
		
		JButton btnHistorico = new JButton("Histórico");
		
		JButton btnSair = new JButton("Sair");
		
		for (JButton b : new JButton[]{btnSacar, btnDepositar, btnHistorico, btnSair})
		    b.setFont(new Font("Arial", Font.BOLD, 18));
		
		gbc.gridy = 4;
		gbc.gridx = 0; add(btnSacar, gbc);
		gbc.gridx = 1; add(btnDepositar, gbc);
		gbc.gridx = 2; add(btnHistorico, gbc);
		gbc.gridx = 0; gbc.gridy = 5;
		gbc.gridwidth = 3;
		add(btnSair, gbc);
		
		btnSacar.addActionListener(e -> realizarOperacao(false));
		btnDepositar.addActionListener(e -> realizarOperacao(true));
		btnHistorico.addActionListener(e -> {
			
			if (contaAtual != null) ouvinte.aoSolicitarHistorico(contaAtual);
			
		});
		btnSair.addActionListener(e -> ouvinte.aoLogout());
				
	}
	
	public void definirConta(Conta conta) {

		this.contaAtual = conta;
		
		atualizarLabels();
		
	}
	
	public void atualizarLabels() {
		
		if (contaAtual == null) return;
		
		lblUsuario.setText("Usuário: " + contaAtual.getNome());
		
		lblSaldo.setText("Saldo: R$ " + NF.format(contaAtual.getSaldo()));
		
		campoValor.setText("");
		
	}
		
	private void realizarOperacao(boolean deposito) {
	
		if (contaAtual == null) return;
		
		String texto = campoValor.getText().trim();
		
		if (texto.isEmpty()) {
			
			JOptionPane.showMessageDialog(this, 
					"Digite um valor para " + (deposito ? "depositar" : "sacar") + ".",
					"Aviso",
					JOptionPane.WARNING_MESSAGE);
			
			return;
			
		}
		
		double valor;
		
		try {
			
			valor = Double.parseDouble(texto);
			
		} catch (NumberFormatException ex) {
			
			JOptionPane.showMessageDialog(this, 
					"Valor inválido (use ponto como separador decimal).",
					"Erro",
					JOptionPane.WARNING_MESSAGE);
			
			return;
			
		}
		
		if (valor <= 0) {
			
			JOptionPane.showMessageDialog(this, 
					"O valor deve ser maior que zero!",
					"Erro",
					JOptionPane.WARNING_MESSAGE);
			
			return;
			
		}
		
		if (!deposito && contaAtual.getSaldo() < valor) {
			
			JOptionPane.showMessageDialog(this, 
					"Saldo insuficiente!",
					"Erro",
					JOptionPane.ERROR_MESSAGE);
			
			return;
			
		}
		
		if (deposito) {
			
			contaAtual.setSaldo(contaAtual.getSaldo() + valor);
			
			contaAtual.adicionarHistorico("Depósito de R$ " + NF.format(valor));
			
		} else {
			
			contaAtual.setSaldo(contaAtual.getSaldo() - valor);
			
			contaAtual.adicionarHistorico("Saque de R$ " + NF.format(valor));
			
		}
		
		// Salva a conta atual no repositório de contas.
		// Isso garante que o novo saldo e o histórico atualizado 
    	//			sejam gravados em arquivo.
		// `getWindowAncestor(this)` obtém a janela (JFrame) 
    	//			que contém este painel, permitindo que a 
    	//			operação de salvamento tenha contexto para 
    	//			exibir mensagens, se necessário.
		repositorio.salvar(contaAtual, (JFrame) SwingUtilities.getWindowAncestor(this));
		
		atualizarLabels();
		
		JOptionPane.showMessageDialog(this, 
				(deposito ? "Depósito" : "Saque") + " realizado com sucesso!",
				"Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
		
	}

}
