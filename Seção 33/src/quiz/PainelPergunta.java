package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PainelPergunta extends JPanel {

	private final JLabel lblPergunta = new JLabel("", SwingConstants.CENTER);
	
	private final JButton[] btnAlternativas = new JButton[4];
	
	public PainelPergunta(ActionListener listenerAlternativas) {
		
		setLayout(new BorderLayout(15, 15));
		
		setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		
		lblPergunta.setFont(new Font("Arial", Font.BOLD, 26));
		
		add(lblPergunta, BorderLayout.NORTH);
		
		JPanel grade = new JPanel(new GridLayout(2, 2, 15, 15));
		
		grade.setOpaque(false);
		
		Font fonteAlternativas = new Font("Arial", Font.PLAIN, 22);
		
		for (int i = 0; i < 4; i++) {
			
			btnAlternativas[i] = new JButton();
			
			btnAlternativas[i].setFont(fonteAlternativas);
			
			btnAlternativas[i].setFocusPainted(false);
			
			btnAlternativas[i].addActionListener(listenerAlternativas);
			
			grade.add(btnAlternativas[i]);
			
		}
		
		add(grade, BorderLayout.CENTER);
		
	}
	
	public void mostrarPergunta(Pergunta p) {
		
		lblPergunta.setText(p.getEnunciado());
		
		for (int i = 0; i < 4; i++) {
			
			btnAlternativas[i].setText(p.getAlternativas()[i]);
			
		}
		
	}
	
	public JButton getBotaoAlternativa(int indice) {
		
		return btnAlternativas[indice];
		
	}

}
