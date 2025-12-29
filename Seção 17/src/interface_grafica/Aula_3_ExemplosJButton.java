package interface_grafica;

import javax.swing.*;

import javax.swing.border.EmptyBorder; //Uma borda vazia que adiciona margens internas. Padding entre o conteúdo e as bordas do painel

import java.awt.*;

import java.net.URL; // Importamos URL para localizar recursos (imagens) no classpath.

public class Aula_3_ExemplosJButton {

	public static void main(String[] args) {
		
		try {
			
			// Solicita ao UIManager a classe do LookAndFeel do sistema atual
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (Exception ignore) {
			
			// Isso vai impedir que o programa seja interrompido, se falhar vai seguir com o padrão do java.
			
		}
		
		JFrame janela = new JFrame("Exemplo JButton Melhorado");
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new BorderLayout(10,10));
		
		JPanel painelCentro = new JPanel(new GridLayout(4, 1, 10, 10));
		
		// Adicionando uma borda interna ao painel, um padding.
		painelCentro.setBorder(new EmptyBorder(10,10,10,10));
		
		// Botão básico
		JButton bt1 = new JButton("Clique aqui.");
		
		// Setando uma tooltip, um texto para o botão
		bt1.setToolTipText("Exemplo de botão básico");
		
		bt1.addActionListener(e -> {
			
			JOptionPane.showMessageDialog(janela, "Você clicou no botão básico");
			
		});
		
		// Botão com cores
		JButton bt2 = new JButton("Botão Azul");
		
		bt2.setUI(new javax.swing.plaf.basic.BasicButtonUI());
		
		bt2.setOpaque(true);
		
		bt2.setBackground(new Color(0, 85, 204));
		
		bt2.setForeground(Color.WHITE);
		
		bt2.setBorder(BorderFactory.createLineBorder(new Color(0, 70, 170)));
		
		bt2.setFocusPainted(false);
		
		bt2.setFont(new Font("Arial", Font.BOLD, 14));
		
		bt2.addActionListener(e -> {
			
			JOptionPane.showMessageDialog(
					janela, 
					"Botão azul pressionado"
			);
			
		});
		
		// Botão com fonte grande
		JButton bt3 = new JButton("Fonte Grande");
		
		bt3.setFont(new Font("Arial", Font.BOLD, 18));
		
		bt3.addActionListener(e -> {
			
			JOptionPane.showMessageDialog(janela, "Você clicou no botão com fonte grande!");
			
		});
		
		// Botão com ícone
		URL urlIcone = Aula_3_ExemplosJButton.class.getResource("/interface_grafica/java.png");
		
		ImageIcon iconeAjustado = null;
		
		if (urlIcone != null) {
			
			ImageIcon iconeOriginal = new ImageIcon(urlIcone);
			
			Image img = iconeOriginal.getImage();
			
			int larguraIcone = 48;
			int alturaIcone = 48;
			
			// Redimensionando a imagem original para as dimensões desejadas, criando uma cópia a partir dela. SCALE_SMOOTH garante uma qualidade visual.
			Image imgEscalada = img.getScaledInstance(larguraIcone, alturaIcone, Image.SCALE_SMOOTH);
			
			iconeAjustado = new ImageIcon(imgEscalada);
			
		}
		
		// Garantindo que o programa rode mesmo sem o ícone do botão
		JButton bt4 = (iconeAjustado != null) ? new JButton("Com ícone", iconeAjustado) : new JButton("Sem ícone");
		
		bt4.setHorizontalTextPosition(SwingConstants.CENTER);
		bt4.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		bt4.setIconTextGap(8);
		
		bt4.setMargin(new Insets(10, 12, 10, 12));
		
		bt4.setFont(new Font("Arial", Font.PLAIN, 14)); // PLAIN é o estilo normal
		
		bt4.setPreferredSize(new Dimension(160, 120)); // Sugere um layout preferido ao botão
		
		bt4.addActionListener(e -> {
			
			JOptionPane.showMessageDialog(janela, "Botão com ícone pressionado.");
			
		});
		
		painelCentro.add(bt1);
		painelCentro.add(bt2);
		painelCentro.add(bt3);
		painelCentro.add(bt4);
		
		janela.add(painelCentro, BorderLayout.CENTER);
		
		janela.pack();
		
		janela.setMinimumSize(new Dimension(420, 360));
		
		// Centralizando na tela do usuário
		janela.setLocationRelativeTo(null);
		
		janela.setVisible(true);

	}

}
