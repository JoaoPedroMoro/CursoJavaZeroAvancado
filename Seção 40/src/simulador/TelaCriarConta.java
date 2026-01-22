package simulador;

import javax.swing.*;
import java.awt.*;

public class TelaCriarConta extends JPanel {
	
	public interface OuvinteCriarConta {
		
		void aoConfirmarCriacao(String nome, String senha, double saldoInicial);
		
		void aoVoltarLogin();
		
	}
	
	private final JTextField campoNome = new JTextField();
	
	private final JPasswordField campoSenha = new JPasswordField();
	
	private final JTextField campoSaldoInicial = new JTextField("0.00");
	
	private final OuvinteCriarConta ouvinte;
	
	public TelaCriarConta(OuvinteCriarConta ouvinte) {
		
		super(new GridBagLayout());
		
		this.ouvinte = ouvinte;
		
		construirInterface();
		
	}
	
	private void construirInterface() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(15, 15, 15, 15);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel titulo = new JLabel("Criar Conta", SwingConstants.CENTER);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 24));
		
		gbc.gridx = 0;
		
		gbc.gridy = 0;
		
		gbc.gridwidth = 2;
		
		add(titulo, gbc);
		
		gbc.gridwidth = 1;
		
		JLabel lblNome = new JLabel("Nome da conta:");
		
		lblNome.setFont(new Font("Arial", Font.PLAIN, 18));
		
		gbc.gridx = 0;
		
		gbc.gridy = 1;
		
		add(lblNome, gbc);
		
		campoNome.setFont(new Font("Arial", Font.PLAIN, 18));
		
		gbc.gridx = 1;
		
		add(campoNome, gbc);
		
		JLabel lblSenha = new JLabel("Senha:");
		
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		add(lblSenha, gbc);
		
		campoSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		
		gbc.gridx = 1;
		
		add(campoSenha, gbc);
		
		JLabel lblSaldo = new JLabel("Saldo inicial");
		
		lblSaldo.setFont(new Font("Arial", Font.PLAIN, 18));
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		
		add(lblSaldo, gbc);
		
		campoSaldoInicial.setFont(new Font("Arial", Font.PLAIN, 18));
		
		gbc.gridx = 1;
		
		add(campoSaldoInicial, gbc);
		
		JButton btnConfirmar = new JButton("Confirmar");
		
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 18));
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		add(btnConfirmar, gbc);
		
		JButton btnVoltar = new JButton("Voltar");
		
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));
		
		gbc.gridx = 1;
		
		add(btnVoltar, gbc);
		
		btnConfirmar.addActionListener(e -> confirmarCriacao());
		
		btnVoltar.addActionListener(e -> ouvinte.aoVoltarLogin());
		
	}
	
	private void confirmarCriacao() {
		
		String nome = campoNome.getText().trim();
		
		String senha = new String(campoSenha.getPassword()).trim();
		
		String saldo = campoSaldoInicial.getText().trim();
		
		if (nome.isEmpty() || senha.isEmpty() || saldo.isEmpty()) {
			
			JOptionPane.showMessageDialog(this, 
					"Preencha todos os campos!",
					"Aviso", JOptionPane.WARNING_MESSAGE);
			
			return;
			
		}
		
		double valor;
		
		try {

			valor = Double.parseDouble(saldo);
			
		} catch (NumberFormatException ex) {
			
			JOptionPane.showMessageDialog(this, 
					"Saldo inicial inválido (use ponto como separador decimal).",
					"Erro", JOptionPane.ERROR_MESSAGE
			);
			
			return;
			
		}
		
		ouvinte.aoConfirmarCriacao(nome, senha, valor);
		
	}

}
