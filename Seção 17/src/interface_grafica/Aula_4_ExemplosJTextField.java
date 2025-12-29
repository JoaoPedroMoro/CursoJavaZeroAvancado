package interface_grafica;

import javax.swing.*;

import java.awt.*;

public class Aula_4_ExemplosJTextField {

	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Exemplos JTextField");
		
		janela.setSize(500,400);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new GridLayout(3, 1, 10, 10));
		
		JPanel painelLogin = new JPanel(new FlowLayout());
		
		painelLogin.setBorder(BorderFactory.createTitledBorder("Login Simples."));
		
		JLabel rotuloUsuario = new JLabel("Usuário.");
		
		JTextField campoUsuario = new JTextField(10);
		
		JButton botaoLogin = new JButton("Entrar");
		
		botaoLogin.addActionListener(e -> {
			JOptionPane.showMessageDialog(
					janela, // Janela pai do diálogo
					"Bem-vindo, " + campoUsuario.getText() + "!", // mensagem de boas-vindas
					"Login", // título da janelad e diálogo 
					JOptionPane.INFORMATION_MESSAGE // tipo de ícone exibido
			);
		});
		
		painelLogin.add(rotuloUsuario);
		
		painelLogin.add(campoUsuario);
		
		painelLogin.add(botaoLogin);
		
		JPanel painelValidacao = new JPanel(new FlowLayout());
		
		painelValidacao.setBorder(BorderFactory.createTitledBorder("Validação de número"));
		
		JLabel rotuloNumero = new JLabel("Digite um número");
		
		JTextField campoNumero = new JTextField(8);
		
		JButton botaoVerificar = new JButton("Verificar");
		
		botaoVerificar.addActionListener(e -> {
			
			try {
				
				int numero = Integer.parseInt(campoNumero.getText());
				
				JOptionPane.showMessageDialog(
						janela,
						"Você digitou o número " + numero,
						"Número válido",
						JOptionPane.INFORMATION_MESSAGE
				);
				
			} catch (NumberFormatException exc) {
				
				JOptionPane.showMessageDialog(
						janela,
						"Digite apenas números",
						"Erro",
						JOptionPane.ERROR_MESSAGE
				);
				
			}
		});
		
		
		painelValidacao.add(rotuloNumero);
		
		painelValidacao.add(campoNumero);
		
		painelValidacao.add(botaoVerificar);
		
		JPanel painelPesquisa = new JPanel(new BorderLayout());
		
		painelPesquisa.setBorder(BorderFactory.createTitledBorder("Pesquisa simulada"));
		
		JPanel painelTopo = new JPanel(new FlowLayout());
		
		JLabel rotuloPesquisa = new JLabel("Pesquisar");
		
		JTextField campoPesquisa = new JTextField(15);
		
		JButton botaoPesquisar = new JButton("Pesquisar");
		
		JTextArea resultados = new JTextArea(5, 25);
		
		resultados.setEditable(false);
		
		JScrollPane rolagemResultados = new JScrollPane(resultados);
		
		botaoPesquisar.addActionListener(e -> {
			
			String termo = campoPesquisa.getText();
			
			resultados.setText("Resultados para \"" + termo + "\" : \n");
			
			resultados.append("- Exemplo 1\n");
			
			resultados.append("- Exemplo 2\n");
			
			resultados.append("- Exemplo 3\n");
			
		});
		
		painelTopo.add(rotuloPesquisa);
		
		painelTopo.add(campoPesquisa);
		
		painelTopo.add(botaoPesquisar);
		
		painelPesquisa.add(painelTopo, BorderLayout.NORTH);
		
		painelPesquisa.add(rolagemResultados, BorderLayout.CENTER);
		
		janela.add(painelLogin);
		
        janela.add(painelValidacao);
        
        janela.add(painelPesquisa);
        
        janela.setVisible(true);
		
	}

}
