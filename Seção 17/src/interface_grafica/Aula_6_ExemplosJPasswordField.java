package interface_grafica;

import javax.swing.*;

import java.awt.*;

public class Aula_6_ExemplosJPasswordField {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Exemplos JPasswordField");
		
		janela.setSize(400, 350);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new GridLayout(3, 1, 10, 10));
		
		// Login simples com senha
		
		JPanel painelLogin = new JPanel(new FlowLayout());
		
		painelLogin.setBorder(BorderFactory.createTitledBorder("Login"));
		
		JLabel rotuloUsuario = new JLabel("Usuário: ");
		
		JTextField campoUsuario = new JTextField(10);
		
		JLabel rotuloSenha = new JLabel("Senha");
		
		JPasswordField campoSenha = new JPasswordField(10);
		
		JButton botaoEntrar = new JButton("Entrar");
		
		botaoEntrar.addActionListener(e -> {
			
			String usuario = campoUsuario.getText();
			
			String senha = new String(campoSenha.getPassword());
			
			if (usuario.equals("admin") && senha.equals("1234")) {
				
				JOptionPane.showMessageDialog(janela, "Login bem-sucedido!");
				
			} else {
				
				JOptionPane.showMessageDialog(janela, "Usuário ou senha incorretos!");
				
			}
		});
		
		painelLogin.add(rotuloUsuario);
		
		painelLogin.add(campoUsuario);
		
		painelLogin.add(rotuloSenha);
		
		painelLogin.add(campoSenha);
		
		painelLogin.add(botaoEntrar);
		
		// Mostrar/Ocultar a senha digitada
		JPanel painelMostrar = new JPanel(new FlowLayout());
		
		painelMostrar.setBorder(BorderFactory.createTitledBorder("Mostrar/Ocultar Senha"));
		
		JPasswordField campoSenha2 = new JPasswordField(10);
		
		JCheckBox checkMostrar = new JCheckBox("Mostrar senha");
		
		checkMostrar.addActionListener(e -> {
			
			if (checkMostrar.isSelected()) {
				
				campoSenha2.setEchoChar((char) 0); // mostra os caracteres
				
			} else {
				
				campoSenha2.setEchoChar('•'); // Mostra •, que é o padrão de senha
				
			}
			
		});
		
		painelMostrar.add(new JLabel("Senha: "));
		
		painelMostrar.add(campoSenha2);
		
		painelMostrar.add(checkMostrar);
		
		// Verificação da força de senha
		JPanel painelForca = new JPanel(new BorderLayout());
		
		painelForca.setBorder(BorderFactory.createTitledBorder("Força da senha"));
		
		JPasswordField campoSenha3 = new JPasswordField(15);
		
		JLabel labelForca = new JLabel("Digite a senha ...");
		
		labelForca.setHorizontalAlignment(SwingConstants.CENTER);
		
		campoSenha3.addCaretListener(e -> {
			
			String senha = new String(campoSenha3.getPassword());
			
			if (senha.length() < 4) {
				
				labelForca.setText("Fraca");
				
				labelForca.setForeground(Color.RED);
				
			} else if (senha.length() < 8) {
				
				labelForca.setText("Média");
				
				labelForca.setForeground(Color.ORANGE);
				
			} else {
				
				labelForca.setText("Forte");
				
				labelForca.setForeground(Color.GREEN);
				
			}
			
		});
		
		painelForca.add(campoSenha3, BorderLayout.NORTH);
		
		painelForca.add(labelForca, BorderLayout.CENTER);
		
		janela.add(painelLogin);
		
		janela.add(painelMostrar);
		
		janela.add(painelForca);
		
		janela.setVisible(true);

	}

}
