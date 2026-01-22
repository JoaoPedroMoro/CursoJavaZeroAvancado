package simulador;

import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JPanel {
	
	public interface OuvinteLogin {
		
		void aoTentarLogin(String nome, String senha);
		
		void aoSolicitarCriacaoConta();
		
	}
	
	private final JTextField campoNome = new JTextField();
	
	private final JPasswordField campoSenha = new JPasswordField();
	
	private final OuvinteLogin ouvinte;
	
	public TelaLogin(OuvinteLogin ouvinte) {
		
		super(new GridBagLayout());
		
		this.ouvinte = ouvinte;
		
		construirInterface();
		
	}
	
	public void construirInterface() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10, 10, 10, 10); // 10 pixels de espaçamento em cada canto
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel titulo = new JLabel("Login do Caixa Eletrônico", SwingConstants.CENTER);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 22));
		
		gbc.gridx = 0;
		
		gbc.gridy = 0;
		
		gbc.gridwidth = 2;
		
		add(titulo, gbc);
		
		gbc.gridwidth = 1;
		
		JLabel lblNome = new JLabel("Nome:");
		
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
		
		JButton btnEntrar = new JButton("Entrar");
		
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 18));
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(btnEntrar, gbc);
		
		JButton btnCriar = new JButton("Criar Conta");
		
		btnCriar.setFont(new Font("Arial", Font.BOLD, 18));
		
		gbc.gridx = 1;
		add(btnCriar, gbc);
		
		btnEntrar.addActionListener(e ->
        ouvinte.aoTentarLogin(campoNome.getText().trim(),
                              new String(campoSenha.getPassword())));
		
		btnCriar.addActionListener(e -> ouvinte.aoSolicitarCriacaoConta());
		
	}

}
