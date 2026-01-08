package interface_grafica;

import javax.swing.*;
import java.awt.*;

public class Aula_18_Avancado_JColorChooser {

	public static void main(String[] args) {

		JFrame f = new JFrame("JColorChooser - Seletor de cores");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setSize(500, 350);
		
		f.setLayout(new BorderLayout(8, 8));
		
		JLabel exemplo = new JLabel("Exemplo de texto colorido");
		
		exemplo.setHorizontalAlignment(SwingConstants.CENTER);
		
		exemplo.setFont(exemplo.getFont().deriveFont(Font.BOLD, 18f));
		
		exemplo.setOpaque(true);
		
		exemplo.setBackground(Color.WHITE);
		
		exemplo.setForeground(Color.DARK_GRAY);
		
		JButton btFonte = new JButton("Cor do texto");
		
		JButton btFundo = new JButton("Cor do fundo");
		
		btFonte.addActionListener(e -> {
			
			Color c = JColorChooser.showDialog(f, "Escolha a cor do texto", exemplo.getForeground());
			
			if (c != null) {
				
				exemplo.setForeground(c);
				
			}
		});
		
		btFundo.addActionListener(e -> {
			
			Color c = JColorChooser.showDialog(f, "Escolha a cor do fundo", exemplo.getForeground());
			
			if (c != null) {
				
				exemplo.setBackground(c);
				
			}
		});
		
		JPanel topo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		topo.add(btFonte);
		
		topo.add(btFundo);
		
		f.add(topo, BorderLayout.NORTH);
		
		f.add(exemplo, BorderLayout.CENTER);
		
		f.setVisible(true);

	}

}
